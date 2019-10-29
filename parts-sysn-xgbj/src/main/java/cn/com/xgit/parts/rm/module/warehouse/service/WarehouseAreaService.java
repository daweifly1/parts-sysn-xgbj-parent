package cn.com.xgit.parts.rm.module.warehouse.service;

import cn.com.xgit.parts.rm.module.warehouse.entity.WarehouseArea;
import cn.com.xgit.parts.rm.module.warehouse.vo.WarehouseAreaVO;
import cn.com.xgit.platform.common.base.service.SuperService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * WarehouseArea service后台接口实
 */
public interface WarehouseAreaService extends SuperService<WarehouseArea> {
    IPage<WarehouseAreaVO> queryPage(IPage page, WarehouseAreaVO vo);
}
