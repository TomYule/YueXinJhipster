export interface ISysOperLog {
  id?: number;
  title?: string;
  businessType?: number;
  method?: string;
  requestMethod?: string;
  operatorType?: number;
  operName?: string;
  deptName?: string;
  operUrl?: string;
  operIp?: string;
  operLocation?: string;
  operParam?: any;
  jsonResult?: any;
  status?: number;
  errorMsg?: any;
  operTime?: Date;
}

export class SysOperLog implements ISysOperLog {
  constructor(
    public id?: number,
    public title?: string,
    public businessType?: number,
    public method?: string,
    public requestMethod?: string,
    public operatorType?: number,
    public operName?: string,
    public deptName?: string,
    public operUrl?: string,
    public operIp?: string,
    public operLocation?: string,
    public operParam?: any,
    public jsonResult?: any,
    public status?: number,
    public errorMsg?: any,
    public operTime?: Date
  ) {}
}
