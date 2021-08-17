import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const GenTable = () => import('@/entities/gen-table/gen-table.vue');
// prettier-ignore
const GenTableUpdate = () => import('@/entities/gen-table/gen-table-update.vue');
// prettier-ignore
const GenTableDetails = () => import('@/entities/gen-table/gen-table-details.vue');
// prettier-ignore
const GenTableColumn = () => import('@/entities/gen-table-column/gen-table-column.vue');
// prettier-ignore
const GenTableColumnUpdate = () => import('@/entities/gen-table-column/gen-table-column-update.vue');
// prettier-ignore
const GenTableColumnDetails = () => import('@/entities/gen-table-column/gen-table-column-details.vue');
// prettier-ignore
const SysConfig = () => import('@/entities/sys-config/sys-config.vue');
// prettier-ignore
const SysConfigUpdate = () => import('@/entities/sys-config/sys-config-update.vue');
// prettier-ignore
const SysConfigDetails = () => import('@/entities/sys-config/sys-config-details.vue');
// prettier-ignore
const SysDept = () => import('@/entities/sys-dept/sys-dept.vue');
// prettier-ignore
const SysDeptUpdate = () => import('@/entities/sys-dept/sys-dept-update.vue');
// prettier-ignore
const SysDeptDetails = () => import('@/entities/sys-dept/sys-dept-details.vue');
// prettier-ignore
const SysDictType = () => import('@/entities/sys-dict-type/sys-dict-type.vue');
// prettier-ignore
const SysDictTypeUpdate = () => import('@/entities/sys-dict-type/sys-dict-type-update.vue');
// prettier-ignore
const SysDictTypeDetails = () => import('@/entities/sys-dict-type/sys-dict-type-details.vue');
// prettier-ignore
const SysDictData = () => import('@/entities/sys-dict-data/sys-dict-data.vue');
// prettier-ignore
const SysDictDataUpdate = () => import('@/entities/sys-dict-data/sys-dict-data-update.vue');
// prettier-ignore
const SysDictDataDetails = () => import('@/entities/sys-dict-data/sys-dict-data-details.vue');
// prettier-ignore
const SysJob = () => import('@/entities/sys-job/sys-job.vue');
// prettier-ignore
const SysJobUpdate = () => import('@/entities/sys-job/sys-job-update.vue');
// prettier-ignore
const SysJobDetails = () => import('@/entities/sys-job/sys-job-details.vue');
// prettier-ignore
const SysJobLog = () => import('@/entities/sys-job-log/sys-job-log.vue');
// prettier-ignore
const SysJobLogUpdate = () => import('@/entities/sys-job-log/sys-job-log-update.vue');
// prettier-ignore
const SysJobLogDetails = () => import('@/entities/sys-job-log/sys-job-log-details.vue');
// prettier-ignore
const SysNotice = () => import('@/entities/sys-notice/sys-notice.vue');
// prettier-ignore
const SysNoticeUpdate = () => import('@/entities/sys-notice/sys-notice-update.vue');
// prettier-ignore
const SysNoticeDetails = () => import('@/entities/sys-notice/sys-notice-details.vue');
// prettier-ignore
const SysPost = () => import('@/entities/sys-post/sys-post.vue');
// prettier-ignore
const SysPostUpdate = () => import('@/entities/sys-post/sys-post-update.vue');
// prettier-ignore
const SysPostDetails = () => import('@/entities/sys-post/sys-post-details.vue');
// prettier-ignore
const SysRole = () => import('@/entities/sys-role/sys-role.vue');
// prettier-ignore
const SysRoleUpdate = () => import('@/entities/sys-role/sys-role-update.vue');
// prettier-ignore
const SysRoleDetails = () => import('@/entities/sys-role/sys-role-details.vue');
// prettier-ignore
const SysUser = () => import('@/entities/sys-user/sys-user.vue');
// prettier-ignore
const SysUserUpdate = () => import('@/entities/sys-user/sys-user-update.vue');
// prettier-ignore
const SysUserDetails = () => import('@/entities/sys-user/sys-user-details.vue');
// prettier-ignore
const SysLoginInfor = () => import('@/entities/sys-login-infor/sys-login-infor.vue');
// prettier-ignore
const SysLoginInforUpdate = () => import('@/entities/sys-login-infor/sys-login-infor-update.vue');
// prettier-ignore
const SysLoginInforDetails = () => import('@/entities/sys-login-infor/sys-login-infor-details.vue');
// prettier-ignore
const SysOperLog = () => import('@/entities/sys-oper-log/sys-oper-log.vue');
// prettier-ignore
const SysOperLogUpdate = () => import('@/entities/sys-oper-log/sys-oper-log-update.vue');
// prettier-ignore
const SysOperLogDetails = () => import('@/entities/sys-oper-log/sys-oper-log-details.vue');
// prettier-ignore
const SysMenu = () => import('@/entities/sys-menu/sys-menu.vue');
// prettier-ignore
const SysMenuUpdate = () => import('@/entities/sys-menu/sys-menu-update.vue');
// prettier-ignore
const SysMenuDetails = () => import('@/entities/sys-menu/sys-menu-details.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/gen-table',
    name: 'GenTable',
    component: GenTable,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/gen-table/new',
    name: 'GenTableCreate',
    component: GenTableUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/gen-table/:genTableId/edit',
    name: 'GenTableEdit',
    component: GenTableUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/gen-table/:genTableId/view',
    name: 'GenTableView',
    component: GenTableDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/gen-table-column',
    name: 'GenTableColumn',
    component: GenTableColumn,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/gen-table-column/new',
    name: 'GenTableColumnCreate',
    component: GenTableColumnUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/gen-table-column/:genTableColumnId/edit',
    name: 'GenTableColumnEdit',
    component: GenTableColumnUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/gen-table-column/:genTableColumnId/view',
    name: 'GenTableColumnView',
    component: GenTableColumnDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-config',
    name: 'SysConfig',
    component: SysConfig,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-config/new',
    name: 'SysConfigCreate',
    component: SysConfigUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-config/:sysConfigId/edit',
    name: 'SysConfigEdit',
    component: SysConfigUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-config/:sysConfigId/view',
    name: 'SysConfigView',
    component: SysConfigDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-dept',
    name: 'SysDept',
    component: SysDept,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-dept/new',
    name: 'SysDeptCreate',
    component: SysDeptUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-dept/:sysDeptId/edit',
    name: 'SysDeptEdit',
    component: SysDeptUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-dept/:sysDeptId/view',
    name: 'SysDeptView',
    component: SysDeptDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-dict-type',
    name: 'SysDictType',
    component: SysDictType,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-dict-type/new',
    name: 'SysDictTypeCreate',
    component: SysDictTypeUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-dict-type/:sysDictTypeId/edit',
    name: 'SysDictTypeEdit',
    component: SysDictTypeUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-dict-type/:sysDictTypeId/view',
    name: 'SysDictTypeView',
    component: SysDictTypeDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-dict-data',
    name: 'SysDictData',
    component: SysDictData,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-dict-data/new',
    name: 'SysDictDataCreate',
    component: SysDictDataUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-dict-data/:sysDictDataId/edit',
    name: 'SysDictDataEdit',
    component: SysDictDataUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-dict-data/:sysDictDataId/view',
    name: 'SysDictDataView',
    component: SysDictDataDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-job',
    name: 'SysJob',
    component: SysJob,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-job/new',
    name: 'SysJobCreate',
    component: SysJobUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-job/:sysJobId/edit',
    name: 'SysJobEdit',
    component: SysJobUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-job/:sysJobId/view',
    name: 'SysJobView',
    component: SysJobDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-job-log',
    name: 'SysJobLog',
    component: SysJobLog,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-job-log/new',
    name: 'SysJobLogCreate',
    component: SysJobLogUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-job-log/:sysJobLogId/edit',
    name: 'SysJobLogEdit',
    component: SysJobLogUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-job-log/:sysJobLogId/view',
    name: 'SysJobLogView',
    component: SysJobLogDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-notice',
    name: 'SysNotice',
    component: SysNotice,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-notice/new',
    name: 'SysNoticeCreate',
    component: SysNoticeUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-notice/:sysNoticeId/edit',
    name: 'SysNoticeEdit',
    component: SysNoticeUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-notice/:sysNoticeId/view',
    name: 'SysNoticeView',
    component: SysNoticeDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-post',
    name: 'SysPost',
    component: SysPost,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-post/new',
    name: 'SysPostCreate',
    component: SysPostUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-post/:sysPostId/edit',
    name: 'SysPostEdit',
    component: SysPostUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-post/:sysPostId/view',
    name: 'SysPostView',
    component: SysPostDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-role',
    name: 'SysRole',
    component: SysRole,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-role/new',
    name: 'SysRoleCreate',
    component: SysRoleUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-role/:sysRoleId/edit',
    name: 'SysRoleEdit',
    component: SysRoleUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-role/:sysRoleId/view',
    name: 'SysRoleView',
    component: SysRoleDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-user',
    name: 'SysUser',
    component: SysUser,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-user/new',
    name: 'SysUserCreate',
    component: SysUserUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-user/:sysUserId/edit',
    name: 'SysUserEdit',
    component: SysUserUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-user/:sysUserId/view',
    name: 'SysUserView',
    component: SysUserDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-login-infor',
    name: 'SysLoginInfor',
    component: SysLoginInfor,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-login-infor/new',
    name: 'SysLoginInforCreate',
    component: SysLoginInforUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-login-infor/:sysLoginInforId/edit',
    name: 'SysLoginInforEdit',
    component: SysLoginInforUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-login-infor/:sysLoginInforId/view',
    name: 'SysLoginInforView',
    component: SysLoginInforDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-oper-log',
    name: 'SysOperLog',
    component: SysOperLog,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-oper-log/new',
    name: 'SysOperLogCreate',
    component: SysOperLogUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-oper-log/:sysOperLogId/edit',
    name: 'SysOperLogEdit',
    component: SysOperLogUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-oper-log/:sysOperLogId/view',
    name: 'SysOperLogView',
    component: SysOperLogDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-menu',
    name: 'SysMenu',
    component: SysMenu,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-menu/new',
    name: 'SysMenuCreate',
    component: SysMenuUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-menu/:sysMenuId/edit',
    name: 'SysMenuEdit',
    component: SysMenuUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/sys-menu/:sysMenuId/view',
    name: 'SysMenuView',
    component: SysMenuDetails,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
