/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import SysLoginInforUpdateComponent from '@/entities/sys-login-infor/sys-login-infor-update.vue';
import SysLoginInforClass from '@/entities/sys-login-infor/sys-login-infor-update.component';
import SysLoginInforService from '@/entities/sys-login-infor/sys-login-infor.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('SysLoginInfor Management Update Component', () => {
    let wrapper: Wrapper<SysLoginInforClass>;
    let comp: SysLoginInforClass;
    let sysLoginInforServiceStub: SinonStubbedInstance<SysLoginInforService>;

    beforeEach(() => {
      sysLoginInforServiceStub = sinon.createStubInstance<SysLoginInforService>(SysLoginInforService);

      wrapper = shallowMount<SysLoginInforClass>(SysLoginInforUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          sysLoginInforService: () => sysLoginInforServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.sysLoginInfor = entity;
        sysLoginInforServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysLoginInforServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.sysLoginInfor = entity;
        sysLoginInforServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysLoginInforServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
