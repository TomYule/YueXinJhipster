/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import SysLoginInforDetailComponent from '@/entities/sys-login-infor/sys-login-infor-details.vue';
import SysLoginInforClass from '@/entities/sys-login-infor/sys-login-infor-details.component';
import SysLoginInforService from '@/entities/sys-login-infor/sys-login-infor.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('SysLoginInfor Management Detail Component', () => {
    let wrapper: Wrapper<SysLoginInforClass>;
    let comp: SysLoginInforClass;
    let sysLoginInforServiceStub: SinonStubbedInstance<SysLoginInforService>;

    beforeEach(() => {
      sysLoginInforServiceStub = sinon.createStubInstance<SysLoginInforService>(SysLoginInforService);

      wrapper = shallowMount<SysLoginInforClass>(SysLoginInforDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { sysLoginInforService: () => sysLoginInforServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundSysLoginInfor = { id: 123 };
        sysLoginInforServiceStub.find.resolves(foundSysLoginInfor);

        // WHEN
        comp.retrieveSysLoginInfor(123);
        await comp.$nextTick();

        // THEN
        expect(comp.sysLoginInfor).toBe(foundSysLoginInfor);
      });
    });
  });
});
