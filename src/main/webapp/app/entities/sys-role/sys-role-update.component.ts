import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import SysMenuService from '../sys-menu/sys-menu.service';
import { ISysMenu } from '@/shared/model/sys-menu.model';

import SysUserService from '../sys-user/sys-user.service';
import { ISysUser } from '@/shared/model/sys-user.model';

import AlertService from '@/shared/alert/alert.service';
import { ISysRole, SysRole } from '@/shared/model/sys-role.model';
import SysRoleService from './sys-role.service';

const validations: any = {
  sysRole: {
    roleName: {},
    roleKey: {},
    roleSort: {},
    dataScope: {},
    menuCheckStrictly: {},
    deptCheckStrictly: {},
    status: {},
    delFlag: {},
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
export default class SysRoleUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('sysRoleService') private sysRoleService: () => SysRoleService;
  public sysRole: ISysRole = new SysRole();

  @Inject('sysMenuService') private sysMenuService: () => SysMenuService;

  public sysMenus: ISysMenu[] = [];

  @Inject('sysUserService') private sysUserService: () => SysUserService;

  public sysUsers: ISysUser[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysRoleId) {
        vm.retrieveSysRole(to.params.sysRoleId);
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
    this.sysRole.sysMenus = [];
    this.sysRole.sysUsers = [];
  }

  public save(): void {
    this.isSaving = true;
    if (this.sysRole.id) {
      this.sysRoleService()
        .update(this.sysRole)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysRole.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.sysRoleService()
        .create(this.sysRole)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysRole.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveSysRole(sysRoleId): void {
    this.sysRoleService()
      .find(sysRoleId)
      .then(res => {
        this.sysRole = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.sysMenuService()
      .retrieve()
      .then(res => {
        this.sysMenus = res.data;
      });
    this.sysUserService()
      .retrieve()
      .then(res => {
        this.sysUsers = res.data;
      });
  }

  public getSelected(selectedVals, option): any {
    if (selectedVals) {
      for (let i = 0; i < selectedVals.length; i++) {
        if (option.id === selectedVals[i].id) {
          return selectedVals[i];
        }
      }
    }
    return option;
  }
}
