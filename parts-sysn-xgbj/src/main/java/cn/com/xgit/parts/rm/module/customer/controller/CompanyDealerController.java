package cn.com.xgit.parts.rm.module.customer.controller;

import cn.com.xgit.parts.rm.common.util.BeanUtil;
import cn.com.xgit.parts.rm.module.common.controller.PartsBaseController;
import cn.com.xgit.parts.rm.module.customer.entity.CompanyDealer;
import cn.com.xgit.parts.rm.module.customer.service.CompanyDealerService;
import cn.com.xgit.parts.rm.module.customer.vo.CompanyDealerVO;
import cn.com.xgit.platform.common.result.ResultMessage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * CompanyDealer Controller 实现类
 */
@Slf4j
@RestController
@RequestMapping("/companyDealerSysn")
public class CompanyDealerController extends PartsBaseController {
    private static final Logger logger = LoggerFactory.getLogger(CompanyDealerController.class);
    @Autowired
    private CompanyDealerService companyDealerService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询")
    public ResultMessage<IPage<CompanyDealerVO>> listWarehouses(CompanyDealerVO companyDealerVO) {
        IPage page = this.getPagination();
        //TODO        warehouseVO.setOrgId();
        IPage<CompanyDealerVO> r = companyDealerService.queryPage(page, companyDealerVO);
        return ResultMessage.success(r);
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ApiOperation(value = "根据ID查询")
    public ResultMessage<CompanyDealerVO> getById(Long id) {
        CompanyDealer m = companyDealerService.getById(id);
        if (null != m) {
            return ResultMessage.success(BeanUtil.do2bo(m, CompanyDealerVO.class));
        }
        return ResultMessage.success(null);
    }

    @PostMapping(value = "/save")
    @ApiOperation("客户信息--保存或者修改")
    public ResultMessage save(@RequestBody CompanyDealerVO vo) {
        try {
            boolean result = companyDealerService.saveByCompanyDealerVO(vo);
            if (result) {
                return ResultMessage.success();
            }
        } catch (Exception e) {
            log.error("", e);
            return ResultMessage.error(e.getMessage());
        }
        return ResultMessage.error();
    }
}
