package cn.com.xgit.parts.rm.common.util.excel;

import java.util.*;

public class ExcelFileConstant {
    /**
     * DATA_LIST 获取excel文件的内容key
     */
    public static final String DATA_LIST = "dataList";
    /**
     * WARNING_MESSAGES 获取excel导入出现的错误警告key
     */
    public static final String WARNING_MESSAGES = "warningMessages";

    public static final String ROW_WARNING_MESSAGES = "warningMessages";

    /**
     * HEADER 存储所有excel导入时的头标题 ，可以通过以上定义的key获取相应的excel头标题内容
     */
    public static Map<ExcelHeader, List<String>> header = new HashMap<>();

    static {
        header.put(ExcelHeader.CUSTOMERS, new ArrayList<>(Arrays.asList("客户姓名", "手机号码", "扩展名称", "客户编号", "维修服务人员", "客户地址", "联系人", "客户邮编")));
//        header.put(ExcelHeader.GOODS, new ArrayList<>(Arrays.asList("商品名称", "库存单位", "建议零售价")));
        // 商品较完善的导入
        header.put(ExcelHeader.GOODS, new ArrayList<>(Arrays.asList("商品名称", "建议零售价", "库存单位名称", "商品分类名称", "所属品牌名称", "商品编码", "商品条码")));
    }

    public enum ExcelHeader {
        CUSTOMERS("客户信息导入"),
        GOODS("商品信息导入");

        private String headerTitle;

        ExcelHeader(String headerTitle) {
            this.headerTitle = headerTitle;
        }
    }
}
