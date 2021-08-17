import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ISysPost } from '@/shared/model/sys-post.model';
import SysPostService from './sys-post.service';

@Component
export default class SysPostDetails extends mixins(JhiDataUtils) {
  @Inject('sysPostService') private sysPostService: () => SysPostService;
  public sysPost: ISysPost = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysPostId) {
        vm.retrieveSysPost(to.params.sysPostId);
      }
    });
  }

  public retrieveSysPost(sysPostId) {
    this.sysPostService()
      .find(sysPostId)
      .then(res => {
        this.sysPost = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
