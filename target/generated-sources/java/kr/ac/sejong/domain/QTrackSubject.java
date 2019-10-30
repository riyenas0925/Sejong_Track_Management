package kr.ac.sejong.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTrackSubject is a Querydsl query type for TrackSubject
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTrackSubject extends EntityPathBase<TrackSubject> {

    private static final long serialVersionUID = -1390575214L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTrackSubject trackSubject = new QTrackSubject("trackSubject");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QSubject subject;

    public final NumberPath<Long> subjectType = createNumber("subjectType", Long.class);

    public final QTrack track;

    public QTrackSubject(String variable) {
        this(TrackSubject.class, forVariable(variable), INITS);
    }

    public QTrackSubject(Path<? extends TrackSubject> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTrackSubject(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTrackSubject(PathMetadata metadata, PathInits inits) {
        this(TrackSubject.class, metadata, inits);
    }

    public QTrackSubject(Class<? extends TrackSubject> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.subject = inits.isInitialized("subject") ? new QSubject(forProperty("subject")) : null;
        this.track = inits.isInitialized("track") ? new QTrack(forProperty("track"), inits.get("track")) : null;
    }

}

