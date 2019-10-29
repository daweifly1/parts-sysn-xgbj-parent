package cn.com.xgit.parts.rm.module.customer.service;

import cn.com.xgit.parts.rm.module.customer.entity.CompanyDealer;
import cn.com.xgit.parts.rm.module.customer.vo.CompanyDealerVO;
import cn.com.xgit.platform.common.base.service.SuperService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * CompanyDealer service后台接口实
 */
public interface CompanyDealerService extends SuperService<CompanyDealer> {

    IPage<CompanyDealerVO> queryPage(IPage page, CompanyDealerVO companyDealerVO);

    boolean saveByCompanyDealerVO(CompanyDealerVO vo);
}
