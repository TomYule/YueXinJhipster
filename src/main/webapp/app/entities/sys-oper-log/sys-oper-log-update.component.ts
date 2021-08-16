import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';
import { ISysOperLog, SysOperLog } from '@/shared/model/sys-oper-log.model';
import SysOperLogService from './sys-oper-log.service';

const validations: any = {
  sysOperLog: {
    title: {
      required,
    },
    businessType: {},
    method: {},
    requestMethod: {},
    operatorType: {},
    operName: {},
    deptName: {},
    operUrl: {},
    operIp: {},
    operLocation: {},
    operParam: {},
    jsonResult: {},
    status: {},
    errorMsg: {},
    operTime: {},
  },
};

@Component({
  validations,
})
export default class SysOperLogUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('sysOperLogService') private sysOperLogService: () => SysOperLogService;
  public sysOperLog: ISysOperLog = new SysOperLog();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysOperLogId) {
        vm.retrieveSysOperLog(to.params.sysOperLogId);
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
    if (this.sysOperLog.id) {
      this.sysOperLogService()
        .update(this.sysOperLog)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysOperLog.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.sysOperLogService()
        .create(this.sysOperLog)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysOperLog.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveSysOperLog(sysOperLogId): void {
    this.sysOperLogService()
      .find(sysOperLogId)
      .then(res => {
        this.sysOperLog = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
