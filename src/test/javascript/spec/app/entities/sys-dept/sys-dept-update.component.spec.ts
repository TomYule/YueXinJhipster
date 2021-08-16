/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import SysDeptUpdateComponent from '@/entities/sys-dept/sys-dept-update.vue';
import SysDeptClass from '@/entities/sys-dept/sys-dept-update.component';
import SysDeptService from '@/entities/sys-dept/sys-dept.service';

import SysUserService from '@/entities/sys-user/sys-user.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('SysDept Management Update Component', () => {
    let wrapper: Wrapper<SysDeptClass>;
    let comp: SysDeptClass;
    let sysDeptServiceStub: SinonStubbedInstance<SysDeptService>;

    beforeEach(() => {
      sysDeptServiceStub = sinon.createStubInstance<SysDeptService>(SysDeptService);

      wrapper = shallowMount<SysDeptClass>(SysDeptUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          sysDeptService: () => sysDeptServiceStub,

          sysUserService: () => new SysUserService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.sysDept = entity;
        sysDeptServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysDeptServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.sysDept = entity;
        sysDeptServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysDeptServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
