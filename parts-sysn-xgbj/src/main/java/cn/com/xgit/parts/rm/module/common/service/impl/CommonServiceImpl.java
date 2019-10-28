package cn.com.xgit.parts.rm.module.common.service.impl;

import cn.com.xgit.parts.rm.module.common.service.CommonService;
import cn.com.xgit.platform.basic.feign.IDentidyClient;
import cn.com.xgit.platform.common.result.ResultMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * CommonService 后台接口实现类
 */
@Slf4j
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private IDentidyClient iDentidyClient;

    @Override
    public String genPartsCommonCode() {
        ResultMessage<String> msg = iDentidyClient.nextCode("xgbj_sysn");
        if (null != msg && StringUtils.isNoneBlank(msg.getData())) {
            return msg.getData();
        }
        return null;
    }
}
