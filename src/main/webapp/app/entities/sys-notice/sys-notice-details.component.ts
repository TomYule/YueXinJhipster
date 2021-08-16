import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ISysNotice } from '@/shared/model/sys-notice.model';
import SysNoticeService from './sys-notice.service';

@Component
export default class SysNoticeDetails extends mixins(JhiDataUtils) {
  @Inject('sysNoticeService') private sysNoticeService: () => SysNoticeService;
  public sysNotice: ISysNotice = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysNoticeId) {
        vm.retrieveSysNotice(to.params.sysNoticeId);
      }
    });
  }

  public retrieveSysNotice(sysNoticeId) {
    this.sysNoticeService()
      .find(sysNoticeId)
      .then(res => {
        this.sysNotice = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
