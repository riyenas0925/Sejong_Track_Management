package kr.ac.sejong.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUniv is a Querydsl query type for Univ
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUniv extends EntityPathBase<Univ> {

    private static final long serialVersionUID = -1083565385L;

    public static final QUniv univ = new QUniv("univ");

    public final NumberPath<Long> univId = createNumber("univId", Long.class);

    public final NumberPath<Long> univNo = createNumber("univNo", Long.class);

    public final StringPath univTitle = createString("univTitle");

    public QUniv(String variable) {
        super(Univ.class, forVariable(variable));
    }

    public QUniv(Path<? extends Univ> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUniv(PathMetadata metadata) {
        super(Univ.class, metadata);
    }

}

