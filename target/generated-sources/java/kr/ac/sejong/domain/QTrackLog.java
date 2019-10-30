package kr.ac.sejong.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTrackLog is a Querydsl query type for TrackLog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTrackLog extends EntityPathBase<TrackLog> {

    private static final long serialVersionUID = -803802454L;

    public static final QTrackLog trackLog = new QTrackLog("trackLog");

    public final DateTimePath<java.sql.Timestamp> logDate = createDateTime("logDate", java.sql.Timestamp.class);

    public final NumberPath<Long> logId = createNumber("logId", Long.class);

    public QTrackLog(String variable) {
        super(TrackLog.class, forVariable(variable));
    }

    public QTrackLog(Path<? extends TrackLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTrackLog(PathMetadata metadata) {
        super(TrackLog.class, metadata);
    }

}

