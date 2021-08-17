import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import SysUserService from '../sys-user/sys-user.service';
import { ISysUser } from '@/shared/model/sys-user.model';

import AlertService from '@/shared/alert/alert.service';
import { ISysPost, SysPost } from '@/shared/model/sys-post.model';
import SysPostService from './sys-post.service';

const validations: any = {
  sysPost: {
    postCode: {},
    postName: {},
    postSort: {},
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
export default class SysPostUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('sysPostService') private sysPostService: () => SysPostService;
  public sysPost: ISysPost = new SysPost();

  @Inject('sysUserService') private sysUserService: () => SysUserService;

  public sysUsers: ISysUser[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysPostId) {
        vm.retrieveSysPost(to.params.sysPostId);
      }
      vm.initRelationships();
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
    if (this.sysPost.id) {
      this.sysPostService()
        .update(this.sysPost)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysPost.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.sysPostService()
        .create(this.sysPost)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysPost.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveSysPost(sysPostId): void {
    this.sysPostService()
      .find(sysPostId)
      .then(res => {
        this.sysPost = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.sysUserService()
      .retrieve()
      .then(res => {
        this.sysUsers = res.data;
      });
  }
}
