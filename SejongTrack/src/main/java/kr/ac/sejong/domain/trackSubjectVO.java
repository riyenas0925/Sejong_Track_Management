package kr.ac.sejong.domain;

public class trackSubjectVO extends subjectVO{
    private String trackTitle;
    private Integer credit;

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }
}
