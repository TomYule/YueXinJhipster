/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import SysJobLogDetailComponent from '@/entities/sys-job-log/sys-job-log-details.vue';
import SysJobLogClass from '@/entities/sys-job-log/sys-job-log-details.component';
import SysJobLogService from '@/entities/sys-job-log/sys-job-log.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('SysJobLog Management Detail Component', () => {
    let wrapper: Wrapper<SysJobLogClass>;
    let comp: SysJobLogClass;
    let sysJobLogServiceStub: SinonStubbedInstance<SysJobLogService>;

    beforeEach(() => {
      sysJobLogServiceStub = sinon.createStubInstance<SysJobLogService>(SysJobLogService);

      wrapper = shallowMount<SysJobLogClass>(SysJobLogDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { sysJobLogService: () => sysJobLogServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundSysJobLog = { id: 123 };
        sysJobLogServiceStub.find.resolves(foundSysJobLog);

        // WHEN
        comp.retrieveSysJobLog(123);
        await comp.$nextTick();

        // THEN
        expect(comp.sysJobLog).toBe(foundSysJobLog);
      });
    });
  });
});
