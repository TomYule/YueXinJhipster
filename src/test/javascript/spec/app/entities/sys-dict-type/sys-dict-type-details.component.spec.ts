/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import SysDictTypeDetailComponent from '@/entities/sys-dict-type/sys-dict-type-details.vue';
import SysDictTypeClass from '@/entities/sys-dict-type/sys-dict-type-details.component';
import SysDictTypeService from '@/entities/sys-dict-type/sys-dict-type.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('SysDictType Management Detail Component', () => {
    let wrapper: Wrapper<SysDictTypeClass>;
    let comp: SysDictTypeClass;
    let sysDictTypeServiceStub: SinonStubbedInstance<SysDictTypeService>;

    beforeEach(() => {
      sysDictTypeServiceStub = sinon.createStubInstance<SysDictTypeService>(SysDictTypeService);

      wrapper = shallowMount<SysDictTypeClass>(SysDictTypeDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { sysDictTypeService: () => sysDictTypeServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundSysDictType = { id: 123 };
        sysDictTypeServiceStub.find.resolves(foundSysDictType);

        // WHEN
        comp.retrieveSysDictType(123);
        await comp.$nextTick();

        // THEN
        expect(comp.sysDictType).toBe(foundSysDictType);
      });
    });
  });
});
