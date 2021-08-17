/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import SysPostDetailComponent from '@/entities/sys-post/sys-post-details.vue';
import SysPostClass from '@/entities/sys-post/sys-post-details.component';
import SysPostService from '@/entities/sys-post/sys-post.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('SysPost Management Detail Component', () => {
    let wrapper: Wrapper<SysPostClass>;
    let comp: SysPostClass;
    let sysPostServiceStub: SinonStubbedInstance<SysPostService>;

    beforeEach(() => {
      sysPostServiceStub = sinon.createStubInstance<SysPostService>(SysPostService);

      wrapper = shallowMount<SysPostClass>(SysPostDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { sysPostService: () => sysPostServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundSysPost = { id: 123 };
        sysPostServiceStub.find.resolves(foundSysPost);

        // WHEN
        comp.retrieveSysPost(123);
        await comp.$nextTick();

        // THEN
        expect(comp.sysPost).toBe(foundSysPost);
      });
    });
  });
});
