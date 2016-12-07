package com.xzhang.service;

import com.xzhang.model.InstmtQuartz;

/**
 * Created by Administrator on 2016/11/29 0029.
 * desc : 定时任务service层
 */
public interface IQuartzService {

    /**
     * 根据id找到定时任务类
     * @param id
     * @return
     */
    public InstmtQuartz findQuartzById(String id);

}
