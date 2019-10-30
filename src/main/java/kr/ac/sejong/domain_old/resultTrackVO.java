package kr.ac.sejong.domain_old;

public class resultTrackVO extends trackVO{
    private Integer percent;
    private Integer basicCredit;
    private Integer appliedCredit;
    private Integer industryCredit;
    private Integer state;

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
                "percent=" + percent +
                ", basicCredit=" + basicCredit +
                ", appliedCredit=" + appliedCredit +
                ", industryCredit=" + industryCredit +
                ", state=" + state +
                '}';
    }
}
