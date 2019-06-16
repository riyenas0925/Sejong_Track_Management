package kr.ac.sejong.domain_old;

public class ruleVO {
    private Integer ruleNo;
    private String univTitle;
    private String trackTitle;
    private String degreeTitle;
    private Integer ruleId;
    private Integer trackId;
    private Integer basic;
    private Integer applied;
    private Integer industry;

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public Integer getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(Integer ruleNo) {
        this.ruleNo = ruleNo;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public Integer getBasic() {
        return basic;
    }

    public void setBasic(Integer basic) {
        this.basic = basic;
    }

    public Integer getApplied() {
        return applied;
    }

    public void setApplied(Integer applied) {
        this.applied = applied;
    }

    public Integer getIndustry() {
        return industry;
    }

    public void setIndustry(Integer industry) {
        this.industry = industry;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public String getUnivTitle() {
        return univTitle;
    }

    public void setUnivTitle(String univTitle) {
        this.univTitle = univTitle;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    @Override
    public String toString() {
        return "ruleVO{" +
                "ruleNo=" + ruleNo +
                ", univTitle='" + univTitle + '\'' +
                ", trackTitle='" + trackTitle + '\'' +
                ", degreeTitle=" + degreeTitle +
                ", ruleId='" + ruleId + '\'' +
                ", trackId=" + trackId +
                ", basic=" + basic +
                ", applied=" + applied +
                ", industry=" + industry +
                '}';
    }
}
