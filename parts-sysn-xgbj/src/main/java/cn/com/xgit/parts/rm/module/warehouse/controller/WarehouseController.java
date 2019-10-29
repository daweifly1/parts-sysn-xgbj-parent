package cn.com.xgit.parts.rm.module.warehouse.controller;

import cn.com.xgit.parts.rm.module.common.controller.PartsBaseController;
import cn.com.xgit.parts.rm.module.warehouse.service.WarehouseService;
import cn.com.xgit.parts.rm.module.warehouse.vo.WarehouseVO;
import cn.com.xgit.platform.common.result.ResultMessage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/warehouseSysn")
public class WarehouseController extends PartsBaseController {
    @Autowired
    private WarehouseService warehouseService;


    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询仓库，查询条件为企业标识，选填")
    public ResultMessage<IPage<WarehouseVO>> listWarehouses(WarehouseVO warehouseVO) {
        IPage page = this.getPagination();
        //TODO        warehouseVO.setOrgId();
        IPage<WarehouseVO> r = warehouseService.queryPage(page, warehouseVO);
        return ResultMessage.success(r);
    }


}
