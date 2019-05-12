package kr.ac.sejong.domain;

import java.sql.Timestamp;

public class visitorVO {
    private Integer visitorNo;
    private String ip;
    private String device;
    private String browser;
    private String os;
    private Timestamp date;

    public  visitorVO(){
    }

    public  visitorVO(String ip, String device, String browser, String os){
        this.ip = ip;
        this.device = device;
        this.browser = browser;
        this.os = os;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getVisitorNo() {
        return visitorNo;
    }

    public void setVisitorNo(Integer visitorNo) {
        this.visitorNo = visitorNo;
    }

    @Override
    public String toString() {
        return "visitorVO{" +
                "ip='" + ip + '\'' +
                ", device='" + device + '\'' +
                ", browser='" + browser + '\'' +
                ", os='" + os + '\'' +
                ", date=" + date +
                '}';
    }
}