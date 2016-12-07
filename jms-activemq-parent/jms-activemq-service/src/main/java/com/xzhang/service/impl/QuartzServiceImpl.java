package com.xzhang.service.impl;

import com.xzhang.mapper.IQuartzMapper;
import com.xzhang.model.InstmtQuartz;
import com.xzhang.service.IQuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
@Service("quartzService")
public class QuartzServiceImpl implements IQuartzService {
    @Autowired
    private IQuartzMapper quartzMapper;



    @Override
    public InstmtQuartz findQuartzById(String id) {
        return quartzMapper.findQuartzById(id);
    }


}
