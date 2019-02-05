package kr.ac.sejong.domain;

import javax.inject.Inject;

public class ruleVO {
    private Integer ruleNo;
    private String univ;
    private String track;
    private Integer basic;
    private Integer applied;
    private Integer industry;

    public Integer getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(Integer ruleNo) {
        this.ruleNo = ruleNo;
    }

    public String getUniv() {
        return univ;
    }

    public void setUniv(String univ) {
        this.univ = univ;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
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

    @Override
    public String toString() {
        return "ruleVO{" +
                "ruleNo=" + ruleNo +
                ", univ='" + univ + '\'' +
                ", track='" + track + '\'' +
                ", basic=" + basic +
                ", applied=" + applied +
                ", industry=" + industry +
                '}';
    }
}
