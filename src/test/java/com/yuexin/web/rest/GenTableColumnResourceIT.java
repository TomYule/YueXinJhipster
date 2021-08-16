package com.yuexin.web.rest;

import com.yuexin.YueXinJhipsterApp;
import com.yuexin.domain.GenTableColumn;
import com.yuexin.repository.GenTableColumnRepository;

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
 * Integration tests for the {@link GenTableColumnResource} REST controller.
 */
@SpringBootTest(classes = YueXinJhipsterApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class GenTableColumnResourceIT {

    private static final String DEFAULT_TABLE_ID = "AAAAAAAAAA";
    private static final String UPDATED_TABLE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_COLUMN_NAME = "AAAAAAAAAA";
    private static final String UPDATED_COLUMN_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_COLUMN_COMMENT = "AAAAAAAAAA";
    private static final String UPDATED_COLUMN_COMMENT = "BBBBBBBBBB";

    private static final String DEFAULT_COLUMN_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_COLUMN_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_JAVA_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_JAVA_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_JAVA_FIELD = "AAAAAAAAAA";
    private static final String UPDATED_JAVA_FIELD = "BBBBBBBBBB";

    private static final String DEFAULT_IS_PK = "AAAAAAAAAA";
    private static final String UPDATED_IS_PK = "BBBBBBBBBB";

    private static final String DEFAULT_IS_INCREMENT = "AAAAAAAAAA";
    private static final String UPDATED_IS_INCREMENT = "BBBBBBBBBB";

    private static final String DEFAULT_IS_REQUIRED = "AAAAAAAAAA";
    private static final String UPDATED_IS_REQUIRED = "BBBBBBBBBB";

    private static final String DEFAULT_IS_INSERT = "AAAAAAAAAA";
    private static final String UPDATED_IS_INSERT = "BBBBBBBBBB";

    private static final String DEFAULT_IS_EDIT = "AAAAAAAAAA";
    private static final String UPDATED_IS_EDIT = "BBBBBBBBBB";

    private static final String DEFAULT_IS_LIST = "AAAAAAAAAA";
    private static final String UPDATED_IS_LIST = "BBBBBBBBBB";

    private static final String DEFAULT_IS_QUERY = "AAAAAAAAAA";
    private static final String UPDATED_IS_QUERY = "BBBBBBBBBB";

    private static final String DEFAULT_HTML_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_HTML_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_DICT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_DICT_TYPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_SORT = 1;
    private static final Integer UPDATED_SORT = 2;

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
    private GenTableColumnRepository genTableColumnRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restGenTableColumnMockMvc;

    private GenTableColumn genTableColumn;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static GenTableColumn createEntity(EntityManager em) {
        GenTableColumn genTableColumn = new GenTableColumn()
            .tableId(DEFAULT_TABLE_ID)
            .columnName(DEFAULT_COLUMN_NAME)
            .columnComment(DEFAULT_COLUMN_COMMENT)
            .columnType(DEFAULT_COLUMN_TYPE)
            .javaType(DEFAULT_JAVA_TYPE)
            .javaField(DEFAULT_JAVA_FIELD)
            .isPk(DEFAULT_IS_PK)
            .isIncrement(DEFAULT_IS_INCREMENT)
            .isRequired(DEFAULT_IS_REQUIRED)
            .isInsert(DEFAULT_IS_INSERT)
            .isEdit(DEFAULT_IS_EDIT)
            .isList(DEFAULT_IS_LIST)
            .isQuery(DEFAULT_IS_QUERY)
            .htmlType(DEFAULT_HTML_TYPE)
            .dictType(DEFAULT_DICT_TYPE)
            .sort(DEFAULT_SORT)
            .createBy(DEFAULT_CREATE_BY)
            .createTime(DEFAULT_CREATE_TIME)
            .updateBy(DEFAULT_UPDATE_BY)
            .upLocalDate(DEFAULT_UP_LOCAL_DATE)
            .remark(DEFAULT_REMARK);
        return genTableColumn;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static GenTableColumn createUpdatedEntity(EntityManager em) {
        GenTableColumn genTableColumn = new GenTableColumn()
            .tableId(UPDATED_TABLE_ID)
            .columnName(UPDATED_COLUMN_NAME)
            .columnComment(UPDATED_COLUMN_COMMENT)
            .columnType(UPDATED_COLUMN_TYPE)
            .javaType(UPDATED_JAVA_TYPE)
            .javaField(UPDATED_JAVA_FIELD)
            .isPk(UPDATED_IS_PK)
            .isIncrement(UPDATED_IS_INCREMENT)
            .isRequired(UPDATED_IS_REQUIRED)
            .isInsert(UPDATED_IS_INSERT)
            .isEdit(UPDATED_IS_EDIT)
            .isList(UPDATED_IS_LIST)
            .isQuery(UPDATED_IS_QUERY)
            .htmlType(UPDATED_HTML_TYPE)
            .dictType(UPDATED_DICT_TYPE)
            .sort(UPDATED_SORT)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);
        return genTableColumn;
    }

    @BeforeEach
    public void initTest() {
        genTableColumn = createEntity(em);
    }

    @Test
    @Transactional
    public void createGenTableColumn() throws Exception {
        int databaseSizeBeforeCreate = genTableColumnRepository.findAll().size();
        // Create the GenTableColumn
        restGenTableColumnMockMvc.perform(post("/api/gen-table-columns").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(genTableColumn)))
            .andExpect(status().isCreated());

        // Validate the GenTableColumn in the database
        List<GenTableColumn> genTableColumnList = genTableColumnRepository.findAll();
        assertThat(genTableColumnList).hasSize(databaseSizeBeforeCreate + 1);
        GenTableColumn testGenTableColumn = genTableColumnList.get(genTableColumnList.size() - 1);
        assertThat(testGenTableColumn.getTableId()).isEqualTo(DEFAULT_TABLE_ID);
        assertThat(testGenTableColumn.getColumnName()).isEqualTo(DEFAULT_COLUMN_NAME);
        assertThat(testGenTableColumn.getColumnComment()).isEqualTo(DEFAULT_COLUMN_COMMENT);
        assertThat(testGenTableColumn.getColumnType()).isEqualTo(DEFAULT_COLUMN_TYPE);
        assertThat(testGenTableColumn.getJavaType()).isEqualTo(DEFAULT_JAVA_TYPE);
        assertThat(testGenTableColumn.getJavaField()).isEqualTo(DEFAULT_JAVA_FIELD);
        assertThat(testGenTableColumn.getIsPk()).isEqualTo(DEFAULT_IS_PK);
        assertThat(testGenTableColumn.getIsIncrement()).isEqualTo(DEFAULT_IS_INCREMENT);
        assertThat(testGenTableColumn.getIsRequired()).isEqualTo(DEFAULT_IS_REQUIRED);
        assertThat(testGenTableColumn.getIsInsert()).isEqualTo(DEFAULT_IS_INSERT);
        assertThat(testGenTableColumn.getIsEdit()).isEqualTo(DEFAULT_IS_EDIT);
        assertThat(testGenTableColumn.getIsList()).isEqualTo(DEFAULT_IS_LIST);
        assertThat(testGenTableColumn.getIsQuery()).isEqualTo(DEFAULT_IS_QUERY);
        assertThat(testGenTableColumn.getHtmlType()).isEqualTo(DEFAULT_HTML_TYPE);
        assertThat(testGenTableColumn.getDictType()).isEqualTo(DEFAULT_DICT_TYPE);
        assertThat(testGenTableColumn.getSort()).isEqualTo(DEFAULT_SORT);
        assertThat(testGenTableColumn.getCreateBy()).isEqualTo(DEFAULT_CREATE_BY);
        assertThat(testGenTableColumn.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testGenTableColumn.getUpdateBy()).isEqualTo(DEFAULT_UPDATE_BY);
        assertThat(testGenTableColumn.getUpLocalDate()).isEqualTo(DEFAULT_UP_LOCAL_DATE);
        assertThat(testGenTableColumn.getRemark()).isEqualTo(DEFAULT_REMARK);
    }

    @Test
    @Transactional
    public void createGenTableColumnWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = genTableColumnRepository.findAll().size();

        // Create the GenTableColumn with an existing ID
        genTableColumn.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restGenTableColumnMockMvc.perform(post("/api/gen-table-columns").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(genTableColumn)))
            .andExpect(status().isBadRequest());

        // Validate the GenTableColumn in the database
        List<GenTableColumn> genTableColumnList = genTableColumnRepository.findAll();
        assertThat(genTableColumnList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkTableIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = genTableColumnRepository.findAll().size();
        // set the field null
        genTableColumn.setTableId(null);

        // Create the GenTableColumn, which fails.


        restGenTableColumnMockMvc.perform(post("/api/gen-table-columns").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(genTableColumn)))
            .andExpect(status().isBadRequest());

        List<GenTableColumn> genTableColumnList = genTableColumnRepository.findAll();
        assertThat(genTableColumnList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllGenTableColumns() throws Exception {
        // Initialize the database
        genTableColumnRepository.saveAndFlush(genTableColumn);

        // Get all the genTableColumnList
        restGenTableColumnMockMvc.perform(get("/api/gen-table-columns?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(genTableColumn.getId().intValue())))
            .andExpect(jsonPath("$.[*].tableId").value(hasItem(DEFAULT_TABLE_ID)))
            .andExpect(jsonPath("$.[*].columnName").value(hasItem(DEFAULT_COLUMN_NAME)))
            .andExpect(jsonPath("$.[*].columnComment").value(hasItem(DEFAULT_COLUMN_COMMENT)))
            .andExpect(jsonPath("$.[*].columnType").value(hasItem(DEFAULT_COLUMN_TYPE)))
            .andExpect(jsonPath("$.[*].javaType").value(hasItem(DEFAULT_JAVA_TYPE)))
            .andExpect(jsonPath("$.[*].javaField").value(hasItem(DEFAULT_JAVA_FIELD)))
            .andExpect(jsonPath("$.[*].isPk").value(hasItem(DEFAULT_IS_PK)))
            .andExpect(jsonPath("$.[*].isIncrement").value(hasItem(DEFAULT_IS_INCREMENT)))
            .andExpect(jsonPath("$.[*].isRequired").value(hasItem(DEFAULT_IS_REQUIRED)))
            .andExpect(jsonPath("$.[*].isInsert").value(hasItem(DEFAULT_IS_INSERT)))
            .andExpect(jsonPath("$.[*].isEdit").value(hasItem(DEFAULT_IS_EDIT)))
            .andExpect(jsonPath("$.[*].isList").value(hasItem(DEFAULT_IS_LIST)))
            .andExpect(jsonPath("$.[*].isQuery").value(hasItem(DEFAULT_IS_QUERY)))
            .andExpect(jsonPath("$.[*].htmlType").value(hasItem(DEFAULT_HTML_TYPE)))
            .andExpect(jsonPath("$.[*].dictType").value(hasItem(DEFAULT_DICT_TYPE)))
            .andExpect(jsonPath("$.[*].sort").value(hasItem(DEFAULT_SORT)))
            .andExpect(jsonPath("$.[*].createBy").value(hasItem(DEFAULT_CREATE_BY)))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateBy").value(hasItem(DEFAULT_UPDATE_BY)))
            .andExpect(jsonPath("$.[*].upLocalDate").value(hasItem(DEFAULT_UP_LOCAL_DATE.toString())))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK.toString())));
    }
    
    @Test
    @Transactional
    public void getGenTableColumn() throws Exception {
        // Initialize the database
        genTableColumnRepository.saveAndFlush(genTableColumn);

        // Get the genTableColumn
        restGenTableColumnMockMvc.perform(get("/api/gen-table-columns/{id}", genTableColumn.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(genTableColumn.getId().intValue()))
            .andExpect(jsonPath("$.tableId").value(DEFAULT_TABLE_ID))
            .andExpect(jsonPath("$.columnName").value(DEFAULT_COLUMN_NAME))
            .andExpect(jsonPath("$.columnComment").value(DEFAULT_COLUMN_COMMENT))
            .andExpect(jsonPath("$.columnType").value(DEFAULT_COLUMN_TYPE))
            .andExpect(jsonPath("$.javaType").value(DEFAULT_JAVA_TYPE))
            .andExpect(jsonPath("$.javaField").value(DEFAULT_JAVA_FIELD))
            .andExpect(jsonPath("$.isPk").value(DEFAULT_IS_PK))
            .andExpect(jsonPath("$.isIncrement").value(DEFAULT_IS_INCREMENT))
            .andExpect(jsonPath("$.isRequired").value(DEFAULT_IS_REQUIRED))
            .andExpect(jsonPath("$.isInsert").value(DEFAULT_IS_INSERT))
            .andExpect(jsonPath("$.isEdit").value(DEFAULT_IS_EDIT))
            .andExpect(jsonPath("$.isList").value(DEFAULT_IS_LIST))
            .andExpect(jsonPath("$.isQuery").value(DEFAULT_IS_QUERY))
            .andExpect(jsonPath("$.htmlType").value(DEFAULT_HTML_TYPE))
            .andExpect(jsonPath("$.dictType").value(DEFAULT_DICT_TYPE))
            .andExpect(jsonPath("$.sort").value(DEFAULT_SORT))
            .andExpect(jsonPath("$.createBy").value(DEFAULT_CREATE_BY))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateBy").value(DEFAULT_UPDATE_BY))
            .andExpect(jsonPath("$.upLocalDate").value(DEFAULT_UP_LOCAL_DATE.toString()))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingGenTableColumn() throws Exception {
        // Get the genTableColumn
        restGenTableColumnMockMvc.perform(get("/api/gen-table-columns/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateGenTableColumn() throws Exception {
        // Initialize the database
        genTableColumnRepository.saveAndFlush(genTableColumn);

        int databaseSizeBeforeUpdate = genTableColumnRepository.findAll().size();

        // Update the genTableColumn
        GenTableColumn updatedGenTableColumn = genTableColumnRepository.findById(genTableColumn.getId()).get();
        // Disconnect from session so that the updates on updatedGenTableColumn are not directly saved in db
        em.detach(updatedGenTableColumn);
        updatedGenTableColumn
            .tableId(UPDATED_TABLE_ID)
            .columnName(UPDATED_COLUMN_NAME)
            .columnComment(UPDATED_COLUMN_COMMENT)
            .columnType(UPDATED_COLUMN_TYPE)
            .javaType(UPDATED_JAVA_TYPE)
            .javaField(UPDATED_JAVA_FIELD)
            .isPk(UPDATED_IS_PK)
            .isIncrement(UPDATED_IS_INCREMENT)
            .isRequired(UPDATED_IS_REQUIRED)
            .isInsert(UPDATED_IS_INSERT)
            .isEdit(UPDATED_IS_EDIT)
            .isList(UPDATED_IS_LIST)
            .isQuery(UPDATED_IS_QUERY)
            .htmlType(UPDATED_HTML_TYPE)
            .dictType(UPDATED_DICT_TYPE)
            .sort(UPDATED_SORT)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);

        restGenTableColumnMockMvc.perform(put("/api/gen-table-columns").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedGenTableColumn)))
            .andExpect(status().isOk());

        // Validate the GenTableColumn in the database
        List<GenTableColumn> genTableColumnList = genTableColumnRepository.findAll();
        assertThat(genTableColumnList).hasSize(databaseSizeBeforeUpdate);
        GenTableColumn testGenTableColumn = genTableColumnList.get(genTableColumnList.size() - 1);
        assertThat(testGenTableColumn.getTableId()).isEqualTo(UPDATED_TABLE_ID);
        assertThat(testGenTableColumn.getColumnName()).isEqualTo(UPDATED_COLUMN_NAME);
        assertThat(testGenTableColumn.getColumnComment()).isEqualTo(UPDATED_COLUMN_COMMENT);
        assertThat(testGenTableColumn.getColumnType()).isEqualTo(UPDATED_COLUMN_TYPE);
        assertThat(testGenTableColumn.getJavaType()).isEqualTo(UPDATED_JAVA_TYPE);
        assertThat(testGenTableColumn.getJavaField()).isEqualTo(UPDATED_JAVA_FIELD);
        assertThat(testGenTableColumn.getIsPk()).isEqualTo(UPDATED_IS_PK);
        assertThat(testGenTableColumn.getIsIncrement()).isEqualTo(UPDATED_IS_INCREMENT);
        assertThat(testGenTableColumn.getIsRequired()).isEqualTo(UPDATED_IS_REQUIRED);
        assertThat(testGenTableColumn.getIsInsert()).isEqualTo(UPDATED_IS_INSERT);
        assertThat(testGenTableColumn.getIsEdit()).isEqualTo(UPDATED_IS_EDIT);
        assertThat(testGenTableColumn.getIsList()).isEqualTo(UPDATED_IS_LIST);
        assertThat(testGenTableColumn.getIsQuery()).isEqualTo(UPDATED_IS_QUERY);
        assertThat(testGenTableColumn.getHtmlType()).isEqualTo(UPDATED_HTML_TYPE);
        assertThat(testGenTableColumn.getDictType()).isEqualTo(UPDATED_DICT_TYPE);
        assertThat(testGenTableColumn.getSort()).isEqualTo(UPDATED_SORT);
        assertThat(testGenTableColumn.getCreateBy()).isEqualTo(UPDATED_CREATE_BY);
        assertThat(testGenTableColumn.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testGenTableColumn.getUpdateBy()).isEqualTo(UPDATED_UPDATE_BY);
        assertThat(testGenTableColumn.getUpLocalDate()).isEqualTo(UPDATED_UP_LOCAL_DATE);
        assertThat(testGenTableColumn.getRemark()).isEqualTo(UPDATED_REMARK);
    }

    @Test
    @Transactional
    public void updateNonExistingGenTableColumn() throws Exception {
        int databaseSizeBeforeUpdate = genTableColumnRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restGenTableColumnMockMvc.perform(put("/api/gen-table-columns").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(genTableColumn)))
            .andExpect(status().isBadRequest());

        // Validate the GenTableColumn in the database
        List<GenTableColumn> genTableColumnList = genTableColumnRepository.findAll();
        assertThat(genTableColumnList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteGenTableColumn() throws Exception {
        // Initialize the database
        genTableColumnRepository.saveAndFlush(genTableColumn);

        int databaseSizeBeforeDelete = genTableColumnRepository.findAll().size();

        // Delete the genTableColumn
        restGenTableColumnMockMvc.perform(delete("/api/gen-table-columns/{id}", genTableColumn.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<GenTableColumn> genTableColumnList = genTableColumnRepository.findAll();
        assertThat(genTableColumnList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
