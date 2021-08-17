package com.yuexin.web.rest;

import com.yuexin.YueXinJhipsterApp;
import com.yuexin.domain.SysDictData;
import com.yuexin.repository.SysDictDataRepository;

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
 * Integration tests for the {@link SysDictDataResource} REST controller.
 */
@SpringBootTest(classes = YueXinJhipsterApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class SysDictDataResourceIT {

    private static final String DEFAULT_DICT_SORT = "AAAAAAAAAA";
    private static final String UPDATED_DICT_SORT = "BBBBBBBBBB";

    private static final String DEFAULT_DICT_LABEL = "AAAAAAAAAA";
    private static final String UPDATED_DICT_LABEL = "BBBBBBBBBB";

    private static final String DEFAULT_DICT_VALUE = "AAAAAAAAAA";
    private static final String UPDATED_DICT_VALUE = "BBBBBBBBBB";

    private static final String DEFAULT_DICT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_DICT_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_CSS_CLASS = "AAAAAAAAAA";
    private static final String UPDATED_CSS_CLASS = "BBBBBBBBBB";

    private static final String DEFAULT_LIST_CLASS = "AAAAAAAAAA";
    private static final String UPDATED_LIST_CLASS = "BBBBBBBBBB";

    private static final String DEFAULT_IS_DEFAULT = "AAAAAAAAAA";
    private static final String UPDATED_IS_DEFAULT = "BBBBBBBBBB";

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
    private SysDictDataRepository sysDictDataRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSysDictDataMockMvc;

    private SysDictData sysDictData;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysDictData createEntity(EntityManager em) {
        SysDictData sysDictData = new SysDictData()
            .dictSort(DEFAULT_DICT_SORT)
            .dictLabel(DEFAULT_DICT_LABEL)
            .dictValue(DEFAULT_DICT_VALUE)
            .dictType(DEFAULT_DICT_TYPE)
            .cssClass(DEFAULT_CSS_CLASS)
            .listClass(DEFAULT_LIST_CLASS)
            .isDefault(DEFAULT_IS_DEFAULT)
            .status(DEFAULT_STATUS)
            .createBy(DEFAULT_CREATE_BY)
            .createTime(DEFAULT_CREATE_TIME)
            .updateBy(DEFAULT_UPDATE_BY)
            .upLocalDate(DEFAULT_UP_LOCAL_DATE)
            .remark(DEFAULT_REMARK);
        return sysDictData;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysDictData createUpdatedEntity(EntityManager em) {
        SysDictData sysDictData = new SysDictData()
            .dictSort(UPDATED_DICT_SORT)
            .dictLabel(UPDATED_DICT_LABEL)
            .dictValue(UPDATED_DICT_VALUE)
            .dictType(UPDATED_DICT_TYPE)
            .cssClass(UPDATED_CSS_CLASS)
            .listClass(UPDATED_LIST_CLASS)
            .isDefault(UPDATED_IS_DEFAULT)
            .status(UPDATED_STATUS)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);
        return sysDictData;
    }

    @BeforeEach
    public void initTest() {
        sysDictData = createEntity(em);
    }

    @Test
    @Transactional
    public void createSysDictData() throws Exception {
        int databaseSizeBeforeCreate = sysDictDataRepository.findAll().size();
        // Create the SysDictData
        restSysDictDataMockMvc.perform(post("/api/sys-dict-data").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysDictData)))
            .andExpect(status().isCreated());

        // Validate the SysDictData in the database
        List<SysDictData> sysDictDataList = sysDictDataRepository.findAll();
        assertThat(sysDictDataList).hasSize(databaseSizeBeforeCreate + 1);
        SysDictData testSysDictData = sysDictDataList.get(sysDictDataList.size() - 1);
        assertThat(testSysDictData.getDictSort()).isEqualTo(DEFAULT_DICT_SORT);
        assertThat(testSysDictData.getDictLabel()).isEqualTo(DEFAULT_DICT_LABEL);
        assertThat(testSysDictData.getDictValue()).isEqualTo(DEFAULT_DICT_VALUE);
        assertThat(testSysDictData.getDictType()).isEqualTo(DEFAULT_DICT_TYPE);
        assertThat(testSysDictData.getCssClass()).isEqualTo(DEFAULT_CSS_CLASS);
        assertThat(testSysDictData.getListClass()).isEqualTo(DEFAULT_LIST_CLASS);
        assertThat(testSysDictData.getIsDefault()).isEqualTo(DEFAULT_IS_DEFAULT);
        assertThat(testSysDictData.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testSysDictData.getCreateBy()).isEqualTo(DEFAULT_CREATE_BY);
        assertThat(testSysDictData.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testSysDictData.getUpdateBy()).isEqualTo(DEFAULT_UPDATE_BY);
        assertThat(testSysDictData.getUpLocalDate()).isEqualTo(DEFAULT_UP_LOCAL_DATE);
        assertThat(testSysDictData.getRemark()).isEqualTo(DEFAULT_REMARK);
    }

    @Test
    @Transactional
    public void createSysDictDataWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sysDictDataRepository.findAll().size();

        // Create the SysDictData with an existing ID
        sysDictData.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSysDictDataMockMvc.perform(post("/api/sys-dict-data").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysDictData)))
            .andExpect(status().isBadRequest());

        // Validate the SysDictData in the database
        List<SysDictData> sysDictDataList = sysDictDataRepository.findAll();
        assertThat(sysDictDataList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSysDictData() throws Exception {
        // Initialize the database
        sysDictDataRepository.saveAndFlush(sysDictData);

        // Get all the sysDictDataList
        restSysDictDataMockMvc.perform(get("/api/sys-dict-data?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sysDictData.getId().intValue())))
            .andExpect(jsonPath("$.[*].dictSort").value(hasItem(DEFAULT_DICT_SORT)))
            .andExpect(jsonPath("$.[*].dictLabel").value(hasItem(DEFAULT_DICT_LABEL)))
            .andExpect(jsonPath("$.[*].dictValue").value(hasItem(DEFAULT_DICT_VALUE)))
            .andExpect(jsonPath("$.[*].dictType").value(hasItem(DEFAULT_DICT_TYPE)))
            .andExpect(jsonPath("$.[*].cssClass").value(hasItem(DEFAULT_CSS_CLASS)))
            .andExpect(jsonPath("$.[*].listClass").value(hasItem(DEFAULT_LIST_CLASS)))
            .andExpect(jsonPath("$.[*].isDefault").value(hasItem(DEFAULT_IS_DEFAULT)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].createBy").value(hasItem(DEFAULT_CREATE_BY)))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateBy").value(hasItem(DEFAULT_UPDATE_BY)))
            .andExpect(jsonPath("$.[*].upLocalDate").value(hasItem(DEFAULT_UP_LOCAL_DATE.toString())))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK.toString())));
    }
    
    @Test
    @Transactional
    public void getSysDictData() throws Exception {
        // Initialize the database
        sysDictDataRepository.saveAndFlush(sysDictData);

        // Get the sysDictData
        restSysDictDataMockMvc.perform(get("/api/sys-dict-data/{id}", sysDictData.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sysDictData.getId().intValue()))
            .andExpect(jsonPath("$.dictSort").value(DEFAULT_DICT_SORT))
            .andExpect(jsonPath("$.dictLabel").value(DEFAULT_DICT_LABEL))
            .andExpect(jsonPath("$.dictValue").value(DEFAULT_DICT_VALUE))
            .andExpect(jsonPath("$.dictType").value(DEFAULT_DICT_TYPE))
            .andExpect(jsonPath("$.cssClass").value(DEFAULT_CSS_CLASS))
            .andExpect(jsonPath("$.listClass").value(DEFAULT_LIST_CLASS))
            .andExpect(jsonPath("$.isDefault").value(DEFAULT_IS_DEFAULT))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.createBy").value(DEFAULT_CREATE_BY))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateBy").value(DEFAULT_UPDATE_BY))
            .andExpect(jsonPath("$.upLocalDate").value(DEFAULT_UP_LOCAL_DATE.toString()))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingSysDictData() throws Exception {
        // Get the sysDictData
        restSysDictDataMockMvc.perform(get("/api/sys-dict-data/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSysDictData() throws Exception {
        // Initialize the database
        sysDictDataRepository.saveAndFlush(sysDictData);

        int databaseSizeBeforeUpdate = sysDictDataRepository.findAll().size();

        // Update the sysDictData
        SysDictData updatedSysDictData = sysDictDataRepository.findById(sysDictData.getId()).get();
        // Disconnect from session so that the updates on updatedSysDictData are not directly saved in db
        em.detach(updatedSysDictData);
        updatedSysDictData
            .dictSort(UPDATED_DICT_SORT)
            .dictLabel(UPDATED_DICT_LABEL)
            .dictValue(UPDATED_DICT_VALUE)
            .dictType(UPDATED_DICT_TYPE)
            .cssClass(UPDATED_CSS_CLASS)
            .listClass(UPDATED_LIST_CLASS)
            .isDefault(UPDATED_IS_DEFAULT)
            .status(UPDATED_STATUS)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);

        restSysDictDataMockMvc.perform(put("/api/sys-dict-data").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedSysDictData)))
            .andExpect(status().isOk());

        // Validate the SysDictData in the database
        List<SysDictData> sysDictDataList = sysDictDataRepository.findAll();
        assertThat(sysDictDataList).hasSize(databaseSizeBeforeUpdate);
        SysDictData testSysDictData = sysDictDataList.get(sysDictDataList.size() - 1);
        assertThat(testSysDictData.getDictSort()).isEqualTo(UPDATED_DICT_SORT);
        assertThat(testSysDictData.getDictLabel()).isEqualTo(UPDATED_DICT_LABEL);
        assertThat(testSysDictData.getDictValue()).isEqualTo(UPDATED_DICT_VALUE);
        assertThat(testSysDictData.getDictType()).isEqualTo(UPDATED_DICT_TYPE);
        assertThat(testSysDictData.getCssClass()).isEqualTo(UPDATED_CSS_CLASS);
        assertThat(testSysDictData.getListClass()).isEqualTo(UPDATED_LIST_CLASS);
        assertThat(testSysDictData.getIsDefault()).isEqualTo(UPDATED_IS_DEFAULT);
        assertThat(testSysDictData.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testSysDictData.getCreateBy()).isEqualTo(UPDATED_CREATE_BY);
        assertThat(testSysDictData.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testSysDictData.getUpdateBy()).isEqualTo(UPDATED_UPDATE_BY);
        assertThat(testSysDictData.getUpLocalDate()).isEqualTo(UPDATED_UP_LOCAL_DATE);
        assertThat(testSysDictData.getRemark()).isEqualTo(UPDATED_REMARK);
    }

    @Test
    @Transactional
    public void updateNonExistingSysDictData() throws Exception {
        int databaseSizeBeforeUpdate = sysDictDataRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSysDictDataMockMvc.perform(put("/api/sys-dict-data").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysDictData)))
            .andExpect(status().isBadRequest());

        // Validate the SysDictData in the database
        List<SysDictData> sysDictDataList = sysDictDataRepository.findAll();
        assertThat(sysDictDataList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSysDictData() throws Exception {
        // Initialize the database
        sysDictDataRepository.saveAndFlush(sysDictData);

        int databaseSizeBeforeDelete = sysDictDataRepository.findAll().size();

        // Delete the sysDictData
        restSysDictDataMockMvc.perform(delete("/api/sys-dict-data/{id}", sysDictData.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SysDictData> sysDictDataList = sysDictDataRepository.findAll();
        assertThat(sysDictDataList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
