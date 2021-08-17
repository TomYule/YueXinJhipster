import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ISysJob } from '@/shared/model/sys-job.model';
import SysJobService from './sys-job.service';

@Component
export default class SysJobDetails extends mixins(JhiDataUtils) {
  @Inject('sysJobService') private sysJobService: () => SysJobService;
  public sysJob: ISysJob = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysJobId) {
        vm.retrieveSysJob(to.params.sysJobId);
      }
    });
  }

  public retrieveSysJob(sysJobId) {
    this.sysJobService()
      .find(sysJobId)
      .then(res => {
        this.sysJob = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
