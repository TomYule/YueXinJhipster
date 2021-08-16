import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import SysDictDataService from '../sys-dict-data/sys-dict-data.service';
import { ISysDictData } from '@/shared/model/sys-dict-data.model';

import AlertService from '@/shared/alert/alert.service';
import { ISysDictType, SysDictType } from '@/shared/model/sys-dict-type.model';
import SysDictTypeService from './sys-dict-type.service';

const validations: any = {
  sysDictType: {
    dictName: {},
    dictType: {},
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
export default class SysDictTypeUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('sysDictTypeService') private sysDictTypeService: () => SysDictTypeService;
  public sysDictType: ISysDictType = new SysDictType();

  @Inject('sysDictDataService') private sysDictDataService: () => SysDictDataService;

  public sysDictData: ISysDictData[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.sysDictTypeId) {
        vm.retrieveSysDictType(to.params.sysDictTypeId);
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
    if (this.sysDictType.id) {
      this.sysDictTypeService()
        .update(this.sysDictType)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysDictType.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.sysDictTypeService()
        .create(this.sysDictType)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('yueXinJhipsterApp.sysDictType.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveSysDictType(sysDictTypeId): void {
    this.sysDictTypeService()
      .find(sysDictTypeId)
      .then(res => {
        this.sysDictType = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.sysDictDataService()
      .retrieve()
      .then(res => {
        this.sysDictData = res.data;
      });
  }
}
