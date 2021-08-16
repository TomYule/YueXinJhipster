/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import GenTableColumnUpdateComponent from '@/entities/gen-table-column/gen-table-column-update.vue';
import GenTableColumnClass from '@/entities/gen-table-column/gen-table-column-update.component';
import GenTableColumnService from '@/entities/gen-table-column/gen-table-column.service';

import GenTableService from '@/entities/gen-table/gen-table.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('GenTableColumn Management Update Component', () => {
    let wrapper: Wrapper<GenTableColumnClass>;
    let comp: GenTableColumnClass;
    let genTableColumnServiceStub: SinonStubbedInstance<GenTableColumnService>;

    beforeEach(() => {
      genTableColumnServiceStub = sinon.createStubInstance<GenTableColumnService>(GenTableColumnService);

      wrapper = shallowMount<GenTableColumnClass>(GenTableColumnUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          genTableColumnService: () => genTableColumnServiceStub,

          genTableService: () => new GenTableService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.genTableColumn = entity;
        genTableColumnServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(genTableColumnServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.genTableColumn = entity;
        genTableColumnServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(genTableColumnServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
