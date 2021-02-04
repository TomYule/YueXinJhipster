import { createLocalVue, shallowMount, Wrapper } from '@vue/test-utils';
import axios from 'axios';
import * as config from '@/shared/config/config';
import SessionsClass from '@/account/sessions/sessions.component';
import Sessions from '@/account/sessions/sessions.vue';
import router from '@/router';
import TranslationService from '@/locale/translation.service';

const localVue = createLocalVue();
const mockedAxios: any = axios;

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);

jest.mock('axios', () => ({
  get: jest.fn(),
  delete: jest.fn(),
}));

const mockedAxiosResetGet = (): void => {
  mockedAxios.get.mockReset();
  mockedAxios.get.mockReturnValue(
    Promise.resolve({
      data: [],
    })
  );
};

describe('Sessions Component', () => {
  let wrapper: Wrapper<SessionsClass>;
  let sessions: SessionsClass;

  beforeEach(() => {
    mockedAxiosResetGet();
    mockedAxios.delete.mockReset();

    store.commit('authenticated', {
      login: 'username',
    });

    wrapper = shallowMount<SessionsClass>(Sessions, {
      store,
      i18n,
      localVue,
    });
    sessions = wrapper.vm;
  });

  it('should call remote service on init', () => {
    expect(mockedAxios.get).toHaveBeenCalledTimes(1);
  });

  it('should have good username', () => {
    expect(sessions.username).toEqual('username');
  });

  it('should invalidate a session', async () => {
    // Given
    mockedAxiosResetGet();
    mockedAxios.delete.mockReturnValue(Promise.resolve());

    // When
    sessions.invalidate('session');
    await sessions.$nextTick();

    // Then
    expect(sessions.error).toBeNull();
    expect(sessions.success).toEqual('OK');
    expect(mockedAxios.get).toHaveBeenCalledTimes(1);
  });

  it('should fail to invalidate session', async () => {
    // Given
    mockedAxiosResetGet();
    mockedAxios.delete.mockReturnValue(Promise.reject());

    // When
    sessions.invalidate('session');
    await sessions.$nextTick();

    // Then
    expect(sessions.success).toBeNull();
    expect(sessions.error).toEqual('ERROR');
    expect(mockedAxios.get).toHaveBeenCalledTimes(0);
  });
});
