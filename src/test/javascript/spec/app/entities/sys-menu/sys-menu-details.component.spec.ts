/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import SysMenuDetailComponent from '@/entities/sys-menu/sys-menu-details.vue';
import SysMenuClass from '@/entities/sys-menu/sys-menu-details.component';
import SysMenuService from '@/entities/sys-menu/sys-menu.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('SysMenu Management Detail Component', () => {
    let wrapper: Wrapper<SysMenuClass>;
    let comp: SysMenuClass;
    let sysMenuServiceStub: SinonStubbedInstance<SysMenuService>;

    beforeEach(() => {
      sysMenuServiceStub = sinon.createStubInstance<SysMenuService>(SysMenuService);

      wrapper = shallowMount<SysMenuClass>(SysMenuDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { sysMenuService: () => sysMenuServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundSysMenu = { id: 123 };
        sysMenuServiceStub.find.resolves(foundSysMenu);

        // WHEN
        comp.retrieveSysMenu(123);
        await comp.$nextTick();

        // THEN
        expect(comp.sysMenu).toBe(foundSysMenu);
      });
    });
  });
});
