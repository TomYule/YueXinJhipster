package com.yuexin.web.rest;

import com.yuexin.YueXinJhipsterApp;
import com.yuexin.domain.SysJob;
import com.yuexin.repository.SysJobRepository;

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
 * Integration tests for the {@link SysJobResource} REST controller.
 */
@SpringBootTest(classes = YueXinJhipsterApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class SysJobResourceIT {

    private static final String DEFAULT_JOB_NAME = "AAAAAAAAAA";
    private static final String UPDATED_JOB_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_JOB_GROUP = "AAAAAAAAAA";
    private static final String UPDATED_JOB_GROUP = "BBBBBBBBBB";

    private static final String DEFAULT_INVOKE_TARGET = "AAAAAAAAAA";
    private static final String UPDATED_INVOKE_TARGET = "BBBBBBBBBB";

    private static final String DEFAULT_CRON_EXPRESSION = "AAAAAAAAAA";
    private static final String UPDATED_CRON_EXPRESSION = "BBBBBBBBBB";

    private static final String DEFAULT_MISFIRE_POLICY = "AAAAAAAAAA";
    private static final String UPDATED_MISFIRE_POLICY = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

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
    private SysJobRepository sysJobRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSysJobMockMvc;

    private SysJob sysJob;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysJob createEntity(EntityManager em) {
        SysJob sysJob = new SysJob()
            .jobName(DEFAULT_JOB_NAME)
            .jobGroup(DEFAULT_JOB_GROUP)
            .invokeTarget(DEFAULT_INVOKE_TARGET)
            .cronExpression(DEFAULT_CRON_EXPRESSION)
            .misfirePolicy(DEFAULT_MISFIRE_POLICY)
            .status(DEFAULT_STATUS)
            .createBy(DEFAULT_CREATE_BY)
            .createTime(DEFAULT_CREATE_TIME)
            .updateBy(DEFAULT_UPDATE_BY)
            .upLocalDate(DEFAULT_UP_LOCAL_DATE)
            .remark(DEFAULT_REMARK);
        return sysJob;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysJob createUpdatedEntity(EntityManager em) {
        SysJob sysJob = new SysJob()
            .jobName(UPDATED_JOB_NAME)
            .jobGroup(UPDATED_JOB_GROUP)
            .invokeTarget(UPDATED_INVOKE_TARGET)
            .cronExpression(UPDATED_CRON_EXPRESSION)
            .misfirePolicy(UPDATED_MISFIRE_POLICY)
            .status(UPDATED_STATUS)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);
        return sysJob;
    }

    @BeforeEach
    public void initTest() {
        sysJob = createEntity(em);
    }

    @Test
    @Transactional
    public void createSysJob() throws Exception {
        int databaseSizeBeforeCreate = sysJobRepository.findAll().size();
        // Create the SysJob
        restSysJobMockMvc.perform(post("/api/sys-jobs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysJob)))
            .andExpect(status().isCreated());

        // Validate the SysJob in the database
        List<SysJob> sysJobList = sysJobRepository.findAll();
        assertThat(sysJobList).hasSize(databaseSizeBeforeCreate + 1);
        SysJob testSysJob = sysJobList.get(sysJobList.size() - 1);
        assertThat(testSysJob.getJobName()).isEqualTo(DEFAULT_JOB_NAME);
        assertThat(testSysJob.getJobGroup()).isEqualTo(DEFAULT_JOB_GROUP);
        assertThat(testSysJob.getInvokeTarget()).isEqualTo(DEFAULT_INVOKE_TARGET);
        assertThat(testSysJob.getCronExpression()).isEqualTo(DEFAULT_CRON_EXPRESSION);
        assertThat(testSysJob.getMisfirePolicy()).isEqualTo(DEFAULT_MISFIRE_POLICY);
        assertThat(testSysJob.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testSysJob.getCreateBy()).isEqualTo(DEFAULT_CREATE_BY);
        assertThat(testSysJob.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testSysJob.getUpdateBy()).isEqualTo(DEFAULT_UPDATE_BY);
        assertThat(testSysJob.getUpLocalDate()).isEqualTo(DEFAULT_UP_LOCAL_DATE);
        assertThat(testSysJob.getRemark()).isEqualTo(DEFAULT_REMARK);
    }

    @Test
    @Transactional
    public void createSysJobWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sysJobRepository.findAll().size();

        // Create the SysJob with an existing ID
        sysJob.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSysJobMockMvc.perform(post("/api/sys-jobs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysJob)))
            .andExpect(status().isBadRequest());

        // Validate the SysJob in the database
        List<SysJob> sysJobList = sysJobRepository.findAll();
        assertThat(sysJobList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSysJobs() throws Exception {
        // Initialize the database
        sysJobRepository.saveAndFlush(sysJob);

        // Get all the sysJobList
        restSysJobMockMvc.perform(get("/api/sys-jobs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sysJob.getId().intValue())))
            .andExpect(jsonPath("$.[*].jobName").value(hasItem(DEFAULT_JOB_NAME)))
            .andExpect(jsonPath("$.[*].jobGroup").value(hasItem(DEFAULT_JOB_GROUP)))
            .andExpect(jsonPath("$.[*].invokeTarget").value(hasItem(DEFAULT_INVOKE_TARGET)))
            .andExpect(jsonPath("$.[*].cronExpression").value(hasItem(DEFAULT_CRON_EXPRESSION)))
            .andExpect(jsonPath("$.[*].misfirePolicy").value(hasItem(DEFAULT_MISFIRE_POLICY)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].createBy").value(hasItem(DEFAULT_CREATE_BY)))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateBy").value(hasItem(DEFAULT_UPDATE_BY)))
            .andExpect(jsonPath("$.[*].upLocalDate").value(hasItem(DEFAULT_UP_LOCAL_DATE.toString())))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK.toString())));
    }
    
    @Test
    @Transactional
    public void getSysJob() throws Exception {
        // Initialize the database
        sysJobRepository.saveAndFlush(sysJob);

        // Get the sysJob
        restSysJobMockMvc.perform(get("/api/sys-jobs/{id}", sysJob.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sysJob.getId().intValue()))
            .andExpect(jsonPath("$.jobName").value(DEFAULT_JOB_NAME))
            .andExpect(jsonPath("$.jobGroup").value(DEFAULT_JOB_GROUP))
            .andExpect(jsonPath("$.invokeTarget").value(DEFAULT_INVOKE_TARGET))
            .andExpect(jsonPath("$.cronExpression").value(DEFAULT_CRON_EXPRESSION))
            .andExpect(jsonPath("$.misfirePolicy").value(DEFAULT_MISFIRE_POLICY))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.createBy").value(DEFAULT_CREATE_BY))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateBy").value(DEFAULT_UPDATE_BY))
            .andExpect(jsonPath("$.upLocalDate").value(DEFAULT_UP_LOCAL_DATE.toString()))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingSysJob() throws Exception {
        // Get the sysJob
        restSysJobMockMvc.perform(get("/api/sys-jobs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSysJob() throws Exception {
        // Initialize the database
        sysJobRepository.saveAndFlush(sysJob);

        int databaseSizeBeforeUpdate = sysJobRepository.findAll().size();

        // Update the sysJob
        SysJob updatedSysJob = sysJobRepository.findById(sysJob.getId()).get();
        // Disconnect from session so that the updates on updatedSysJob are not directly saved in db
        em.detach(updatedSysJob);
        updatedSysJob
            .jobName(UPDATED_JOB_NAME)
            .jobGroup(UPDATED_JOB_GROUP)
            .invokeTarget(UPDATED_INVOKE_TARGET)
            .cronExpression(UPDATED_CRON_EXPRESSION)
            .misfirePolicy(UPDATED_MISFIRE_POLICY)
            .status(UPDATED_STATUS)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);

        restSysJobMockMvc.perform(put("/api/sys-jobs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedSysJob)))
            .andExpect(status().isOk());

        // Validate the SysJob in the database
        List<SysJob> sysJobList = sysJobRepository.findAll();
        assertThat(sysJobList).hasSize(databaseSizeBeforeUpdate);
        SysJob testSysJob = sysJobList.get(sysJobList.size() - 1);
        assertThat(testSysJob.getJobName()).isEqualTo(UPDATED_JOB_NAME);
        assertThat(testSysJob.getJobGroup()).isEqualTo(UPDATED_JOB_GROUP);
        assertThat(testSysJob.getInvokeTarget()).isEqualTo(UPDATED_INVOKE_TARGET);
        assertThat(testSysJob.getCronExpression()).isEqualTo(UPDATED_CRON_EXPRESSION);
        assertThat(testSysJob.getMisfirePolicy()).isEqualTo(UPDATED_MISFIRE_POLICY);
        assertThat(testSysJob.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testSysJob.getCreateBy()).isEqualTo(UPDATED_CREATE_BY);
        assertThat(testSysJob.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testSysJob.getUpdateBy()).isEqualTo(UPDATED_UPDATE_BY);
        assertThat(testSysJob.getUpLocalDate()).isEqualTo(UPDATED_UP_LOCAL_DATE);
        assertThat(testSysJob.getRemark()).isEqualTo(UPDATED_REMARK);
    }

    @Test
    @Transactional
    public void updateNonExistingSysJob() throws Exception {
        int databaseSizeBeforeUpdate = sysJobRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSysJobMockMvc.perform(put("/api/sys-jobs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysJob)))
            .andExpect(status().isBadRequest());

        // Validate the SysJob in the database
        List<SysJob> sysJobList = sysJobRepository.findAll();
        assertThat(sysJobList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSysJob() throws Exception {
        // Initialize the database
        sysJobRepository.saveAndFlush(sysJob);

        int databaseSizeBeforeDelete = sysJobRepository.findAll().size();

        // Delete the sysJob
        restSysJobMockMvc.perform(delete("/api/sys-jobs/{id}", sysJob.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SysJob> sysJobList = sysJobRepository.findAll();
        assertThat(sysJobList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
