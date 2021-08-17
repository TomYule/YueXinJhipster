/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import SysDictDataUpdateComponent from '@/entities/sys-dict-data/sys-dict-data-update.vue';
import SysDictDataClass from '@/entities/sys-dict-data/sys-dict-data-update.component';
import SysDictDataService from '@/entities/sys-dict-data/sys-dict-data.service';

import SysDictTypeService from '@/entities/sys-dict-type/sys-dict-type.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('SysDictData Management Update Component', () => {
    let wrapper: Wrapper<SysDictDataClass>;
    let comp: SysDictDataClass;
    let sysDictDataServiceStub: SinonStubbedInstance<SysDictDataService>;

    beforeEach(() => {
      sysDictDataServiceStub = sinon.createStubInstance<SysDictDataService>(SysDictDataService);

      wrapper = shallowMount<SysDictDataClass>(SysDictDataUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          sysDictDataService: () => sysDictDataServiceStub,

          sysDictTypeService: () => new SysDictTypeService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.sysDictData = entity;
        sysDictDataServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysDictDataServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.sysDictData = entity;
        sysDictDataServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysDictDataServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
