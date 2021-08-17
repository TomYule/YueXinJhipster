/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import GenTableColumnDetailComponent from '@/entities/gen-table-column/gen-table-column-details.vue';
import GenTableColumnClass from '@/entities/gen-table-column/gen-table-column-details.component';
import GenTableColumnService from '@/entities/gen-table-column/gen-table-column.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('GenTableColumn Management Detail Component', () => {
    let wrapper: Wrapper<GenTableColumnClass>;
    let comp: GenTableColumnClass;
    let genTableColumnServiceStub: SinonStubbedInstance<GenTableColumnService>;

    beforeEach(() => {
      genTableColumnServiceStub = sinon.createStubInstance<GenTableColumnService>(GenTableColumnService);

      wrapper = shallowMount<GenTableColumnClass>(GenTableColumnDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { genTableColumnService: () => genTableColumnServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundGenTableColumn = { id: 123 };
        genTableColumnServiceStub.find.resolves(foundGenTableColumn);

        // WHEN
        comp.retrieveGenTableColumn(123);
        await comp.$nextTick();

        // THEN
        expect(comp.genTableColumn).toBe(foundGenTableColumn);
      });
    });
  });
});
