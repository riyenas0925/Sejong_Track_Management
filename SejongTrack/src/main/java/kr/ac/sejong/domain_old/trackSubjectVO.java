package kr.ac.sejong.domain_old;

public class trackSubjectVO extends subjectVO{
    private Integer credit;
    private Integer subType;
    private Integer trackNo;

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public Integer getTrackNo() {
        return trackNo;
    }

    public void setTrackNo(Integer trackNo) {
        this.trackNo = trackNo;
    }

    @Override
    public String toString() {
        return "trackSubjectVO{" +
                "credit=" + credit +
                ", subType=" + subType +
                ", trackNo=" + trackNo +
                '}';
    }
}
