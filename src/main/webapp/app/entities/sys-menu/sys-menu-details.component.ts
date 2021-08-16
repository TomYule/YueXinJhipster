import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ISysMenu } from '@/shared/model/sys-menu.model';
import SysMenuService from './sys-menu.service';

@Component
export default class SysMenuDetails extends mixins(JhiDataUtils) {
  @Inject('sysMenuService') private sysMenuService: () => SysMenuService;
  public sysMenu: ISysMenu = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysMenuId) {
        vm.retrieveSysMenu(to.params.sysMenuId);
      }
    });
  }

  public retrieveSysMenu(sysMenuId) {
    this.sysMenuService()
      .find(sysMenuId)
      .then(res => {
        this.sysMenu = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
