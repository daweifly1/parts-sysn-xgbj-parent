package cn.com.xgit.parts.rm.module.warehouse.service;

import cn.com.xgit.parts.rm.module.warehouse.entity.WarehouseAreaLocation;
import cn.com.xgit.parts.rm.module.warehouse.vo.WarehouseAreaLocationVO;
import cn.com.xgit.platform.common.base.service.SuperService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * WarehouseAreaLocation service后台接口实
 */
public interface WarehouseAreaLocationService extends SuperService<WarehouseAreaLocation> {
    IPage<WarehouseAreaLocationVO> queryPage(IPage page, WarehouseAreaLocationVO warehouseAreaLocationVO);
}
