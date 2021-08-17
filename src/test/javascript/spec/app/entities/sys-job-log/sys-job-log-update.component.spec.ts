/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import SysJobLogUpdateComponent from '@/entities/sys-job-log/sys-job-log-update.vue';
import SysJobLogClass from '@/entities/sys-job-log/sys-job-log-update.component';
import SysJobLogService from '@/entities/sys-job-log/sys-job-log.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('SysJobLog Management Update Component', () => {
    let wrapper: Wrapper<SysJobLogClass>;
    let comp: SysJobLogClass;
    let sysJobLogServiceStub: SinonStubbedInstance<SysJobLogService>;

    beforeEach(() => {
      sysJobLogServiceStub = sinon.createStubInstance<SysJobLogService>(SysJobLogService);

      wrapper = shallowMount<SysJobLogClass>(SysJobLogUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          sysJobLogService: () => sysJobLogServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.sysJobLog = entity;
        sysJobLogServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysJobLogServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.sysJobLog = entity;
        sysJobLogServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysJobLogServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
