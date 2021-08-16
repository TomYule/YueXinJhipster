/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import SysOperLogUpdateComponent from '@/entities/sys-oper-log/sys-oper-log-update.vue';
import SysOperLogClass from '@/entities/sys-oper-log/sys-oper-log-update.component';
import SysOperLogService from '@/entities/sys-oper-log/sys-oper-log.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('SysOperLog Management Update Component', () => {
    let wrapper: Wrapper<SysOperLogClass>;
    let comp: SysOperLogClass;
    let sysOperLogServiceStub: SinonStubbedInstance<SysOperLogService>;

    beforeEach(() => {
      sysOperLogServiceStub = sinon.createStubInstance<SysOperLogService>(SysOperLogService);

      wrapper = shallowMount<SysOperLogClass>(SysOperLogUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          sysOperLogService: () => sysOperLogServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.sysOperLog = entity;
        sysOperLogServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysOperLogServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.sysOperLog = entity;
        sysOperLogServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysOperLogServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
