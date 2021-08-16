/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import GenTableUpdateComponent from '@/entities/gen-table/gen-table-update.vue';
import GenTableClass from '@/entities/gen-table/gen-table-update.component';
import GenTableService from '@/entities/gen-table/gen-table.service';

import GenTableColumnService from '@/entities/gen-table-column/gen-table-column.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('GenTable Management Update Component', () => {
    let wrapper: Wrapper<GenTableClass>;
    let comp: GenTableClass;
    let genTableServiceStub: SinonStubbedInstance<GenTableService>;

    beforeEach(() => {
      genTableServiceStub = sinon.createStubInstance<GenTableService>(GenTableService);

      wrapper = shallowMount<GenTableClass>(GenTableUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          genTableService: () => genTableServiceStub,

          genTableColumnService: () => new GenTableColumnService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.genTable = entity;
        genTableServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(genTableServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.genTable = entity;
        genTableServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(genTableServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
