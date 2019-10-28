package cn.com.xgit.parts.rm.common.util;

import cn.com.xgit.platform.common.util.AuthorizationUtils;

/**
 * @author f00lish
 * @version 2019-08-15
 * Created By IntelliJ IDEA.
 * Qun:530350843
 */
public class PartsUtils {

    /**
     * 全局获取店铺StoreId
     * @return
     */
    public static Long getStoreId() {
        return AuthorizationUtils.getTenantId();
    }

    /**
     * 全局获取门店shopId
     * @return
     */
    public static Long getShopId() {
        return AuthorizationUtils.getDeptId();
    }

    /**
     * 获取shopId 对前端的默认0返回null
     *
     * @return
     */
    public static Long getRealShopId() {
        Long shopId = getShopId();
        if (null != shopId && 0 == shopId) {
            return null;
        }
        return shopId;
    }
}
