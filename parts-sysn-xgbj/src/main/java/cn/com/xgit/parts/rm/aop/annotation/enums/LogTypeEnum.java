package cn.com.xgit.parts.rm.aop.annotation.enums;

public enum LogTypeEnum {
    COMMON(0, "普通访问"), ADD(1, "新增"), UPDATE(2, "更改"), DELETE(3, "删除");

    private Integer logType;
    private String logDescription;

    LogTypeEnum(Integer logType, String logDescription) {
        this.logType = logType;
        this.logDescription = logDescription;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getLogDescription() {
        return logDescription;
    }

    public void setLogDescription(String logDescription) {
        this.logDescription = logDescription;
    }
}
