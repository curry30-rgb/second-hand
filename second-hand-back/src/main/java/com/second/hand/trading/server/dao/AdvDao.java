package com.second.hand.trading.server.dao;

import com.second.hand.trading.server.model.AdvModel;
import com.second.hand.trading.server.model.IdleItemModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Title: AdvDao
 * @Description:
 * @Author: localUser
 * @Version: 1.0
 * @create: 2024/3/23 17:30
 */
@Mapper
public interface AdvDao {

    List<AdvModel> getAdvByStatus(int status, int begin, int nums);

    int countAdvByStatus(int status);

    int addAdv(AdvModel advModel);

    int updateByPrimaryKeySelective(AdvModel advModel);

    List<AdvModel> getAdvPathByStatus();
}
