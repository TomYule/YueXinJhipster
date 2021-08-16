export interface ISysConfig {
  id?: number;
  configName?: string;
  configKey?: string;
  configValue?: string;
  configType?: string;
  createBy?: string;
  createTime?: Date;
  updateBy?: string;
  upLocalDate?: Date;
  remark?: any;
}

export class SysConfig implements ISysConfig {
  constructor(
    public id?: number,
    public configName?: string,
    public configKey?: string,
    public configValue?: string,
    public configType?: string,
    public createBy?: string,
    public createTime?: Date,
    public updateBy?: string,
    public upLocalDate?: Date,
    public remark?: any
  ) {}
}
