package model;

import java.util.Date;

public class LogBaseInfo {
    private Integer logId;

    private Date logTime;

    private Integer logAboutUser;

    private Integer logType;

    private String logWhat;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public Integer getLogAboutUser() {
        return logAboutUser;
    }

    public void setLogAboutUser(Integer logAboutUser) {
        this.logAboutUser = logAboutUser;
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