package cn.com.xgit.parts.rm.exceptions;

/**
 * 使用数据库乐观锁时候抛出异常信息，由事务拦截层上层确定重试次数
 */
public class PartsDbVersionExceptions extends RuntimeException {

    // 返回code，新增失败1 更新失败2
    private int code;

    private String message;

    public final static int DB_ADD = 1;

    public final static int DB_UPDATE = 1;

    public PartsDbVersionExceptions(int i, String message) {
        super(message);
        this.code = i;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
