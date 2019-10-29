package cn.com.xgit.parts.rm.module.warehouse.service.impl;

import cn.com.xgit.parts.rm.common.util.BeanUtil;
import cn.com.xgit.parts.rm.module.warehouse.entity.WarehouseArea;
import cn.com.xgit.parts.rm.module.warehouse.mapper.WarehouseAreaMapper;
import cn.com.xgit.parts.rm.module.warehouse.service.WarehouseAreaService;
import cn.com.xgit.parts.rm.module.warehouse.vo.WarehouseAreaVO;
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
 * WarehouseArea 后台接口实现类
 */
@Slf4j
@Service
public class WarehouseAreaServiceImpl extends SuperServiceImpl<SuperMapper<WarehouseArea>, WarehouseArea> implements WarehouseAreaService {
    @Autowired
    private WarehouseAreaMapper warehouseAreaMapper;


    @Override
    public IPage<WarehouseAreaVO> queryPage(IPage page, WarehouseAreaVO vo) {
        Page<WarehouseAreaVO> r = null;
        Wrapper<WarehouseArea> q = new QueryWrapper<>(BeanUtil.do2bo(vo, WarehouseArea.class));
        IPage<WarehouseArea> pr = warehouseAreaMapper.selectPage(page, q);
        r = BeanUtil.do2bo(pr, Page.class);
        if (null != r && !CollectionUtils.isEmpty(pr.getRecords())) {
            r.setRecords(BeanUtil.do2bo4List(pr.getRecords(), WarehouseAreaVO.class));
        }
        return r;
    }
}
