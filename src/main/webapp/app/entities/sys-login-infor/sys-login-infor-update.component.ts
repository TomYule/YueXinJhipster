import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import AlertService from '@/shared/alert/alert.service';
import { ISysLoginInfor, SysLoginInfor } from '@/shared/model/sys-login-infor.model';
import SysLoginInforService from './sys-login-infor.service';

const validations: any = {
  sysLoginInfor: {
    userName: {},
    ipAddr: {},
    loginLocation: {},
    browser: {},
    os: {},
    status: {},
    msg: {},
    loginTime: {},
  },
};

@Component({
  validations,
})
export default class SysLoginInforUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('sysLoginInforService') private sysLoginInforService: () => SysLoginInforService;
  public sysLoginInfor: ISysLoginInfor = new SysLoginInfor();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysLoginInforId) {
        vm.retrieveSysLoginInfor(to.params.sysLoginInforId);
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
    if (this.sysLoginInfor.id) {
      this.sysLoginInforService()
        .update(this.sysLoginInfor)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysLoginInfor.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.sysLoginInforService()
        .create(this.sysLoginInfor)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysLoginInfor.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveSysLoginInfor(sysLoginInforId): void {
    this.sysLoginInforService()
      .find(sysLoginInforId)
      .then(res => {
        this.sysLoginInfor = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
