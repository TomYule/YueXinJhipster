/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import SysRoleUpdateComponent from '@/entities/sys-role/sys-role-update.vue';
import SysRoleClass from '@/entities/sys-role/sys-role-update.component';
import SysRoleService from '@/entities/sys-role/sys-role.service';

import SysMenuService from '@/entities/sys-menu/sys-menu.service';

import SysUserService from '@/entities/sys-user/sys-user.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('SysRole Management Update Component', () => {
    let wrapper: Wrapper<SysRoleClass>;
    let comp: SysRoleClass;
    let sysRoleServiceStub: SinonStubbedInstance<SysRoleService>;

    beforeEach(() => {
      sysRoleServiceStub = sinon.createStubInstance<SysRoleService>(SysRoleService);

      wrapper = shallowMount<SysRoleClass>(SysRoleUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          sysRoleService: () => sysRoleServiceStub,

          sysMenuService: () => new SysMenuService(),

          sysUserService: () => new SysUserService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.sysRole = entity;
        sysRoleServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysRoleServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.sysRole = entity;
        sysRoleServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysRoleServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
