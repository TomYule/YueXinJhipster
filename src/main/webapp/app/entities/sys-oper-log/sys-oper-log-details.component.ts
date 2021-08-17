import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ISysOperLog } from '@/shared/model/sys-oper-log.model';
import SysOperLogService from './sys-oper-log.service';

@Component
export default class SysOperLogDetails extends mixins(JhiDataUtils) {
  @Inject('sysOperLogService') private sysOperLogService: () => SysOperLogService;
  public sysOperLog: ISysOperLog = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysOperLogId) {
        vm.retrieveSysOperLog(to.params.sysOperLogId);
      }
    });
  }

  public retrieveSysOperLog(sysOperLogId) {
    this.sysOperLogService()
      .find(sysOperLogId)
      .then(res => {
        this.sysOperLog = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
