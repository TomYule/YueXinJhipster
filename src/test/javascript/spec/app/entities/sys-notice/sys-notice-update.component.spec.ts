/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import SysNoticeUpdateComponent from '@/entities/sys-notice/sys-notice-update.vue';
import SysNoticeClass from '@/entities/sys-notice/sys-notice-update.component';
import SysNoticeService from '@/entities/sys-notice/sys-notice.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('SysNotice Management Update Component', () => {
    let wrapper: Wrapper<SysNoticeClass>;
    let comp: SysNoticeClass;
    let sysNoticeServiceStub: SinonStubbedInstance<SysNoticeService>;

    beforeEach(() => {
      sysNoticeServiceStub = sinon.createStubInstance<SysNoticeService>(SysNoticeService);

      wrapper = shallowMount<SysNoticeClass>(SysNoticeUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          sysNoticeService: () => sysNoticeServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.sysNotice = entity;
        sysNoticeServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysNoticeServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.sysNotice = entity;
        sysNoticeServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysNoticeServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
