/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import SysDictDataComponent from '@/entities/sys-dict-data/sys-dict-data.vue';
import SysDictDataClass from '@/entities/sys-dict-data/sys-dict-data.component';
import SysDictDataService from '@/entities/sys-dict-data/sys-dict-data.service';

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
  describe('SysDictData Management Component', () => {
    let wrapper: Wrapper<SysDictDataClass>;
    let comp: SysDictDataClass;
    let sysDictDataServiceStub: SinonStubbedInstance<SysDictDataService>;

    beforeEach(() => {
      sysDictDataServiceStub = sinon.createStubInstance<SysDictDataService>(SysDictDataService);
      sysDictDataServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<SysDictDataClass>(SysDictDataComponent, {
        store,
        i18n,
        localVue,
        stubs: { jhiItemCount: true, bPagination: true, bModal: bModalStub as any },
        provide: {
          alertService: () => new AlertService(store),
          sysDictDataService: () => sysDictDataServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      sysDictDataServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllSysDictDatas();
      await comp.$nextTick();

      // THEN
      expect(sysDictDataServiceStub.retrieve.called).toBeTruthy();
      expect(comp.sysDictData[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', async () => {
      // GIVEN
      sysDictDataServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();

      // THEN
      expect(sysDictDataServiceStub.retrieve.called).toBeTruthy();
      expect(comp.sysDictData[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should not load a page if the page is the same as the previous page', () => {
      // GIVEN
      sysDictDataServiceStub.retrieve.reset();
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(sysDictDataServiceStub.retrieve.called).toBeFalsy();
    });

    it('should re-initialize the page', async () => {
      // GIVEN
      sysDictDataServiceStub.retrieve.reset();
      sysDictDataServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();
      comp.clear();
      await comp.$nextTick();

      // THEN
      expect(sysDictDataServiceStub.retrieve.callCount).toEqual(3);
      expect(comp.page).toEqual(1);
      expect(comp.sysDictData[0]).toEqual(jasmine.objectContaining({ id: 123 }));
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
      sysDictDataServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeSysDictData();
      await comp.$nextTick();

      // THEN
      expect(sysDictDataServiceStub.delete.called).toBeTruthy();
      expect(sysDictDataServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
