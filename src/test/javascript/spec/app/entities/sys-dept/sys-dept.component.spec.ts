/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import SysDeptComponent from '@/entities/sys-dept/sys-dept.vue';
import SysDeptClass from '@/entities/sys-dept/sys-dept.component';
import SysDeptService from '@/entities/sys-dept/sys-dept.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-alert', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('SysDept Management Component', () => {
    let wrapper: Wrapper<SysDeptClass>;
    let comp: SysDeptClass;
    let sysDeptServiceStub: SinonStubbedInstance<SysDeptService>;

    beforeEach(() => {
      sysDeptServiceStub = sinon.createStubInstance<SysDeptService>(SysDeptService);
      sysDeptServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<SysDeptClass>(SysDeptComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          alertService: () => new AlertService(store),
          sysDeptService: () => sysDeptServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      sysDeptServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllSysDepts();
      await comp.$nextTick();

      // THEN
      expect(sysDeptServiceStub.retrieve.called).toBeTruthy();
      expect(comp.sysDepts[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      sysDeptServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeSysDept();
      await comp.$nextTick();

      // THEN
      expect(sysDeptServiceStub.delete.called).toBeTruthy();
      expect(sysDeptServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
