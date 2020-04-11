-- Univ
INSERT INTO univ(id, univNo, title) VALUES (1, 1000, '소프트웨어융합대학');
INSERT INTO univ(id, univNo, title) VALUES (2, 1001, '무인기융합대학원');

-- Track
INSERT INTO track(id, trackNo, title, univId) VALUES (1, 2000, 'HCI&비쥬얼컴퓨팅', 1);
INSERT INTO track(id, trackNo, title, univId) VALUES (2, 2001, '멀티미디어', 1);
INSERT INTO track(id, trackNo, title, univId) VALUES (3, 2002, '사물인터넷', 1);
INSERT INTO track(id, trackNo, title, univId) VALUES (4, 2003, '시스템응용', 1);
INSERT INTO track(id, trackNo, title, univId) VALUES (5, 2004, '인공지능', 1);
INSERT INTO track(id, trackNo, title, univId) VALUES (6, 2005, '가상현실', 1);
INSERT INTO track(id, trackNo, title, univId) VALUES (7, 2006, '정보보호', 1);
INSERT INTO track(id, trackNo, title, univId) VALUES (8, 2007, '데이터사이언스', 1);
INSERT INTO track(id, trackNo, title, univId) VALUES (9, 2008, 'SW교육', 1);
INSERT INTO track(id, trackNo, title, univId) VALUES (10, 2009, '사이버국방', 1);
INSERT INTO track(id, trackNo, title, univId) VALUES (11, 2010, '무인기 시스템 트랙', 2);
INSERT INTO track(id, trackNo, title, univId) VALUES (12, 2011, '무인기 소프트웨어 트랙', 2);

-- CourseSchedule
INSERT INTO course_schedule(id, name) VALUES(1, '소프트웨어융합대학 트랙');
INSERT INTO course_schedule(id, name) VALUES(2, '무인기융합대학원 트랙');

-- Course
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (1, 3, '000001', '선형대수및프로그래밍', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (2, 3, '000002', '컴퓨터그래픽스', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (3, 3, '000003', '웹프로그래밍', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (4, 3, '000004', '영상처리', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (5, 3, '000005', 'HCI개론', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (6, 3, '000006', '웹프로그래밍설계', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (7, 3, '000007', '웹기반시스템', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (8, 3, '000008', '윈도우즈프로그래밍', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (9, 3, '000009', 'XML 프로그래밍', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (10, 3, '000010', '데이터컴퓨팅', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (11, 3, '000011', '정보검색', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (12, 3, '000012', '가상현실', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (13, 3, '000013', '멀티미디어', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (14, 3, '000014', '선형대수및프로그래밍', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (15, 3, '000015', '통계학개론', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (16, 3, '000016', '신호및시스템', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (17, 3, '000017', '디지털신호처리', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (18, 3, '000018', '멀티미디어데이터베이스', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (19, 3, '000019', '패턴인식', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (20, 3, '000020', '컴퓨터비젼시스템', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (21, 3, '000021', '영상처리', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (22, 3, '000022', '영상처리프로그래밍', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (23, 3, '000023', '모바일프로그래밍', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (24, 3, '000024', '가상현실', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (25, 3, '000025', '컴퓨터네트워크', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (26, 3, '000026', '신호및시스템', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (27, 3, '000027', '확률통계및프로그래밍', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (28, 3, '000028', '통신시스템', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (29, 3, '000029', '디지털신호처리', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (30, 3, '000030', '임베디드시스템', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (31, 3, '000031', '네트워크프로그래밍', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (32, 3, '000032', '정보보호개론', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (33, 3, '000033', '데이터통신', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (34, 3, '000034', '무선통신', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (35, 3, '000035', '스마트그리드', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (36, 3, '000036', '인터넷보안', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (37, 3, '000037', '지능형시스템', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (38, 3, '000038', '멀티코어프로그래밍', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (39, 3, '000039', '디지털시스템', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (40, 3, '000040', '마이크로컴퓨터', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (41, 3, '000041', 'VHDL프로그래밍', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (42, 3, '000042', '데이터베이스', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (43, 3, '000043', '프로그래밍언어의개념', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (44, 3, '000044', '소프트웨어공학', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (45, 3, '000045', '멀티코어프로그래밍', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (46, 3, '000046', '시스템모델링', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (47, 3, '000047', '분산시스템', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (48, 3, '000048', '컴파일러', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (49, 3, '000049', 'UNIX프로그래밍', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (50, 3, '000050', '임베디드시스템', 1);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (51, 3, '000051', '멀티미디어프로그래밍', 1);

INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (52, 3, '000052', '실시간 시뮬레이션 특론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (53, 3, '000053', '항법제어 특론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (54, 3, '000054', '선형제어론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (55, 3, '000055', '항법전자 특론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (56, 3, '000056', 'Matlab을 이용한 공학문제 프로그래밍(수학과)', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (57, 3, '000057', '유도제어시스템 설계', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (58, 3, '000058', '드론코드 특론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (59, 3, '000059', '응용공기역학 특론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (60, 3, '000060', '진동학 특론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (61, 3, '000061', '회전익 공기역학 특론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (62, 3, '000062', '비선형제어론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (63, 3, '000063', '확률 최적추정론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (64, 3, '000064', '공력설계 최적화', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (65, 3, '000065', '모델링 및 시뮬레이션', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (66, 3, '000066', '패턴인식특론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (67, 3, '000067', '디지털 영상처리 개론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (68, 3, '000068', '고급 컴퓨터 비젼', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (69, 3, '000069', '시각적 데이터 분석', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (70, 3, '000070', '센서 및 엑츄에이터', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (71, 3, '000071', '데이터 시각화', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (72, 3, '000072', '디지털 영상처리 특론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (73, 3, '000073', '인터랙티브 그래픽스 특론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (74, 3, '000074', '비쥬얼 컴퓨팅 특론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (75, 3, '000075', '고급패턴인식', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (76, 3, '000076', '멀티미디어응용 특론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (77, 3, '000077', '고급증강현실 특론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (78, 3, '000078', '실시간렌더링 특론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (79, 3, '000079', '가상현실 특론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (80, 3, '000080', '항법유도제어 특론', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (81, 3, '000081', '산학공동 세미나', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (82, 3, '000082', '산학공동 PBL 1', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (83, 3, '000083', '산학공동 PBL 2', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (84, 3, '000084', '산학공동 워크숍', 2);
INSERT INTO course (id, credit, courseNo, title, courseScheduleId) VALUES (85, 3, '000085', '산업체 전문가 특강', 2);

-- TrackCourse
-- Track - HCI & Visual Computing
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('BASIC', 1, 1);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('BASIC', 2, 1);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('BASIC', 3, 1);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 4, 1);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 5, 1);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 6, 1);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 7, 1);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 8, 1);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 9, 1);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 12, 1);

-- Track - Multimedia
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('BASIC', 13, 2);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('BASIC', 14, 2);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('BASIC', 15, 2);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 16, 2);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 17, 2);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 18, 2);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 19, 2);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 20, 2);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 21, 2);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 21, 2);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 22, 2);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 23, 2);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 24, 2);

-- Track - Cyber Defense
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 20, 10);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 21, 10);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 22, 10);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 23, 10);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 24, 10);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 25, 10);

-- Track - Drone System
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('BASIC', 52, 11);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('BASIC', 53, 11);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('BASIC', 54, 11);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('BASIC', 55, 11);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('BASIC', 56, 11);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('BASIC', 57, 11);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 58, 11);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 59, 11);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 60, 11);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('APPLIED', 61, 11);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('EXPERT', 62, 11);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('EXPERT', 63, 11);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('EXPERT', 64, 11);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('EXPERT', 65, 11);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('COMMON', 81, 11);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('COMMON', 82, 11);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('COMMON', 83, 11);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('COMMON', 84, 11);
INSERT INTO track_course(courseType, courseId, trackId) VALUES ('COMMON', 85, 11);

-- Degree
INSERT INTO degree(id, title) VALUES (1, '학사');
INSERT INTO degree(id, title) VALUES (2, '석사');
INSERT INTO degree(id, title) VALUES (3, '박사');
INSERT INTO degree(id, title) VALUES (4, '학석사');
INSERT INTO degree(id, title) VALUES (5, '석박사');

-- Rule
INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (9, 'BASIC', 1, 1);
INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (18, 'APPLIED', 1, 1);

INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (9, 'BASIC', 2, 1);
INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (18, 'APPLIED', 2, 1);

INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (18, 'APPLIED', 10, 1);

INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (6, 'BASIC', 11, 2);
INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (6, 'APPLIED', 11, 2);
INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (6, 'EXPERT', 11, 2);
INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (15, 'COMMON', 11, 2);

INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (6, 'BASIC', 11, 3);
INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (9, 'APPLIED', 11, 3);
INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (9, 'EXPERT', 11, 3);
INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (15, 'COMMON', 11, 3);

INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (6, 'BASIC', 11, 4);
INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (9, 'APPLIED', 11, 4);
INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (8, 'EXPERT', 11, 4);
INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (15, 'COMMON', 11, 4);

INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (6, 'BASIC', 11, 5);
INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (12, 'APPLIED', 11, 5);
INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (9, 'EXPERT', 11, 5);
INSERT INTO rule(credit, courseType, trackId, degreeId) VALUES (15, 'COMMON', 11, 5);


-- Member
INSERT INTO member(id,userId, email, name, password,major, univ) VALUES (1,'student','k@h.com', '김학생', '{bcrypt}$2a$10$aI/58n6pbSK6r0uplO82Pe3QT7xiquclSXQXFrDjz3jD/FvGz3BRG','정치외교학과','소프트웨어융합대학');
INSERT INTO member(id,userId, email, name, password,major, univ) VALUES (2,'pro','k@n', '김교수', '{bcrypt}$2a$10$aI/58n6pbSK6r0uplO82Pe3QT7xiquclSXQXFrDjz3jD/FvGz3BRG','김치배달학과','모르는대학');
INSERT INTO member(id,userId, email, name, password,major, univ) VALUES (3,'admin','k@g', '김관리자', '{bcrypt}$2a$10$aI/58n6pbSK6r0uplO82Pe3QT7xiquclSXQXFrDjz3jD/FvGz3BRG','바둑공학과','예체대학');

-- Member Role
INSERT INTO member_role(role_enum, memberId) VALUES ('ROLE_STUDENT', 1);
INSERT INTO member_role(role_enum, memberId) VALUES ('ROLE_PRO', 2);
INSERT INTO member_role(role_enum, memberId) VALUES ('ROLE_ADMIN', 3);

-- JudgeLog
INSERT INTO judge_log(id, percent, pnp, memberId, trackId) VALUES(1, 44, 0, 1,1);
INSERT INTO judge_log(id, percent, pnp, memberId, trackId) VALUES(1, 60, 0, 1,2);
INSERT INTO judge_log(id, percent, pnp, memberId, trackId) VALUES(1, 70, 0, 1,3);
