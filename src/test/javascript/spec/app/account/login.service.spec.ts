import LoginService from '@/account/login.service';
import axios from 'axios';

const mockedAxios: any = axios;
jest.mock('axios', () => ({
  post: jest.fn(),
}));

describe('Login Service test suite', () => {
  let loginService;

  beforeEach(() => {
    loginService = new LoginService();
  });

  it('should call global logout when asked to', () => {
    loginService.logout();

    expect(mockedAxios.post).toHaveBeenCalledWith('api/logout');
  });
});
