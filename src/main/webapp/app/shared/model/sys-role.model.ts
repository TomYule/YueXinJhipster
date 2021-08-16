import { ISysMenu } from '@/shared/model/sys-menu.model';
import { ISysUser } from '@/shared/model/sys-user.model';

export interface ISysRole {
  id?: number;
  roleName?: string;
  roleKey?: string;
  roleSort?: number;
  dataScope?: string;
  menuCheckStrictly?: number;
  deptCheckStrictly?: number;
  status?: string;
  delFlag?: string;
  createBy?: string;
  createTime?: Date;
  updateBy?: string;
  upLocalDate?: Date;
  remark?: any;
  sysMenus?: ISysMenu[];
  sysUsers?: ISysUser[];
}

export class SysRole implements ISysRole {
  constructor(
    public id?: number,
    public roleName?: string,
    public roleKey?: string,
    public roleSort?: number,
    public dataScope?: string,
    public menuCheckStrictly?: number,
    public deptCheckStrictly?: number,
    public status?: string,
    public delFlag?: string,
    public createBy?: string,
    public createTime?: Date,
    public updateBy?: string,
    public upLocalDate?: Date,
    public remark?: any,
    public sysMenus?: ISysMenu[],
    public sysUsers?: ISysUser[]
  ) {}
}
