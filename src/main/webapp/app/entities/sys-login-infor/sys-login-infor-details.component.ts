import { Component, Vue, Inject } from 'vue-property-decorator';

import { ISysLoginInfor } from '@/shared/model/sys-login-infor.model';
import SysLoginInforService from './sys-login-infor.service';

@Component
export default class SysLoginInforDetails extends Vue {
  @Inject('sysLoginInforService') private sysLoginInforService: () => SysLoginInforService;
  public sysLoginInfor: ISysLoginInfor = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysLoginInforId) {
        vm.retrieveSysLoginInfor(to.params.sysLoginInforId);
      }
    });
  }

  public retrieveSysLoginInfor(sysLoginInforId) {
    this.sysLoginInforService()
      .find(sysLoginInforId)
      .then(res => {
        this.sysLoginInfor = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
