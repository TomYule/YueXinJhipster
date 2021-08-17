import { ISysDictType } from '@/shared/model/sys-dict-type.model';

export interface ISysDictData {
  id?: number;
  dictSort?: string;
  dictLabel?: string;
  dictValue?: string;
  dictType?: string;
  cssClass?: string;
  listClass?: string;
  isDefault?: string;
  status?: string;
  createBy?: string;
  createTime?: Date;
  updateBy?: string;
  upLocalDate?: Date;
  remark?: any;
  sysDictType?: ISysDictType;
}

export class SysDictData implements ISysDictData {
  constructor(
    public id?: number,
    public dictSort?: string,
    public dictLabel?: string,
    public dictValue?: string,
    public dictType?: string,
    public cssClass?: string,
    public listClass?: string,
    public isDefault?: string,
    public status?: string,
    public createBy?: string,
    public createTime?: Date,
    public updateBy?: string,
    public upLocalDate?: Date,
    public remark?: any,
    public sysDictType?: ISysDictType
  ) {}
}
