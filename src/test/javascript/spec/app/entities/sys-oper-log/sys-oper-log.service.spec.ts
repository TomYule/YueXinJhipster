/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';

import * as config from '@/shared/config/config';
import { DATE_FORMAT } from '@/shared/date/filters';
import SysOperLogService from '@/entities/sys-oper-log/sys-oper-log.service';
import { SysOperLog } from '@/shared/model/sys-oper-log.model';

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
  describe('SysOperLog Service', () => {
    let service: SysOperLogService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new SysOperLogService();
      currentDate = new Date();

      elemDefault = new SysOperLog(
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        currentDate
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            operTime: format(currentDate, DATE_FORMAT),
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

      it('should create a SysOperLog', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            operTime: format(currentDate, DATE_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            operTime: currentDate,
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a SysOperLog', async () => {
        mockedAxios.post.mockReturnValue(Promise.reject(error));

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a SysOperLog', async () => {
        const returnedFromService = Object.assign(
          {
            title: 'BBBBBB',
            businessType: 1,
            method: 'BBBBBB',
            requestMethod: 'BBBBBB',
            operatorType: 1,
            operName: 'BBBBBB',
            deptName: 'BBBBBB',
            operUrl: 'BBBBBB',
            operIp: 'BBBBBB',
            operLocation: 'BBBBBB',
            operParam: 'BBBBBB',
            jsonResult: 'BBBBBB',
            status: 1,
            errorMsg: 'BBBBBB',
            operTime: format(currentDate, DATE_FORMAT),
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            operTime: currentDate,
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a SysOperLog', async () => {
        mockedAxios.put.mockReturnValue(Promise.reject(error));

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of SysOperLog', async () => {
        const returnedFromService = Object.assign(
          {
            title: 'BBBBBB',
            businessType: 1,
            method: 'BBBBBB',
            requestMethod: 'BBBBBB',
            operatorType: 1,
            operName: 'BBBBBB',
            deptName: 'BBBBBB',
            operUrl: 'BBBBBB',
            operIp: 'BBBBBB',
            operLocation: 'BBBBBB',
            operParam: 'BBBBBB',
            jsonResult: 'BBBBBB',
            status: 1,
            errorMsg: 'BBBBBB',
            operTime: format(currentDate, DATE_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            operTime: currentDate,
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of SysOperLog', async () => {
        mockedAxios.get.mockReturnValue(Promise.reject(error));

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a SysOperLog', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a SysOperLog', async () => {
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
