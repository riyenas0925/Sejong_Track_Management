<<<<<<< HEAD
﻿# Sejong-Track-Management-Spring
세종대학교 트랙관리 프로그램 Spring  

### 프로젝트 받아서 application run시켰는데 안될때?  
오른쪽 maven열어서 -> plugins -> spring-boot의 run 실행  
**(이때 application run했던건 다 중지시킨 후 실행해야됨. <i>안그러면 안먹힘</i>)**

### 기능 개발 전 '이슈 등록'하기!!!

### Todo    
- [ ] travis-CI, heroku 사용법 익히기
- [ ] Ajax, jquery공부<br>
   - [ ] ~~```<a href>```에서 컨트롤러 이용하지 않고 페이지 로드~~(**페이지로드는 해야될것같음**)
   - [x] id중복확인 버튼 만들기
   - [ ] 로그인 페이지 만들기
      - [x] idCheck()아이디 체크
      - [ ] emailCheck()이메일 형식 체크
      - [ ] pwCheck() 비밀번호 형식 체크
   - [ ] 로딩바 만들기

<hr>

ENH: (Enhancement) 개선하거나 신기능 추가    
BUG: 버그 수정    
DOC: (Documentation) 문서화 관련된 작업    
TST: (Test) 새로운 유닛테스트를 추가하거나 기존 테스트를 수정   
PERF: (Performance) 계산 속도의 개선과 관련된 작업   
CLN: (Cleanup) 코드를 정리하거나 리팩토링한 작업   
<hr>
Hibernate: 
    
    create table tbl_degree (
       degreeId bigint not null auto_increment,
        degreeTitle varchar(255),
        primary key (degreeId)
    ) engine=InnoDB
Hibernate: 
    
    create table tbl_member (
       id varchar(255) not null,
        email varchar(255),
        name varchar(255),
        password varchar(255),
        regdate datetime,
        updatedate datetime,
        primary key (id)
    ) engine=InnoDB
Hibernate: 
    
    create table tbl_member_role (
       roleId bigint not null auto_increment,
        roleName varchar(255),
        member varchar(255),
        primary key (roleId)
    ) engine=InnoDB
Hibernate: 
    
    create table tbl_rule (
       ruleId bigint not null auto_increment,
        appliedCredit bigint,
        basicCredit bigint,
        industryCredit bigint,
        degreeId bigint,
        trackId bigint,
        primary key (ruleId)
    ) engine=InnoDB
Hibernate: 
    
    create table tbl_subject (
       subjectId bigint not null auto_increment,
        subjectCredit bigint,
        subjectNo bigint,
        subjectTitle varchar(255),
        primary key (subjectId)
    ) engine=InnoDB
Hibernate: 
    
    create table tbl_track (
       trackId bigint not null auto_increment,
        trackNo bigint,
        trackTitle varchar(255),
        univId bigint,
        primary key (trackId)
    ) engine=InnoDB
Hibernate: 
    
    create table tbl_track_log (
       logId bigint not null auto_increment,
        logDate datetime,
        primary key (logId)
    ) engine=InnoDB
Hibernate: 
    
    create table tbl_track_subject (
       trackSubjectId bigint not null auto_increment,
        subjectType bigint,
        subjectId bigint,
        trackId bigint,
        primary key (trackSubjectId)
    ) engine=InnoDB
Hibernate: 
    
    create table tbl_univ (
       univId bigint not null auto_increment,
        univNo bigint,
        univTitle varchar(255),
        primary key (univId)
    ) engine=InnoDB
Hibernate: 
    
    alter table tbl_member_role 
       add constraint FKfq8gs22gq5tfr888j0q6tocoq 
       foreign key (member) 
       references tbl_member (id)
Hibernate: 
    
    alter table tbl_rule 
       add constraint FKhk2waak8e6dass3dawthm1hvb 
       foreign key (degreeId) 
       references tbl_degree (degreeId)
Hibernate: 
    
    alter table tbl_rule 
       add constraint FKknna43iyerbbavqnjh6kye0bl 
       foreign key (trackId) 
       references tbl_track (trackId)
Hibernate: 
    
    alter table tbl_track 
       add constraint FKhfbdsfi4tp076vwf57wpfauoi 
       foreign key (univId) 
       references tbl_univ (univId)
Hibernate: 
    
    alter table tbl_track_subject 
       add constraint FKd5dwdnic0axnu21012v4g7t20 
       foreign key (subjectId) 
       references tbl_subject (subjectId)
Hibernate: 
    
    alter table tbl_track_subject 
       add constraint FK6luhn2k0820kyput10wmbcop4 
       foreign key (trackId) 
       references tbl_track (trackId)
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
=======
# Sejong-Track-Management-Spring [![Build Status](https://travis-ci.org/riyenas0925/Project-Sejong-Track-Management.svg?branch=develop)](https://travis-ci.org/riyenas0925/Project-Sejong-Track-Management)
세종대학교 트랙관리 프로그램 Spring
>>>>>>> c2d67ee2035099b0cc24a3030c2870ae7504b13b
