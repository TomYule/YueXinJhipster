package com.yuexin.web.rest;

import com.yuexin.YueXinJhipsterApp;
import com.yuexin.domain.SysMenu;
import com.yuexin.repository.SysMenuRepository;

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
 * Integration tests for the {@link SysMenuResource} REST controller.
 */
@SpringBootTest(classes = YueXinJhipsterApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class SysMenuResourceIT {

    private static final String DEFAULT_MENU_NAME = "AAAAAAAAAA";
    private static final String UPDATED_MENU_NAME = "BBBBBBBBBB";

    private static final Long DEFAULT_PARENT_ID = 1L;
    private static final Long UPDATED_PARENT_ID = 2L;

    private static final Integer DEFAULT_ORDER_NUM = 1;
    private static final Integer UPDATED_ORDER_NUM = 2;

    private static final String DEFAULT_PATH = "AAAAAAAAAA";
    private static final String UPDATED_PATH = "BBBBBBBBBB";

    private static final String DEFAULT_COMPONENTS = "AAAAAAAAAA";
    private static final String UPDATED_COMPONENTS = "BBBBBBBBBB";

    private static final String DEFAULT_IS_FRAME = "AAAAAAAAAA";
    private static final String UPDATED_IS_FRAME = "BBBBBBBBBB";

    private static final String DEFAULT_IS_CACHE = "AAAAAAAAAA";
    private static final String UPDATED_IS_CACHE = "BBBBBBBBBB";

    private static final String DEFAULT_MENU_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_MENU_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_VISIBLE = "AAAAAAAAAA";
    private static final String UPDATED_VISIBLE = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_PERMS = "AAAAAAAAAA";
    private static final String UPDATED_PERMS = "BBBBBBBBBB";

    private static final String DEFAULT_ICON = "AAAAAAAAAA";
    private static final String UPDATED_ICON = "BBBBBBBBBB";

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
    private SysMenuRepository sysMenuRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSysMenuMockMvc;

    private SysMenu sysMenu;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysMenu createEntity(EntityManager em) {
        SysMenu sysMenu = new SysMenu()
            .menuName(DEFAULT_MENU_NAME)
            .parentId(DEFAULT_PARENT_ID)
            .orderNum(DEFAULT_ORDER_NUM)
            .path(DEFAULT_PATH)
            .components(DEFAULT_COMPONENTS)
            .isFrame(DEFAULT_IS_FRAME)
            .isCache(DEFAULT_IS_CACHE)
            .menuType(DEFAULT_MENU_TYPE)
            .visible(DEFAULT_VISIBLE)
            .status(DEFAULT_STATUS)
            .perms(DEFAULT_PERMS)
            .icon(DEFAULT_ICON)
            .createBy(DEFAULT_CREATE_BY)
            .createTime(DEFAULT_CREATE_TIME)
            .updateBy(DEFAULT_UPDATE_BY)
            .upLocalDate(DEFAULT_UP_LOCAL_DATE)
            .remark(DEFAULT_REMARK);
        return sysMenu;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SysMenu createUpdatedEntity(EntityManager em) {
        SysMenu sysMenu = new SysMenu()
            .menuName(UPDATED_MENU_NAME)
            .parentId(UPDATED_PARENT_ID)
            .orderNum(UPDATED_ORDER_NUM)
            .path(UPDATED_PATH)
            .components(UPDATED_COMPONENTS)
            .isFrame(UPDATED_IS_FRAME)
            .isCache(UPDATED_IS_CACHE)
            .menuType(UPDATED_MENU_TYPE)
            .visible(UPDATED_VISIBLE)
            .status(UPDATED_STATUS)
            .perms(UPDATED_PERMS)
            .icon(UPDATED_ICON)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);
        return sysMenu;
    }

    @BeforeEach
    public void initTest() {
        sysMenu = createEntity(em);
    }

    @Test
    @Transactional
    public void createSysMenu() throws Exception {
        int databaseSizeBeforeCreate = sysMenuRepository.findAll().size();
        // Create the SysMenu
        restSysMenuMockMvc.perform(post("/api/sys-menus").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysMenu)))
            .andExpect(status().isCreated());

        // Validate the SysMenu in the database
        List<SysMenu> sysMenuList = sysMenuRepository.findAll();
        assertThat(sysMenuList).hasSize(databaseSizeBeforeCreate + 1);
        SysMenu testSysMenu = sysMenuList.get(sysMenuList.size() - 1);
        assertThat(testSysMenu.getMenuName()).isEqualTo(DEFAULT_MENU_NAME);
        assertThat(testSysMenu.getParentId()).isEqualTo(DEFAULT_PARENT_ID);
        assertThat(testSysMenu.getOrderNum()).isEqualTo(DEFAULT_ORDER_NUM);
        assertThat(testSysMenu.getPath()).isEqualTo(DEFAULT_PATH);
        assertThat(testSysMenu.getComponents()).isEqualTo(DEFAULT_COMPONENTS);
        assertThat(testSysMenu.getIsFrame()).isEqualTo(DEFAULT_IS_FRAME);
        assertThat(testSysMenu.getIsCache()).isEqualTo(DEFAULT_IS_CACHE);
        assertThat(testSysMenu.getMenuType()).isEqualTo(DEFAULT_MENU_TYPE);
        assertThat(testSysMenu.getVisible()).isEqualTo(DEFAULT_VISIBLE);
        assertThat(testSysMenu.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testSysMenu.getPerms()).isEqualTo(DEFAULT_PERMS);
        assertThat(testSysMenu.getIcon()).isEqualTo(DEFAULT_ICON);
        assertThat(testSysMenu.getCreateBy()).isEqualTo(DEFAULT_CREATE_BY);
        assertThat(testSysMenu.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testSysMenu.getUpdateBy()).isEqualTo(DEFAULT_UPDATE_BY);
        assertThat(testSysMenu.getUpLocalDate()).isEqualTo(DEFAULT_UP_LOCAL_DATE);
        assertThat(testSysMenu.getRemark()).isEqualTo(DEFAULT_REMARK);
    }

    @Test
    @Transactional
    public void createSysMenuWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sysMenuRepository.findAll().size();

        // Create the SysMenu with an existing ID
        sysMenu.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSysMenuMockMvc.perform(post("/api/sys-menus").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysMenu)))
            .andExpect(status().isBadRequest());

        // Validate the SysMenu in the database
        List<SysMenu> sysMenuList = sysMenuRepository.findAll();
        assertThat(sysMenuList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkMenuNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = sysMenuRepository.findAll().size();
        // set the field null
        sysMenu.setMenuName(null);

        // Create the SysMenu, which fails.


        restSysMenuMockMvc.perform(post("/api/sys-menus").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysMenu)))
            .andExpect(status().isBadRequest());

        List<SysMenu> sysMenuList = sysMenuRepository.findAll();
        assertThat(sysMenuList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllSysMenus() throws Exception {
        // Initialize the database
        sysMenuRepository.saveAndFlush(sysMenu);

        // Get all the sysMenuList
        restSysMenuMockMvc.perform(get("/api/sys-menus?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sysMenu.getId().intValue())))
            .andExpect(jsonPath("$.[*].menuName").value(hasItem(DEFAULT_MENU_NAME)))
            .andExpect(jsonPath("$.[*].parentId").value(hasItem(DEFAULT_PARENT_ID.intValue())))
            .andExpect(jsonPath("$.[*].orderNum").value(hasItem(DEFAULT_ORDER_NUM)))
            .andExpect(jsonPath("$.[*].path").value(hasItem(DEFAULT_PATH)))
            .andExpect(jsonPath("$.[*].components").value(hasItem(DEFAULT_COMPONENTS)))
            .andExpect(jsonPath("$.[*].isFrame").value(hasItem(DEFAULT_IS_FRAME)))
            .andExpect(jsonPath("$.[*].isCache").value(hasItem(DEFAULT_IS_CACHE)))
            .andExpect(jsonPath("$.[*].menuType").value(hasItem(DEFAULT_MENU_TYPE)))
            .andExpect(jsonPath("$.[*].visible").value(hasItem(DEFAULT_VISIBLE)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].perms").value(hasItem(DEFAULT_PERMS)))
            .andExpect(jsonPath("$.[*].icon").value(hasItem(DEFAULT_ICON)))
            .andExpect(jsonPath("$.[*].createBy").value(hasItem(DEFAULT_CREATE_BY)))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateBy").value(hasItem(DEFAULT_UPDATE_BY)))
            .andExpect(jsonPath("$.[*].upLocalDate").value(hasItem(DEFAULT_UP_LOCAL_DATE.toString())))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK.toString())));
    }
    
    @Test
    @Transactional
    public void getSysMenu() throws Exception {
        // Initialize the database
        sysMenuRepository.saveAndFlush(sysMenu);

        // Get the sysMenu
        restSysMenuMockMvc.perform(get("/api/sys-menus/{id}", sysMenu.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sysMenu.getId().intValue()))
            .andExpect(jsonPath("$.menuName").value(DEFAULT_MENU_NAME))
            .andExpect(jsonPath("$.parentId").value(DEFAULT_PARENT_ID.intValue()))
            .andExpect(jsonPath("$.orderNum").value(DEFAULT_ORDER_NUM))
            .andExpect(jsonPath("$.path").value(DEFAULT_PATH))
            .andExpect(jsonPath("$.components").value(DEFAULT_COMPONENTS))
            .andExpect(jsonPath("$.isFrame").value(DEFAULT_IS_FRAME))
            .andExpect(jsonPath("$.isCache").value(DEFAULT_IS_CACHE))
            .andExpect(jsonPath("$.menuType").value(DEFAULT_MENU_TYPE))
            .andExpect(jsonPath("$.visible").value(DEFAULT_VISIBLE))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.perms").value(DEFAULT_PERMS))
            .andExpect(jsonPath("$.icon").value(DEFAULT_ICON))
            .andExpect(jsonPath("$.createBy").value(DEFAULT_CREATE_BY))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateBy").value(DEFAULT_UPDATE_BY))
            .andExpect(jsonPath("$.upLocalDate").value(DEFAULT_UP_LOCAL_DATE.toString()))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingSysMenu() throws Exception {
        // Get the sysMenu
        restSysMenuMockMvc.perform(get("/api/sys-menus/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSysMenu() throws Exception {
        // Initialize the database
        sysMenuRepository.saveAndFlush(sysMenu);

        int databaseSizeBeforeUpdate = sysMenuRepository.findAll().size();

        // Update the sysMenu
        SysMenu updatedSysMenu = sysMenuRepository.findById(sysMenu.getId()).get();
        // Disconnect from session so that the updates on updatedSysMenu are not directly saved in db
        em.detach(updatedSysMenu);
        updatedSysMenu
            .menuName(UPDATED_MENU_NAME)
            .parentId(UPDATED_PARENT_ID)
            .orderNum(UPDATED_ORDER_NUM)
            .path(UPDATED_PATH)
            .components(UPDATED_COMPONENTS)
            .isFrame(UPDATED_IS_FRAME)
            .isCache(UPDATED_IS_CACHE)
            .menuType(UPDATED_MENU_TYPE)
            .visible(UPDATED_VISIBLE)
            .status(UPDATED_STATUS)
            .perms(UPDATED_PERMS)
            .icon(UPDATED_ICON)
            .createBy(UPDATED_CREATE_BY)
            .createTime(UPDATED_CREATE_TIME)
            .updateBy(UPDATED_UPDATE_BY)
            .upLocalDate(UPDATED_UP_LOCAL_DATE)
            .remark(UPDATED_REMARK);

        restSysMenuMockMvc.perform(put("/api/sys-menus").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedSysMenu)))
            .andExpect(status().isOk());

        // Validate the SysMenu in the database
        List<SysMenu> sysMenuList = sysMenuRepository.findAll();
        assertThat(sysMenuList).hasSize(databaseSizeBeforeUpdate);
        SysMenu testSysMenu = sysMenuList.get(sysMenuList.size() - 1);
        assertThat(testSysMenu.getMenuName()).isEqualTo(UPDATED_MENU_NAME);
        assertThat(testSysMenu.getParentId()).isEqualTo(UPDATED_PARENT_ID);
        assertThat(testSysMenu.getOrderNum()).isEqualTo(UPDATED_ORDER_NUM);
        assertThat(testSysMenu.getPath()).isEqualTo(UPDATED_PATH);
        assertThat(testSysMenu.getComponents()).isEqualTo(UPDATED_COMPONENTS);
        assertThat(testSysMenu.getIsFrame()).isEqualTo(UPDATED_IS_FRAME);
        assertThat(testSysMenu.getIsCache()).isEqualTo(UPDATED_IS_CACHE);
        assertThat(testSysMenu.getMenuType()).isEqualTo(UPDATED_MENU_TYPE);
        assertThat(testSysMenu.getVisible()).isEqualTo(UPDATED_VISIBLE);
        assertThat(testSysMenu.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testSysMenu.getPerms()).isEqualTo(UPDATED_PERMS);
        assertThat(testSysMenu.getIcon()).isEqualTo(UPDATED_ICON);
        assertThat(testSysMenu.getCreateBy()).isEqualTo(UPDATED_CREATE_BY);
        assertThat(testSysMenu.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testSysMenu.getUpdateBy()).isEqualTo(UPDATED_UPDATE_BY);
        assertThat(testSysMenu.getUpLocalDate()).isEqualTo(UPDATED_UP_LOCAL_DATE);
        assertThat(testSysMenu.getRemark()).isEqualTo(UPDATED_REMARK);
    }

    @Test
    @Transactional
    public void updateNonExistingSysMenu() throws Exception {
        int databaseSizeBeforeUpdate = sysMenuRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSysMenuMockMvc.perform(put("/api/sys-menus").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(sysMenu)))
            .andExpect(status().isBadRequest());

        // Validate the SysMenu in the database
        List<SysMenu> sysMenuList = sysMenuRepository.findAll();
        assertThat(sysMenuList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSysMenu() throws Exception {
        // Initialize the database
        sysMenuRepository.saveAndFlush(sysMenu);

        int databaseSizeBeforeDelete = sysMenuRepository.findAll().size();

        // Delete the sysMenu
        restSysMenuMockMvc.perform(delete("/api/sys-menus/{id}", sysMenu.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SysMenu> sysMenuList = sysMenuRepository.findAll();
        assertThat(sysMenuList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
