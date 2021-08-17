package com.yuexin.web.rest;

import com.yuexin.YueXinJhipsterApp;
import com.yuexin.domain.SysUser;
import com.yuexin.repository.SysUserRepository;

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

import com.yuexin.domain.enumeration.UserStatus;
/**
 * Integration tests for the {@link SysUserResource} REST controller.
 */
@SpringBootTest(classes = YueXinJhipsterApp.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WithMockUser
public class SysUserResourceIT {

    private static final String DEFAULT_DEPT_ID = "AAAAAAAAAA";
    private static final String UPDATED_DEPT_ID = "BBBBBBBBBB";

    private static final String DEFAULT_USER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_USER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_NICK_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NICK_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_USER_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_USER_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_GENDER = "AAAAAAAAAA";
    private static final String UPDATED_GENDER = "BBBBBBBBBB";

    private static final String DEFAULT_AVATAR = "AAAAAAAAAA";
    private static final String UPDATED_AVATAR = "BBBBBBBBBB";

    private static final String DEFAULT_PASSWORD = "AAAAAAAAAA";
    private static final String UPDATED_PASSWORD = "BBBBBBBBBB";

    private static final UserStatus DEFAULT_STATUS = UserStatus.ENABLE;
    private static final UserStatus UPDATED_STATUS = UserStatus.DISABLE;

    private static final String DEFAULT_DEL_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_DEL_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_LOGIN_IP = "AAAAAAAAAA";
    private static final String UPDATED_LOGIN_IP = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_LOGIN_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LOGIN_DATE = LocalDate.now(ZoneId.systemDefault());

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
    private SysUserRepository sysUserRepository;

    @Mock
    private SysUserRepository sysUserRepositoryMock;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSysUserMockMvc;

    private SysUser sysUser;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysUser createEntity(EntityManager em) {
        SysUser sysUser = new SysUser()
            .deptId(DEFAULT_DEPT_ID)
            .userName(DEFAULT_USER_NAME)
            .nickName(DEFAULT_NICK_NAME)
            .userType(DEFAULT_USER_TYPE)
            .email(DEFAULT_EMAIL)
            .phoneNumber(DEFAULT_PHONE_NUMBER)
            .gender(DEFAULT_GENDER)
            .avatar(DEFAULT_AVATAR)
            .password(DEFAULT_PASSWORD)
            .status(DEFAULT_STATUS)
            .delFlag(DEFAULT_DEL_FLAG)
            .loginIp(DEFAULT_LOGIN_IP)
            .loginDate(DEFAULT_LOGIN_DATE)
            .createBy(DEFAULT_CREATE_BY)
            .createTime(DEFAULT_CREATE_TIME)
            .updateBy(DEFAULT_UPDATE_BY)
            .upLocalDate(DEFAULT_UP_LOCAL_DATE)
            .remark(DEFAULT_REMARK);
        return sysUser;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysUser createUpdatedEntity(EntityManager em) {
        SysUser sysUser = new SysUser()
            .deptId(UPDATED_DEPT_ID)
            .userName(UPDATED_USER_NAME)
            .nickName(UPDATED_NICK_NAME)
            .userType(UPDATED_USER_TYPE)
            .email(UPDATED_EMAIL)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .gender(UPDATED_GENDER)
            .avatar(UPDATED_AVATAR)
            .password(UPDATED_PASSWORD)
            .status(UPDATED_STATUS)
            .delFlag(UPDATED_DEL_FLAG)
            .loginIp(UPDATED_LOGIN_IP)
            .loginDate(UPDATED_LOGIN_DATE)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);
        return sysUser;
    }

    @BeforeEach
    public void initTest() {
        sysUser = createEntity(em);
    }

    @Test
    @Transactional
    public void createSysUser() throws Exception {
        int databaseSizeBeforeCreate = sysUserRepository.findAll().size();
        // Create the SysUser
        restSysUserMockMvc.perform(post("/api/sys-users").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysUser)))
            .andExpect(status().isCreated());

        // Validate the SysUser in the database
        List<SysUser> sysUserList = sysUserRepository.findAll();
        assertThat(sysUserList).hasSize(databaseSizeBeforeCreate + 1);
        SysUser testSysUser = sysUserList.get(sysUserList.size() - 1);
        assertThat(testSysUser.getDeptId()).isEqualTo(DEFAULT_DEPT_ID);
        assertThat(testSysUser.getUserName()).isEqualTo(DEFAULT_USER_NAME);
        assertThat(testSysUser.getNickName()).isEqualTo(DEFAULT_NICK_NAME);
        assertThat(testSysUser.getUserType()).isEqualTo(DEFAULT_USER_TYPE);
        assertThat(testSysUser.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testSysUser.getPhoneNumber()).isEqualTo(DEFAULT_PHONE_NUMBER);
        assertThat(testSysUser.getGender()).isEqualTo(DEFAULT_GENDER);
        assertThat(testSysUser.getAvatar()).isEqualTo(DEFAULT_AVATAR);
        assertThat(testSysUser.getPassword()).isEqualTo(DEFAULT_PASSWORD);
        assertThat(testSysUser.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testSysUser.getDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testSysUser.getLoginIp()).isEqualTo(DEFAULT_LOGIN_IP);
        assertThat(testSysUser.getLoginDate()).isEqualTo(DEFAULT_LOGIN_DATE);
        assertThat(testSysUser.getCreateBy()).isEqualTo(DEFAULT_CREATE_BY);
        assertThat(testSysUser.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testSysUser.getUpdateBy()).isEqualTo(DEFAULT_UPDATE_BY);
        assertThat(testSysUser.getUpLocalDate()).isEqualTo(DEFAULT_UP_LOCAL_DATE);
        assertThat(testSysUser.getRemark()).isEqualTo(DEFAULT_REMARK);
    }

    @Test
    @Transactional
    public void createSysUserWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sysUserRepository.findAll().size();

        // Create the SysUser with an existing ID
        sysUser.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSysUserMockMvc.perform(post("/api/sys-users").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysUser)))
            .andExpect(status().isBadRequest());

        // Validate the SysUser in the database
        List<SysUser> sysUserList = sysUserRepository.findAll();
        assertThat(sysUserList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkDeptIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = sysUserRepository.findAll().size();
        // set the field null
        sysUser.setDeptId(null);

        // Create the SysUser, which fails.


        restSysUserMockMvc.perform(post("/api/sys-users").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysUser)))
            .andExpect(status().isBadRequest());

        List<SysUser> sysUserList = sysUserRepository.findAll();
        assertThat(sysUserList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllSysUsers() throws Exception {
        // Initialize the database
        sysUserRepository.saveAndFlush(sysUser);

        // Get all the sysUserList
        restSysUserMockMvc.perform(get("/api/sys-users?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sysUser.getId().intValue())))
            .andExpect(jsonPath("$.[*].deptId").value(hasItem(DEFAULT_DEPT_ID)))
            .andExpect(jsonPath("$.[*].userName").value(hasItem(DEFAULT_USER_NAME)))
            .andExpect(jsonPath("$.[*].nickName").value(hasItem(DEFAULT_NICK_NAME)))
            .andExpect(jsonPath("$.[*].userType").value(hasItem(DEFAULT_USER_TYPE)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].phoneNumber").value(hasItem(DEFAULT_PHONE_NUMBER)))
            .andExpect(jsonPath("$.[*].gender").value(hasItem(DEFAULT_GENDER)))
            .andExpect(jsonPath("$.[*].avatar").value(hasItem(DEFAULT_AVATAR)))
            .andExpect(jsonPath("$.[*].password").value(hasItem(DEFAULT_PASSWORD)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].delFlag").value(hasItem(DEFAULT_DEL_FLAG)))
            .andExpect(jsonPath("$.[*].loginIp").value(hasItem(DEFAULT_LOGIN_IP)))
            .andExpect(jsonPath("$.[*].loginDate").value(hasItem(DEFAULT_LOGIN_DATE.toString())))
            .andExpect(jsonPath("$.[*].createBy").value(hasItem(DEFAULT_CREATE_BY)))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateBy").value(hasItem(DEFAULT_UPDATE_BY)))
            .andExpect(jsonPath("$.[*].upLocalDate").value(hasItem(DEFAULT_UP_LOCAL_DATE.toString())))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK.toString())));
    }
    
    @SuppressWarnings({"unchecked"})
    public void getAllSysUsersWithEagerRelationshipsIsEnabled() throws Exception {
        when(sysUserRepositoryMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restSysUserMockMvc.perform(get("/api/sys-users?eagerload=true"))
            .andExpect(status().isOk());

        verify(sysUserRepositoryMock, times(1)).findAllWithEagerRelationships(any());
    }

    @SuppressWarnings({"unchecked"})
    public void getAllSysUsersWithEagerRelationshipsIsNotEnabled() throws Exception {
        when(sysUserRepositoryMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restSysUserMockMvc.perform(get("/api/sys-users?eagerload=true"))
            .andExpect(status().isOk());

        verify(sysUserRepositoryMock, times(1)).findAllWithEagerRelationships(any());
    }

    @Test
    @Transactional
    public void getSysUser() throws Exception {
        // Initialize the database
        sysUserRepository.saveAndFlush(sysUser);

        // Get the sysUser
        restSysUserMockMvc.perform(get("/api/sys-users/{id}", sysUser.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sysUser.getId().intValue()))
            .andExpect(jsonPath("$.deptId").value(DEFAULT_DEPT_ID))
            .andExpect(jsonPath("$.userName").value(DEFAULT_USER_NAME))
            .andExpect(jsonPath("$.nickName").value(DEFAULT_NICK_NAME))
            .andExpect(jsonPath("$.userType").value(DEFAULT_USER_TYPE))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.phoneNumber").value(DEFAULT_PHONE_NUMBER))
            .andExpect(jsonPath("$.gender").value(DEFAULT_GENDER))
            .andExpect(jsonPath("$.avatar").value(DEFAULT_AVATAR))
            .andExpect(jsonPath("$.password").value(DEFAULT_PASSWORD))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()))
            .andExpect(jsonPath("$.delFlag").value(DEFAULT_DEL_FLAG))
            .andExpect(jsonPath("$.loginIp").value(DEFAULT_LOGIN_IP))
            .andExpect(jsonPath("$.loginDate").value(DEFAULT_LOGIN_DATE.toString()))
            .andExpect(jsonPath("$.createBy").value(DEFAULT_CREATE_BY))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateBy").value(DEFAULT_UPDATE_BY))
            .andExpect(jsonPath("$.upLocalDate").value(DEFAULT_UP_LOCAL_DATE.toString()))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingSysUser() throws Exception {
        // Get the sysUser
        restSysUserMockMvc.perform(get("/api/sys-users/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSysUser() throws Exception {
        // Initialize the database
        sysUserRepository.saveAndFlush(sysUser);

        int databaseSizeBeforeUpdate = sysUserRepository.findAll().size();

        // Update the sysUser
        SysUser updatedSysUser = sysUserRepository.findById(sysUser.getId()).get();
        // Disconnect from session so that the updates on updatedSysUser are not directly saved in db
        em.detach(updatedSysUser);
        updatedSysUser
            .deptId(UPDATED_DEPT_ID)
            .userName(UPDATED_USER_NAME)
            .nickName(UPDATED_NICK_NAME)
            .userType(UPDATED_USER_TYPE)
            .email(UPDATED_EMAIL)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .gender(UPDATED_GENDER)
            .avatar(UPDATED_AVATAR)
            .password(UPDATED_PASSWORD)
            .status(UPDATED_STATUS)
            .delFlag(UPDATED_DEL_FLAG)
            .loginIp(UPDATED_LOGIN_IP)
            .loginDate(UPDATED_LOGIN_DATE)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);

        restSysUserMockMvc.perform(put("/api/sys-users").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedSysUser)))
            .andExpect(status().isOk());

        // Validate the SysUser in the database
        List<SysUser> sysUserList = sysUserRepository.findAll();
        assertThat(sysUserList).hasSize(databaseSizeBeforeUpdate);
        SysUser testSysUser = sysUserList.get(sysUserList.size() - 1);
        assertThat(testSysUser.getDeptId()).isEqualTo(UPDATED_DEPT_ID);
        assertThat(testSysUser.getUserName()).isEqualTo(UPDATED_USER_NAME);
        assertThat(testSysUser.getNickName()).isEqualTo(UPDATED_NICK_NAME);
        assertThat(testSysUser.getUserType()).isEqualTo(UPDATED_USER_TYPE);
        assertThat(testSysUser.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testSysUser.getPhoneNumber()).isEqualTo(UPDATED_PHONE_NUMBER);
        assertThat(testSysUser.getGender()).isEqualTo(UPDATED_GENDER);
        assertThat(testSysUser.getAvatar()).isEqualTo(UPDATED_AVATAR);
        assertThat(testSysUser.getPassword()).isEqualTo(UPDATED_PASSWORD);
        assertThat(testSysUser.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testSysUser.getDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testSysUser.getLoginIp()).isEqualTo(UPDATED_LOGIN_IP);
        assertThat(testSysUser.getLoginDate()).isEqualTo(UPDATED_LOGIN_DATE);
        assertThat(testSysUser.getCreateBy()).isEqualTo(UPDATED_CREATE_BY);
        assertThat(testSysUser.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testSysUser.getUpdateBy()).isEqualTo(UPDATED_UPDATE_BY);
        assertThat(testSysUser.getUpLocalDate()).isEqualTo(UPDATED_UP_LOCAL_DATE);
        assertThat(testSysUser.getRemark()).isEqualTo(UPDATED_REMARK);
    }

    @Test
    @Transactional
    public void updateNonExistingSysUser() throws Exception {
        int databaseSizeBeforeUpdate = sysUserRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSysUserMockMvc.perform(put("/api/sys-users").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysUser)))
            .andExpect(status().isBadRequest());

        // Validate the SysUser in the database
        List<SysUser> sysUserList = sysUserRepository.findAll();
        assertThat(sysUserList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSysUser() throws Exception {
        // Initialize the database
        sysUserRepository.saveAndFlush(sysUser);

        int databaseSizeBeforeDelete = sysUserRepository.findAll().size();

        // Delete the sysUser
        restSysUserMockMvc.perform(delete("/api/sys-users/{id}", sysUser.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SysUser> sysUserList = sysUserRepository.findAll();
        assertThat(sysUserList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
