import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ISysDictData } from '@/shared/model/sys-dict-data.model';
import SysDictDataService from './sys-dict-data.service';

@Component
export default class SysDictDataDetails extends mixins(JhiDataUtils) {
  @Inject('sysDictDataService') private sysDictDataService: () => SysDictDataService;
  public sysDictData: ISysDictData = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysDictDataId) {
        vm.retrieveSysDictData(to.params.sysDictDataId);
      }
    });
  }

  public retrieveSysDictData(sysDictDataId) {
    this.sysDictDataService()
      .find(sysDictDataId)
      .then(res => {
        this.sysDictData = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
