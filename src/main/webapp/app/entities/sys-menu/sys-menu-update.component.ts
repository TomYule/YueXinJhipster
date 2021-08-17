import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import SysRoleService from '../sys-role/sys-role.service';
import { ISysRole } from '@/shared/model/sys-role.model';

import AlertService from '@/shared/alert/alert.service';
import { ISysMenu, SysMenu } from '@/shared/model/sys-menu.model';
import SysMenuService from './sys-menu.service';

const validations: any = {
  sysMenu: {
    menuName: {
      required,
    },
    parentId: {},
    orderNum: {},
    path: {},
    components: {},
    isFrame: {},
    isCache: {},
    menuType: {},
    visible: {},
    status: {},
    perms: {},
    icon: {},
    createBy: {},
    createTime: {},
    updateBy: {},
    upLocalDate: {},
    remark: {},
  },
};

@Component({
  validations,
})
export default class SysMenuUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('sysMenuService') private sysMenuService: () => SysMenuService;
  public sysMenu: ISysMenu = new SysMenu();

  @Inject('sysRoleService') private sysRoleService: () => SysRoleService;

  public sysRoles: ISysRole[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysMenuId) {
        vm.retrieveSysMenu(to.params.sysMenuId);
      }
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;
    if (this.sysMenu.id) {
      this.sysMenuService()
        .update(this.sysMenu)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysMenu.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.sysMenuService()
        .create(this.sysMenu)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysMenu.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveSysMenu(sysMenuId): void {
    this.sysMenuService()
      .find(sysMenuId)
      .then(res => {
        this.sysMenu = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.sysRoleService()
      .retrieve()
      .then(res => {
        this.sysRoles = res.data;
      });
  }
}
