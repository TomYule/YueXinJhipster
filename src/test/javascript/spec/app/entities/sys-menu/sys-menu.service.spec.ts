/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';

import * as config from '@/shared/config/config';
import { DATE_FORMAT } from '@/shared/date/filters';
import SysMenuService from '@/entities/sys-menu/sys-menu.service';
import { SysMenu } from '@/shared/model/sys-menu.model';

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
  describe('SysMenu Service', () => {
    let service: SysMenuService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new SysMenuService();
      currentDate = new Date();

      elemDefault = new SysMenu(
        0,
        'AAAAAAA',
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        currentDate,
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            createTime: format(currentDate, DATE_FORMAT),
            upLocalDate: format(currentDate, DATE_FORMAT),
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

      it('should create a SysMenu', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            createTime: format(currentDate, DATE_FORMAT),
            upLocalDate: format(currentDate, DATE_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            createTime: currentDate,
            upLocalDate: currentDate,
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a SysMenu', async () => {
        mockedAxios.post.mockReturnValue(Promise.reject(error));

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a SysMenu', async () => {
        const returnedFromService = Object.assign(
          {
            menuName: 'BBBBBB',
            parentId: 1,
            orderNum: 1,
            path: 'BBBBBB',
            components: 'BBBBBB',
            isFrame: 'BBBBBB',
            isCache: 'BBBBBB',
            menuType: 'BBBBBB',
            visible: 'BBBBBB',
            status: 'BBBBBB',
            perms: 'BBBBBB',
            icon: 'BBBBBB',
            createBy: 'BBBBBB',
            createTime: format(currentDate, DATE_FORMAT),
            updateBy: 'BBBBBB',
            upLocalDate: format(currentDate, DATE_FORMAT),
            remark: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            createTime: currentDate,
            upLocalDate: currentDate,
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a SysMenu', async () => {
        mockedAxios.put.mockReturnValue(Promise.reject(error));

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of SysMenu', async () => {
        const returnedFromService = Object.assign(
          {
            menuName: 'BBBBBB',
            parentId: 1,
            orderNum: 1,
            path: 'BBBBBB',
            components: 'BBBBBB',
            isFrame: 'BBBBBB',
            isCache: 'BBBBBB',
            menuType: 'BBBBBB',
            visible: 'BBBBBB',
            status: 'BBBBBB',
            perms: 'BBBBBB',
            icon: 'BBBBBB',
            createBy: 'BBBBBB',
            createTime: format(currentDate, DATE_FORMAT),
            updateBy: 'BBBBBB',
            upLocalDate: format(currentDate, DATE_FORMAT),
            remark: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            createTime: currentDate,
            upLocalDate: currentDate,
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of SysMenu', async () => {
        mockedAxios.get.mockReturnValue(Promise.reject(error));

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a SysMenu', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a SysMenu', async () => {
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
