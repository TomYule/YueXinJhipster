import { ISysDictData } from '@/shared/model/sys-dict-data.model';

export interface ISysDictType {
  id?: number;
  dictName?: string;
  dictType?: string;
  status?: string;
  createBy?: string;
  createTime?: Date;
  updateBy?: string;
  upLocalDate?: Date;
  remark?: any;
  dictTypes?: ISysDictData[];
}

export class SysDictType implements ISysDictType {
  constructor(
    public id?: number,
    public dictName?: string,
    public dictType?: string,
    public status?: string,
    public createBy?: string,
    public createTime?: Date,
    public updateBy?: string,
    public upLocalDate?: Date,
    public remark?: any,
    public dictTypes?: ISysDictData[]
  ) {}
}
