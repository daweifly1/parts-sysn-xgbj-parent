package cn.com.xgit.parts.rm.module.warehouse.service.impl;

import cn.com.xgit.parts.rm.common.util.BeanUtil;
import cn.com.xgit.parts.rm.module.warehouse.entity.WarehouseAreaLocation;
import cn.com.xgit.parts.rm.module.warehouse.mapper.WarehouseAreaLocationMapper;
import cn.com.xgit.parts.rm.module.warehouse.service.WarehouseAreaLocationService;
import cn.com.xgit.parts.rm.module.warehouse.vo.WarehouseAreaLocationVO;
import cn.com.xgit.platform.common.base.mapper.SuperMapper;
import cn.com.xgit.platform.common.base.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * WarehouseAreaLocation 后台接口实现类
 */
@Slf4j
@Service
public class WarehouseAreaLocationServiceImpl extends SuperServiceImpl<SuperMapper<WarehouseAreaLocation>, WarehouseAreaLocation> implements WarehouseAreaLocationService {

    @Autowired
    private WarehouseAreaLocationMapper warehouseAreaLocationMapper;

    @Override
    public IPage<WarehouseAreaLocationVO> queryPage(IPage page, WarehouseAreaLocationVO warehouseAreaLocationVO) {
        Page<WarehouseAreaLocationVO> r = null;
        Wrapper<WarehouseAreaLocation> q = new QueryWrapper<>(BeanUtil.do2bo(warehouseAreaLocationVO, WarehouseAreaLocation.class));
        IPage<WarehouseAreaLocation> pr = warehouseAreaLocationMapper.selectPage(page, q);
        r = BeanUtil.do2bo(pr, Page.class);
        if (null != r && !CollectionUtils.isEmpty(pr.getRecords())) {
            r.setRecords(BeanUtil.do2bo4List(pr.getRecords(), WarehouseAreaLocationVO.class));
        }
        return r;
    }
}
