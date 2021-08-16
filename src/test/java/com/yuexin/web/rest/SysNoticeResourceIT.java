package com.yuexin.web.rest;

import com.yuexin.YueXinJhipsterApp;
import com.yuexin.domain.SysNotice;
import com.yuexin.repository.SysNoticeRepository;

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
 * Integration tests for the {@link SysNoticeResource} REST controller.
 */
@SpringBootTest(classes = YueXinJhipsterApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class SysNoticeResourceIT {

    private static final String DEFAULT_NOTICE_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_NOTICE_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_NOTICE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_NOTICE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_NOTICE_CONTENT = "AAAAAAAAAA";
    private static final String UPDATED_NOTICE_CONTENT = "BBBBBBBBBB";

    private static final Integer DEFAULT_STATUS = 1;
    private static final Integer UPDATED_STATUS = 2;

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
    private SysNoticeRepository sysNoticeRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSysNoticeMockMvc;

    private SysNotice sysNotice;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysNotice createEntity(EntityManager em) {
        SysNotice sysNotice = new SysNotice()
            .noticeTitle(DEFAULT_NOTICE_TITLE)
            .noticeType(DEFAULT_NOTICE_TYPE)
            .noticeContent(DEFAULT_NOTICE_CONTENT)
            .status(DEFAULT_STATUS)
            .createBy(DEFAULT_CREATE_BY)
            .createTime(DEFAULT_CREATE_TIME)
            .updateBy(DEFAULT_UPDATE_BY)
            .upLocalDate(DEFAULT_UP_LOCAL_DATE)
            .remark(DEFAULT_REMARK);
        return sysNotice;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysNotice createUpdatedEntity(EntityManager em) {
        SysNotice sysNotice = new SysNotice()
            .noticeTitle(UPDATED_NOTICE_TITLE)
            .noticeType(UPDATED_NOTICE_TYPE)
            .noticeContent(UPDATED_NOTICE_CONTENT)
            .status(UPDATED_STATUS)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);
        return sysNotice;
    }

    @BeforeEach
    public void initTest() {
        sysNotice = createEntity(em);
    }

    @Test
    @Transactional
    public void createSysNotice() throws Exception {
        int databaseSizeBeforeCreate = sysNoticeRepository.findAll().size();
        // Create the SysNotice
        restSysNoticeMockMvc.perform(post("/api/sys-notices").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysNotice)))
            .andExpect(status().isCreated());

        // Validate the SysNotice in the database
        List<SysNotice> sysNoticeList = sysNoticeRepository.findAll();
        assertThat(sysNoticeList).hasSize(databaseSizeBeforeCreate + 1);
        SysNotice testSysNotice = sysNoticeList.get(sysNoticeList.size() - 1);
        assertThat(testSysNotice.getNoticeTitle()).isEqualTo(DEFAULT_NOTICE_TITLE);
        assertThat(testSysNotice.getNoticeType()).isEqualTo(DEFAULT_NOTICE_TYPE);
        assertThat(testSysNotice.getNoticeContent()).isEqualTo(DEFAULT_NOTICE_CONTENT);
        assertThat(testSysNotice.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testSysNotice.getCreateBy()).isEqualTo(DEFAULT_CREATE_BY);
        assertThat(testSysNotice.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testSysNotice.getUpdateBy()).isEqualTo(DEFAULT_UPDATE_BY);
        assertThat(testSysNotice.getUpLocalDate()).isEqualTo(DEFAULT_UP_LOCAL_DATE);
        assertThat(testSysNotice.getRemark()).isEqualTo(DEFAULT_REMARK);
    }

    @Test
    @Transactional
    public void createSysNoticeWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sysNoticeRepository.findAll().size();

        // Create the SysNotice with an existing ID
        sysNotice.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSysNoticeMockMvc.perform(post("/api/sys-notices").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysNotice)))
            .andExpect(status().isBadRequest());

        // Validate the SysNotice in the database
        List<SysNotice> sysNoticeList = sysNoticeRepository.findAll();
        assertThat(sysNoticeList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkNoticeTitleIsRequired() throws Exception {
        int databaseSizeBeforeTest = sysNoticeRepository.findAll().size();
        // set the field null
        sysNotice.setNoticeTitle(null);

        // Create the SysNotice, which fails.


        restSysNoticeMockMvc.perform(post("/api/sys-notices").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysNotice)))
            .andExpect(status().isBadRequest());

        List<SysNotice> sysNoticeList = sysNoticeRepository.findAll();
        assertThat(sysNoticeList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllSysNotices() throws Exception {
        // Initialize the database
        sysNoticeRepository.saveAndFlush(sysNotice);

        // Get all the sysNoticeList
        restSysNoticeMockMvc.perform(get("/api/sys-notices?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sysNotice.getId().intValue())))
            .andExpect(jsonPath("$.[*].noticeTitle").value(hasItem(DEFAULT_NOTICE_TITLE)))
            .andExpect(jsonPath("$.[*].noticeType").value(hasItem(DEFAULT_NOTICE_TYPE)))
            .andExpect(jsonPath("$.[*].noticeContent").value(hasItem(DEFAULT_NOTICE_CONTENT)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].createBy").value(hasItem(DEFAULT_CREATE_BY)))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateBy").value(hasItem(DEFAULT_UPDATE_BY)))
            .andExpect(jsonPath("$.[*].upLocalDate").value(hasItem(DEFAULT_UP_LOCAL_DATE.toString())))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK.toString())));
    }
    
    @Test
    @Transactional
    public void getSysNotice() throws Exception {
        // Initialize the database
        sysNoticeRepository.saveAndFlush(sysNotice);

        // Get the sysNotice
        restSysNoticeMockMvc.perform(get("/api/sys-notices/{id}", sysNotice.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sysNotice.getId().intValue()))
            .andExpect(jsonPath("$.noticeTitle").value(DEFAULT_NOTICE_TITLE))
            .andExpect(jsonPath("$.noticeType").value(DEFAULT_NOTICE_TYPE))
            .andExpect(jsonPath("$.noticeContent").value(DEFAULT_NOTICE_CONTENT))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.createBy").value(DEFAULT_CREATE_BY))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateBy").value(DEFAULT_UPDATE_BY))
            .andExpect(jsonPath("$.upLocalDate").value(DEFAULT_UP_LOCAL_DATE.toString()))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingSysNotice() throws Exception {
        // Get the sysNotice
        restSysNoticeMockMvc.perform(get("/api/sys-notices/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSysNotice() throws Exception {
        // Initialize the database
        sysNoticeRepository.saveAndFlush(sysNotice);

        int databaseSizeBeforeUpdate = sysNoticeRepository.findAll().size();

        // Update the sysNotice
        SysNotice updatedSysNotice = sysNoticeRepository.findById(sysNotice.getId()).get();
        // Disconnect from session so that the updates on updatedSysNotice are not directly saved in db
        em.detach(updatedSysNotice);
        updatedSysNotice
            .noticeTitle(UPDATED_NOTICE_TITLE)
            .noticeType(UPDATED_NOTICE_TYPE)
            .noticeContent(UPDATED_NOTICE_CONTENT)
            .status(UPDATED_STATUS)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);

        restSysNoticeMockMvc.perform(put("/api/sys-notices").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedSysNotice)))
            .andExpect(status().isOk());

        // Validate the SysNotice in the database
        List<SysNotice> sysNoticeList = sysNoticeRepository.findAll();
        assertThat(sysNoticeList).hasSize(databaseSizeBeforeUpdate);
        SysNotice testSysNotice = sysNoticeList.get(sysNoticeList.size() - 1);
        assertThat(testSysNotice.getNoticeTitle()).isEqualTo(UPDATED_NOTICE_TITLE);
        assertThat(testSysNotice.getNoticeType()).isEqualTo(UPDATED_NOTICE_TYPE);
        assertThat(testSysNotice.getNoticeContent()).isEqualTo(UPDATED_NOTICE_CONTENT);
        assertThat(testSysNotice.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testSysNotice.getCreateBy()).isEqualTo(UPDATED_CREATE_BY);
        assertThat(testSysNotice.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testSysNotice.getUpdateBy()).isEqualTo(UPDATED_UPDATE_BY);
        assertThat(testSysNotice.getUpLocalDate()).isEqualTo(UPDATED_UP_LOCAL_DATE);
        assertThat(testSysNotice.getRemark()).isEqualTo(UPDATED_REMARK);
    }

    @Test
    @Transactional
    public void updateNonExistingSysNotice() throws Exception {
        int databaseSizeBeforeUpdate = sysNoticeRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSysNoticeMockMvc.perform(put("/api/sys-notices").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysNotice)))
            .andExpect(status().isBadRequest());

        // Validate the SysNotice in the database
        List<SysNotice> sysNoticeList = sysNoticeRepository.findAll();
        assertThat(sysNoticeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSysNotice() throws Exception {
        // Initialize the database
        sysNoticeRepository.saveAndFlush(sysNotice);

        int databaseSizeBeforeDelete = sysNoticeRepository.findAll().size();

        // Delete the sysNotice
        restSysNoticeMockMvc.perform(delete("/api/sys-notices/{id}", sysNotice.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SysNotice> sysNoticeList = sysNoticeRepository.findAll();
        assertThat(sysNoticeList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
