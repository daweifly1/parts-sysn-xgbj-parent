package cn.com.xgit.parts.rm.module.warehouse.service;

import cn.com.xgit.parts.rm.module.warehouse.entity.Warehouse;
import cn.com.xgit.parts.rm.module.warehouse.vo.WarehouseVO;
import cn.com.xgit.platform.common.base.service.SuperService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * AccountExt service后台接口实
 */
public interface WarehouseService extends SuperService<Warehouse> {

    IPage<WarehouseVO> queryPage(IPage page, WarehouseVO warehouseVO);
}
