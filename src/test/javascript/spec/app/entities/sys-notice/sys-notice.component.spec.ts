/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import SysNoticeComponent from '@/entities/sys-notice/sys-notice.vue';
import SysNoticeClass from '@/entities/sys-notice/sys-notice.component';
import SysNoticeService from '@/entities/sys-notice/sys-notice.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-alert', {});
localVue.component('b-badge', {});
localVue.component('jhi-sort-indicator', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('SysNotice Management Component', () => {
    let wrapper: Wrapper<SysNoticeClass>;
    let comp: SysNoticeClass;
    let sysNoticeServiceStub: SinonStubbedInstance<SysNoticeService>;

    beforeEach(() => {
      sysNoticeServiceStub = sinon.createStubInstance<SysNoticeService>(SysNoticeService);
      sysNoticeServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<SysNoticeClass>(SysNoticeComponent, {
        store,
        i18n,
        localVue,
        stubs: { jhiItemCount: true, bPagination: true, bModal: bModalStub as any },
        provide: {
          alertService: () => new AlertService(store),
          sysNoticeService: () => sysNoticeServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      sysNoticeServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllSysNotices();
      await comp.$nextTick();

      // THEN
      expect(sysNoticeServiceStub.retrieve.called).toBeTruthy();
      expect(comp.sysNotices[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', async () => {
      // GIVEN
      sysNoticeServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();

      // THEN
      expect(sysNoticeServiceStub.retrieve.called).toBeTruthy();
      expect(comp.sysNotices[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should not load a page if the page is the same as the previous page', () => {
      // GIVEN
      sysNoticeServiceStub.retrieve.reset();
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(sysNoticeServiceStub.retrieve.called).toBeFalsy();
    });

    it('should re-initialize the page', async () => {
      // GIVEN
      sysNoticeServiceStub.retrieve.reset();
      sysNoticeServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();
      comp.clear();
      await comp.$nextTick();

      // THEN
      expect(sysNoticeServiceStub.retrieve.callCount).toEqual(3);
      expect(comp.page).toEqual(1);
      expect(comp.sysNotices[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should calculate the sort attribute for an id', () => {
      // WHEN
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['id,desc']);
    });

    it('should calculate the sort attribute for a non-id attribute', () => {
      // GIVEN
      comp.propOrder = 'name';

      // WHEN
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['name,desc', 'id']);
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      sysNoticeServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeSysNotice();
      await comp.$nextTick();

      // THEN
      expect(sysNoticeServiceStub.delete.called).toBeTruthy();
      expect(sysNoticeServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
