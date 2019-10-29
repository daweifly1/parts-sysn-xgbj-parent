package cn.com.xgit.parts.rm.module.warehouse.controller;

import cn.com.xgit.parts.rm.module.common.controller.PartsBaseController;
import cn.com.xgit.parts.rm.module.warehouse.service.WarehouseAreaLocationService;
import cn.com.xgit.parts.rm.module.warehouse.vo.WarehouseAreaLocationVO;
import cn.com.xgit.platform.common.result.ResultMessage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * WarehouseAreaLocation Controller 实现类
 */
@RestController
@RequestMapping("/warehouseAreaLocationSysn")
public class WarehouseAreaLocationController extends PartsBaseController {
    private static final Logger logger = LoggerFactory.getLogger(WarehouseAreaLocationController.class);
    @Autowired
    private WarehouseAreaLocationService warehouseAreaLocationService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询")
    public ResultMessage<IPage<WarehouseAreaLocationVO>> listWarehouseAreaLocation(WarehouseAreaLocationVO warehouseAreaLocationVO) {
        IPage page = this.getPagination();
        //TODO        warehouseVO.setOrgId();
        IPage<WarehouseAreaLocationVO> r = warehouseAreaLocationService.queryPage(page, warehouseAreaLocationVO);
        return ResultMessage.success(r);
    }
}
