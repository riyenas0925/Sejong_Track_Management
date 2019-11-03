package kr.ac.sejong.domain_old;

public class trackVO {
    private Integer univNo;
    private Integer trackNo;
    private String trackTitle;
    private Integer trackNum;

    public Integer getUnivNo() {
        return univNo;
    }

    public void setUnivNo(Integer univNo) {
        this.univNo = univNo;
    }

    public Integer getTrackNo() {
        return trackNo;
    }

    public void setTrackNo(Integer trackNo) {
        this.trackNo = trackNo;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public Integer getTrackNum() {
        return trackNum;
    }

    public void setTrackNum(Integer trackNum) {
        this.trackNum = trackNum;
    }

    @Override
    public String toString() {
        return "trackVO{" +
                "univNo=" + univNo +
                ", trackNo=" + trackNo +
                ", trackTitle='" + trackTitle + '\'' +
                ", trackNum=" + trackNum +
                '}';
    }
}
