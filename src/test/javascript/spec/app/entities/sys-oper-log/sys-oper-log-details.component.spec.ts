/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import SysOperLogDetailComponent from '@/entities/sys-oper-log/sys-oper-log-details.vue';
import SysOperLogClass from '@/entities/sys-oper-log/sys-oper-log-details.component';
import SysOperLogService from '@/entities/sys-oper-log/sys-oper-log.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('SysOperLog Management Detail Component', () => {
    let wrapper: Wrapper<SysOperLogClass>;
    let comp: SysOperLogClass;
    let sysOperLogServiceStub: SinonStubbedInstance<SysOperLogService>;

    beforeEach(() => {
      sysOperLogServiceStub = sinon.createStubInstance<SysOperLogService>(SysOperLogService);

      wrapper = shallowMount<SysOperLogClass>(SysOperLogDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { sysOperLogService: () => sysOperLogServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundSysOperLog = { id: 123 };
        sysOperLogServiceStub.find.resolves(foundSysOperLog);

        // WHEN
        comp.retrieveSysOperLog(123);
        await comp.$nextTick();

        // THEN
        expect(comp.sysOperLog).toBe(foundSysOperLog);
      });
    });
  });
});
