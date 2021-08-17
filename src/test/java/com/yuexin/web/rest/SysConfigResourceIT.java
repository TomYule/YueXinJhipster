package com.yuexin.web.rest;

import com.yuexin.YueXinJhipsterApp;
import com.yuexin.domain.SysConfig;
import com.yuexin.repository.SysConfigRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;
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
 * Integration tests for the {@link SysConfigResource} REST controller.
 */
@SpringBootTest(classes = YueXinJhipsterApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class SysConfigResourceIT {

    private static final String DEFAULT_CONFIG_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CONFIG_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CONFIG_KEY = "AAAAAAAAAA";
    private static final String UPDATED_CONFIG_KEY = "BBBBBBBBBB";

    private static final String DEFAULT_CONFIG_VALUE = "AAAAAAAAAA";
    private static final String UPDATED_CONFIG_VALUE = "BBBBBBBBBB";

    private static final String DEFAULT_CONFIG_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_CONFIG_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_CREATE_BY = "AAAAAAAAAA";
    private static final String UPDATED_CREATE_BY = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_CREATE_TIME = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CREATE_TIME = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_UPDATE_BY = "AAAAAAAAAA";
    private static final String UPDATED_UPDATE_BY = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_UP_LOCAL_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UP_LOCAL_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_REMARK = "AAAAAAAAAA";
    private static final String UPDATED_REMARK = "BBBBBBBBBB";

    @Autowired
    private SysConfigRepository sysConfigRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSysConfigMockMvc;

    private SysConfig sysConfig;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysConfig createEntity(EntityManager em) {
        SysConfig sysConfig = new SysConfig()
            .configName(DEFAULT_CONFIG_NAME)
            .configKey(DEFAULT_CONFIG_KEY)
            .configValue(DEFAULT_CONFIG_VALUE)
            .configType(DEFAULT_CONFIG_TYPE)
            .createBy(DEFAULT_CREATE_BY)
            .createTime(DEFAULT_CREATE_TIME)
            .updateBy(DEFAULT_UPDATE_BY)
            .upLocalDate(DEFAULT_UP_LOCAL_DATE)
            .remark(DEFAULT_REMARK);
        return sysConfig;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysConfig createUpdatedEntity(EntityManager em) {
        SysConfig sysConfig = new SysConfig()
            .configName(UPDATED_CONFIG_NAME)
            .configKey(UPDATED_CONFIG_KEY)
            .configValue(UPDATED_CONFIG_VALUE)
            .configType(UPDATED_CONFIG_TYPE)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);
        return sysConfig;
    }

    @BeforeEach
    public void initTest() {
        sysConfig = createEntity(em);
    }

    @Test
    @Transactional
    public void createSysConfig() throws Exception {
        int databaseSizeBeforeCreate = sysConfigRepository.findAll().size();
        // Create the SysConfig
        restSysConfigMockMvc.perform(post("/api/sys-configs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysConfig)))
            .andExpect(status().isCreated());

        // Validate the SysConfig in the database
        List<SysConfig> sysConfigList = sysConfigRepository.findAll();
        assertThat(sysConfigList).hasSize(databaseSizeBeforeCreate + 1);
        SysConfig testSysConfig = sysConfigList.get(sysConfigList.size() - 1);
        assertThat(testSysConfig.getConfigName()).isEqualTo(DEFAULT_CONFIG_NAME);
        assertThat(testSysConfig.getConfigKey()).isEqualTo(DEFAULT_CONFIG_KEY);
        assertThat(testSysConfig.getConfigValue()).isEqualTo(DEFAULT_CONFIG_VALUE);
        assertThat(testSysConfig.getConfigType()).isEqualTo(DEFAULT_CONFIG_TYPE);
        assertThat(testSysConfig.getCreateBy()).isEqualTo(DEFAULT_CREATE_BY);
        assertThat(testSysConfig.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testSysConfig.getUpdateBy()).isEqualTo(DEFAULT_UPDATE_BY);
        assertThat(testSysConfig.getUpLocalDate()).isEqualTo(DEFAULT_UP_LOCAL_DATE);
        assertThat(testSysConfig.getRemark()).isEqualTo(DEFAULT_REMARK);
    }

    @Test
    @Transactional
    public void createSysConfigWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sysConfigRepository.findAll().size();

        // Create the SysConfig with an existing ID
        sysConfig.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSysConfigMockMvc.perform(post("/api/sys-configs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysConfig)))
            .andExpect(status().isBadRequest());

        // Validate the SysConfig in the database
        List<SysConfig> sysConfigList = sysConfigRepository.findAll();
        assertThat(sysConfigList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkConfigNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = sysConfigRepository.findAll().size();
        // set the field null
        sysConfig.setConfigName(null);

        // Create the SysConfig, which fails.


        restSysConfigMockMvc.perform(post("/api/sys-configs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysConfig)))
            .andExpect(status().isBadRequest());

        List<SysConfig> sysConfigList = sysConfigRepository.findAll();
        assertThat(sysConfigList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllSysConfigs() throws Exception {
        // Initialize the database
        sysConfigRepository.saveAndFlush(sysConfig);

        // Get all the sysConfigList
        restSysConfigMockMvc.perform(get("/api/sys-configs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sysConfig.getId().intValue())))
            .andExpect(jsonPath("$.[*].configName").value(hasItem(DEFAULT_CONFIG_NAME)))
            .andExpect(jsonPath("$.[*].configKey").value(hasItem(DEFAULT_CONFIG_KEY)))
            .andExpect(jsonPath("$.[*].configValue").value(hasItem(DEFAULT_CONFIG_VALUE)))
            .andExpect(jsonPath("$.[*].configType").value(hasItem(DEFAULT_CONFIG_TYPE)))
            .andExpect(jsonPath("$.[*].createBy").value(hasItem(DEFAULT_CREATE_BY)))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateBy").value(hasItem(DEFAULT_UPDATE_BY)))
            .andExpect(jsonPath("$.[*].upLocalDate").value(hasItem(DEFAULT_UP_LOCAL_DATE.toString())))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK.toString())));
    }
    
    @Test
    @Transactional
    public void getSysConfig() throws Exception {
        // Initialize the database
        sysConfigRepository.saveAndFlush(sysConfig);

        // Get the sysConfig
        restSysConfigMockMvc.perform(get("/api/sys-configs/{id}", sysConfig.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sysConfig.getId().intValue()))
            .andExpect(jsonPath("$.configName").value(DEFAULT_CONFIG_NAME))
            .andExpect(jsonPath("$.configKey").value(DEFAULT_CONFIG_KEY))
            .andExpect(jsonPath("$.configValue").value(DEFAULT_CONFIG_VALUE))
            .andExpect(jsonPath("$.configType").value(DEFAULT_CONFIG_TYPE))
            .andExpect(jsonPath("$.createBy").value(DEFAULT_CREATE_BY))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateBy").value(DEFAULT_UPDATE_BY))
            .andExpect(jsonPath("$.upLocalDate").value(DEFAULT_UP_LOCAL_DATE.toString()))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingSysConfig() throws Exception {
        // Get the sysConfig
        restSysConfigMockMvc.perform(get("/api/sys-configs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSysConfig() throws Exception {
        // Initialize the database
        sysConfigRepository.saveAndFlush(sysConfig);

        int databaseSizeBeforeUpdate = sysConfigRepository.findAll().size();

        // Update the sysConfig
        SysConfig updatedSysConfig = sysConfigRepository.findById(sysConfig.getId()).get();
        // Disconnect from session so that the updates on updatedSysConfig are not directly saved in db
        em.detach(updatedSysConfig);
        updatedSysConfig
            .configName(UPDATED_CONFIG_NAME)
            .configKey(UPDATED_CONFIG_KEY)
            .configValue(UPDATED_CONFIG_VALUE)
            .configType(UPDATED_CONFIG_TYPE)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);

        restSysConfigMockMvc.perform(put("/api/sys-configs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedSysConfig)))
            .andExpect(status().isOk());

        // Validate the SysConfig in the database
        List<SysConfig> sysConfigList = sysConfigRepository.findAll();
        assertThat(sysConfigList).hasSize(databaseSizeBeforeUpdate);
        SysConfig testSysConfig = sysConfigList.get(sysConfigList.size() - 1);
        assertThat(testSysConfig.getConfigName()).isEqualTo(UPDATED_CONFIG_NAME);
        assertThat(testSysConfig.getConfigKey()).isEqualTo(UPDATED_CONFIG_KEY);
        assertThat(testSysConfig.getConfigValue()).isEqualTo(UPDATED_CONFIG_VALUE);
        assertThat(testSysConfig.getConfigType()).isEqualTo(UPDATED_CONFIG_TYPE);
        assertThat(testSysConfig.getCreateBy()).isEqualTo(UPDATED_CREATE_BY);
        assertThat(testSysConfig.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testSysConfig.getUpdateBy()).isEqualTo(UPDATED_UPDATE_BY);
        assertThat(testSysConfig.getUpLocalDate()).isEqualTo(UPDATED_UP_LOCAL_DATE);
        assertThat(testSysConfig.getRemark()).isEqualTo(UPDATED_REMARK);
    }

    @Test
    @Transactional
    public void updateNonExistingSysConfig() throws Exception {
        int databaseSizeBeforeUpdate = sysConfigRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSysConfigMockMvc.perform(put("/api/sys-configs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysConfig)))
            .andExpect(status().isBadRequest());

        // Validate the SysConfig in the database
        List<SysConfig> sysConfigList = sysConfigRepository.findAll();
        assertThat(sysConfigList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSysConfig() throws Exception {
        // Initialize the database
        sysConfigRepository.saveAndFlush(sysConfig);

        int databaseSizeBeforeDelete = sysConfigRepository.findAll().size();

        // Delete the sysConfig
        restSysConfigMockMvc.perform(delete("/api/sys-configs/{id}", sysConfig.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SysConfig> sysConfigList = sysConfigRepository.findAll();
        assertThat(sysConfigList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
