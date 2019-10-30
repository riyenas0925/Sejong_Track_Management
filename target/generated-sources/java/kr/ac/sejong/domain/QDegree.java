package kr.ac.sejong.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDegree is a Querydsl query type for Degree
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDegree extends EntityPathBase<Degree> {

    private static final long serialVersionUID = 1875650493L;

    public static final QDegree degree = new QDegree("degree");

    public final NumberPath<Long> degreeId = createNumber("degreeId", Long.class);

    public final StringPath degreeTitle = createString("degreeTitle");

    public QDegree(String variable) {
        super(Degree.class, forVariable(variable));
    }

    public QDegree(Path<? extends Degree> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDegree(PathMetadata metadata) {
        super(Degree.class, metadata);
    }

}

