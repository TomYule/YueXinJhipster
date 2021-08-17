import { ISysRole } from '@/shared/model/sys-role.model';

export interface ISysMenu {
  id?: number;
  menuName?: string;
  parentId?: number;
  orderNum?: number;
  path?: string;
  components?: string;
  isFrame?: string;
  isCache?: string;
  menuType?: string;
  visible?: string;
  status?: string;
  perms?: string;
  icon?: string;
  createBy?: string;
  createTime?: Date;
  updateBy?: string;
  upLocalDate?: Date;
  remark?: any;
  sysRoles?: ISysRole[];
}

export class SysMenu implements ISysMenu {
  constructor(
    public id?: number,
    public menuName?: string,
    public parentId?: number,
    public orderNum?: number,
    public path?: string,
    public components?: string,
    public isFrame?: string,
    public isCache?: string,
    public menuType?: string,
    public visible?: string,
    public status?: string,
    public perms?: string,
    public icon?: string,
    public createBy?: string,
    public createTime?: Date,
    public updateBy?: string,
    public upLocalDate?: Date,
    public remark?: any,
    public sysRoles?: ISysRole[]
  ) {}
}
