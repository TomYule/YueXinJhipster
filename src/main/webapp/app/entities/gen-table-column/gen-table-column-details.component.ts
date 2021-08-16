import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { IGenTableColumn } from '@/shared/model/gen-table-column.model';
import GenTableColumnService from './gen-table-column.service';

@Component
export default class GenTableColumnDetails extends mixins(JhiDataUtils) {
  @Inject('genTableColumnService') private genTableColumnService: () => GenTableColumnService;
  public genTableColumn: IGenTableColumn = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.genTableColumnId) {
        vm.retrieveGenTableColumn(to.params.genTableColumnId);
      }
    });
  }

  public retrieveGenTableColumn(genTableColumnId) {
    this.genTableColumnService()
      .find(genTableColumnId)
      .then(res => {
        this.genTableColumn = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
