/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import SysRoleDetailComponent from '@/entities/sys-role/sys-role-details.vue';
import SysRoleClass from '@/entities/sys-role/sys-role-details.component';
import SysRoleService from '@/entities/sys-role/sys-role.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('SysRole Management Detail Component', () => {
    let wrapper: Wrapper<SysRoleClass>;
    let comp: SysRoleClass;
    let sysRoleServiceStub: SinonStubbedInstance<SysRoleService>;

    beforeEach(() => {
      sysRoleServiceStub = sinon.createStubInstance<SysRoleService>(SysRoleService);

      wrapper = shallowMount<SysRoleClass>(SysRoleDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { sysRoleService: () => sysRoleServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundSysRole = { id: 123 };
        sysRoleServiceStub.find.resolves(foundSysRole);

        // WHEN
        comp.retrieveSysRole(123);
        await comp.$nextTick();

        // THEN
        expect(comp.sysRole).toBe(foundSysRole);
      });
    });
  });
});
