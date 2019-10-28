package cn.com.xgit.parts.rm.mybatisplus.plugin.parser.handle.tenant.handle;


import cn.com.xgit.platform.mybatis.autoconfigure.mybatisplus.plugin.parser.handle.tenant.handler.DefaultTenantHandler;

/**
 * @author f00lish
 * @version 2019-08-16
 * Created By IntelliJ IDEA.
 * Qun:530350843
 */
public class DefaultStoreHandler extends DefaultTenantHandler {

    @Override
    public String getTenantIdColumn() {
        return "store_id";
    }
}
