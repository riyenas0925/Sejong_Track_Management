package kr.ac.sejong.service;

import kr.ac.sejong.domain.degreeVO;
import kr.ac.sejong.domain.ruleVO;

import java.util.List;

public interface TrackRuleService {
    public void regist(ruleVO rule)throws Exception;

    public ruleVO read(Integer ruleNo)throws Exception;

    public ruleVO readRule(Integer degree, Integer trackNo)throws Exception;

    public void update(ruleVO rule)throws Exception;

    public void remove(Integer ruleNo)throws Exception;

    public List<ruleVO> listAll() throws Exception;

    public List<ruleVO> listSearch(Integer univNo) throws Exception;

    public List<degreeVO> degreeList() throws Exception;
}
