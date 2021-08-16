/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import GenTableDetailComponent from '@/entities/gen-table/gen-table-details.vue';
import GenTableClass from '@/entities/gen-table/gen-table-details.component';
import GenTableService from '@/entities/gen-table/gen-table.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('GenTable Management Detail Component', () => {
    let wrapper: Wrapper<GenTableClass>;
    let comp: GenTableClass;
    let genTableServiceStub: SinonStubbedInstance<GenTableService>;

    beforeEach(() => {
      genTableServiceStub = sinon.createStubInstance<GenTableService>(GenTableService);

      wrapper = shallowMount<GenTableClass>(GenTableDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { genTableService: () => genTableServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundGenTable = { id: 123 };
        genTableServiceStub.find.resolves(foundGenTable);

        // WHEN
        comp.retrieveGenTable(123);
        await comp.$nextTick();

        // THEN
        expect(comp.genTable).toBe(foundGenTable);
      });
    });
  });
});
