import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { IGenTable } from '@/shared/model/gen-table.model';
import GenTableService from './gen-table.service';

@Component
export default class GenTableDetails extends mixins(JhiDataUtils) {
  @Inject('genTableService') private genTableService: () => GenTableService;
  public genTable: IGenTable = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.genTableId) {
        vm.retrieveGenTable(to.params.genTableId);
      }
    });
  }

  public retrieveGenTable(genTableId) {
    this.genTableService()
      .find(genTableId)
      .then(res => {
        this.genTable = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
