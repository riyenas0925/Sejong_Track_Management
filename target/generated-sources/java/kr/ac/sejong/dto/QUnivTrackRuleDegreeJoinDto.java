package kr.ac.sejong.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * kr.ac.sejong.dto.QUnivTrackRuleDegreeJoinDto is a Querydsl Projection type for UnivTrackRuleDegreeJoinDto
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QUnivTrackRuleDegreeJoinDto extends ConstructorExpression<UnivTrackRuleDegreeJoinDto> {

    private static final long serialVersionUID = 2005471600L;

    public QUnivTrackRuleDegreeJoinDto(com.querydsl.core.types.Expression<Long> univNo, com.querydsl.core.types.Expression<String> univTitle, com.querydsl.core.types.Expression<Long> ruleId, com.querydsl.core.types.Expression<Long> trackId, com.querydsl.core.types.Expression<String> trackTitle, com.querydsl.core.types.Expression<Long> trackNo, com.querydsl.core.types.Expression<Long> basicCredit, com.querydsl.core.types.Expression<Long> appliedCredit, com.querydsl.core.types.Expression<Long> industryCredit, com.querydsl.core.types.Expression<Long> degreeId, com.querydsl.core.types.Expression<String> degreeTitle) {
        super(UnivTrackRuleDegreeJoinDto.class, new Class<?>[]{long.class, String.class, long.class, long.class, String.class, long.class, long.class, long.class, long.class, long.class, String.class}, univNo, univTitle, ruleId, trackId, trackTitle, trackNo, basicCredit, appliedCredit, industryCredit, degreeId, degreeTitle);
    }

}

