export interface ISysNotice {
  id?: number;
  noticeTitle?: string;
  noticeType?: string;
  noticeContent?: string;
  status?: number;
  createBy?: string;
  createTime?: Date;
  updateBy?: string;
  upLocalDate?: Date;
  remark?: any;
}

export class SysNotice implements ISysNotice {
  constructor(
    public id?: number,
    public noticeTitle?: string,
    public noticeType?: string,
    public noticeContent?: string,
    public status?: number,
    public createBy?: string,
    public createTime?: Date,
    public updateBy?: string,
    public upLocalDate?: Date,
    public remark?: any
  ) {}
}
