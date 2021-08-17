/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import SysUserUpdateComponent from '@/entities/sys-user/sys-user-update.vue';
import SysUserClass from '@/entities/sys-user/sys-user-update.component';
import SysUserService from '@/entities/sys-user/sys-user.service';

import SysPostService from '@/entities/sys-post/sys-post.service';

import SysDeptService from '@/entities/sys-dept/sys-dept.service';

import SysRoleService from '@/entities/sys-role/sys-role.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('SysUser Management Update Component', () => {
    let wrapper: Wrapper<SysUserClass>;
    let comp: SysUserClass;
    let sysUserServiceStub: SinonStubbedInstance<SysUserService>;

    beforeEach(() => {
      sysUserServiceStub = sinon.createStubInstance<SysUserService>(SysUserService);

      wrapper = shallowMount<SysUserClass>(SysUserUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          sysUserService: () => sysUserServiceStub,

          sysPostService: () => new SysPostService(),

          sysDeptService: () => new SysDeptService(),

          sysRoleService: () => new SysRoleService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.sysUser = entity;
        sysUserServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysUserServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.sysUser = entity;
        sysUserServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysUserServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
