import { IGenTable } from '@/shared/model/gen-table.model';

export interface IGenTableColumn {
  id?: number;
  tableId?: string;
  columnName?: string;
  columnComment?: string;
  columnType?: string;
  javaType?: string;
  javaField?: string;
  isPk?: string;
  isIncrement?: string;
  isRequired?: string;
  isInsert?: string;
  isEdit?: string;
  isList?: string;
  isQuery?: string;
  htmlType?: string;
  dictType?: string;
  sort?: number;
  createBy?: string;
  createTime?: Date;
  updateBy?: string;
  upLocalDate?: Date;
  remark?: any;
  genTable?: IGenTable;
}

export class GenTableColumn implements IGenTableColumn {
  constructor(
    public id?: number,
    public tableId?: string,
    public columnName?: string,
    public columnComment?: string,
    public columnType?: string,
    public javaType?: string,
    public javaField?: string,
    public isPk?: string,
    public isIncrement?: string,
    public isRequired?: string,
    public isInsert?: string,
    public isEdit?: string,
    public isList?: string,
    public isQuery?: string,
    public htmlType?: string,
    public dictType?: string,
    public sort?: number,
    public createBy?: string,
    public createTime?: Date,
    public updateBy?: string,
    public upLocalDate?: Date,
    public remark?: any,
    public genTable?: IGenTable
  ) {}
}
