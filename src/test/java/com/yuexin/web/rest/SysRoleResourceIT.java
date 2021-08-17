package com.yuexin.web.rest;

import com.yuexin.YueXinJhipsterApp;
import com.yuexin.domain.SysRole;
import com.yuexin.repository.SysRoleRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link SysRoleResource} REST controller.
 */
@SpringBootTest(classes = YueXinJhipsterApp.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WithMockUser
public class SysRoleResourceIT {

    private static final String DEFAULT_ROLE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ROLE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ROLE_KEY = "AAAAAAAAAA";
    private static final String UPDATED_ROLE_KEY = "BBBBBBBBBB";

    private static final Integer DEFAULT_ROLE_SORT = 1;
    private static final Integer UPDATED_ROLE_SORT = 2;

    private static final String DEFAULT_DATA_SCOPE = "AAAAAAAAAA";
    private static final String UPDATED_DATA_SCOPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_MENU_CHECK_STRICTLY = 1;
    private static final Integer UPDATED_MENU_CHECK_STRICTLY = 2;

    private static final Integer DEFAULT_DEPT_CHECK_STRICTLY = 1;
    private static final Integer UPDATED_DEPT_CHECK_STRICTLY = 2;

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

    private static final String DEFAULT_REMARK = "AAAAAAAAAA";
    private static final String UPDATED_REMARK = "BBBBBBBBBB";

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Mock
    private SysRoleRepository sysRoleRepositoryMock;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSysRoleMockMvc;

    private SysRole sysRole;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysRole createEntity(EntityManager em) {
        SysRole sysRole = new SysRole()
            .roleName(DEFAULT_ROLE_NAME)
            .roleKey(DEFAULT_ROLE_KEY)
            .roleSort(DEFAULT_ROLE_SORT)
            .dataScope(DEFAULT_DATA_SCOPE)
            .menuCheckStrictly(DEFAULT_MENU_CHECK_STRICTLY)
            .deptCheckStrictly(DEFAULT_DEPT_CHECK_STRICTLY)
            .status(DEFAULT_STATUS)
            .delFlag(DEFAULT_DEL_FLAG)
            .createBy(DEFAULT_CREATE_BY)
            .createTime(DEFAULT_CREATE_TIME)
            .updateBy(DEFAULT_UPDATE_BY)
            .upLocalDate(DEFAULT_UP_LOCAL_DATE)
            .remark(DEFAULT_REMARK);
        return sysRole;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysRole createUpdatedEntity(EntityManager em) {
        SysRole sysRole = new SysRole()
            .roleName(UPDATED_ROLE_NAME)
            .roleKey(UPDATED_ROLE_KEY)
            .roleSort(UPDATED_ROLE_SORT)
            .dataScope(UPDATED_DATA_SCOPE)
            .menuCheckStrictly(UPDATED_MENU_CHECK_STRICTLY)
            .deptCheckStrictly(UPDATED_DEPT_CHECK_STRICTLY)
            .status(UPDATED_STATUS)
            .delFlag(UPDATED_DEL_FLAG)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);
        return sysRole;
    }

    @BeforeEach
    public void initTest() {
        sysRole = createEntity(em);
    }

    @Test
    @Transactional
    public void createSysRole() throws Exception {
        int databaseSizeBeforeCreate = sysRoleRepository.findAll().size();
        // Create the SysRole
        restSysRoleMockMvc.perform(post("/api/sys-roles").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysRole)))
            .andExpect(status().isCreated());

        // Validate the SysRole in the database
        List<SysRole> sysRoleList = sysRoleRepository.findAll();
        assertThat(sysRoleList).hasSize(databaseSizeBeforeCreate + 1);
        SysRole testSysRole = sysRoleList.get(sysRoleList.size() - 1);
        assertThat(testSysRole.getRoleName()).isEqualTo(DEFAULT_ROLE_NAME);
        assertThat(testSysRole.getRoleKey()).isEqualTo(DEFAULT_ROLE_KEY);
        assertThat(testSysRole.getRoleSort()).isEqualTo(DEFAULT_ROLE_SORT);
        assertThat(testSysRole.getDataScope()).isEqualTo(DEFAULT_DATA_SCOPE);
        assertThat(testSysRole.getMenuCheckStrictly()).isEqualTo(DEFAULT_MENU_CHECK_STRICTLY);
        assertThat(testSysRole.getDeptCheckStrictly()).isEqualTo(DEFAULT_DEPT_CHECK_STRICTLY);
        assertThat(testSysRole.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testSysRole.getDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testSysRole.getCreateBy()).isEqualTo(DEFAULT_CREATE_BY);
        assertThat(testSysRole.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testSysRole.getUpdateBy()).isEqualTo(DEFAULT_UPDATE_BY);
        assertThat(testSysRole.getUpLocalDate()).isEqualTo(DEFAULT_UP_LOCAL_DATE);
        assertThat(testSysRole.getRemark()).isEqualTo(DEFAULT_REMARK);
    }

    @Test
    @Transactional
    public void createSysRoleWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sysRoleRepository.findAll().size();

        // Create the SysRole with an existing ID
        sysRole.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSysRoleMockMvc.perform(post("/api/sys-roles").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysRole)))
            .andExpect(status().isBadRequest());

        // Validate the SysRole in the database
        List<SysRole> sysRoleList = sysRoleRepository.findAll();
        assertThat(sysRoleList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSysRoles() throws Exception {
        // Initialize the database
        sysRoleRepository.saveAndFlush(sysRole);

        // Get all the sysRoleList
        restSysRoleMockMvc.perform(get("/api/sys-roles?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sysRole.getId().intValue())))
            .andExpect(jsonPath("$.[*].roleName").value(hasItem(DEFAULT_ROLE_NAME)))
            .andExpect(jsonPath("$.[*].roleKey").value(hasItem(DEFAULT_ROLE_KEY)))
            .andExpect(jsonPath("$.[*].roleSort").value(hasItem(DEFAULT_ROLE_SORT)))
            .andExpect(jsonPath("$.[*].dataScope").value(hasItem(DEFAULT_DATA_SCOPE)))
            .andExpect(jsonPath("$.[*].menuCheckStrictly").value(hasItem(DEFAULT_MENU_CHECK_STRICTLY)))
            .andExpect(jsonPath("$.[*].deptCheckStrictly").value(hasItem(DEFAULT_DEPT_CHECK_STRICTLY)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].delFlag").value(hasItem(DEFAULT_DEL_FLAG)))
            .andExpect(jsonPath("$.[*].createBy").value(hasItem(DEFAULT_CREATE_BY)))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateBy").value(hasItem(DEFAULT_UPDATE_BY)))
            .andExpect(jsonPath("$.[*].upLocalDate").value(hasItem(DEFAULT_UP_LOCAL_DATE.toString())))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK.toString())));
    }
    
    @SuppressWarnings({"unchecked"})
    public void getAllSysRolesWithEagerRelationshipsIsEnabled() throws Exception {
        when(sysRoleRepositoryMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restSysRoleMockMvc.perform(get("/api/sys-roles?eagerload=true"))
            .andExpect(status().isOk());

        verify(sysRoleRepositoryMock, times(1)).findAllWithEagerRelationships(any());
    }

    @SuppressWarnings({"unchecked"})
    public void getAllSysRolesWithEagerRelationshipsIsNotEnabled() throws Exception {
        when(sysRoleRepositoryMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restSysRoleMockMvc.perform(get("/api/sys-roles?eagerload=true"))
            .andExpect(status().isOk());

        verify(sysRoleRepositoryMock, times(1)).findAllWithEagerRelationships(any());
    }

    @Test
    @Transactional
    public void getSysRole() throws Exception {
        // Initialize the database
        sysRoleRepository.saveAndFlush(sysRole);

        // Get the sysRole
        restSysRoleMockMvc.perform(get("/api/sys-roles/{id}", sysRole.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sysRole.getId().intValue()))
            .andExpect(jsonPath("$.roleName").value(DEFAULT_ROLE_NAME))
            .andExpect(jsonPath("$.roleKey").value(DEFAULT_ROLE_KEY))
            .andExpect(jsonPath("$.roleSort").value(DEFAULT_ROLE_SORT))
            .andExpect(jsonPath("$.dataScope").value(DEFAULT_DATA_SCOPE))
            .andExpect(jsonPath("$.menuCheckStrictly").value(DEFAULT_MENU_CHECK_STRICTLY))
            .andExpect(jsonPath("$.deptCheckStrictly").value(DEFAULT_DEPT_CHECK_STRICTLY))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.delFlag").value(DEFAULT_DEL_FLAG))
            .andExpect(jsonPath("$.createBy").value(DEFAULT_CREATE_BY))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateBy").value(DEFAULT_UPDATE_BY))
            .andExpect(jsonPath("$.upLocalDate").value(DEFAULT_UP_LOCAL_DATE.toString()))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingSysRole() throws Exception {
        // Get the sysRole
        restSysRoleMockMvc.perform(get("/api/sys-roles/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSysRole() throws Exception {
        // Initialize the database
        sysRoleRepository.saveAndFlush(sysRole);

        int databaseSizeBeforeUpdate = sysRoleRepository.findAll().size();

        // Update the sysRole
        SysRole updatedSysRole = sysRoleRepository.findById(sysRole.getId()).get();
        // Disconnect from session so that the updates on updatedSysRole are not directly saved in db
        em.detach(updatedSysRole);
        updatedSysRole
            .roleName(UPDATED_ROLE_NAME)
            .roleKey(UPDATED_ROLE_KEY)
            .roleSort(UPDATED_ROLE_SORT)
            .dataScope(UPDATED_DATA_SCOPE)
            .menuCheckStrictly(UPDATED_MENU_CHECK_STRICTLY)
            .deptCheckStrictly(UPDATED_DEPT_CHECK_STRICTLY)
            .status(UPDATED_STATUS)
            .delFlag(UPDATED_DEL_FLAG)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);

        restSysRoleMockMvc.perform(put("/api/sys-roles").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedSysRole)))
            .andExpect(status().isOk());

        // Validate the SysRole in the database
        List<SysRole> sysRoleList = sysRoleRepository.findAll();
        assertThat(sysRoleList).hasSize(databaseSizeBeforeUpdate);
        SysRole testSysRole = sysRoleList.get(sysRoleList.size() - 1);
        assertThat(testSysRole.getRoleName()).isEqualTo(UPDATED_ROLE_NAME);
        assertThat(testSysRole.getRoleKey()).isEqualTo(UPDATED_ROLE_KEY);
        assertThat(testSysRole.getRoleSort()).isEqualTo(UPDATED_ROLE_SORT);
        assertThat(testSysRole.getDataScope()).isEqualTo(UPDATED_DATA_SCOPE);
        assertThat(testSysRole.getMenuCheckStrictly()).isEqualTo(UPDATED_MENU_CHECK_STRICTLY);
        assertThat(testSysRole.getDeptCheckStrictly()).isEqualTo(UPDATED_DEPT_CHECK_STRICTLY);
        assertThat(testSysRole.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testSysRole.getDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testSysRole.getCreateBy()).isEqualTo(UPDATED_CREATE_BY);
        assertThat(testSysRole.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testSysRole.getUpdateBy()).isEqualTo(UPDATED_UPDATE_BY);
        assertThat(testSysRole.getUpLocalDate()).isEqualTo(UPDATED_UP_LOCAL_DATE);
        assertThat(testSysRole.getRemark()).isEqualTo(UPDATED_REMARK);
    }

    @Test
    @Transactional
    public void updateNonExistingSysRole() throws Exception {
        int databaseSizeBeforeUpdate = sysRoleRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSysRoleMockMvc.perform(put("/api/sys-roles").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysRole)))
            .andExpect(status().isBadRequest());

        // Validate the SysRole in the database
        List<SysRole> sysRoleList = sysRoleRepository.findAll();
        assertThat(sysRoleList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSysRole() throws Exception {
        // Initialize the database
        sysRoleRepository.saveAndFlush(sysRole);

        int databaseSizeBeforeDelete = sysRoleRepository.findAll().size();

        // Delete the sysRole
        restSysRoleMockMvc.perform(delete("/api/sys-roles/{id}", sysRole.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SysRole> sysRoleList = sysRoleRepository.findAll();
        assertThat(sysRoleList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
