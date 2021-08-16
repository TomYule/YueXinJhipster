package com.yuexin.web.rest;

import com.yuexin.YueXinJhipsterApp;
import com.yuexin.domain.SysDept;
import com.yuexin.repository.SysDeptRepository;

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
 * Integration tests for the {@link SysDeptResource} REST controller.
 */
@SpringBootTest(classes = YueXinJhipsterApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class SysDeptResourceIT {

    private static final String DEFAULT_DEPT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_DEPT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PARENT_ID = "AAAAAAAAAA";
    private static final String UPDATED_PARENT_ID = "BBBBBBBBBB";

    private static final String DEFAULT_ANCESTORS = "AAAAAAAAAA";
    private static final String UPDATED_ANCESTORS = "BBBBBBBBBB";

    private static final Integer DEFAULT_ORDER_NUM = 1;
    private static final Integer UPDATED_ORDER_NUM = 2;

    private static final String DEFAULT_LEADER = "AAAAAAAAAA";
    private static final String UPDATED_LEADER = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE = "AAAAAAAAAA";
    private static final String UPDATED_PHONE = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_DEL_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_DEL_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_CREATE_BY = "AAAAAAAAAA";
    private static final String UPDATED_CREATE_BY = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_CREATE_TIME = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CREATE_TIME = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_UPDATE_BY = "AAAAAAAAAA";
    private static final String UPDATED_UPDATE_BY = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_UP_LOCAL_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UP_LOCAL_DATE = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private SysDeptRepository sysDeptRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSysDeptMockMvc;

    private SysDept sysDept;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysDept createEntity(EntityManager em) {
        SysDept sysDept = new SysDept()
            .deptName(DEFAULT_DEPT_NAME)
            .parentId(DEFAULT_PARENT_ID)
            .ancestors(DEFAULT_ANCESTORS)
            .orderNum(DEFAULT_ORDER_NUM)
            .leader(DEFAULT_LEADER)
            .phone(DEFAULT_PHONE)
            .email(DEFAULT_EMAIL)
            .status(DEFAULT_STATUS)
            .delFlag(DEFAULT_DEL_FLAG)
            .createBy(DEFAULT_CREATE_BY)
            .createTime(DEFAULT_CREATE_TIME)
            .updateBy(DEFAULT_UPDATE_BY)
            .upLocalDate(DEFAULT_UP_LOCAL_DATE);
        return sysDept;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysDept createUpdatedEntity(EntityManager em) {
        SysDept sysDept = new SysDept()
            .deptName(UPDATED_DEPT_NAME)
            .parentId(UPDATED_PARENT_ID)
            .ancestors(UPDATED_ANCESTORS)
            .orderNum(UPDATED_ORDER_NUM)
            .leader(UPDATED_LEADER)
            .phone(UPDATED_PHONE)
            .email(UPDATED_EMAIL)
            .status(UPDATED_STATUS)
            .delFlag(UPDATED_DEL_FLAG)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE);
        return sysDept;
    }

    @BeforeEach
    public void initTest() {
        sysDept = createEntity(em);
    }

    @Test
    @Transactional
    public void createSysDept() throws Exception {
        int databaseSizeBeforeCreate = sysDeptRepository.findAll().size();
        // Create the SysDept
        restSysDeptMockMvc.perform(post("/api/sys-depts").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysDept)))
            .andExpect(status().isCreated());

        // Validate the SysDept in the database
        List<SysDept> sysDeptList = sysDeptRepository.findAll();
        assertThat(sysDeptList).hasSize(databaseSizeBeforeCreate + 1);
        SysDept testSysDept = sysDeptList.get(sysDeptList.size() - 1);
        assertThat(testSysDept.getDeptName()).isEqualTo(DEFAULT_DEPT_NAME);
        assertThat(testSysDept.getParentId()).isEqualTo(DEFAULT_PARENT_ID);
        assertThat(testSysDept.getAncestors()).isEqualTo(DEFAULT_ANCESTORS);
        assertThat(testSysDept.getOrderNum()).isEqualTo(DEFAULT_ORDER_NUM);
        assertThat(testSysDept.getLeader()).isEqualTo(DEFAULT_LEADER);
        assertThat(testSysDept.getPhone()).isEqualTo(DEFAULT_PHONE);
        assertThat(testSysDept.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testSysDept.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testSysDept.getDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testSysDept.getCreateBy()).isEqualTo(DEFAULT_CREATE_BY);
        assertThat(testSysDept.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testSysDept.getUpdateBy()).isEqualTo(DEFAULT_UPDATE_BY);
        assertThat(testSysDept.getUpLocalDate()).isEqualTo(DEFAULT_UP_LOCAL_DATE);
    }

    @Test
    @Transactional
    public void createSysDeptWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sysDeptRepository.findAll().size();

        // Create the SysDept with an existing ID
        sysDept.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSysDeptMockMvc.perform(post("/api/sys-depts").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysDept)))
            .andExpect(status().isBadRequest());

        // Validate the SysDept in the database
        List<SysDept> sysDeptList = sysDeptRepository.findAll();
        assertThat(sysDeptList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkDeptNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = sysDeptRepository.findAll().size();
        // set the field null
        sysDept.setDeptName(null);

        // Create the SysDept, which fails.


        restSysDeptMockMvc.perform(post("/api/sys-depts").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysDept)))
            .andExpect(status().isBadRequest());

        List<SysDept> sysDeptList = sysDeptRepository.findAll();
        assertThat(sysDeptList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllSysDepts() throws Exception {
        // Initialize the database
        sysDeptRepository.saveAndFlush(sysDept);

        // Get all the sysDeptList
        restSysDeptMockMvc.perform(get("/api/sys-depts?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sysDept.getId().intValue())))
            .andExpect(jsonPath("$.[*].deptName").value(hasItem(DEFAULT_DEPT_NAME)))
            .andExpect(jsonPath("$.[*].parentId").value(hasItem(DEFAULT_PARENT_ID)))
            .andExpect(jsonPath("$.[*].ancestors").value(hasItem(DEFAULT_ANCESTORS)))
            .andExpect(jsonPath("$.[*].orderNum").value(hasItem(DEFAULT_ORDER_NUM)))
            .andExpect(jsonPath("$.[*].leader").value(hasItem(DEFAULT_LEADER)))
            .andExpect(jsonPath("$.[*].phone").value(hasItem(DEFAULT_PHONE)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].delFlag").value(hasItem(DEFAULT_DEL_FLAG)))
            .andExpect(jsonPath("$.[*].createBy").value(hasItem(DEFAULT_CREATE_BY)))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateBy").value(hasItem(DEFAULT_UPDATE_BY)))
            .andExpect(jsonPath("$.[*].upLocalDate").value(hasItem(DEFAULT_UP_LOCAL_DATE.toString())));
    }
    
    @Test
    @Transactional
    public void getSysDept() throws Exception {
        // Initialize the database
        sysDeptRepository.saveAndFlush(sysDept);

        // Get the sysDept
        restSysDeptMockMvc.perform(get("/api/sys-depts/{id}", sysDept.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sysDept.getId().intValue()))
            .andExpect(jsonPath("$.deptName").value(DEFAULT_DEPT_NAME))
            .andExpect(jsonPath("$.parentId").value(DEFAULT_PARENT_ID))
            .andExpect(jsonPath("$.ancestors").value(DEFAULT_ANCESTORS))
            .andExpect(jsonPath("$.orderNum").value(DEFAULT_ORDER_NUM))
            .andExpect(jsonPath("$.leader").value(DEFAULT_LEADER))
            .andExpect(jsonPath("$.phone").value(DEFAULT_PHONE))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.delFlag").value(DEFAULT_DEL_FLAG))
            .andExpect(jsonPath("$.createBy").value(DEFAULT_CREATE_BY))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateBy").value(DEFAULT_UPDATE_BY))
            .andExpect(jsonPath("$.upLocalDate").value(DEFAULT_UP_LOCAL_DATE.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingSysDept() throws Exception {
        // Get the sysDept
        restSysDeptMockMvc.perform(get("/api/sys-depts/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSysDept() throws Exception {
        // Initialize the database
        sysDeptRepository.saveAndFlush(sysDept);

        int databaseSizeBeforeUpdate = sysDeptRepository.findAll().size();

        // Update the sysDept
        SysDept updatedSysDept = sysDeptRepository.findById(sysDept.getId()).get();
        // Disconnect from session so that the updates on updatedSysDept are not directly saved in db
        em.detach(updatedSysDept);
        updatedSysDept
            .deptName(UPDATED_DEPT_NAME)
            .parentId(UPDATED_PARENT_ID)
            .ancestors(UPDATED_ANCESTORS)
            .orderNum(UPDATED_ORDER_NUM)
            .leader(UPDATED_LEADER)
            .phone(UPDATED_PHONE)
            .email(UPDATED_EMAIL)
            .status(UPDATED_STATUS)
            .delFlag(UPDATED_DEL_FLAG)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE);

        restSysDeptMockMvc.perform(put("/api/sys-depts").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedSysDept)))
            .andExpect(status().isOk());

        // Validate the SysDept in the database
        List<SysDept> sysDeptList = sysDeptRepository.findAll();
        assertThat(sysDeptList).hasSize(databaseSizeBeforeUpdate);
        SysDept testSysDept = sysDeptList.get(sysDeptList.size() - 1);
        assertThat(testSysDept.getDeptName()).isEqualTo(UPDATED_DEPT_NAME);
        assertThat(testSysDept.getParentId()).isEqualTo(UPDATED_PARENT_ID);
        assertThat(testSysDept.getAncestors()).isEqualTo(UPDATED_ANCESTORS);
        assertThat(testSysDept.getOrderNum()).isEqualTo(UPDATED_ORDER_NUM);
        assertThat(testSysDept.getLeader()).isEqualTo(UPDATED_LEADER);
        assertThat(testSysDept.getPhone()).isEqualTo(UPDATED_PHONE);
        assertThat(testSysDept.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testSysDept.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testSysDept.getDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testSysDept.getCreateBy()).isEqualTo(UPDATED_CREATE_BY);
        assertThat(testSysDept.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testSysDept.getUpdateBy()).isEqualTo(UPDATED_UPDATE_BY);
        assertThat(testSysDept.getUpLocalDate()).isEqualTo(UPDATED_UP_LOCAL_DATE);
    }

    @Test
    @Transactional
    public void updateNonExistingSysDept() throws Exception {
        int databaseSizeBeforeUpdate = sysDeptRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSysDeptMockMvc.perform(put("/api/sys-depts").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysDept)))
            .andExpect(status().isBadRequest());

        // Validate the SysDept in the database
        List<SysDept> sysDeptList = sysDeptRepository.findAll();
        assertThat(sysDeptList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSysDept() throws Exception {
        // Initialize the database
        sysDeptRepository.saveAndFlush(sysDept);

        int databaseSizeBeforeDelete = sysDeptRepository.findAll().size();

        // Delete the sysDept
        restSysDeptMockMvc.perform(delete("/api/sys-depts/{id}", sysDept.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SysDept> sysDeptList = sysDeptRepository.findAll();
        assertThat(sysDeptList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
