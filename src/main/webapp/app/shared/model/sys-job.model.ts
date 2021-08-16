export interface ISysJob {
  id?: number;
  jobName?: string;
  jobGroup?: string;
  invokeTarget?: string;
  cronExpression?: string;
  misfirePolicy?: string;
  status?: string;
  createBy?: string;
  createTime?: Date;
  updateBy?: string;
  upLocalDate?: Date;
  remark?: any;
}

export class SysJob implements ISysJob {
  constructor(
    public id?: number,
    public jobName?: string,
    public jobGroup?: string,
    public invokeTarget?: string,
    public cronExpression?: string,
    public misfirePolicy?: string,
    public status?: string,
    public createBy?: string,
    public createTime?: Date,
    public updateBy?: string,
    public upLocalDate?: Date,
    public remark?: any
  ) {}
}
