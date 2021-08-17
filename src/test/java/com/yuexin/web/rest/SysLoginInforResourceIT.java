package com.yuexin.web.rest;

import com.yuexin.YueXinJhipsterApp;
import com.yuexin.domain.SysLoginInfor;
import com.yuexin.repository.SysLoginInforRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link SysLoginInforResource} REST controller.
 */
@SpringBootTest(classes = YueXinJhipsterApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class SysLoginInforResourceIT {

    private static final String DEFAULT_USER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_USER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_IP_ADDR = "AAAAAAAAAA";
    private static final String UPDATED_IP_ADDR = "BBBBBBBBBB";

    private static final String DEFAULT_LOGIN_LOCATION = "AAAAAAAAAA";
    private static final String UPDATED_LOGIN_LOCATION = "BBBBBBBBBB";

    private static final String DEFAULT_BROWSER = "AAAAAAAAAA";
    private static final String UPDATED_BROWSER = "BBBBBBBBBB";

    private static final String DEFAULT_OS = "AAAAAAAAAA";
    private static final String UPDATED_OS = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_MSG = "AAAAAAAAAA";
    private static final String UPDATED_MSG = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_LOGIN_TIME = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LOGIN_TIME = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private SysLoginInforRepository sysLoginInforRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSysLoginInforMockMvc;

    private SysLoginInfor sysLoginInfor;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysLoginInfor createEntity(EntityManager em) {
        SysLoginInfor sysLoginInfor = new SysLoginInfor()
            .userName(DEFAULT_USER_NAME)
            .ipAddr(DEFAULT_IP_ADDR)
            .loginLocation(DEFAULT_LOGIN_LOCATION)
            .browser(DEFAULT_BROWSER)
            .os(DEFAULT_OS)
            .status(DEFAULT_STATUS)
            .msg(DEFAULT_MSG)
            .loginTime(DEFAULT_LOGIN_TIME);
        return sysLoginInfor;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysLoginInfor createUpdatedEntity(EntityManager em) {
        SysLoginInfor sysLoginInfor = new SysLoginInfor()
            .userName(UPDATED_USER_NAME)
            .ipAddr(UPDATED_IP_ADDR)
            .loginLocation(UPDATED_LOGIN_LOCATION)
            .browser(UPDATED_BROWSER)
            .os(UPDATED_OS)
            .status(UPDATED_STATUS)
            .msg(UPDATED_MSG)
            .loginTime(UPDATED_LOGIN_TIME);
        return sysLoginInfor;
    }

    @BeforeEach
    public void initTest() {
        sysLoginInfor = createEntity(em);
    }

    @Test
    @Transactional
    public void createSysLoginInfor() throws Exception {
        int databaseSizeBeforeCreate = sysLoginInforRepository.findAll().size();
        // Create the SysLoginInfor
        restSysLoginInforMockMvc.perform(post("/api/sys-login-infors").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysLoginInfor)))
            .andExpect(status().isCreated());

        // Validate the SysLoginInfor in the database
        List<SysLoginInfor> sysLoginInforList = sysLoginInforRepository.findAll();
        assertThat(sysLoginInforList).hasSize(databaseSizeBeforeCreate + 1);
        SysLoginInfor testSysLoginInfor = sysLoginInforList.get(sysLoginInforList.size() - 1);
        assertThat(testSysLoginInfor.getUserName()).isEqualTo(DEFAULT_USER_NAME);
        assertThat(testSysLoginInfor.getIpAddr()).isEqualTo(DEFAULT_IP_ADDR);
        assertThat(testSysLoginInfor.getLoginLocation()).isEqualTo(DEFAULT_LOGIN_LOCATION);
        assertThat(testSysLoginInfor.getBrowser()).isEqualTo(DEFAULT_BROWSER);
        assertThat(testSysLoginInfor.getOs()).isEqualTo(DEFAULT_OS);
        assertThat(testSysLoginInfor.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testSysLoginInfor.getMsg()).isEqualTo(DEFAULT_MSG);
        assertThat(testSysLoginInfor.getLoginTime()).isEqualTo(DEFAULT_LOGIN_TIME);
    }

    @Test
    @Transactional
    public void createSysLoginInforWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sysLoginInforRepository.findAll().size();

        // Create the SysLoginInfor with an existing ID
        sysLoginInfor.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSysLoginInforMockMvc.perform(post("/api/sys-login-infors").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysLoginInfor)))
            .andExpect(status().isBadRequest());

        // Validate the SysLoginInfor in the database
        List<SysLoginInfor> sysLoginInforList = sysLoginInforRepository.findAll();
        assertThat(sysLoginInforList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSysLoginInfors() throws Exception {
        // Initialize the database
        sysLoginInforRepository.saveAndFlush(sysLoginInfor);

        // Get all the sysLoginInforList
        restSysLoginInforMockMvc.perform(get("/api/sys-login-infors?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sysLoginInfor.getId().intValue())))
            .andExpect(jsonPath("$.[*].userName").value(hasItem(DEFAULT_USER_NAME)))
            .andExpect(jsonPath("$.[*].ipAddr").value(hasItem(DEFAULT_IP_ADDR)))
            .andExpect(jsonPath("$.[*].loginLocation").value(hasItem(DEFAULT_LOGIN_LOCATION)))
            .andExpect(jsonPath("$.[*].browser").value(hasItem(DEFAULT_BROWSER)))
            .andExpect(jsonPath("$.[*].os").value(hasItem(DEFAULT_OS)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].msg").value(hasItem(DEFAULT_MSG)))
            .andExpect(jsonPath("$.[*].loginTime").value(hasItem(DEFAULT_LOGIN_TIME.toString())));
    }
    
    @Test
    @Transactional
    public void getSysLoginInfor() throws Exception {
        // Initialize the database
        sysLoginInforRepository.saveAndFlush(sysLoginInfor);

        // Get the sysLoginInfor
        restSysLoginInforMockMvc.perform(get("/api/sys-login-infors/{id}", sysLoginInfor.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sysLoginInfor.getId().intValue()))
            .andExpect(jsonPath("$.userName").value(DEFAULT_USER_NAME))
            .andExpect(jsonPath("$.ipAddr").value(DEFAULT_IP_ADDR))
            .andExpect(jsonPath("$.loginLocation").value(DEFAULT_LOGIN_LOCATION))
            .andExpect(jsonPath("$.browser").value(DEFAULT_BROWSER))
            .andExpect(jsonPath("$.os").value(DEFAULT_OS))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.msg").value(DEFAULT_MSG))
            .andExpect(jsonPath("$.loginTime").value(DEFAULT_LOGIN_TIME.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingSysLoginInfor() throws Exception {
        // Get the sysLoginInfor
        restSysLoginInforMockMvc.perform(get("/api/sys-login-infors/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSysLoginInfor() throws Exception {
        // Initialize the database
        sysLoginInforRepository.saveAndFlush(sysLoginInfor);

        int databaseSizeBeforeUpdate = sysLoginInforRepository.findAll().size();

        // Update the sysLoginInfor
        SysLoginInfor updatedSysLoginInfor = sysLoginInforRepository.findById(sysLoginInfor.getId()).get();
        // Disconnect from session so that the updates on updatedSysLoginInfor are not directly saved in db
        em.detach(updatedSysLoginInfor);
        updatedSysLoginInfor
            .userName(UPDATED_USER_NAME)
            .ipAddr(UPDATED_IP_ADDR)
            .loginLocation(UPDATED_LOGIN_LOCATION)
            .browser(UPDATED_BROWSER)
            .os(UPDATED_OS)
            .status(UPDATED_STATUS)
            .msg(UPDATED_MSG)
            .loginTime(UPDATED_LOGIN_TIME);

        restSysLoginInforMockMvc.perform(put("/api/sys-login-infors").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedSysLoginInfor)))
            .andExpect(status().isOk());

        // Validate the SysLoginInfor in the database
        List<SysLoginInfor> sysLoginInforList = sysLoginInforRepository.findAll();
        assertThat(sysLoginInforList).hasSize(databaseSizeBeforeUpdate);
        SysLoginInfor testSysLoginInfor = sysLoginInforList.get(sysLoginInforList.size() - 1);
        assertThat(testSysLoginInfor.getUserName()).isEqualTo(UPDATED_USER_NAME);
        assertThat(testSysLoginInfor.getIpAddr()).isEqualTo(UPDATED_IP_ADDR);
        assertThat(testSysLoginInfor.getLoginLocation()).isEqualTo(UPDATED_LOGIN_LOCATION);
        assertThat(testSysLoginInfor.getBrowser()).isEqualTo(UPDATED_BROWSER);
        assertThat(testSysLoginInfor.getOs()).isEqualTo(UPDATED_OS);
        assertThat(testSysLoginInfor.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testSysLoginInfor.getMsg()).isEqualTo(UPDATED_MSG);
        assertThat(testSysLoginInfor.getLoginTime()).isEqualTo(UPDATED_LOGIN_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingSysLoginInfor() throws Exception {
        int databaseSizeBeforeUpdate = sysLoginInforRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSysLoginInforMockMvc.perform(put("/api/sys-login-infors").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysLoginInfor)))
            .andExpect(status().isBadRequest());

        // Validate the SysLoginInfor in the database
        List<SysLoginInfor> sysLoginInforList = sysLoginInforRepository.findAll();
        assertThat(sysLoginInforList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSysLoginInfor() throws Exception {
        // Initialize the database
        sysLoginInforRepository.saveAndFlush(sysLoginInfor);

        int databaseSizeBeforeDelete = sysLoginInforRepository.findAll().size();

        // Delete the sysLoginInfor
        restSysLoginInforMockMvc.perform(delete("/api/sys-login-infors/{id}", sysLoginInfor.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SysLoginInfor> sysLoginInforList = sysLoginInforRepository.findAll();
        assertThat(sysLoginInforList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
