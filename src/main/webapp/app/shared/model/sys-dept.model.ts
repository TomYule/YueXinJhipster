import { ISysUser } from '@/shared/model/sys-user.model';

export interface ISysDept {
  id?: number;
  deptName?: string;
  parentId?: string;
  ancestors?: string;
  orderNum?: number;
  leader?: string;
  phone?: string;
  email?: string;
  status?: string;
  delFlag?: string;
  createBy?: string;
  createTime?: Date;
  updateBy?: string;
  upLocalDate?: Date;
  deptIds?: ISysUser[];
}

export class SysDept implements ISysDept {
  constructor(
    public id?: number,
    public deptName?: string,
    public parentId?: string,
    public ancestors?: string,
    public orderNum?: number,
    public leader?: string,
    public phone?: string,
    public email?: string,
    public status?: string,
    public delFlag?: string,
    public createBy?: string,
    public createTime?: Date,
    public updateBy?: string,
    public upLocalDate?: Date,
    public deptIds?: ISysUser[]
  ) {}
}
