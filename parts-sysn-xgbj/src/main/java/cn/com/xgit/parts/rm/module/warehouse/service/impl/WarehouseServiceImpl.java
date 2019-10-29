package cn.com.xgit.parts.rm.module.warehouse.service.impl;

import cn.com.xgit.parts.rm.common.util.BeanUtil;
import cn.com.xgit.parts.rm.module.warehouse.entity.Warehouse;
import cn.com.xgit.parts.rm.module.warehouse.mapper.WarehouseMapper;
import cn.com.xgit.parts.rm.module.warehouse.service.WarehouseService;
import cn.com.xgit.parts.rm.module.warehouse.vo.WarehouseVO;
import cn.com.xgit.platform.common.base.mapper.SuperMapper;
import cn.com.xgit.platform.common.base.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


/**
 * AccountExt 后台接口实现类
 */
@Slf4j
@Service
public class WarehouseServiceImpl extends SuperServiceImpl<SuperMapper<Warehouse>, Warehouse> implements WarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public IPage<WarehouseVO> queryPage(IPage page, WarehouseVO warehouseVO) {
        Page<WarehouseVO> r = null;
        Wrapper<Warehouse> q = new QueryWrapper<>(BeanUtil.do2bo(warehouseVO, Warehouse.class));
        IPage<Warehouse> pr = warehouseMapper.selectPage(page, q);
        r = BeanUtil.do2bo(pr, Page.class);
        if (null != r && !CollectionUtils.isEmpty(pr.getRecords())) {
            r.setRecords(BeanUtil.do2bo4List(pr.getRecords(), WarehouseVO.class));
        }
        return r;
    }
}
