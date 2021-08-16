package com.yuexin.web.rest;

import com.yuexin.YueXinJhipsterApp;
import com.yuexin.domain.SysDictType;
import com.yuexin.repository.SysDictTypeRepository;

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
 * Integration tests for the {@link SysDictTypeResource} REST controller.
 */
@SpringBootTest(classes = YueXinJhipsterApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class SysDictTypeResourceIT {

    private static final String DEFAULT_DICT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_DICT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_DICT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_DICT_TYPE = "BBBBBBBBBB";

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
    private SysDictTypeRepository sysDictTypeRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSysDictTypeMockMvc;

    private SysDictType sysDictType;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysDictType createEntity(EntityManager em) {
        SysDictType sysDictType = new SysDictType()
            .dictName(DEFAULT_DICT_NAME)
            .dictType(DEFAULT_DICT_TYPE)
            .status(DEFAULT_STATUS)
            .createBy(DEFAULT_CREATE_BY)
            .createTime(DEFAULT_CREATE_TIME)
            .updateBy(DEFAULT_UPDATE_BY)
            .upLocalDate(DEFAULT_UP_LOCAL_DATE)
            .remark(DEFAULT_REMARK);
        return sysDictType;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysDictType createUpdatedEntity(EntityManager em) {
        SysDictType sysDictType = new SysDictType()
            .dictName(UPDATED_DICT_NAME)
            .dictType(UPDATED_DICT_TYPE)
            .status(UPDATED_STATUS)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);
        return sysDictType;
    }

    @BeforeEach
    public void initTest() {
        sysDictType = createEntity(em);
    }

    @Test
    @Transactional
    public void createSysDictType() throws Exception {
        int databaseSizeBeforeCreate = sysDictTypeRepository.findAll().size();
        // Create the SysDictType
        restSysDictTypeMockMvc.perform(post("/api/sys-dict-types").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysDictType)))
            .andExpect(status().isCreated());

        // Validate the SysDictType in the database
        List<SysDictType> sysDictTypeList = sysDictTypeRepository.findAll();
        assertThat(sysDictTypeList).hasSize(databaseSizeBeforeCreate + 1);
        SysDictType testSysDictType = sysDictTypeList.get(sysDictTypeList.size() - 1);
        assertThat(testSysDictType.getDictName()).isEqualTo(DEFAULT_DICT_NAME);
        assertThat(testSysDictType.getDictType()).isEqualTo(DEFAULT_DICT_TYPE);
        assertThat(testSysDictType.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testSysDictType.getCreateBy()).isEqualTo(DEFAULT_CREATE_BY);
        assertThat(testSysDictType.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testSysDictType.getUpdateBy()).isEqualTo(DEFAULT_UPDATE_BY);
        assertThat(testSysDictType.getUpLocalDate()).isEqualTo(DEFAULT_UP_LOCAL_DATE);
        assertThat(testSysDictType.getRemark()).isEqualTo(DEFAULT_REMARK);
    }

    @Test
    @Transactional
    public void createSysDictTypeWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sysDictTypeRepository.findAll().size();

        // Create the SysDictType with an existing ID
        sysDictType.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSysDictTypeMockMvc.perform(post("/api/sys-dict-types").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysDictType)))
            .andExpect(status().isBadRequest());

        // Validate the SysDictType in the database
        List<SysDictType> sysDictTypeList = sysDictTypeRepository.findAll();
        assertThat(sysDictTypeList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSysDictTypes() throws Exception {
        // Initialize the database
        sysDictTypeRepository.saveAndFlush(sysDictType);

        // Get all the sysDictTypeList
        restSysDictTypeMockMvc.perform(get("/api/sys-dict-types?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sysDictType.getId().intValue())))
            .andExpect(jsonPath("$.[*].dictName").value(hasItem(DEFAULT_DICT_NAME)))
            .andExpect(jsonPath("$.[*].dictType").value(hasItem(DEFAULT_DICT_TYPE)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].createBy").value(hasItem(DEFAULT_CREATE_BY)))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateBy").value(hasItem(DEFAULT_UPDATE_BY)))
            .andExpect(jsonPath("$.[*].upLocalDate").value(hasItem(DEFAULT_UP_LOCAL_DATE.toString())))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK.toString())));
    }
    
    @Test
    @Transactional
    public void getSysDictType() throws Exception {
        // Initialize the database
        sysDictTypeRepository.saveAndFlush(sysDictType);

        // Get the sysDictType
        restSysDictTypeMockMvc.perform(get("/api/sys-dict-types/{id}", sysDictType.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sysDictType.getId().intValue()))
            .andExpect(jsonPath("$.dictName").value(DEFAULT_DICT_NAME))
            .andExpect(jsonPath("$.dictType").value(DEFAULT_DICT_TYPE))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.createBy").value(DEFAULT_CREATE_BY))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateBy").value(DEFAULT_UPDATE_BY))
            .andExpect(jsonPath("$.upLocalDate").value(DEFAULT_UP_LOCAL_DATE.toString()))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingSysDictType() throws Exception {
        // Get the sysDictType
        restSysDictTypeMockMvc.perform(get("/api/sys-dict-types/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSysDictType() throws Exception {
        // Initialize the database
        sysDictTypeRepository.saveAndFlush(sysDictType);

        int databaseSizeBeforeUpdate = sysDictTypeRepository.findAll().size();

        // Update the sysDictType
        SysDictType updatedSysDictType = sysDictTypeRepository.findById(sysDictType.getId()).get();
        // Disconnect from session so that the updates on updatedSysDictType are not directly saved in db
        em.detach(updatedSysDictType);
        updatedSysDictType
            .dictName(UPDATED_DICT_NAME)
            .dictType(UPDATED_DICT_TYPE)
            .status(UPDATED_STATUS)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);

        restSysDictTypeMockMvc.perform(put("/api/sys-dict-types").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedSysDictType)))
            .andExpect(status().isOk());

        // Validate the SysDictType in the database
        List<SysDictType> sysDictTypeList = sysDictTypeRepository.findAll();
        assertThat(sysDictTypeList).hasSize(databaseSizeBeforeUpdate);
        SysDictType testSysDictType = sysDictTypeList.get(sysDictTypeList.size() - 1);
        assertThat(testSysDictType.getDictName()).isEqualTo(UPDATED_DICT_NAME);
        assertThat(testSysDictType.getDictType()).isEqualTo(UPDATED_DICT_TYPE);
        assertThat(testSysDictType.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testSysDictType.getCreateBy()).isEqualTo(UPDATED_CREATE_BY);
        assertThat(testSysDictType.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testSysDictType.getUpdateBy()).isEqualTo(UPDATED_UPDATE_BY);
        assertThat(testSysDictType.getUpLocalDate()).isEqualTo(UPDATED_UP_LOCAL_DATE);
        assertThat(testSysDictType.getRemark()).isEqualTo(UPDATED_REMARK);
    }

    @Test
    @Transactional
    public void updateNonExistingSysDictType() throws Exception {
        int databaseSizeBeforeUpdate = sysDictTypeRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSysDictTypeMockMvc.perform(put("/api/sys-dict-types").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysDictType)))
            .andExpect(status().isBadRequest());

        // Validate the SysDictType in the database
        List<SysDictType> sysDictTypeList = sysDictTypeRepository.findAll();
        assertThat(sysDictTypeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSysDictType() throws Exception {
        // Initialize the database
        sysDictTypeRepository.saveAndFlush(sysDictType);

        int databaseSizeBeforeDelete = sysDictTypeRepository.findAll().size();

        // Delete the sysDictType
        restSysDictTypeMockMvc.perform(delete("/api/sys-dict-types/{id}", sysDictType.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SysDictType> sysDictTypeList = sysDictTypeRepository.findAll();
        assertThat(sysDictTypeList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
