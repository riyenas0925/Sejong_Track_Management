package kr.ac.sejong.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRule is a Querydsl query type for Rule
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRule extends EntityPathBase<Rule> {

    private static final long serialVersionUID = -1083647955L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRule rule = new QRule("rule");

    public final NumberPath<Long> appliedCredit = createNumber("appliedCredit", Long.class);

    public final NumberPath<Long> basicCredit = createNumber("basicCredit", Long.class);

    public final QDegree degree;

    public final NumberPath<Long> industryCredit = createNumber("industryCredit", Long.class);

    public final NumberPath<Long> ruleId = createNumber("ruleId", Long.class);

    public final QTrack track;

    public QRule(String variable) {
        this(Rule.class, forVariable(variable), INITS);
    }

    public QRule(Path<? extends Rule> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRule(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRule(PathMetadata metadata, PathInits inits) {
        this(Rule.class, metadata, inits);
    }

    public QRule(Class<? extends Rule> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.degree = inits.isInitialized("degree") ? new QDegree(forProperty("degree")) : null;
        this.track = inits.isInitialized("track") ? new QTrack(forProperty("track"), inits.get("track")) : null;
    }

}

