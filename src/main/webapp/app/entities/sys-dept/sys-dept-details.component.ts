import { Component, Vue, Inject } from 'vue-property-decorator';

import { ISysDept } from '@/shared/model/sys-dept.model';
import SysDeptService from './sys-dept.service';

@Component
export default class SysDeptDetails extends Vue {
  @Inject('sysDeptService') private sysDeptService: () => SysDeptService;
  public sysDept: ISysDept = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysDeptId) {
        vm.retrieveSysDept(to.params.sysDeptId);
      }
    });
  }

  public retrieveSysDept(sysDeptId) {
    this.sysDeptService()
      .find(sysDeptId)
      .then(res => {
        this.sysDept = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
