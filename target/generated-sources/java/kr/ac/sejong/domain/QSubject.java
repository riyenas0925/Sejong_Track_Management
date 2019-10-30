package kr.ac.sejong.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubject is a Querydsl query type for Subject
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSubject extends EntityPathBase<Subject> {

    private static final long serialVersionUID = -1103512997L;

    public static final QSubject subject = new QSubject("subject");

    public final NumberPath<Long> subjectCredit = createNumber("subjectCredit", Long.class);

    public final NumberPath<Long> subjectId = createNumber("subjectId", Long.class);

    public final NumberPath<Long> subjectNo = createNumber("subjectNo", Long.class);

    public final StringPath subjectTitle = createString("subjectTitle");

    public final ListPath<TrackSubject, QTrackSubject> trackSubjects = this.<TrackSubject, QTrackSubject>createList("trackSubjects", TrackSubject.class, QTrackSubject.class, PathInits.DIRECT2);

    public QSubject(String variable) {
        super(Subject.class, forVariable(variable));
    }

    public QSubject(Path<? extends Subject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubject(PathMetadata metadata) {
        super(Subject.class, metadata);
    }

}

