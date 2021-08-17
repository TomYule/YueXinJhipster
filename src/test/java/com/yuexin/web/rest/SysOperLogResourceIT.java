package com.yuexin.web.rest;

import com.yuexin.YueXinJhipsterApp;
import com.yuexin.domain.SysOperLog;
import com.yuexin.repository.SysOperLogRepository;

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
 * Integration tests for the {@link SysOperLogResource} REST controller.
 */
@SpringBootTest(classes = YueXinJhipsterApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class SysOperLogResourceIT {

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final Integer DEFAULT_BUSINESS_TYPE = 1;
    private static final Integer UPDATED_BUSINESS_TYPE = 2;

    private static final String DEFAULT_METHOD = "AAAAAAAAAA";
    private static final String UPDATED_METHOD = "BBBBBBBBBB";

    private static final String DEFAULT_REQUEST_METHOD = "AAAAAAAAAA";
    private static final String UPDATED_REQUEST_METHOD = "BBBBBBBBBB";

    private static final Integer DEFAULT_OPERATOR_TYPE = 1;
    private static final Integer UPDATED_OPERATOR_TYPE = 2;

    private static final String DEFAULT_OPER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_OPER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_DEPT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_DEPT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_OPER_URL = "AAAAAAAAAA";
    private static final String UPDATED_OPER_URL = "BBBBBBBBBB";

    private static final String DEFAULT_OPER_IP = "AAAAAAAAAA";
    private static final String UPDATED_OPER_IP = "BBBBBBBBBB";

    private static final String DEFAULT_OPER_LOCATION = "AAAAAAAAAA";
    private static final String UPDATED_OPER_LOCATION = "BBBBBBBBBB";

    private static final String DEFAULT_OPER_PARAM = "AAAAAAAAAA";
    private static final String UPDATED_OPER_PARAM = "BBBBBBBBBB";

    private static final String DEFAULT_JSON_RESULT = "AAAAAAAAAA";
    private static final String UPDATED_JSON_RESULT = "BBBBBBBBBB";

    private static final Integer DEFAULT_STATUS = 1;
    private static final Integer UPDATED_STATUS = 2;

    private static final String DEFAULT_ERROR_MSG = "AAAAAAAAAA";
    private static final String UPDATED_ERROR_MSG = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_OPER_TIME = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_OPER_TIME = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private SysOperLogRepository sysOperLogRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSysOperLogMockMvc;

    private SysOperLog sysOperLog;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysOperLog createEntity(EntityManager em) {
        SysOperLog sysOperLog = new SysOperLog()
            .title(DEFAULT_TITLE)
            .businessType(DEFAULT_BUSINESS_TYPE)
            .method(DEFAULT_METHOD)
            .requestMethod(DEFAULT_REQUEST_METHOD)
            .operatorType(DEFAULT_OPERATOR_TYPE)
            .operName(DEFAULT_OPER_NAME)
            .deptName(DEFAULT_DEPT_NAME)
            .operUrl(DEFAULT_OPER_URL)
            .operIp(DEFAULT_OPER_IP)
            .operLocation(DEFAULT_OPER_LOCATION)
            .operParam(DEFAULT_OPER_PARAM)
            .jsonResult(DEFAULT_JSON_RESULT)
            .status(DEFAULT_STATUS)
            .errorMsg(DEFAULT_ERROR_MSG)
            .operTime(DEFAULT_OPER_TIME);
        return sysOperLog;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysOperLog createUpdatedEntity(EntityManager em) {
        SysOperLog sysOperLog = new SysOperLog()
            .title(UPDATED_TITLE)
            .businessType(UPDATED_BUSINESS_TYPE)
            .method(UPDATED_METHOD)
            .requestMethod(UPDATED_REQUEST_METHOD)
            .operatorType(UPDATED_OPERATOR_TYPE)
            .operName(UPDATED_OPER_NAME)
            .deptName(UPDATED_DEPT_NAME)
            .operUrl(UPDATED_OPER_URL)
            .operIp(UPDATED_OPER_IP)
            .operLocation(UPDATED_OPER_LOCATION)
            .operParam(UPDATED_OPER_PARAM)
            .jsonResult(UPDATED_JSON_RESULT)
            .status(UPDATED_STATUS)
            .errorMsg(UPDATED_ERROR_MSG)
            .operTime(UPDATED_OPER_TIME);
        return sysOperLog;
    }

    @BeforeEach
    public void initTest() {
        sysOperLog = createEntity(em);
    }

    @Test
    @Transactional
    public void createSysOperLog() throws Exception {
        int databaseSizeBeforeCreate = sysOperLogRepository.findAll().size();
        // Create the SysOperLog
        restSysOperLogMockMvc.perform(post("/api/sys-oper-logs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysOperLog)))
            .andExpect(status().isCreated());

        // Validate the SysOperLog in the database
        List<SysOperLog> sysOperLogList = sysOperLogRepository.findAll();
        assertThat(sysOperLogList).hasSize(databaseSizeBeforeCreate + 1);
        SysOperLog testSysOperLog = sysOperLogList.get(sysOperLogList.size() - 1);
        assertThat(testSysOperLog.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testSysOperLog.getBusinessType()).isEqualTo(DEFAULT_BUSINESS_TYPE);
        assertThat(testSysOperLog.getMethod()).isEqualTo(DEFAULT_METHOD);
        assertThat(testSysOperLog.getRequestMethod()).isEqualTo(DEFAULT_REQUEST_METHOD);
        assertThat(testSysOperLog.getOperatorType()).isEqualTo(DEFAULT_OPERATOR_TYPE);
        assertThat(testSysOperLog.getOperName()).isEqualTo(DEFAULT_OPER_NAME);
        assertThat(testSysOperLog.getDeptName()).isEqualTo(DEFAULT_DEPT_NAME);
        assertThat(testSysOperLog.getOperUrl()).isEqualTo(DEFAULT_OPER_URL);
        assertThat(testSysOperLog.getOperIp()).isEqualTo(DEFAULT_OPER_IP);
        assertThat(testSysOperLog.getOperLocation()).isEqualTo(DEFAULT_OPER_LOCATION);
        assertThat(testSysOperLog.getOperParam()).isEqualTo(DEFAULT_OPER_PARAM);
        assertThat(testSysOperLog.getJsonResult()).isEqualTo(DEFAULT_JSON_RESULT);
        assertThat(testSysOperLog.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testSysOperLog.getErrorMsg()).isEqualTo(DEFAULT_ERROR_MSG);
        assertThat(testSysOperLog.getOperTime()).isEqualTo(DEFAULT_OPER_TIME);
    }

    @Test
    @Transactional
    public void createSysOperLogWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sysOperLogRepository.findAll().size();

        // Create the SysOperLog with an existing ID
        sysOperLog.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSysOperLogMockMvc.perform(post("/api/sys-oper-logs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysOperLog)))
            .andExpect(status().isBadRequest());

        // Validate the SysOperLog in the database
        List<SysOperLog> sysOperLogList = sysOperLogRepository.findAll();
        assertThat(sysOperLogList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkTitleIsRequired() throws Exception {
        int databaseSizeBeforeTest = sysOperLogRepository.findAll().size();
        // set the field null
        sysOperLog.setTitle(null);

        // Create the SysOperLog, which fails.


        restSysOperLogMockMvc.perform(post("/api/sys-oper-logs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysOperLog)))
            .andExpect(status().isBadRequest());

        List<SysOperLog> sysOperLogList = sysOperLogRepository.findAll();
        assertThat(sysOperLogList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllSysOperLogs() throws Exception {
        // Initialize the database
        sysOperLogRepository.saveAndFlush(sysOperLog);

        // Get all the sysOperLogList
        restSysOperLogMockMvc.perform(get("/api/sys-oper-logs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sysOperLog.getId().intValue())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
            .andExpect(jsonPath("$.[*].businessType").value(hasItem(DEFAULT_BUSINESS_TYPE)))
            .andExpect(jsonPath("$.[*].method").value(hasItem(DEFAULT_METHOD)))
            .andExpect(jsonPath("$.[*].requestMethod").value(hasItem(DEFAULT_REQUEST_METHOD)))
            .andExpect(jsonPath("$.[*].operatorType").value(hasItem(DEFAULT_OPERATOR_TYPE)))
            .andExpect(jsonPath("$.[*].operName").value(hasItem(DEFAULT_OPER_NAME)))
            .andExpect(jsonPath("$.[*].deptName").value(hasItem(DEFAULT_DEPT_NAME)))
            .andExpect(jsonPath("$.[*].operUrl").value(hasItem(DEFAULT_OPER_URL)))
            .andExpect(jsonPath("$.[*].operIp").value(hasItem(DEFAULT_OPER_IP)))
            .andExpect(jsonPath("$.[*].operLocation").value(hasItem(DEFAULT_OPER_LOCATION)))
            .andExpect(jsonPath("$.[*].operParam").value(hasItem(DEFAULT_OPER_PARAM.toString())))
            .andExpect(jsonPath("$.[*].jsonResult").value(hasItem(DEFAULT_JSON_RESULT.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].errorMsg").value(hasItem(DEFAULT_ERROR_MSG.toString())))
            .andExpect(jsonPath("$.[*].operTime").value(hasItem(DEFAULT_OPER_TIME.toString())));
    }
    
    @Test
    @Transactional
    public void getSysOperLog() throws Exception {
        // Initialize the database
        sysOperLogRepository.saveAndFlush(sysOperLog);

        // Get the sysOperLog
        restSysOperLogMockMvc.perform(get("/api/sys-oper-logs/{id}", sysOperLog.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sysOperLog.getId().intValue()))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE))
            .andExpect(jsonPath("$.businessType").value(DEFAULT_BUSINESS_TYPE))
            .andExpect(jsonPath("$.method").value(DEFAULT_METHOD))
            .andExpect(jsonPath("$.requestMethod").value(DEFAULT_REQUEST_METHOD))
            .andExpect(jsonPath("$.operatorType").value(DEFAULT_OPERATOR_TYPE))
            .andExpect(jsonPath("$.operName").value(DEFAULT_OPER_NAME))
            .andExpect(jsonPath("$.deptName").value(DEFAULT_DEPT_NAME))
            .andExpect(jsonPath("$.operUrl").value(DEFAULT_OPER_URL))
            .andExpect(jsonPath("$.operIp").value(DEFAULT_OPER_IP))
            .andExpect(jsonPath("$.operLocation").value(DEFAULT_OPER_LOCATION))
            .andExpect(jsonPath("$.operParam").value(DEFAULT_OPER_PARAM.toString()))
            .andExpect(jsonPath("$.jsonResult").value(DEFAULT_JSON_RESULT.toString()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.errorMsg").value(DEFAULT_ERROR_MSG.toString()))
            .andExpect(jsonPath("$.operTime").value(DEFAULT_OPER_TIME.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingSysOperLog() throws Exception {
        // Get the sysOperLog
        restSysOperLogMockMvc.perform(get("/api/sys-oper-logs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSysOperLog() throws Exception {
        // Initialize the database
        sysOperLogRepository.saveAndFlush(sysOperLog);

        int databaseSizeBeforeUpdate = sysOperLogRepository.findAll().size();

        // Update the sysOperLog
        SysOperLog updatedSysOperLog = sysOperLogRepository.findById(sysOperLog.getId()).get();
        // Disconnect from session so that the updates on updatedSysOperLog are not directly saved in db
        em.detach(updatedSysOperLog);
        updatedSysOperLog
            .title(UPDATED_TITLE)
            .businessType(UPDATED_BUSINESS_TYPE)
            .method(UPDATED_METHOD)
            .requestMethod(UPDATED_REQUEST_METHOD)
            .operatorType(UPDATED_OPERATOR_TYPE)
            .operName(UPDATED_OPER_NAME)
            .deptName(UPDATED_DEPT_NAME)
            .operUrl(UPDATED_OPER_URL)
            .operIp(UPDATED_OPER_IP)
            .operLocation(UPDATED_OPER_LOCATION)
            .operParam(UPDATED_OPER_PARAM)
            .jsonResult(UPDATED_JSON_RESULT)
            .status(UPDATED_STATUS)
            .errorMsg(UPDATED_ERROR_MSG)
            .operTime(UPDATED_OPER_TIME);

        restSysOperLogMockMvc.perform(put("/api/sys-oper-logs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedSysOperLog)))
            .andExpect(status().isOk());

        // Validate the SysOperLog in the database
        List<SysOperLog> sysOperLogList = sysOperLogRepository.findAll();
        assertThat(sysOperLogList).hasSize(databaseSizeBeforeUpdate);
        SysOperLog testSysOperLog = sysOperLogList.get(sysOperLogList.size() - 1);
        assertThat(testSysOperLog.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testSysOperLog.getBusinessType()).isEqualTo(UPDATED_BUSINESS_TYPE);
        assertThat(testSysOperLog.getMethod()).isEqualTo(UPDATED_METHOD);
        assertThat(testSysOperLog.getRequestMethod()).isEqualTo(UPDATED_REQUEST_METHOD);
        assertThat(testSysOperLog.getOperatorType()).isEqualTo(UPDATED_OPERATOR_TYPE);
        assertThat(testSysOperLog.getOperName()).isEqualTo(UPDATED_OPER_NAME);
        assertThat(testSysOperLog.getDeptName()).isEqualTo(UPDATED_DEPT_NAME);
        assertThat(testSysOperLog.getOperUrl()).isEqualTo(UPDATED_OPER_URL);
        assertThat(testSysOperLog.getOperIp()).isEqualTo(UPDATED_OPER_IP);
        assertThat(testSysOperLog.getOperLocation()).isEqualTo(UPDATED_OPER_LOCATION);
        assertThat(testSysOperLog.getOperParam()).isEqualTo(UPDATED_OPER_PARAM);
        assertThat(testSysOperLog.getJsonResult()).isEqualTo(UPDATED_JSON_RESULT);
        assertThat(testSysOperLog.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testSysOperLog.getErrorMsg()).isEqualTo(UPDATED_ERROR_MSG);
        assertThat(testSysOperLog.getOperTime()).isEqualTo(UPDATED_OPER_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingSysOperLog() throws Exception {
        int databaseSizeBeforeUpdate = sysOperLogRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSysOperLogMockMvc.perform(put("/api/sys-oper-logs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysOperLog)))
            .andExpect(status().isBadRequest());

        // Validate the SysOperLog in the database
        List<SysOperLog> sysOperLogList = sysOperLogRepository.findAll();
        assertThat(sysOperLogList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSysOperLog() throws Exception {
        // Initialize the database
        sysOperLogRepository.saveAndFlush(sysOperLog);

        int databaseSizeBeforeDelete = sysOperLogRepository.findAll().size();

        // Delete the sysOperLog
        restSysOperLogMockMvc.perform(delete("/api/sys-oper-logs/{id}", sysOperLog.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SysOperLog> sysOperLogList = sysOperLogRepository.findAll();
        assertThat(sysOperLogList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
