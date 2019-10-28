package cn.com.xgit.parts.rm.module.user.controller;

import cn.com.xgit.parts.rm.aop.annotation.OperationLogTag;
import cn.com.xgit.parts.rm.module.common.controller.PartsBaseController;
import cn.com.xgit.parts.rm.module.user.entity.AccountExt;
import cn.com.xgit.parts.rm.module.user.service.AccountExtService;
import cn.com.xgit.platform.common.result.ResultMessage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * AccountExt Controller 实现类
 */
@Slf4j
@RestController
@RequestMapping("/accountExt")
@Api(value = "用户扩展信息--Controller接口 ")
public class AccountExtController extends PartsBaseController {
    @Autowired
    private AccountExtService accountExtService;

    @OperationLogTag(description = "查寻用户扩展信息分页列表")
    @GetMapping(value = "/page")
    @ApiOperation(value = "用户扩展信息分页列表信息")
    @ApiImplicitParam
    public ResultMessage<IPage<AccountExt>> list(AccountExt accountExt) {
        IPage page = this.getPagination();
        return ResultMessage.success(accountExtService.page(page, new QueryWrapper<AccountExt>(accountExt)));
    }

    @GetMapping(value = "/list")
    @ApiOperation(value = "用户扩展信息列表")
    public ResultMessage<List<AccountExt>> allList(AccountExt accountExt) {
        return ResultMessage.success(accountExtService.list(new QueryWrapper<AccountExt>(accountExt)));
    }


//    @ResponseBody
//    @GetMapping("/nextId")
//    public Long nextId() {
////        System.out.println(AuthorizationUtils.getPrincipal());
//        return mybatisKeyGenerator.nextId();
//    }
}
