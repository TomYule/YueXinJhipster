/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import SysPostUpdateComponent from '@/entities/sys-post/sys-post-update.vue';
import SysPostClass from '@/entities/sys-post/sys-post-update.component';
import SysPostService from '@/entities/sys-post/sys-post.service';

import SysUserService from '@/entities/sys-user/sys-user.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});

describe('Component Tests', () => {
  describe('SysPost Management Update Component', () => {
    let wrapper: Wrapper<SysPostClass>;
    let comp: SysPostClass;
    let sysPostServiceStub: SinonStubbedInstance<SysPostService>;

    beforeEach(() => {
      sysPostServiceStub = sinon.createStubInstance<SysPostService>(SysPostService);

      wrapper = shallowMount<SysPostClass>(SysPostUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          alertService: () => new AlertService(store),
          sysPostService: () => sysPostServiceStub,

          sysUserService: () => new SysUserService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.sysPost = entity;
        sysPostServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysPostServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.sysPost = entity;
        sysPostServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(sysPostServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });
  });
});
