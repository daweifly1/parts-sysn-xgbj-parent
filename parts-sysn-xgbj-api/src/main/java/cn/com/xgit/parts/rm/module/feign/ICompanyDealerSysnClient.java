package cn.com.xgit.parts.rm.module.feign;

import cn.com.xgit.parts.rm.module.customer.vo.CompanyDealerVO;
import cn.com.xgit.parts.rm.module.feign.fallback.ICompanyDealerSysnClientFallback;
import cn.com.xgit.platform.common.result.ResultMessage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "${hcloud.partsSysn.serviceIDentidyId:parts-sysn-xgbj}", fallback = ICompanyDealerSysnClientFallback.class)
public interface ICompanyDealerSysnClient {

    //分页查询
    @RequestMapping(value = "/companyDealerSysn/page", method = RequestMethod.GET)
    ResultMessage<IPage<CompanyDealerVO>> listWarehouses(CompanyDealerVO companyDealerVO);


    //根据ID查询
    @RequestMapping(value = "/companyDealerSysn/getById", method = RequestMethod.GET)
    ResultMessage<CompanyDealerVO> getById(@RequestParam("id") Long id);

    //客户信息--保存或者修改
    @PostMapping(value = "/companyDealerSysn/save")
    ResultMessage save(@RequestBody CompanyDealerVO vo);
}
