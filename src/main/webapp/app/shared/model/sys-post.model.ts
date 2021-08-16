import { ISysUser } from '@/shared/model/sys-user.model';

export interface ISysPost {
  id?: number;
  postCode?: string;
  postName?: string;
  postSort?: number;
  status?: string;
  createBy?: string;
  createTime?: Date;
  updateBy?: string;
  upLocalDate?: Date;
  remark?: any;
  sysUsers?: ISysUser[];
}

export class SysPost implements ISysPost {
  constructor(
    public id?: number,
    public postCode?: string,
    public postName?: string,
    public postSort?: number,
    public status?: string,
    public createBy?: string,
    public createTime?: Date,
    public updateBy?: string,
    public upLocalDate?: Date,
    public remark?: any,
    public sysUsers?: ISysUser[]
  ) {}
}
