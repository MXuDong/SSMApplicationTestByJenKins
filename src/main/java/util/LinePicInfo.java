package util;

public class LinePicInfo {
    private String xAxisType;
    private String [] xAxisData;
    private String yAxisType;
    private String [] seriesData;
    private String seriesType = "line";

    public LinePicInfo() {

    }

    public LinePicInfo(String xAxisType, String[] xAxisData, String yAxisType, String[] seriesData) {
        this.xAxisType = xAxisType;
        this.xAxisData = xAxisData;
        this.yAxisType = yAxisType;
        this.seriesData = seriesData;
    }

    public String getxAxisType() {
        return xAxisType;
    }

    public void setxAxisType(String xAxisType) {
        this.xAxisType = xAxisType;
    }

    public String[] getxAxisData() {
        return xAxisData;
    }

    public void setxAxisData(String[] xAxisData) {
        this.xAxisData = xAxisData;
    }

    public String getyAxisType() {
        return yAxisType;
    }

    public void setyAxisType(String yAxisType) {
        this.yAxisType = yAxisType;
    }

    public String[] getSeriesData() {
        return seriesData;
    }

    public void setSeriesData(String[] seriesData) {
        this.seriesData = seriesData;
    }
}
