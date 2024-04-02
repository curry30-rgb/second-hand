package com.second.hand.trading.server.controller;

import com.second.hand.trading.server.enums.ErrorMsg;
import com.second.hand.trading.server.model.AdminModel;
import com.second.hand.trading.server.model.AdvModel;
import com.second.hand.trading.server.model.IdleItemModel;
import com.second.hand.trading.server.model.UserModel;
import com.second.hand.trading.server.utils.MD5Utils;
import com.second.hand.trading.server.service.*;
import com.second.hand.trading.server.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@CrossOrigin
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private IdleItemService idleItemService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private AdvService advService;

    @GetMapping("login")
    public ResultVo login(@RequestParam("accountNumber") @NotNull @NotEmpty String accountNumber,
                          @RequestParam("adminPassword") @NotNull @NotEmpty String adminPassword,
                          HttpSession session){
        String encode = MD5Utils.encode(adminPassword);
        AdminModel adminModel=adminService.login(accountNumber,encode);
        if (null == adminModel) {
            return ResultVo.fail(ErrorMsg.EMAIL_LOGIN_ERROR);
        }
        session.setAttribute("admin",adminModel);
        return ResultVo.success(adminModel);
    }

    @GetMapping("loginOut")
    public ResultVo loginOut( HttpSession session){
        session.removeAttribute("admin");
        return ResultVo.success();
    }

    @GetMapping("list")
    public ResultVo getAdminList(HttpSession session,
                                 @RequestParam(value = "page",required = false) Integer page,
                                 @RequestParam(value = "nums",required = false) Integer nums){
        if(session.getAttribute("admin")==null){
            return ResultVo.fail(ErrorMsg.COOKIE_ERROR);
        }
        int p=1;
        int n=8;
        if(null!=page){
            p=page>0?page:1;
        }
        if(null!=nums){
            n=nums>0?nums:8;
        }
        return ResultVo.success(adminService.getAdminList(p,n));
    }

    @PostMapping("add")
    public ResultVo addAdmin(HttpSession session,
                             @RequestBody AdminModel adminModel){
        if(session.getAttribute("admin")==null){
            return ResultVo.fail(ErrorMsg.COOKIE_ERROR);
        }
        if(adminService.addAdmin(adminModel)){
            return ResultVo.success();
        }
        return ResultVo.fail(ErrorMsg.PARAM_ERROR);
    }

    @GetMapping("idleList")
    public ResultVo idleList(HttpSession session,
                             @RequestParam(value = "status",required = false) @NotNull @NotEmpty Integer status,
                             @RequestParam(value = "page",required = false) Integer page,
                             @RequestParam(value = "nums",required = false) Integer nums){
        if(session.getAttribute("admin")==null){
            return ResultVo.fail(ErrorMsg.COOKIE_ERROR);
        }
        int p=1;
        int n=8;
        if(null!=page){
            p=page>0?page:1;
        }
        if(null!=nums){
            n=nums>0?nums:8;
        }
        return ResultVo.success(idleItemService.adminGetIdleList(status,p,n));
    }

    @GetMapping("updateIdleStatus")
    public ResultVo updateIdleStatus(HttpSession session,
                                     @RequestParam("id") @NotNull @NotEmpty Long id,
                                     @RequestParam("status") @NotNull @NotEmpty Integer status){
        if(session.getAttribute("admin")==null){
            return ResultVo.fail(ErrorMsg.COOKIE_ERROR);
        }
        IdleItemModel idleItemModel=new IdleItemModel();
        idleItemModel.setId(id);
        idleItemModel.setIdleStatus(status.byteValue());
        if(idleItemService.updateIdleItem(idleItemModel)){
            return ResultVo.success();
        }
        return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
    }

    @GetMapping("orderList")
    public ResultVo orderList(HttpSession session,
                              @RequestParam(value = "page",required = false) Integer page,
                              @RequestParam(value = "nums",required = false) Integer nums){
        if(session.getAttribute("admin")==null){
            return ResultVo.fail(ErrorMsg.COOKIE_ERROR);
        }
        int p=1;
        int n=8;
        if(null!=page){
            p=page>0?page:1;
        }
        if(null!=nums){
            n=nums>0?nums:8;
        }
        return ResultVo.success(orderService.getAllOrder(p,n));
    }

    @GetMapping("deleteOrder")
    public ResultVo deleteOrder(HttpSession session,
                              @RequestParam("id") @NotNull @NotEmpty Long id){
        if(session.getAttribute("admin")==null){
            return ResultVo.fail(ErrorMsg.COOKIE_ERROR);
        }
        if(orderService.deleteOrder(id)){
            return ResultVo.success();
        }
        return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
    }

    @GetMapping("userList")
    public ResultVo userList(HttpSession session,
                             @RequestParam(value = "page",required = false) Integer page,
                             @RequestParam(value = "nums",required = false) Integer nums,
                             @RequestParam("status") @NotNull @NotEmpty Integer status){
        if(session.getAttribute("admin")==null){
            return ResultVo.fail(ErrorMsg.COOKIE_ERROR);
        }
        int p=1;
        int n=8;
        if(null!=page){
            p=page>0?page:1;
        }
        if(null!=nums){
            n=nums>0?nums:8;
        }
        return ResultVo.success(userService.getUserByStatus(status,p,n));
    }

    @GetMapping("updateUserStatus")
    public ResultVo updateUserStatus(HttpSession session,
                                     @RequestParam("id") @NotNull @NotEmpty Long id,
                                     @RequestParam("status") @NotNull @NotEmpty Integer status){
        if(session.getAttribute("admin")==null){
            return ResultVo.fail(ErrorMsg.COOKIE_ERROR);
        }
        UserModel userModel=new UserModel();
        userModel.setId(id);
        userModel.setUserStatus(status.byteValue());
        if(userService.updateUserInfo(userModel))
            return ResultVo.success();
        return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
    }

    @GetMapping("advList")
    public ResultVo advList(HttpSession session,
                             @RequestParam(value = "status",required = false) @NotNull @NotEmpty Integer status,
                             @RequestParam(value = "page",required = false) Integer page,
                             @RequestParam(value = "nums",required = false) Integer nums){
        if(session.getAttribute("admin")==null){
            return ResultVo.fail(ErrorMsg.COOKIE_ERROR);
        }
        int p=1;
        int n=8;
        if(null!=page){
            p=page>0?page:1;
        }
        if(null!=nums){
            n=nums>0?nums:8;
        }
        return ResultVo.success(advService.adminGetAdv(status,p,n));
    }

    @GetMapping("updateAdvStatus")
    public ResultVo updateAdvStatus(HttpSession session,
                                    @RequestParam("id") @NotNull @NotEmpty Long id,
                                    @RequestParam("status") @NotNull @NotEmpty Integer status){
        if(session.getAttribute("admin")==null){
            return ResultVo.fail(ErrorMsg.COOKIE_ERROR);
        }
        AdvModel advModel=new AdvModel();
        advModel.setId(id);
        advModel.setStatus(status.byteValue());
        if(advService.updateAdv(advModel)){
            return ResultVo.success();
        }
        return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
    }

    @PostMapping("addAdv")
    public ResultVo addAdv(HttpSession session,
                            @RequestBody AdvModel advModel){
        if(session.getAttribute("admin")==null){
            return ResultVo.fail(ErrorMsg.COOKIE_ERROR);
        }
        if(advService.addAdv(advModel)){
            return ResultVo.success(advModel);
        }
        return ResultVo.fail(ErrorMsg.PARAM_ERROR);
    }
}



