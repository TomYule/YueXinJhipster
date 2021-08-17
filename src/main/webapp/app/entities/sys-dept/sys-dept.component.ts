import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ISysDept } from '@/shared/model/sys-dept.model';
import AlertMixin from '@/shared/alert/alert.mixin';

import SysDeptService from './sys-dept.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class SysDept extends mixins(AlertMixin) {
  @Inject('sysDeptService') private sysDeptService: () => SysDeptService;
  private removeId: number = null;

  public sysDepts: ISysDept[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllSysDepts();
  }

  public clear(): void {
    this.retrieveAllSysDepts();
  }

  public retrieveAllSysDepts(): void {
    this.isFetching = true;

    this.sysDeptService()
      .retrieve()
      .then(
        res => {
          this.sysDepts = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public prepareRemove(instance: ISysDept): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeSysDept(): void {
    this.sysDeptService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('yueXinJhipsterApp.sysDept.deleted', { param: this.removeId });
        this.alertService().showAlert(message, 'danger');
        this.getAlertFromStore();
        this.removeId = null;
        this.retrieveAllSysDepts();
        this.closeDialog();
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
