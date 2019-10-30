package kr.ac.sejong.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTrack is a Querydsl query type for Track
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTrack extends EntityPathBase<Track> {

    private static final long serialVersionUID = 768398906L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTrack track = new QTrack("track");

    public final NumberPath<Long> trackId = createNumber("trackId", Long.class);

    public final NumberPath<Long> trackNo = createNumber("trackNo", Long.class);

    public final ListPath<TrackSubject, QTrackSubject> trackSubjects = this.<TrackSubject, QTrackSubject>createList("trackSubjects", TrackSubject.class, QTrackSubject.class, PathInits.DIRECT2);

    public final StringPath trackTitle = createString("trackTitle");

    public final QUniv univ;

    public QTrack(String variable) {
        this(Track.class, forVariable(variable), INITS);
    }

    public QTrack(Path<? extends Track> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTrack(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTrack(PathMetadata metadata, PathInits inits) {
        this(Track.class, metadata, inits);
    }

    public QTrack(Class<? extends Track> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.univ = inits.isInitialized("univ") ? new QUniv(forProperty("univ")) : null;
    }

}

