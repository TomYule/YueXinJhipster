import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ISysMenu } from '@/shared/model/sys-menu.model';
import AlertMixin from '@/shared/alert/alert.mixin';

import JhiDataUtils from '@/shared/data/data-utils.service';

import SysMenuService from './sys-menu.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class SysMenu extends mixins(JhiDataUtils, AlertMixin) {
  @Inject('sysMenuService') private sysMenuService: () => SysMenuService;
  private removeId: number = null;

  public sysMenus: ISysMenu[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllSysMenus();
  }

  public clear(): void {
    this.retrieveAllSysMenus();
  }

  public retrieveAllSysMenus(): void {
    this.isFetching = true;

    this.sysMenuService()
      .retrieve()
      .then(
        res => {
          this.sysMenus = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public prepareRemove(instance: ISysMenu): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeSysMenu(): void {
    this.sysMenuService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('yueXinJhipsterApp.sysMenu.deleted', { param: this.removeId });
        this.alertService().showAlert(message, 'danger');
        this.getAlertFromStore();
        this.removeId = null;
        this.retrieveAllSysMenus();
        this.closeDialog();
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
