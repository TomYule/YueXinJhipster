import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ISysRole } from '@/shared/model/sys-role.model';
import SysRoleService from './sys-role.service';

@Component
export default class SysRoleDetails extends mixins(JhiDataUtils) {
  @Inject('sysRoleService') private sysRoleService: () => SysRoleService;
  public sysRole: ISysRole = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysRoleId) {
        vm.retrieveSysRole(to.params.sysRoleId);
      }
    });
  }

  public retrieveSysRole(sysRoleId) {
    this.sysRoleService()
      .find(sysRoleId)
      .then(res => {
        this.sysRole = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
