import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import SysPostService from '../sys-post/sys-post.service';
import { ISysPost } from '@/shared/model/sys-post.model';

import SysDeptService from '../sys-dept/sys-dept.service';
import { ISysDept } from '@/shared/model/sys-dept.model';

import SysRoleService from '../sys-role/sys-role.service';
import { ISysRole } from '@/shared/model/sys-role.model';

import AlertService from '@/shared/alert/alert.service';
import { ISysUser, SysUser } from '@/shared/model/sys-user.model';
import SysUserService from './sys-user.service';

const validations: any = {
  sysUser: {
    deptId: {
      required,
    },
    userName: {
      maxLength: maxLength(30),
    },
    nickName: {
      maxLength: maxLength(30),
    },
    userType: {},
    email: {
      maxLength: maxLength(50),
    },
    phoneNumber: {
      maxLength: maxLength(11),
    },
    gender: {},
    avatar: {},
    password: {},
    status: {},
    delFlag: {},
    loginIp: {},
    loginDate: {},
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
export default class SysUserUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('sysUserService') private sysUserService: () => SysUserService;
  public sysUser: ISysUser = new SysUser();

  @Inject('sysPostService') private sysPostService: () => SysPostService;

  public sysPosts: ISysPost[] = [];

  @Inject('sysDeptService') private sysDeptService: () => SysDeptService;

  public sysDepts: ISysDept[] = [];

  @Inject('sysRoleService') private sysRoleService: () => SysRoleService;

  public sysRoles: ISysRole[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysUserId) {
        vm.retrieveSysUser(to.params.sysUserId);
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
    this.sysUser.sysPosts = [];
  }

  public save(): void {
    this.isSaving = true;
    if (this.sysUser.id) {
      this.sysUserService()
        .update(this.sysUser)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysUser.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.sysUserService()
        .create(this.sysUser)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysUser.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveSysUser(sysUserId): void {
    this.sysUserService()
      .find(sysUserId)
      .then(res => {
        this.sysUser = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.sysPostService()
      .retrieve()
      .then(res => {
        this.sysPosts = res.data;
      });
    this.sysDeptService()
      .retrieve()
      .then(res => {
        this.sysDepts = res.data;
      });
    this.sysRoleService()
      .retrieve()
      .then(res => {
        this.sysRoles = res.data;
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
