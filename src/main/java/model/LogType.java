package model;

import java.util.Date;

public class LogType {
    private Integer logId;

    private Date logDate;

    private Integer logType;

    private String logWhat;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getLogWhat() {
        return logWhat;
    }

    public void setLogWhat(String logWhat) {
        this.logWhat = logWhat == null ? null : logWhat.trim();
    }
}