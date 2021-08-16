import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import GenTableService from '../gen-table/gen-table.service';
import { IGenTable } from '@/shared/model/gen-table.model';

import AlertService from '@/shared/alert/alert.service';
import { IGenTableColumn, GenTableColumn } from '@/shared/model/gen-table-column.model';
import GenTableColumnService from './gen-table-column.service';

const validations: any = {
  genTableColumn: {
    tableId: {
      required,
    },
    columnName: {},
    columnComment: {},
    columnType: {},
    javaType: {},
    javaField: {},
    isPk: {},
    isIncrement: {},
    isRequired: {},
    isInsert: {},
    isEdit: {},
    isList: {},
    isQuery: {},
    htmlType: {},
    dictType: {},
    sort: {},
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
export default class GenTableColumnUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('genTableColumnService') private genTableColumnService: () => GenTableColumnService;
  public genTableColumn: IGenTableColumn = new GenTableColumn();

  @Inject('genTableService') private genTableService: () => GenTableService;

  public genTables: IGenTable[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.genTableColumnId) {
        vm.retrieveGenTableColumn(to.params.genTableColumnId);
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
    if (this.genTableColumn.id) {
      this.genTableColumnService()
        .update(this.genTableColumn)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.genTableColumn.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.genTableColumnService()
        .create(this.genTableColumn)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.genTableColumn.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveGenTableColumn(genTableColumnId): void {
    this.genTableColumnService()
      .find(genTableColumnId)
      .then(res => {
        this.genTableColumn = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.genTableService()
      .retrieve()
      .then(res => {
        this.genTables = res.data;
      });
  }
}
