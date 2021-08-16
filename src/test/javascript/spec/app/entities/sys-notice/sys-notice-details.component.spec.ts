/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import SysNoticeDetailComponent from '@/entities/sys-notice/sys-notice-details.vue';
import SysNoticeClass from '@/entities/sys-notice/sys-notice-details.component';
import SysNoticeService from '@/entities/sys-notice/sys-notice.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('SysNotice Management Detail Component', () => {
    let wrapper: Wrapper<SysNoticeClass>;
    let comp: SysNoticeClass;
    let sysNoticeServiceStub: SinonStubbedInstance<SysNoticeService>;

    beforeEach(() => {
      sysNoticeServiceStub = sinon.createStubInstance<SysNoticeService>(SysNoticeService);

      wrapper = shallowMount<SysNoticeClass>(SysNoticeDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { sysNoticeService: () => sysNoticeServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundSysNotice = { id: 123 };
        sysNoticeServiceStub.find.resolves(foundSysNotice);

        // WHEN
        comp.retrieveSysNotice(123);
        await comp.$nextTick();

        // THEN
        expect(comp.sysNotice).toBe(foundSysNotice);
      });
    });
  });
});
