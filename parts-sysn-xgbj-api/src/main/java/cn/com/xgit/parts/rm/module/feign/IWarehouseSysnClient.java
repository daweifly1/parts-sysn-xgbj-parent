package cn.com.xgit.parts.rm.module.feign;

import cn.com.xgit.parts.rm.module.feign.fallback.IWarehouseSysnClientFallback;
import cn.com.xgit.parts.rm.module.warehouse.vo.WarehouseAreaLocationVO;
import cn.com.xgit.parts.rm.module.warehouse.vo.WarehouseAreaVO;
import cn.com.xgit.parts.rm.module.warehouse.vo.WarehouseVO;
import cn.com.xgit.platform.common.result.ResultMessage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "${hcloud.partsSysn.serviceIDentidyId:parts-sysn-xgbj}", fallback = IWarehouseSysnClientFallback.class)
public interface IWarehouseSysnClient {

    //分页查询仓库
    @RequestMapping(value = "/warehouseSysn/page", method = RequestMethod.GET)
    ResultMessage<IPage<WarehouseVO>> listWarehouses(WarehouseVO vo);

    //分页查询库区
    @RequestMapping(value = "/warehouseAreaSysn/page", method = RequestMethod.GET)
    ResultMessage<IPage<WarehouseAreaVO>> listWarehouseArea(WarehouseAreaVO vo);

    //分页查询储位
    @RequestMapping(value = "/warehouseAreaLocationSysn/page", method = RequestMethod.GET)
    ResultMessage<IPage<WarehouseAreaLocationVO>> listWarehouseAreaLocation(WarehouseAreaLocationVO vo);

}
