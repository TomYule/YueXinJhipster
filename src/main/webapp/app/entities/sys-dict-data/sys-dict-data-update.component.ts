import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import SysDictTypeService from '../sys-dict-type/sys-dict-type.service';
import { ISysDictType } from '@/shared/model/sys-dict-type.model';

import AlertService from '@/shared/alert/alert.service';
import { ISysDictData, SysDictData } from '@/shared/model/sys-dict-data.model';
import SysDictDataService from './sys-dict-data.service';

const validations: any = {
  sysDictData: {
    dictSort: {},
    dictLabel: {},
    dictValue: {},
    dictType: {},
    cssClass: {},
    listClass: {},
    isDefault: {},
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
export default class SysDictDataUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('sysDictDataService') private sysDictDataService: () => SysDictDataService;
  public sysDictData: ISysDictData = new SysDictData();

  @Inject('sysDictTypeService') private sysDictTypeService: () => SysDictTypeService;

  public sysDictTypes: ISysDictType[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysDictDataId) {
        vm.retrieveSysDictData(to.params.sysDictDataId);
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
    if (this.sysDictData.id) {
      this.sysDictDataService()
        .update(this.sysDictData)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysDictData.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.sysDictDataService()
        .create(this.sysDictData)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysDictData.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveSysDictData(sysDictDataId): void {
    this.sysDictDataService()
      .find(sysDictDataId)
      .then(res => {
        this.sysDictData = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.sysDictTypeService()
      .retrieve()
      .then(res => {
        this.sysDictTypes = res.data;
      });
  }
}
