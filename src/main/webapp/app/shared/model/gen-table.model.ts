import { IGenTableColumn } from '@/shared/model/gen-table-column.model';

export interface IGenTable {
  id?: number;
  tableName?: string;
  tableComment?: string;
  subTableName?: string;
  subTableFkName?: string;
  className?: string;
  tplCategory?: string;
  packAgeName?: string;
  moduleName?: string;
  businessName?: string;
  functionName?: string;
  functionAuthor?: string;
  genType?: string;
  genPath?: string;
  options?: string;
  createBy?: string;
  createTime?: Date;
  updateBy?: string;
  upLocalDate?: Date;
  remark?: any;
  tableIds?: IGenTableColumn[];
}

export class GenTable implements IGenTable {
  constructor(
    public id?: number,
    public tableName?: string,
    public tableComment?: string,
    public subTableName?: string,
    public subTableFkName?: string,
    public className?: string,
    public tplCategory?: string,
    public packAgeName?: string,
    public moduleName?: string,
    public businessName?: string,
    public functionName?: string,
    public functionAuthor?: string,
    public genType?: string,
    public genPath?: string,
    public options?: string,
    public createBy?: string,
    public createTime?: Date,
    public updateBy?: string,
    public upLocalDate?: Date,
    public remark?: any,
    public tableIds?: IGenTableColumn[]
  ) {}
}
