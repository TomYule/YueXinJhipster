/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';

import * as config from '@/shared/config/config';
import { DATE_FORMAT } from '@/shared/date/filters';
import SysLoginInforService from '@/entities/sys-login-infor/sys-login-infor.service';
import { SysLoginInfor } from '@/shared/model/sys-login-infor.model';

const mockedAxios: any = axios;
const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

jest.mock('axios', () => ({
  get: jest.fn(),
  post: jest.fn(),
  put: jest.fn(),
  delete: jest.fn(),
}));

describe('Service Tests', () => {
  describe('SysLoginInfor Service', () => {
    let service: SysLoginInforService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new SysLoginInforService();
      currentDate = new Date();

      elemDefault = new SysLoginInfor(0, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', currentDate);
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            loginTime: format(currentDate, DATE_FORMAT),
          },
          elemDefault
        );
        mockedAxios.get.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        mockedAxios.get.mockReturnValue(Promise.reject(error));
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should create a SysLoginInfor', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            loginTime: format(currentDate, DATE_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            loginTime: currentDate,
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a SysLoginInfor', async () => {
        mockedAxios.post.mockReturnValue(Promise.reject(error));

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a SysLoginInfor', async () => {
        const returnedFromService = Object.assign(
          {
            userName: 'BBBBBB',
            ipAddr: 'BBBBBB',
            loginLocation: 'BBBBBB',
            browser: 'BBBBBB',
            os: 'BBBBBB',
            status: 'BBBBBB',
            msg: 'BBBBBB',
            loginTime: format(currentDate, DATE_FORMAT),
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            loginTime: currentDate,
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a SysLoginInfor', async () => {
        mockedAxios.put.mockReturnValue(Promise.reject(error));

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of SysLoginInfor', async () => {
        const returnedFromService = Object.assign(
          {
            userName: 'BBBBBB',
            ipAddr: 'BBBBBB',
            loginLocation: 'BBBBBB',
            browser: 'BBBBBB',
            os: 'BBBBBB',
            status: 'BBBBBB',
            msg: 'BBBBBB',
            loginTime: format(currentDate, DATE_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            loginTime: currentDate,
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of SysLoginInfor', async () => {
        mockedAxios.get.mockReturnValue(Promise.reject(error));

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a SysLoginInfor', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a SysLoginInfor', async () => {
        mockedAxios.delete.mockReturnValue(Promise.reject(error));

        return service
          .delete(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
