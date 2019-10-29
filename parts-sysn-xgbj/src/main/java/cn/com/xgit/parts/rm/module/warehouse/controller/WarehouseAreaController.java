package cn.com.xgit.parts.rm.module.warehouse.controller;

import cn.com.xgit.parts.rm.module.common.controller.PartsBaseController;
import cn.com.xgit.parts.rm.module.warehouse.service.WarehouseAreaService;
import cn.com.xgit.parts.rm.module.warehouse.vo.WarehouseAreaVO;
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
 * WarehouseArea Controller 实现类
 */
@RestController
@RequestMapping("/warehouseAreaSysn")
public class WarehouseAreaController extends PartsBaseController {
    private static final Logger logger = LoggerFactory.getLogger(WarehouseAreaController.class);
    @Autowired
    private WarehouseAreaService warehouseAreaService;


    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询仓库，查询条件为企业标识，选填")
    public ResultMessage<IPage<WarehouseAreaVO>> listWarehouseArea(WarehouseAreaVO warehouseAreaVO) {
        IPage page = this.getPagination();
        //TODO        warehouseVO.setOrgId();
        IPage<WarehouseAreaVO> r = warehouseAreaService.queryPage(page,warehouseAreaVO);
        return ResultMessage.success(r);
    }

}
