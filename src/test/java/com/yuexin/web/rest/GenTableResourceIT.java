package com.yuexin.web.rest;

import com.yuexin.YueXinJhipsterApp;
import com.yuexin.domain.GenTable;
import com.yuexin.repository.GenTableRepository;

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
 * Integration tests for the {@link GenTableResource} REST controller.
 */
@SpringBootTest(classes = YueXinJhipsterApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class GenTableResourceIT {

    private static final String DEFAULT_TABLE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_TABLE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TABLE_COMMENT = "AAAAAAAAAA";
    private static final String UPDATED_TABLE_COMMENT = "BBBBBBBBBB";

    private static final String DEFAULT_SUB_TABLE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SUB_TABLE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SUB_TABLE_FK_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SUB_TABLE_FK_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CLASS_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CLASS_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TPL_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_TPL_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_PACK_AGE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PACK_AGE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_MODULE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_MODULE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_BUSINESS_NAME = "AAAAAAAAAA";
    private static final String UPDATED_BUSINESS_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_FUNCTION_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FUNCTION_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_FUNCTION_AUTHOR = "AAAAAAAAAA";
    private static final String UPDATED_FUNCTION_AUTHOR = "BBBBBBBBBB";

    private static final String DEFAULT_GEN_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_GEN_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_GEN_PATH = "AAAAAAAAAA";
    private static final String UPDATED_GEN_PATH = "BBBBBBBBBB";

    private static final String DEFAULT_OPTIONS = "AAAAAAAAAA";
    private static final String UPDATED_OPTIONS = "BBBBBBBBBB";

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
    private GenTableRepository genTableRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restGenTableMockMvc;

    private GenTable genTable;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static GenTable createEntity(EntityManager em) {
        GenTable genTable = new GenTable()
            .tableName(DEFAULT_TABLE_NAME)
            .tableComment(DEFAULT_TABLE_COMMENT)
            .subTableName(DEFAULT_SUB_TABLE_NAME)
            .subTableFkName(DEFAULT_SUB_TABLE_FK_NAME)
            .className(DEFAULT_CLASS_NAME)
            .tplCategory(DEFAULT_TPL_CATEGORY)
            .packAgeName(DEFAULT_PACK_AGE_NAME)
            .moduleName(DEFAULT_MODULE_NAME)
            .businessName(DEFAULT_BUSINESS_NAME)
            .functionName(DEFAULT_FUNCTION_NAME)
            .functionAuthor(DEFAULT_FUNCTION_AUTHOR)
            .genType(DEFAULT_GEN_TYPE)
            .genPath(DEFAULT_GEN_PATH)
            .options(DEFAULT_OPTIONS)
            .createBy(DEFAULT_CREATE_BY)
            .createTime(DEFAULT_CREATE_TIME)
            .updateBy(DEFAULT_UPDATE_BY)
            .upLocalDate(DEFAULT_UP_LOCAL_DATE)
            .remark(DEFAULT_REMARK);
        return genTable;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static GenTable createUpdatedEntity(EntityManager em) {
        GenTable genTable = new GenTable()
            .tableName(UPDATED_TABLE_NAME)
            .tableComment(UPDATED_TABLE_COMMENT)
            .subTableName(UPDATED_SUB_TABLE_NAME)
            .subTableFkName(UPDATED_SUB_TABLE_FK_NAME)
            .className(UPDATED_CLASS_NAME)
            .tplCategory(UPDATED_TPL_CATEGORY)
            .packAgeName(UPDATED_PACK_AGE_NAME)
            .moduleName(UPDATED_MODULE_NAME)
            .businessName(UPDATED_BUSINESS_NAME)
            .functionName(UPDATED_FUNCTION_NAME)
            .functionAuthor(UPDATED_FUNCTION_AUTHOR)
            .genType(UPDATED_GEN_TYPE)
            .genPath(UPDATED_GEN_PATH)
            .options(UPDATED_OPTIONS)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);
        return genTable;
    }

    @BeforeEach
    public void initTest() {
        genTable = createEntity(em);
    }

    @Test
    @Transactional
    public void createGenTable() throws Exception {
        int databaseSizeBeforeCreate = genTableRepository.findAll().size();
        // Create the GenTable
        restGenTableMockMvc.perform(post("/api/gen-tables").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(genTable)))
            .andExpect(status().isCreated());

        // Validate the GenTable in the database
        List<GenTable> genTableList = genTableRepository.findAll();
        assertThat(genTableList).hasSize(databaseSizeBeforeCreate + 1);
        GenTable testGenTable = genTableList.get(genTableList.size() - 1);
        assertThat(testGenTable.getTableName()).isEqualTo(DEFAULT_TABLE_NAME);
        assertThat(testGenTable.getTableComment()).isEqualTo(DEFAULT_TABLE_COMMENT);
        assertThat(testGenTable.getSubTableName()).isEqualTo(DEFAULT_SUB_TABLE_NAME);
        assertThat(testGenTable.getSubTableFkName()).isEqualTo(DEFAULT_SUB_TABLE_FK_NAME);
        assertThat(testGenTable.getClassName()).isEqualTo(DEFAULT_CLASS_NAME);
        assertThat(testGenTable.getTplCategory()).isEqualTo(DEFAULT_TPL_CATEGORY);
        assertThat(testGenTable.getPackAgeName()).isEqualTo(DEFAULT_PACK_AGE_NAME);
        assertThat(testGenTable.getModuleName()).isEqualTo(DEFAULT_MODULE_NAME);
        assertThat(testGenTable.getBusinessName()).isEqualTo(DEFAULT_BUSINESS_NAME);
        assertThat(testGenTable.getFunctionName()).isEqualTo(DEFAULT_FUNCTION_NAME);
        assertThat(testGenTable.getFunctionAuthor()).isEqualTo(DEFAULT_FUNCTION_AUTHOR);
        assertThat(testGenTable.getGenType()).isEqualTo(DEFAULT_GEN_TYPE);
        assertThat(testGenTable.getGenPath()).isEqualTo(DEFAULT_GEN_PATH);
        assertThat(testGenTable.getOptions()).isEqualTo(DEFAULT_OPTIONS);
        assertThat(testGenTable.getCreateBy()).isEqualTo(DEFAULT_CREATE_BY);
        assertThat(testGenTable.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testGenTable.getUpdateBy()).isEqualTo(DEFAULT_UPDATE_BY);
        assertThat(testGenTable.getUpLocalDate()).isEqualTo(DEFAULT_UP_LOCAL_DATE);
        assertThat(testGenTable.getRemark()).isEqualTo(DEFAULT_REMARK);
    }

    @Test
    @Transactional
    public void createGenTableWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = genTableRepository.findAll().size();

        // Create the GenTable with an existing ID
        genTable.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restGenTableMockMvc.perform(post("/api/gen-tables").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(genTable)))
            .andExpect(status().isBadRequest());

        // Validate the GenTable in the database
        List<GenTable> genTableList = genTableRepository.findAll();
        assertThat(genTableList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkTableNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = genTableRepository.findAll().size();
        // set the field null
        genTable.setTableName(null);

        // Create the GenTable, which fails.


        restGenTableMockMvc.perform(post("/api/gen-tables").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(genTable)))
            .andExpect(status().isBadRequest());

        List<GenTable> genTableList = genTableRepository.findAll();
        assertThat(genTableList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllGenTables() throws Exception {
        // Initialize the database
        genTableRepository.saveAndFlush(genTable);

        // Get all the genTableList
        restGenTableMockMvc.perform(get("/api/gen-tables?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(genTable.getId().intValue())))
            .andExpect(jsonPath("$.[*].tableName").value(hasItem(DEFAULT_TABLE_NAME)))
            .andExpect(jsonPath("$.[*].tableComment").value(hasItem(DEFAULT_TABLE_COMMENT)))
            .andExpect(jsonPath("$.[*].subTableName").value(hasItem(DEFAULT_SUB_TABLE_NAME)))
            .andExpect(jsonPath("$.[*].subTableFkName").value(hasItem(DEFAULT_SUB_TABLE_FK_NAME)))
            .andExpect(jsonPath("$.[*].className").value(hasItem(DEFAULT_CLASS_NAME)))
            .andExpect(jsonPath("$.[*].tplCategory").value(hasItem(DEFAULT_TPL_CATEGORY)))
            .andExpect(jsonPath("$.[*].packAgeName").value(hasItem(DEFAULT_PACK_AGE_NAME)))
            .andExpect(jsonPath("$.[*].moduleName").value(hasItem(DEFAULT_MODULE_NAME)))
            .andExpect(jsonPath("$.[*].businessName").value(hasItem(DEFAULT_BUSINESS_NAME)))
            .andExpect(jsonPath("$.[*].functionName").value(hasItem(DEFAULT_FUNCTION_NAME)))
            .andExpect(jsonPath("$.[*].functionAuthor").value(hasItem(DEFAULT_FUNCTION_AUTHOR)))
            .andExpect(jsonPath("$.[*].genType").value(hasItem(DEFAULT_GEN_TYPE)))
            .andExpect(jsonPath("$.[*].genPath").value(hasItem(DEFAULT_GEN_PATH)))
            .andExpect(jsonPath("$.[*].options").value(hasItem(DEFAULT_OPTIONS)))
            .andExpect(jsonPath("$.[*].createBy").value(hasItem(DEFAULT_CREATE_BY)))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateBy").value(hasItem(DEFAULT_UPDATE_BY)))
            .andExpect(jsonPath("$.[*].upLocalDate").value(hasItem(DEFAULT_UP_LOCAL_DATE.toString())))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK.toString())));
    }
    
    @Test
    @Transactional
    public void getGenTable() throws Exception {
        // Initialize the database
        genTableRepository.saveAndFlush(genTable);

        // Get the genTable
        restGenTableMockMvc.perform(get("/api/gen-tables/{id}", genTable.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(genTable.getId().intValue()))
            .andExpect(jsonPath("$.tableName").value(DEFAULT_TABLE_NAME))
            .andExpect(jsonPath("$.tableComment").value(DEFAULT_TABLE_COMMENT))
            .andExpect(jsonPath("$.subTableName").value(DEFAULT_SUB_TABLE_NAME))
            .andExpect(jsonPath("$.subTableFkName").value(DEFAULT_SUB_TABLE_FK_NAME))
            .andExpect(jsonPath("$.className").value(DEFAULT_CLASS_NAME))
            .andExpect(jsonPath("$.tplCategory").value(DEFAULT_TPL_CATEGORY))
            .andExpect(jsonPath("$.packAgeName").value(DEFAULT_PACK_AGE_NAME))
            .andExpect(jsonPath("$.moduleName").value(DEFAULT_MODULE_NAME))
            .andExpect(jsonPath("$.businessName").value(DEFAULT_BUSINESS_NAME))
            .andExpect(jsonPath("$.functionName").value(DEFAULT_FUNCTION_NAME))
            .andExpect(jsonPath("$.functionAuthor").value(DEFAULT_FUNCTION_AUTHOR))
            .andExpect(jsonPath("$.genType").value(DEFAULT_GEN_TYPE))
            .andExpect(jsonPath("$.genPath").value(DEFAULT_GEN_PATH))
            .andExpect(jsonPath("$.options").value(DEFAULT_OPTIONS))
            .andExpect(jsonPath("$.createBy").value(DEFAULT_CREATE_BY))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateBy").value(DEFAULT_UPDATE_BY))
            .andExpect(jsonPath("$.upLocalDate").value(DEFAULT_UP_LOCAL_DATE.toString()))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingGenTable() throws Exception {
        // Get the genTable
        restGenTableMockMvc.perform(get("/api/gen-tables/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateGenTable() throws Exception {
        // Initialize the database
        genTableRepository.saveAndFlush(genTable);

        int databaseSizeBeforeUpdate = genTableRepository.findAll().size();

        // Update the genTable
        GenTable updatedGenTable = genTableRepository.findById(genTable.getId()).get();
        // Disconnect from session so that the updates on updatedGenTable are not directly saved in db
        em.detach(updatedGenTable);
        updatedGenTable
            .tableName(UPDATED_TABLE_NAME)
            .tableComment(UPDATED_TABLE_COMMENT)
            .subTableName(UPDATED_SUB_TABLE_NAME)
            .subTableFkName(UPDATED_SUB_TABLE_FK_NAME)
            .className(UPDATED_CLASS_NAME)
            .tplCategory(UPDATED_TPL_CATEGORY)
            .packAgeName(UPDATED_PACK_AGE_NAME)
            .moduleName(UPDATED_MODULE_NAME)
            .businessName(UPDATED_BUSINESS_NAME)
            .functionName(UPDATED_FUNCTION_NAME)
            .functionAuthor(UPDATED_FUNCTION_AUTHOR)
            .genType(UPDATED_GEN_TYPE)
            .genPath(UPDATED_GEN_PATH)
            .options(UPDATED_OPTIONS)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);

        restGenTableMockMvc.perform(put("/api/gen-tables").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedGenTable)))
            .andExpect(status().isOk());

        // Validate the GenTable in the database
        List<GenTable> genTableList = genTableRepository.findAll();
        assertThat(genTableList).hasSize(databaseSizeBeforeUpdate);
        GenTable testGenTable = genTableList.get(genTableList.size() - 1);
        assertThat(testGenTable.getTableName()).isEqualTo(UPDATED_TABLE_NAME);
        assertThat(testGenTable.getTableComment()).isEqualTo(UPDATED_TABLE_COMMENT);
        assertThat(testGenTable.getSubTableName()).isEqualTo(UPDATED_SUB_TABLE_NAME);
        assertThat(testGenTable.getSubTableFkName()).isEqualTo(UPDATED_SUB_TABLE_FK_NAME);
        assertThat(testGenTable.getClassName()).isEqualTo(UPDATED_CLASS_NAME);
        assertThat(testGenTable.getTplCategory()).isEqualTo(UPDATED_TPL_CATEGORY);
        assertThat(testGenTable.getPackAgeName()).isEqualTo(UPDATED_PACK_AGE_NAME);
        assertThat(testGenTable.getModuleName()).isEqualTo(UPDATED_MODULE_NAME);
        assertThat(testGenTable.getBusinessName()).isEqualTo(UPDATED_BUSINESS_NAME);
        assertThat(testGenTable.getFunctionName()).isEqualTo(UPDATED_FUNCTION_NAME);
        assertThat(testGenTable.getFunctionAuthor()).isEqualTo(UPDATED_FUNCTION_AUTHOR);
        assertThat(testGenTable.getGenType()).isEqualTo(UPDATED_GEN_TYPE);
        assertThat(testGenTable.getGenPath()).isEqualTo(UPDATED_GEN_PATH);
        assertThat(testGenTable.getOptions()).isEqualTo(UPDATED_OPTIONS);
        assertThat(testGenTable.getCreateBy()).isEqualTo(UPDATED_CREATE_BY);
        assertThat(testGenTable.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testGenTable.getUpdateBy()).isEqualTo(UPDATED_UPDATE_BY);
        assertThat(testGenTable.getUpLocalDate()).isEqualTo(UPDATED_UP_LOCAL_DATE);
        assertThat(testGenTable.getRemark()).isEqualTo(UPDATED_REMARK);
    }

    @Test
    @Transactional
    public void updateNonExistingGenTable() throws Exception {
        int databaseSizeBeforeUpdate = genTableRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restGenTableMockMvc.perform(put("/api/gen-tables").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(genTable)))
            .andExpect(status().isBadRequest());

        // Validate the GenTable in the database
        List<GenTable> genTableList = genTableRepository.findAll();
        assertThat(genTableList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteGenTable() throws Exception {
        // Initialize the database
        genTableRepository.saveAndFlush(genTable);

        int databaseSizeBeforeDelete = genTableRepository.findAll().size();

        // Delete the genTable
        restGenTableMockMvc.perform(delete("/api/gen-tables/{id}", genTable.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<GenTable> genTableList = genTableRepository.findAll();
        assertThat(genTableList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
