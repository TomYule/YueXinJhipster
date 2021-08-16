package com.yuexin.web.rest;

import com.yuexin.YueXinJhipsterApp;
import com.yuexin.domain.SysJobLog;
import com.yuexin.repository.SysJobLogRepository;

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
 * Integration tests for the {@link SysJobLogResource} REST controller.
 */
@SpringBootTest(classes = YueXinJhipsterApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class SysJobLogResourceIT {

    private static final String DEFAULT_JOB_NAME = "AAAAAAAAAA";
    private static final String UPDATED_JOB_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_JOB_GROUP = "AAAAAAAAAA";
    private static final String UPDATED_JOB_GROUP = "BBBBBBBBBB";

    private static final String DEFAULT_INVOKE_TARGET = "AAAAAAAAAA";
    private static final String UPDATED_INVOKE_TARGET = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_EXCEPTION_INFO = "AAAAAAAAAA";
    private static final String UPDATED_EXCEPTION_INFO = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_CREATE_TIME = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CREATE_TIME = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private SysJobLogRepository sysJobLogRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSysJobLogMockMvc;

    private SysJobLog sysJobLog;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysJobLog createEntity(EntityManager em) {
        SysJobLog sysJobLog = new SysJobLog()
            .jobName(DEFAULT_JOB_NAME)
            .jobGroup(DEFAULT_JOB_GROUP)
            .invokeTarget(DEFAULT_INVOKE_TARGET)
            .status(DEFAULT_STATUS)
            .exceptionInfo(DEFAULT_EXCEPTION_INFO)
            .createTime(DEFAULT_CREATE_TIME);
        return sysJobLog;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysJobLog createUpdatedEntity(EntityManager em) {
        SysJobLog sysJobLog = new SysJobLog()
            .jobName(UPDATED_JOB_NAME)
            .jobGroup(UPDATED_JOB_GROUP)
            .invokeTarget(UPDATED_INVOKE_TARGET)
            .status(UPDATED_STATUS)
            .exceptionInfo(UPDATED_EXCEPTION_INFO)
            .createTime(UPDATED_CREATE_TIME);
        return sysJobLog;
    }

    @BeforeEach
    public void initTest() {
        sysJobLog = createEntity(em);
    }

    @Test
    @Transactional
    public void createSysJobLog() throws Exception {
        int databaseSizeBeforeCreate = sysJobLogRepository.findAll().size();
        // Create the SysJobLog
        restSysJobLogMockMvc.perform(post("/api/sys-job-logs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysJobLog)))
            .andExpect(status().isCreated());

        // Validate the SysJobLog in the database
        List<SysJobLog> sysJobLogList = sysJobLogRepository.findAll();
        assertThat(sysJobLogList).hasSize(databaseSizeBeforeCreate + 1);
        SysJobLog testSysJobLog = sysJobLogList.get(sysJobLogList.size() - 1);
        assertThat(testSysJobLog.getJobName()).isEqualTo(DEFAULT_JOB_NAME);
        assertThat(testSysJobLog.getJobGroup()).isEqualTo(DEFAULT_JOB_GROUP);
        assertThat(testSysJobLog.getInvokeTarget()).isEqualTo(DEFAULT_INVOKE_TARGET);
        assertThat(testSysJobLog.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testSysJobLog.getExceptionInfo()).isEqualTo(DEFAULT_EXCEPTION_INFO);
        assertThat(testSysJobLog.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
    }

    @Test
    @Transactional
    public void createSysJobLogWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sysJobLogRepository.findAll().size();

        // Create the SysJobLog with an existing ID
        sysJobLog.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSysJobLogMockMvc.perform(post("/api/sys-job-logs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysJobLog)))
            .andExpect(status().isBadRequest());

        // Validate the SysJobLog in the database
        List<SysJobLog> sysJobLogList = sysJobLogRepository.findAll();
        assertThat(sysJobLogList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSysJobLogs() throws Exception {
        // Initialize the database
        sysJobLogRepository.saveAndFlush(sysJobLog);

        // Get all the sysJobLogList
        restSysJobLogMockMvc.perform(get("/api/sys-job-logs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sysJobLog.getId().intValue())))
            .andExpect(jsonPath("$.[*].jobName").value(hasItem(DEFAULT_JOB_NAME)))
            .andExpect(jsonPath("$.[*].jobGroup").value(hasItem(DEFAULT_JOB_GROUP)))
            .andExpect(jsonPath("$.[*].invokeTarget").value(hasItem(DEFAULT_INVOKE_TARGET)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].exceptionInfo").value(hasItem(DEFAULT_EXCEPTION_INFO)))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())));
    }
    
    @Test
    @Transactional
    public void getSysJobLog() throws Exception {
        // Initialize the database
        sysJobLogRepository.saveAndFlush(sysJobLog);

        // Get the sysJobLog
        restSysJobLogMockMvc.perform(get("/api/sys-job-logs/{id}", sysJobLog.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sysJobLog.getId().intValue()))
            .andExpect(jsonPath("$.jobName").value(DEFAULT_JOB_NAME))
            .andExpect(jsonPath("$.jobGroup").value(DEFAULT_JOB_GROUP))
            .andExpect(jsonPath("$.invokeTarget").value(DEFAULT_INVOKE_TARGET))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.exceptionInfo").value(DEFAULT_EXCEPTION_INFO))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingSysJobLog() throws Exception {
        // Get the sysJobLog
        restSysJobLogMockMvc.perform(get("/api/sys-job-logs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSysJobLog() throws Exception {
        // Initialize the database
        sysJobLogRepository.saveAndFlush(sysJobLog);

        int databaseSizeBeforeUpdate = sysJobLogRepository.findAll().size();

        // Update the sysJobLog
        SysJobLog updatedSysJobLog = sysJobLogRepository.findById(sysJobLog.getId()).get();
        // Disconnect from session so that the updates on updatedSysJobLog are not directly saved in db
        em.detach(updatedSysJobLog);
        updatedSysJobLog
            .jobName(UPDATED_JOB_NAME)
            .jobGroup(UPDATED_JOB_GROUP)
            .invokeTarget(UPDATED_INVOKE_TARGET)
            .status(UPDATED_STATUS)
            .exceptionInfo(UPDATED_EXCEPTION_INFO)
            .createTime(UPDATED_CREATE_TIME);

        restSysJobLogMockMvc.perform(put("/api/sys-job-logs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedSysJobLog)))
            .andExpect(status().isOk());

        // Validate the SysJobLog in the database
        List<SysJobLog> sysJobLogList = sysJobLogRepository.findAll();
        assertThat(sysJobLogList).hasSize(databaseSizeBeforeUpdate);
        SysJobLog testSysJobLog = sysJobLogList.get(sysJobLogList.size() - 1);
        assertThat(testSysJobLog.getJobName()).isEqualTo(UPDATED_JOB_NAME);
        assertThat(testSysJobLog.getJobGroup()).isEqualTo(UPDATED_JOB_GROUP);
        assertThat(testSysJobLog.getInvokeTarget()).isEqualTo(UPDATED_INVOKE_TARGET);
        assertThat(testSysJobLog.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testSysJobLog.getExceptionInfo()).isEqualTo(UPDATED_EXCEPTION_INFO);
        assertThat(testSysJobLog.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingSysJobLog() throws Exception {
        int databaseSizeBeforeUpdate = sysJobLogRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSysJobLogMockMvc.perform(put("/api/sys-job-logs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysJobLog)))
            .andExpect(status().isBadRequest());

        // Validate the SysJobLog in the database
        List<SysJobLog> sysJobLogList = sysJobLogRepository.findAll();
        assertThat(sysJobLogList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSysJobLog() throws Exception {
        // Initialize the database
        sysJobLogRepository.saveAndFlush(sysJobLog);

        int databaseSizeBeforeDelete = sysJobLogRepository.findAll().size();

        // Delete the sysJobLog
        restSysJobLogMockMvc.perform(delete("/api/sys-job-logs/{id}", sysJobLog.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SysJobLog> sysJobLogList = sysJobLogRepository.findAll();
        assertThat(sysJobLogList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
