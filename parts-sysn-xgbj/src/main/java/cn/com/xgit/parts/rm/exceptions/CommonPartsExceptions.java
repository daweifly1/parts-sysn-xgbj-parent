package cn.com.xgit.parts.rm.exceptions;

/**
 * 商城通用异常信息
 */
public class CommonPartsExceptions extends RuntimeException {

    // 返回code
    private int code;

    private String message;

    public CommonPartsExceptions(String message) {
        super(message);
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
