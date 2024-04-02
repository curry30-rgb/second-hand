package com.second.hand.trading.server.service;

import com.second.hand.trading.server.model.AdvModel;
import com.second.hand.trading.server.model.IdleItemModel;
import com.second.hand.trading.server.vo.PageVo;

import java.util.List;

/**
 * @Title: AdvService
 * @Description:
 * @Author: localUser
 * @Version: 1.0
 * @create: 2024/3/23 17:41
 */
public interface AdvService {

    PageVo<AdvModel> adminGetAdv(int status, int page, int nums) ;

    boolean addAdv(AdvModel adv);

    boolean updateAdv(AdvModel advModel);

    List<AdvModel> getAdvPathByStatus();
}
