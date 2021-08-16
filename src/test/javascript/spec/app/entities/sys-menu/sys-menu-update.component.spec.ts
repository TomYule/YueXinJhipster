/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import SysMenuUpdateComponent from '@/entities/sys-menu/sys-menu-update.vue';
import SysMenuClass from '@/entities/sys-menu/sys-menu-update.component';
import SysMenuService from '@/entities/sys-menu/sys-menu.service';

import SysRoleService from '@/entities/sys-role/sys-role.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('SysMenu Management Update Component', () => {
    let wrapper: Wrapper<SysMenuClass>;
    let comp: SysMenuClass;
    let sysMenuServiceStub: SinonStubbedInstance<SysMenuService>;

    beforeEach(() => {
      sysMenuServiceStub = sinon.createStubInstance<SysMenuService>(SysMenuService);

      wrapper = shallowMount<SysMenuClass>(SysMenuUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          sysMenuService: () => sysMenuServiceStub,

          sysRoleService: () => new SysRoleService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.sysMenu = entity;
        sysMenuServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysMenuServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.sysMenu = entity;
        sysMenuServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysMenuServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
