package com.second.hand.trading.server.controller;

import com.second.hand.trading.server.service.AdvService;
import com.second.hand.trading.server.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping("carousel")
public class CarouselController {

    @Autowired
    private AdvService advService;

    @PostMapping("getAdv")
    private ResultVo getAdvByStatus(){
        return ResultVo.success(advService.getAdvPathByStatus());
    }
}
