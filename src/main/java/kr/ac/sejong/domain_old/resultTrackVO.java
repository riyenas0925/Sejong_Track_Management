package kr.ac.sejong.domain_old;

public class resultTrackVO {
    private Integer univNo;
    private Integer trackNo;
    private String trackTitle;
    private Integer trackNum;
    private Integer percent;
    private Integer basicCredit;
    private Integer appliedCredit;
    private Integer industryCredit;
    private Integer state;

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

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public Integer getBasicCredit() {
        return basicCredit;
    }

    public void setBasicCredit(Integer basicCredit) {
        this.basicCredit = basicCredit;
    }

    public Integer getAppliedCredit() {
        return appliedCredit;
    }

    public void setAppliedCredit(Integer appliedCredit) {
        this.appliedCredit = appliedCredit;
    }

    public Integer getIndustryCredit() {
        return industryCredit;
    }

    public void setIndustryCredit(Integer industryCredit) {
        this.industryCredit = industryCredit;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "resultTrackVO{" +
                "univNo=" + univNo +
                ", trackNo=" + trackNo +
                ", trackTitle='" + trackTitle + '\'' +
                ", trackNum=" + trackNum +
                ", percent=" + percent +
                ", basicCredit=" + basicCredit +
                ", appliedCredit=" + appliedCredit +
                ", industryCredit=" + industryCredit +
                ", state=" + state +
                '}';
    }
}
