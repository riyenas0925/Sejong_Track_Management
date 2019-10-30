package kr.ac.sejong.domain_old;

public class univVO {
    private Integer univNo;
    private String univTitle;
    private Integer univNum;

    public Integer getUnivNo() {
        return univNo;
    }

    public void setUnivNo(Integer univNo) {
        this.univNo = univNo;
    }

    public String getUnivTitle() {
        return univTitle;
    }

    public void setUnivTitle(String univTitle) {
        this.univTitle = univTitle;
    }

    public Integer getUnivNum() {
        return univNum;
    }

    public void setUnivNum(Integer univNum) {
        this.univNum = univNum;
    }

    @Override
    public String toString() {
        return "univVO{" +
                "univNo=" + univNo +
                ", univTitle='" + univTitle + '\'' +
                ", univNum=" + univNum +
                '}';
    }
}
