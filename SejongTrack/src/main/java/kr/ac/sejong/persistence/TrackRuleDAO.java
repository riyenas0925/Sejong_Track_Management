package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.degreeVO;
import kr.ac.sejong.domain.ruleVO;

import java.util.List;

public interface TrackRuleDAO {
    public void create(ruleVO vo)throws Exception;

    public ruleVO read(Integer ruleNo)throws Exception;

    public ruleVO readRule(Integer degree, Integer trackNo)throws Exception;

    public void update(ruleVO vo)throws Exception;

    public void delete(Integer ruleNo)throws Exception;

    public List<ruleVO> listAll()throws Exception;

    public List<ruleVO> listSearch(Integer univNo)throws Exception;

    public void aiInit(Integer aiNo)throws Exception;

    public List<degreeVO> degreeList()throws Exception;
}
