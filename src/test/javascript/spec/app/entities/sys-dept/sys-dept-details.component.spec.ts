/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import SysDeptDetailComponent from '@/entities/sys-dept/sys-dept-details.vue';
import SysDeptClass from '@/entities/sys-dept/sys-dept-details.component';
import SysDeptService from '@/entities/sys-dept/sys-dept.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('SysDept Management Detail Component', () => {
    let wrapper: Wrapper<SysDeptClass>;
    let comp: SysDeptClass;
    let sysDeptServiceStub: SinonStubbedInstance<SysDeptService>;

    beforeEach(() => {
      sysDeptServiceStub = sinon.createStubInstance<SysDeptService>(SysDeptService);

      wrapper = shallowMount<SysDeptClass>(SysDeptDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { sysDeptService: () => sysDeptServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundSysDept = { id: 123 };
        sysDeptServiceStub.find.resolves(foundSysDept);

        // WHEN
        comp.retrieveSysDept(123);
        await comp.$nextTick();

        // THEN
        expect(comp.sysDept).toBe(foundSysDept);
      });
    });
  });
});
