package com.yuexin.web.rest;

import com.yuexin.YueXinJhipsterApp;
import com.yuexin.domain.SysPost;
import com.yuexin.repository.SysPostRepository;

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
 * Integration tests for the {@link SysPostResource} REST controller.
 */
@SpringBootTest(classes = YueXinJhipsterApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class SysPostResourceIT {

    private static final String DEFAULT_POST_CODE = "AAAAAAAAAA";
    private static final String UPDATED_POST_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_POST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_POST_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_POST_SORT = 1;
    private static final Integer UPDATED_POST_SORT = 2;

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
    private SysPostRepository sysPostRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSysPostMockMvc;

    private SysPost sysPost;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysPost createEntity(EntityManager em) {
        SysPost sysPost = new SysPost()
            .postCode(DEFAULT_POST_CODE)
            .postName(DEFAULT_POST_NAME)
            .postSort(DEFAULT_POST_SORT)
            .status(DEFAULT_STATUS)
            .createBy(DEFAULT_CREATE_BY)
            .createTime(DEFAULT_CREATE_TIME)
            .updateBy(DEFAULT_UPDATE_BY)
            .upLocalDate(DEFAULT_UP_LOCAL_DATE)
            .remark(DEFAULT_REMARK);
        return sysPost;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysPost createUpdatedEntity(EntityManager em) {
        SysPost sysPost = new SysPost()
            .postCode(UPDATED_POST_CODE)
            .postName(UPDATED_POST_NAME)
            .postSort(UPDATED_POST_SORT)
            .status(UPDATED_STATUS)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);
        return sysPost;
    }

    @BeforeEach
    public void initTest() {
        sysPost = createEntity(em);
    }

    @Test
    @Transactional
    public void createSysPost() throws Exception {
        int databaseSizeBeforeCreate = sysPostRepository.findAll().size();
        // Create the SysPost
        restSysPostMockMvc.perform(post("/api/sys-posts").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysPost)))
            .andExpect(status().isCreated());

        // Validate the SysPost in the database
        List<SysPost> sysPostList = sysPostRepository.findAll();
        assertThat(sysPostList).hasSize(databaseSizeBeforeCreate + 1);
        SysPost testSysPost = sysPostList.get(sysPostList.size() - 1);
        assertThat(testSysPost.getPostCode()).isEqualTo(DEFAULT_POST_CODE);
        assertThat(testSysPost.getPostName()).isEqualTo(DEFAULT_POST_NAME);
        assertThat(testSysPost.getPostSort()).isEqualTo(DEFAULT_POST_SORT);
        assertThat(testSysPost.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testSysPost.getCreateBy()).isEqualTo(DEFAULT_CREATE_BY);
        assertThat(testSysPost.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testSysPost.getUpdateBy()).isEqualTo(DEFAULT_UPDATE_BY);
        assertThat(testSysPost.getUpLocalDate()).isEqualTo(DEFAULT_UP_LOCAL_DATE);
        assertThat(testSysPost.getRemark()).isEqualTo(DEFAULT_REMARK);
    }

    @Test
    @Transactional
    public void createSysPostWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sysPostRepository.findAll().size();

        // Create the SysPost with an existing ID
        sysPost.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSysPostMockMvc.perform(post("/api/sys-posts").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysPost)))
            .andExpect(status().isBadRequest());

        // Validate the SysPost in the database
        List<SysPost> sysPostList = sysPostRepository.findAll();
        assertThat(sysPostList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSysPosts() throws Exception {
        // Initialize the database
        sysPostRepository.saveAndFlush(sysPost);

        // Get all the sysPostList
        restSysPostMockMvc.perform(get("/api/sys-posts?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sysPost.getId().intValue())))
            .andExpect(jsonPath("$.[*].postCode").value(hasItem(DEFAULT_POST_CODE)))
            .andExpect(jsonPath("$.[*].postName").value(hasItem(DEFAULT_POST_NAME)))
            .andExpect(jsonPath("$.[*].postSort").value(hasItem(DEFAULT_POST_SORT)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].createBy").value(hasItem(DEFAULT_CREATE_BY)))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateBy").value(hasItem(DEFAULT_UPDATE_BY)))
            .andExpect(jsonPath("$.[*].upLocalDate").value(hasItem(DEFAULT_UP_LOCAL_DATE.toString())))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK.toString())));
    }
    
    @Test
    @Transactional
    public void getSysPost() throws Exception {
        // Initialize the database
        sysPostRepository.saveAndFlush(sysPost);

        // Get the sysPost
        restSysPostMockMvc.perform(get("/api/sys-posts/{id}", sysPost.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sysPost.getId().intValue()))
            .andExpect(jsonPath("$.postCode").value(DEFAULT_POST_CODE))
            .andExpect(jsonPath("$.postName").value(DEFAULT_POST_NAME))
            .andExpect(jsonPath("$.postSort").value(DEFAULT_POST_SORT))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.createBy").value(DEFAULT_CREATE_BY))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateBy").value(DEFAULT_UPDATE_BY))
            .andExpect(jsonPath("$.upLocalDate").value(DEFAULT_UP_LOCAL_DATE.toString()))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingSysPost() throws Exception {
        // Get the sysPost
        restSysPostMockMvc.perform(get("/api/sys-posts/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSysPost() throws Exception {
        // Initialize the database
        sysPostRepository.saveAndFlush(sysPost);

        int databaseSizeBeforeUpdate = sysPostRepository.findAll().size();

        // Update the sysPost
        SysPost updatedSysPost = sysPostRepository.findById(sysPost.getId()).get();
        // Disconnect from session so that the updates on updatedSysPost are not directly saved in db
        em.detach(updatedSysPost);
        updatedSysPost
            .postCode(UPDATED_POST_CODE)
            .postName(UPDATED_POST_NAME)
            .postSort(UPDATED_POST_SORT)
            .status(UPDATED_STATUS)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);

        restSysPostMockMvc.perform(put("/api/sys-posts").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedSysPost)))
            .andExpect(status().isOk());

        // Validate the SysPost in the database
        List<SysPost> sysPostList = sysPostRepository.findAll();
        assertThat(sysPostList).hasSize(databaseSizeBeforeUpdate);
        SysPost testSysPost = sysPostList.get(sysPostList.size() - 1);
        assertThat(testSysPost.getPostCode()).isEqualTo(UPDATED_POST_CODE);
        assertThat(testSysPost.getPostName()).isEqualTo(UPDATED_POST_NAME);
        assertThat(testSysPost.getPostSort()).isEqualTo(UPDATED_POST_SORT);
        assertThat(testSysPost.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testSysPost.getCreateBy()).isEqualTo(UPDATED_CREATE_BY);
        assertThat(testSysPost.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testSysPost.getUpdateBy()).isEqualTo(UPDATED_UPDATE_BY);
        assertThat(testSysPost.getUpLocalDate()).isEqualTo(UPDATED_UP_LOCAL_DATE);
        assertThat(testSysPost.getRemark()).isEqualTo(UPDATED_REMARK);
    }

    @Test
    @Transactional
    public void updateNonExistingSysPost() throws Exception {
        int databaseSizeBeforeUpdate = sysPostRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSysPostMockMvc.perform(put("/api/sys-posts").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysPost)))
            .andExpect(status().isBadRequest());

        // Validate the SysPost in the database
        List<SysPost> sysPostList = sysPostRepository.findAll();
        assertThat(sysPostList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSysPost() throws Exception {
        // Initialize the database
        sysPostRepository.saveAndFlush(sysPost);

        int databaseSizeBeforeDelete = sysPostRepository.findAll().size();

        // Delete the sysPost
        restSysPostMockMvc.perform(delete("/api/sys-posts/{id}", sysPost.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SysPost> sysPostList = sysPostRepository.findAll();
        assertThat(sysPostList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
