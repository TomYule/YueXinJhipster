/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import SysJobUpdateComponent from '@/entities/sys-job/sys-job-update.vue';
import SysJobClass from '@/entities/sys-job/sys-job-update.component';
import SysJobService from '@/entities/sys-job/sys-job.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('SysJob Management Update Component', () => {
    let wrapper: Wrapper<SysJobClass>;
    let comp: SysJobClass;
    let sysJobServiceStub: SinonStubbedInstance<SysJobService>;

    beforeEach(() => {
      sysJobServiceStub = sinon.createStubInstance<SysJobService>(SysJobService);

      wrapper = shallowMount<SysJobClass>(SysJobUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          sysJobService: () => sysJobServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.sysJob = entity;
        sysJobServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysJobServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.sysJob = entity;
        sysJobServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysJobServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
