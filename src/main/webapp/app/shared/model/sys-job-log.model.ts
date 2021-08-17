export interface ISysJobLog {
  id?: number;
  jobName?: string;
  jobGroup?: string;
  invokeTarget?: string;
  status?: string;
  exceptionInfo?: string;
  createTime?: Date;
}

export class SysJobLog implements ISysJobLog {
  constructor(
    public id?: number,
    public jobName?: string,
    public jobGroup?: string,
    public invokeTarget?: string,
    public status?: string,
    public exceptionInfo?: string,
    public createTime?: Date
  ) {}
}
