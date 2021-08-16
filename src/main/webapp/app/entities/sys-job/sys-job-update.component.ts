import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';
import { ISysJob, SysJob } from '@/shared/model/sys-job.model';
import SysJobService from './sys-job.service';

const validations: any = {
  sysJob: {
    jobName: {},
    jobGroup: {},
    invokeTarget: {},
    cronExpression: {},
    misfirePolicy: {},
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
export default class SysJobUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('sysJobService') private sysJobService: () => SysJobService;
  public sysJob: ISysJob = new SysJob();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysJobId) {
        vm.retrieveSysJob(to.params.sysJobId);
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
    if (this.sysJob.id) {
      this.sysJobService()
        .update(this.sysJob)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysJob.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.sysJobService()
        .create(this.sysJob)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysJob.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveSysJob(sysJobId): void {
    this.sysJobService()
      .find(sysJobId)
      .then(res => {
        this.sysJob = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
