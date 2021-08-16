import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';
import { ISysJobLog, SysJobLog } from '@/shared/model/sys-job-log.model';
import SysJobLogService from './sys-job-log.service';

const validations: any = {
  sysJobLog: {
    jobName: {},
    jobGroup: {},
    invokeTarget: {},
    status: {},
    exceptionInfo: {},
    createTime: {},
  },
};

@Component({
  validations,
})
export default class SysJobLogUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('sysJobLogService') private sysJobLogService: () => SysJobLogService;
  public sysJobLog: ISysJobLog = new SysJobLog();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysJobLogId) {
        vm.retrieveSysJobLog(to.params.sysJobLogId);
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
    if (this.sysJobLog.id) {
      this.sysJobLogService()
        .update(this.sysJobLog)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysJobLog.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.sysJobLogService()
        .create(this.sysJobLog)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysJobLog.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveSysJobLog(sysJobLogId): void {
    this.sysJobLogService()
      .find(sysJobLogId)
      .then(res => {
        this.sysJobLog = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
