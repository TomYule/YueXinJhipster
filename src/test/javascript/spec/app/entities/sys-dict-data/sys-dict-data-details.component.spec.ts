/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import SysDictDataDetailComponent from '@/entities/sys-dict-data/sys-dict-data-details.vue';
import SysDictDataClass from '@/entities/sys-dict-data/sys-dict-data-details.component';
import SysDictDataService from '@/entities/sys-dict-data/sys-dict-data.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('SysDictData Management Detail Component', () => {
    let wrapper: Wrapper<SysDictDataClass>;
    let comp: SysDictDataClass;
    let sysDictDataServiceStub: SinonStubbedInstance<SysDictDataService>;

    beforeEach(() => {
      sysDictDataServiceStub = sinon.createStubInstance<SysDictDataService>(SysDictDataService);

      wrapper = shallowMount<SysDictDataClass>(SysDictDataDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { sysDictDataService: () => sysDictDataServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundSysDictData = { id: 123 };
        sysDictDataServiceStub.find.resolves(foundSysDictData);

        // WHEN
        comp.retrieveSysDictData(123);
        await comp.$nextTick();

        // THEN
        expect(comp.sysDictData).toBe(foundSysDictData);
      });
    });
  });
});
