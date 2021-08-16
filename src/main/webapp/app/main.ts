// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.common with an alias.
import Vue from 'vue';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import App from './app.vue';
import Vue2Filters from 'vue2-filters';
import router from './router';
import * as config from './shared/config/config';
import * as bootstrapVueConfig from './shared/config/config-bootstrap-vue';
import JhiItemCountComponent from './shared/jhi-item-count.vue';
import JhiSortIndicatorComponent from './shared/sort/jhi-sort-indicator.vue';
import InfiniteLoading from 'vue-infinite-loading';
import AuditsService from './admin/audits/audits.service';

import HealthService from './admin/health/health.service';
import MetricsService from './admin/metrics/metrics.service';
import LogsService from './admin/logs/logs.service';
import ActivateService from './account/activate/activate.service';
import RegisterService from './account/register/register.service';
import UserManagementService from '@/admin/user-management/user-management.service';

import LoginService from './account/login.service';
import AccountService from './account/account.service';

import '../content/scss/vendor.scss';
import AlertService from '@/shared/alert/alert.service';
import TranslationService from '@/locale/translation.service';
import ConfigurationService from '@/admin/configuration/configuration.service';

/* tslint:disable */

import GenTableService from '@/entities/gen-table/gen-table.service';
import GenTableColumnService from '@/entities/gen-table-column/gen-table-column.service';
import SysConfigService from '@/entities/sys-config/sys-config.service';
import SysDeptService from '@/entities/sys-dept/sys-dept.service';
import SysDictTypeService from '@/entities/sys-dict-type/sys-dict-type.service';
import SysDictDataService from '@/entities/sys-dict-data/sys-dict-data.service';
import SysJobService from '@/entities/sys-job/sys-job.service';
import SysJobLogService from '@/entities/sys-job-log/sys-job-log.service';
import SysNoticeService from '@/entities/sys-notice/sys-notice.service';
import SysPostService from '@/entities/sys-post/sys-post.service';
import SysRoleService from '@/entities/sys-role/sys-role.service';
import SysUserService from '@/entities/sys-user/sys-user.service';
import SysLoginInforService from '@/entities/sys-login-infor/sys-login-infor.service';
import SysOperLogService from '@/entities/sys-oper-log/sys-oper-log.service';
import SysMenuService from '@/entities/sys-menu/sys-menu.service';
// jhipster-needle-add-entity-service-to-main-import - JHipster will import entities services here

/* tslint:enable */
Vue.config.productionTip = false;
config.initVueApp(Vue);
config.initFortAwesome(Vue);
bootstrapVueConfig.initBootstrapVue(Vue);
Vue.use(Vue2Filters);
Vue.component('font-awesome-icon', FontAwesomeIcon);
Vue.component('jhi-item-count', JhiItemCountComponent);
Vue.component('jhi-sort-indicator', JhiSortIndicatorComponent);
Vue.component('infinite-loading', InfiniteLoading);

const i18n = config.initI18N(Vue);
const store = config.initVueXStore(Vue);

const alertService = new AlertService(store);
const translationService = new TranslationService(store, i18n);
const loginService = new LoginService();
const accountService = new AccountService(store, translationService, (<any>Vue).cookie, router);

router.beforeEach((to, from, next) => {
  if (!to.matched.length) {
    next('/not-found');
  }

  if (to.meta && to.meta.authorities && to.meta.authorities.length > 0) {
    accountService.hasAnyAuthorityAndCheckAuth(to.meta.authorities).then(value => {
      if (!value) {
        sessionStorage.setItem('requested-url', to.fullPath);
        next('/forbidden');
      } else {
        next();
      }
    });
  } else {
    // no authorities, so just proceed
    next();
  }
});

/* tslint:disable */
new Vue({
  el: '#app',
  components: { App },
  template: '<App/>',
  router,
  provide: {
    loginService: () => loginService,
    activateService: () => new ActivateService(),
    registerService: () => new RegisterService(),
    userService: () => new UserManagementService(),

    auditsService: () => new AuditsService(),

    healthService: () => new HealthService(),

    configurationService: () => new ConfigurationService(),
    logsService: () => new LogsService(),
    metricsService: () => new MetricsService(),
    alertService: () => alertService,
    translationService: () => translationService,
    genTableService: () => new GenTableService(),
    genTableColumnService: () => new GenTableColumnService(),
    sysConfigService: () => new SysConfigService(),
    sysDeptService: () => new SysDeptService(),
    sysDictTypeService: () => new SysDictTypeService(),
    sysDictDataService: () => new SysDictDataService(),
    sysJobService: () => new SysJobService(),
    sysJobLogService: () => new SysJobLogService(),
    sysNoticeService: () => new SysNoticeService(),
    sysPostService: () => new SysPostService(),
    sysRoleService: () => new SysRoleService(),
    sysUserService: () => new SysUserService(),
    sysLoginInforService: () => new SysLoginInforService(),
    sysOperLogService: () => new SysOperLogService(),
    sysMenuService: () => new SysMenuService(),
    // jhipster-needle-add-entity-service-to-main - JHipster will import entities services here
    accountService: () => accountService,
  },
  i18n,
  store,
});
