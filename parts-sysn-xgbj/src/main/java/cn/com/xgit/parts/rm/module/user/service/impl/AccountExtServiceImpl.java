package cn.com.xgit.parts.rm.module.user.service.impl;

import cn.com.xgit.parts.rm.common.util.BeanUtil;
import cn.com.xgit.parts.rm.module.user.entity.AccountExt;
import cn.com.xgit.parts.rm.module.user.mapper.AccountExtMapper;
import cn.com.xgit.parts.rm.module.user.service.AccountExtService;
import cn.com.xgit.parts.rm.module.user.vo.AccountExtVO;
import cn.com.xgit.platform.common.base.mapper.SuperMapper;
import cn.com.xgit.platform.common.base.service.impl.SuperServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * AccountExt 后台接口实现类
 */
@Slf4j
@Service
public class AccountExtServiceImpl extends SuperServiceImpl<SuperMapper<AccountExt>, AccountExt> implements AccountExtService {

    @Autowired
    private AccountExtMapper accountExtMapper;


    public List<AccountExtVO> queryListByIds(List<Long> ids) {
        List<AccountExt> doList = accountExtMapper.queryListByIds(ids);
        if (null != doList) {
            return BeanUtil.do2bo4List(doList, AccountExtVO.class);
        }
        return new ArrayList<>();
    }

}
