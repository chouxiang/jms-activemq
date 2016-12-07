package com.xzhang.mapper;

import com.xzhang.model.InstmtQuartz;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public interface IQuartzMapper {

    /**
     * 根据id找到定时任务类
     * @param id
     * @return
     */
    public InstmtQuartz findQuartzById(String id);

}
