/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import SysJobDetailComponent from '@/entities/sys-job/sys-job-details.vue';
import SysJobClass from '@/entities/sys-job/sys-job-details.component';
import SysJobService from '@/entities/sys-job/sys-job.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('SysJob Management Detail Component', () => {
    let wrapper: Wrapper<SysJobClass>;
    let comp: SysJobClass;
    let sysJobServiceStub: SinonStubbedInstance<SysJobService>;

    beforeEach(() => {
      sysJobServiceStub = sinon.createStubInstance<SysJobService>(SysJobService);

      wrapper = shallowMount<SysJobClass>(SysJobDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { sysJobService: () => sysJobServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundSysJob = { id: 123 };
        sysJobServiceStub.find.resolves(foundSysJob);

        // WHEN
        comp.retrieveSysJob(123);
        await comp.$nextTick();

        // THEN
        expect(comp.sysJob).toBe(foundSysJob);
      });
    });
  });
});
