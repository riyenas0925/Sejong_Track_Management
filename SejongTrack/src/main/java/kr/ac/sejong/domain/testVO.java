package kr.ac.sejong.domain;

public class testVO {
    private Integer bno;
    private String univ;
    private String track;
    private Integer basic;
    private Integer applied;
    private Integer industry;

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
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
        return "testVO{" +
                "bno=" + bno +
                ", univ='" + univ + '\'' +
                ", track='" + track + '\'' +
                ", basic=" + basic +
                ", applied=" + applied +
                ", industry=" + industry +
                '}';
    }
}
