package cn.com.xgit.parts.rm.module.common.controller;

import cn.com.xgit.parts.rm.common.util.DatePropertyEditor;
import cn.com.xgit.platform.common.base.controller.BaseController;
import cn.com.xgit.platform.common.security.userdetails.AuthUserDetails;
import cn.com.xgit.platform.common.user.entity.vo.SysUserVO;
import cn.com.xgit.platform.common.util.AuthorizationUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 */
public class PartsBaseController extends BaseController {


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
        binder.registerCustomEditor(Date.class, new DatePropertyEditor(true));
        binder.registerCustomEditor(Timestamp.class, new DatePropertyEditor(true));
    }

    public SysUserVO getSysUserVO() {
        AuthUserDetails authUserDetails = (AuthUserDetails) AuthorizationUtils.getPrincipal();
        return authUserDetails;
    }

}
