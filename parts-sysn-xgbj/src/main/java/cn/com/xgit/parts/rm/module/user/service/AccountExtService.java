package cn.com.xgit.parts.rm.module.user.service;

import cn.com.xgit.parts.rm.module.user.entity.AccountExt;
import cn.com.xgit.parts.rm.module.user.vo.AccountExtVO;
import cn.com.xgit.platform.common.base.service.SuperService;

import java.util.List;

/**
 * AccountExt service后台接口实
 */
public interface AccountExtService extends SuperService<AccountExt> {

    List<AccountExtVO> queryListByIds(List<Long> ids);

}
