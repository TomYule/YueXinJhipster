import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';
import { ISysNotice, SysNotice } from '@/shared/model/sys-notice.model';
import SysNoticeService from './sys-notice.service';

const validations: any = {
  sysNotice: {
    noticeTitle: {
      required,
    },
    noticeType: {},
    noticeContent: {},
    status: {},
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
export default class SysNoticeUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('sysNoticeService') private sysNoticeService: () => SysNoticeService;
  public sysNotice: ISysNotice = new SysNotice();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysNoticeId) {
        vm.retrieveSysNotice(to.params.sysNoticeId);
      }
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
    if (this.sysNotice.id) {
      this.sysNoticeService()
        .update(this.sysNotice)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysNotice.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.sysNoticeService()
        .create(this.sysNotice)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysNotice.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveSysNotice(sysNoticeId): void {
    this.sysNoticeService()
      .find(sysNoticeId)
      .then(res => {
        this.sysNotice = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
