/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import SysMenuComponent from '@/entities/sys-menu/sys-menu.vue';
import SysMenuClass from '@/entities/sys-menu/sys-menu.component';
import SysMenuService from '@/entities/sys-menu/sys-menu.service';

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
  describe('SysMenu Management Component', () => {
    let wrapper: Wrapper<SysMenuClass>;
    let comp: SysMenuClass;
    let sysMenuServiceStub: SinonStubbedInstance<SysMenuService>;

    beforeEach(() => {
      sysMenuServiceStub = sinon.createStubInstance<SysMenuService>(SysMenuService);
      sysMenuServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<SysMenuClass>(SysMenuComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          alertService: () => new AlertService(store),
          sysMenuService: () => sysMenuServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      sysMenuServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllSysMenus();
      await comp.$nextTick();

      // THEN
      expect(sysMenuServiceStub.retrieve.called).toBeTruthy();
      expect(comp.sysMenus[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      sysMenuServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeSysMenu();
      await comp.$nextTick();

      // THEN
      expect(sysMenuServiceStub.delete.called).toBeTruthy();
      expect(sysMenuServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
