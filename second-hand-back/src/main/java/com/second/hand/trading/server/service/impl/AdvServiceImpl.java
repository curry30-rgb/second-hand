package com.second.hand.trading.server.service.impl;

import com.second.hand.trading.server.dao.AdvDao;
import com.second.hand.trading.server.model.AdvModel;
import com.second.hand.trading.server.model.IdleItemModel;
import com.second.hand.trading.server.service.AdvService;
import com.second.hand.trading.server.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: AdvServiceImpl
 * @Description:
 * @Author: localUser
 * @Version: 1.0
 * @create: 2024/3/23 17:42
 */
@Service
public class AdvServiceImpl implements AdvService {

    @Autowired
    private AdvDao advDao;


    @Override
    public PageVo<AdvModel> adminGetAdv(int status, int page, int nums) {
        List<AdvModel> advList=advDao.getAdvByStatus(status, (page - 1) * nums, nums);
        int count=advDao.countAdvByStatus(status);
        return new PageVo<>(advList, count);
    }

    @Override
    public boolean addAdv(AdvModel adv) {
        return advDao.addAdv(adv)==1 ;
    }


    @Override
    public boolean updateAdv(AdvModel advModel) {
        return advDao.updateByPrimaryKeySelective(advModel)==1;
    }

    @Override
    public List<AdvModel> getAdvPathByStatus() {
        return advDao.getAdvPathByStatus();
    }
}
