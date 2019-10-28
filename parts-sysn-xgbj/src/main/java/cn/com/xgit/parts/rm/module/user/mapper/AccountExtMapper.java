package cn.com.xgit.parts.rm.module.user.mapper;

import cn.com.xgit.parts.rm.module.user.entity.AccountExt;
import cn.com.xgit.platform.common.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户扩展信息 Mapper
 */
@Mapper
public interface AccountExtMapper extends SuperMapper<AccountExt> {
    List<AccountExt> queryListByIds(@Param(value = "ids") List<Long> ids);
}

