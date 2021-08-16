import { Component, Vue, Inject } from 'vue-property-decorator';

import { ISysJobLog } from '@/shared/model/sys-job-log.model';
import SysJobLogService from './sys-job-log.service';

@Component
export default class SysJobLogDetails extends Vue {
  @Inject('sysJobLogService') private sysJobLogService: () => SysJobLogService;
  public sysJobLog: ISysJobLog = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysJobLogId) {
        vm.retrieveSysJobLog(to.params.sysJobLogId);
      }
    });
  }

  public retrieveSysJobLog(sysJobLogId) {
    this.sysJobLogService()
      .find(sysJobLogId)
      .then(res => {
        this.sysJobLog = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
