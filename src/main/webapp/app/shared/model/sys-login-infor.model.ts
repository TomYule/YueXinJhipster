export interface ISysLoginInfor {
  id?: number;
  userName?: string;
  ipAddr?: string;
  loginLocation?: string;
  browser?: string;
  os?: string;
  status?: string;
  msg?: string;
  loginTime?: Date;
}

export class SysLoginInfor implements ISysLoginInfor {
  constructor(
    public id?: number,
    public userName?: string,
    public ipAddr?: string,
    public loginLocation?: string,
    public browser?: string,
    public os?: string,
    public status?: string,
    public msg?: string,
    public loginTime?: Date
  ) {}
}
