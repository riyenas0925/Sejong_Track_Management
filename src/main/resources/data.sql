INSERT INTO tbl_univ(univNo, univTitle) VALUES (1000, '소프트웨어융합대학');

INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2000, 'HCI&비쥬얼컴퓨팅', 1);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2001, '멀티미디어', 1);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2002, '사물인터넷', 1);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2003, '시스템응용', 1);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2004, '인공지능', 1);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2005, '가상현실', 1);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2006, '정보보호', 1);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2007, '데이터사이언스', 1);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2008, 'SW교육', 1);
INSERT INTO tbl_track(trackNo, trackTitle, univId) VALUES (2009, '사이버국방', 1);

INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003001', '시험 과목 1');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003002', '시험 과목 2');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003003', '시험 과목 3');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003004', '시험 과목 4');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003005', '시험 과목 5');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003006', '시험 과목 6');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003007', '시험 과목 7');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003008', '시험 과목 8');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003009', '시험 과목 9');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003010', '시험 과목 10');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003011', '시험 과목 11');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003012', '시험 과목 12');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003013', '시험 과목 13');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003014', '시험 과목 14');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003015', '시험 과목 15');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003016', '시험 과목 16');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003017', '시험 과목 17');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003018', '시험 과목 18');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003019', '시험 과목 19');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003020', '시험 과목 20');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003021', '시험 과목 21');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003022', '시험 과목 22');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003023', '시험 과목 23');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003024', '시험 과목 24');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003025', '시험 과목 25');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003026', '시험 과목 26');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003027', '시험 과목 27');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003028', '시험 과목 28');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003029', '시험 과목 29');
INSERT INTO tbl_subject(credit, courseNum, courseTitle) VALUES (3, '003030', '시험 과목 30');

INSERT INTO tbl_degree(degreeTitle) VALUES ('학사');
INSERT INTO tbl_degree(degreeTitle) VALUES ('석사');
INSERT INTO tbl_degree(degreeTitle) VALUES ('박사');
INSERT INTO tbl_degree(degreeTitle) VALUES ('학석사');
INSERT INTO tbl_degree(degreeTitle) VALUES ('석박사');

INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('BASIC', 1, 1);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('BASIC', 2, 1);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('BASIC', 3, 1);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 4, 1);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 5, 1);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 6, 1);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 7, 1);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 8, 1);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 9, 1);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 10, 1);

INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('BASIC', 11, 2);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('BASIC', 12, 2);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('BASIC', 13, 2);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 14, 2);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 15, 2);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 16, 2);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 17, 2);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 18, 2);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 19, 2);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 20, 2);

INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('BASIC', 21, 3);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('BASIC', 22, 3);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('BASIC', 23, 3);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 24, 3);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 25, 3);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 26, 3);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 27, 3);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 28, 3);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 29, 3);
INSERT INTO tbl_track_subject(subjectType, subjectId, trackId) VALUES ('APPLIED', 30, 3);

INSERT INTO tbl_rule(basicCredit, appliedCredit, industryCredit, degreeId, trackId) VALUES (9,18,0,1,1);
INSERT INTO tbl_rule(basicCredit, appliedCredit, industryCredit, degreeId, trackId) VALUES (9,18,0,1,2);
INSERT INTO tbl_rule(basicCredit, appliedCredit, industryCredit, degreeId, trackId) VALUES (9,18,0,1,3);
INSERT INTO tbl_rule(basicCredit, appliedCredit, industryCredit, degreeId, trackId) VALUES (9,18,0,1,4);
INSERT INTO tbl_rule(basicCredit, appliedCredit, industryCredit, degreeId, trackId) VALUES (9,18,0,1,5);
INSERT INTO tbl_rule(basicCredit, appliedCredit, industryCredit, degreeId, trackId) VALUES (9,18,0,1,6);
INSERT INTO tbl_rule(basicCredit, appliedCredit, industryCredit, degreeId, trackId) VALUES (9,18,0,1,7);
INSERT INTO tbl_rule(basicCredit, appliedCredit, industryCredit, degreeId, trackId) VALUES (9,18,0,1,8);
INSERT INTO tbl_rule(basicCredit, appliedCredit, industryCredit, degreeId, trackId) VALUES (9,18,0,1,9);
INSERT INTO tbl_rule(basicCredit, appliedCredit, industryCredit, degreeId, trackId) VALUES (24,0,0,1,10);

INSERT INTO tbl_member(memberId, email, name, password) VALUES ('student','k@h.com', '김학생', '{bcrypt}$2a$10$aI/58n6pbSK6r0uplO82Pe3QT7xiquclSXQXFrDjz3jD/FvGz3BRG');
INSERT INTO tbl_member(memberId, email, name, password) VALUES ('pro','k@n', '김교수님', '{bcrypt}$2a$10$aI/58n6pbSK6r0uplO82Pe3QT7xiquclSXQXFrDjz3jD/FvGz3BRG');
INSERT INTO tbl_member(memberId, email, name, password) VALUES ('admin','k@g', '김관리자', '{bcrypt}$2a$10$aI/58n6pbSK6r0uplO82Pe3QT7xiquclSXQXFrDjz3jD/FvGz3BRG');

INSERT INTO tbl_member_role(role_enum, memberId) VALUES ('ROLE_STUDENT', 'student');
INSERT INTO tbl_member_role(role_enum, memberId) VALUES ('ROLE_PRO', 'pro');
INSERT INTO tbl_member_role(role_enum, memberId) VALUES ('ROLE_ADMIN', 'admin');