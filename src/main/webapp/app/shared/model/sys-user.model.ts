import { ISysPost } from '@/shared/model/sys-post.model';
import { ISysDept } from '@/shared/model/sys-dept.model';
import { ISysRole } from '@/shared/model/sys-role.model';

export const enum UserStatus {
  ENABLE = 'ENABLE',
  DISABLE = 'DISABLE',
  DELETED = 'DELETED',
}

export interface ISysUser {
  id?: number;
  deptId?: string;
  userName?: string;
  nickName?: string;
  userType?: string;
  email?: string;
  phoneNumber?: string;
  gender?: string;
  avatar?: string;
  password?: string;
  status?: UserStatus;
  delFlag?: string;
  loginIp?: string;
  loginDate?: Date;
  createBy?: string;
  createTime?: Date;
  updateBy?: string;
  upLocalDate?: Date;
  remark?: any;
  sysPosts?: ISysPost[];
  sysDept?: ISysDept;
  sysRoles?: ISysRole[];
}

export class SysUser implements ISysUser {
  constructor(
    public id?: number,
    public deptId?: string,
    public userName?: string,
    public nickName?: string,
    public userType?: string,
    public email?: string,
    public phoneNumber?: string,
    public gender?: string,
    public avatar?: string,
    public password?: string,
    public status?: UserStatus,
    public delFlag?: string,
    public loginIp?: string,
    public loginDate?: Date,
    public createBy?: string,
    public createTime?: Date,
    public updateBy?: string,
    public upLocalDate?: Date,
    public remark?: any,
    public sysPosts?: ISysPost[],
    public sysDept?: ISysDept,
    public sysRoles?: ISysRole[]
  ) {}
}
