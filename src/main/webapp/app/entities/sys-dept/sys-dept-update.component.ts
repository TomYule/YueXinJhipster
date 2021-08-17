import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import SysUserService from '../sys-user/sys-user.service';
import { ISysUser } from '@/shared/model/sys-user.model';

import AlertService from '@/shared/alert/alert.service';
import { ISysDept, SysDept } from '@/shared/model/sys-dept.model';
import SysDeptService from './sys-dept.service';

const validations: any = {
  sysDept: {
    deptName: {
      required,
    },
    parentId: {},
    ancestors: {},
    orderNum: {},
    leader: {},
    phone: {},
    email: {},
    status: {},
    delFlag: {},
    createBy: {},
    createTime: {},
    updateBy: {},
    upLocalDate: {},
  },
};

@Component({
  validations,
})
export default class SysDeptUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('sysDeptService') private sysDeptService: () => SysDeptService;
  public sysDept: ISysDept = new SysDept();

  @Inject('sysUserService') private sysUserService: () => SysUserService;

  public sysUsers: ISysUser[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysDeptId) {
        vm.retrieveSysDept(to.params.sysDeptId);
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
    if (this.sysDept.id) {
      this.sysDeptService()
        .update(this.sysDept)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysDept.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.sysDeptService()
        .create(this.sysDept)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysDept.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveSysDept(sysDeptId): void {
    this.sysDeptService()
      .find(sysDeptId)
      .then(res => {
        this.sysDept = res;
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
