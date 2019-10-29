package cn.com.xgit.parts.rm.module.feign.fallback;

import cn.com.xgit.parts.rm.module.customer.vo.CompanyDealerVO;
import cn.com.xgit.parts.rm.module.feign.ICompanyDealerSysnClient;
import cn.com.xgit.platform.common.result.ResultMessage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ICompanyDealerSysnClientFallback implements ICompanyDealerSysnClient {


    @Override
    public ResultMessage<IPage<CompanyDealerVO>> listWarehouses(CompanyDealerVO companyDealerVO) {
        log.warn("listWarehouses 方法熔断，companyDealerVO：{}，", companyDealerVO);
        return ResultMessage.error("服务异常，请稍后重试");
    }

    @Override
    public ResultMessage<CompanyDealerVO> getById(Long id) {
        log.warn("getById 方法熔断，id：{}，", id);
        return ResultMessage.error("服务异常，请稍后重试");
    }

    @Override
    public ResultMessage save(CompanyDealerVO vo) {
        log.warn("save 方法熔断，CompanyDealerVO：{}，", vo);
        return ResultMessage.error("服务异常，请稍后重试");
    }
}
