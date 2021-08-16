/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import SysConfigDetailComponent from '@/entities/sys-config/sys-config-details.vue';
import SysConfigClass from '@/entities/sys-config/sys-config-details.component';
import SysConfigService from '@/entities/sys-config/sys-config.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('SysConfig Management Detail Component', () => {
    let wrapper: Wrapper<SysConfigClass>;
    let comp: SysConfigClass;
    let sysConfigServiceStub: SinonStubbedInstance<SysConfigService>;

    beforeEach(() => {
      sysConfigServiceStub = sinon.createStubInstance<SysConfigService>(SysConfigService);

      wrapper = shallowMount<SysConfigClass>(SysConfigDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { sysConfigService: () => sysConfigServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundSysConfig = { id: 123 };
        sysConfigServiceStub.find.resolves(foundSysConfig);

        // WHEN
        comp.retrieveSysConfig(123);
        await comp.$nextTick();

        // THEN
        expect(comp.sysConfig).toBe(foundSysConfig);
      });
    });
  });
});
