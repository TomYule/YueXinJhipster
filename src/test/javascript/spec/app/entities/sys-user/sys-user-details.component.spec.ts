/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import SysUserDetailComponent from '@/entities/sys-user/sys-user-details.vue';
import SysUserClass from '@/entities/sys-user/sys-user-details.component';
import SysUserService from '@/entities/sys-user/sys-user.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('SysUser Management Detail Component', () => {
    let wrapper: Wrapper<SysUserClass>;
    let comp: SysUserClass;
    let sysUserServiceStub: SinonStubbedInstance<SysUserService>;

    beforeEach(() => {
      sysUserServiceStub = sinon.createStubInstance<SysUserService>(SysUserService);

      wrapper = shallowMount<SysUserClass>(SysUserDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { sysUserService: () => sysUserServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundSysUser = { id: 123 };
        sysUserServiceStub.find.resolves(foundSysUser);

        // WHEN
        comp.retrieveSysUser(123);
        await comp.$nextTick();

        // THEN
        expect(comp.sysUser).toBe(foundSysUser);
      });
    });
  });
});
