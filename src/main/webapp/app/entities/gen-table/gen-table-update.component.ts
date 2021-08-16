import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import GenTableColumnService from '../gen-table-column/gen-table-column.service';
import { IGenTableColumn } from '@/shared/model/gen-table-column.model';

import AlertService from '@/shared/alert/alert.service';
import { IGenTable, GenTable } from '@/shared/model/gen-table.model';
import GenTableService from './gen-table.service';

const validations: any = {
  genTable: {
    tableName: {
      required,
    },
    tableComment: {},
    subTableName: {},
    subTableFkName: {},
    className: {},
    tplCategory: {},
    packAgeName: {},
    moduleName: {},
    businessName: {},
    functionName: {},
    functionAuthor: {},
    genType: {},
    genPath: {},
    options: {},
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
export default class GenTableUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('genTableService') private genTableService: () => GenTableService;
  public genTable: IGenTable = new GenTable();

  @Inject('genTableColumnService') private genTableColumnService: () => GenTableColumnService;

  public genTableColumns: IGenTableColumn[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.genTableId) {
        vm.retrieveGenTable(to.params.genTableId);
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
    if (this.genTable.id) {
      this.genTableService()
        .update(this.genTable)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.genTable.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.genTableService()
        .create(this.genTable)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.genTable.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveGenTable(genTableId): void {
    this.genTableService()
      .find(genTableId)
      .then(res => {
        this.genTable = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.genTableColumnService()
      .retrieve()
      .then(res => {
        this.genTableColumns = res.data;
      });
  }
}
