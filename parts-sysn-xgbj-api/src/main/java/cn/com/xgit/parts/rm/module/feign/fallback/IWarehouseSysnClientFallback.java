package cn.com.xgit.parts.rm.module.feign.fallback;

import cn.com.xgit.parts.rm.module.feign.IWarehouseSysnClient;
import cn.com.xgit.parts.rm.module.warehouse.vo.WarehouseAreaLocationVO;
import cn.com.xgit.parts.rm.module.warehouse.vo.WarehouseAreaVO;
import cn.com.xgit.parts.rm.module.warehouse.vo.WarehouseVO;
import cn.com.xgit.platform.common.result.ResultMessage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class IWarehouseSysnClientFallback implements IWarehouseSysnClient {

    @Override
    public ResultMessage<IPage<WarehouseVO>> listWarehouses(WarehouseVO vo) {
        log.warn("listWarehouses 方法熔断，WarehouseVO：{}，", vo);
        return ResultMessage.error("服务异常，请稍后重试");
    }

    @Override
    public ResultMessage<IPage<WarehouseAreaVO>> listWarehouseArea(WarehouseAreaVO vo) {
        log.warn("listWarehouseArea 方法熔断，WarehouseAreaVO：{}，", vo);
        return ResultMessage.error("服务异常，请稍后重试");
    }

    @Override
    public ResultMessage<IPage<WarehouseAreaLocationVO>> listWarehouseAreaLocation(WarehouseAreaLocationVO vo) {
        log.warn("listWarehouseAreaLocation 方法熔断，WarehouseAreaLocationVO：{}，", vo);
        return ResultMessage.error("服务异常，请稍后重试");
    }
}
