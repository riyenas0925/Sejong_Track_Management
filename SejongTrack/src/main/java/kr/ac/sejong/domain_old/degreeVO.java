package kr.ac.sejong.domain_old;

public class degreeVO {
    private Integer degreeNo;
    private Integer degreeId;
    private String degreeTitle;

    public Integer getDegreeNo() {
        return degreeNo;
    }

    public void setDegreeNo(Integer degreeNo) {
        this.degreeNo = degreeNo;
    }

    public Integer getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Integer degreeId) {
        this.degreeId = degreeId;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    @Override
    public String toString() {
        return "degreeVO{" +
                "degreeNo=" + degreeNo +
                ", degreeId=" + degreeId +
                ", degreeTitle='" + degreeTitle + '\'' +
                '}';
    }
}
