<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<nav class="navbar navbar-vertical fixed-left navbar-expand-md navbar-light bg-white" id="sidenav-main">
    <div class="container-fluid">
        <!-- Toggler -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#sidenav-collapse-main" aria-controls="sidenav-main" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <!-- Brand -->
        <a class="navbar-brand pt-0" href="./index.html">
            <img src="../resources/img/brand/sejongtrack_blue.png" class="navbar-brand-img" alt="...">
        </a>
        <!-- 모바일 User -->
        <ul class="nav align-items-center d-md-none">
            <li class="nav-item dropdown">
                <a class="nav-link" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <div class="media align-items-center">
                            <span class="avatar avatar-sm rounded-circle">
                                <sec:authorize access="isAuthenticated()">
                                    <img alt="Image placeholder" src="../resources/img/theme/user.png">
                                </sec:authorize>
                                <sec:authorize access="isAnonymous()">
                                    <img alt="Image placeholder" src="../resources/img/theme/logout.png">
                                </sec:authorize>
                            </span>
                    </div>
                </a>
                <div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right">
                    <div class=" dropdown-header noti-title">
                        <sec:authorize access="isAnonymous()">
                        <h6 class="text-overflow m-0">안녕하세요.<br>로그인하세요.</h6>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <h6 class="text-overflow m-0">안녕하세요.<br><sec:authentication property="principal.name"/>님!</h6>
                        </sec:authorize>
                    </div>

                    <sec:authorize access="isAuthenticated()">
                    <a href="${path}/modify" class="dropdown-item">
                        <i class="ni ni-single-02"></i>
                        <span>정보수정</span>
                    </a>
                    </sec:authorize>

                    <div class="dropdown-divider"></div>

                    <div class="dropdown-item">
                        <i class="ni ni-user-run"></i>
                        <sec:authorize access="isAuthenticated()">
                        <span OnClick="location.href='${path}/memberLogout'">Logout</span>
                        </sec:authorize>
                        <sec:authorize access="isAnonymous()">
                        <span OnClick="location.href='${path}/loginView'">Login</span>
                        </sec:authorize>
                    </div>
                </div>

            </li>
        </ul>
        <!-- Collapse -->
        <div class="collapse navbar-collapse" id="sidenav-collapse-main">
            <!-- Collapse header -->
            <div class="navbar-collapse-header d-md-none">
                <div class="row">
                    <div class="col-6 collapse-brand">
                        <a href="./index.html">
                            <img src="../resources/img/brand/sejongtrack_blue.png">
                        </a>
                    </div>
                    <div class="col-6 collapse-close">
                        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#sidenav-collapse-main" aria-controls="sidenav-main" aria-expanded="false" aria-label="Toggle sidenav">
                            <span></span>
                            <span></span>
                        </button>
                    </div>
                </div>
            </div>
            <!-- Navigation -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link  active " href="${path}/">
                        <i class="ni ni-tv-2 text-primary"></i> Home
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="${path}/prepare">
                        <i class="ni ni-planet text-blue"></i> 공지사항
                    </a>
                </li>
                <li class="nav-item">
                    <sec:authorize access="isAuthenticated()">
                    <a class="nav-link" href="${path}/modify">
                        <i class="ni ni-single-02 text-blue"></i> 정보수정
                    </a>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        <a class="nav-link" href="${path}/loginView">
                            <i class="ni ni-single-02 text-blue"></i> 정보수정
                        </a>
                    </sec:authorize>
                </li>

                <hr class="my-3">

                <li class="nav-item">
                    <a class="nav-link " href="${path}/trackAll">
                        <i class="ni ni-single-02 text-yellow"></i> 전체 트랙 보기
                    </a>
                </li>
                <li class="nav-item">
                    <sec:authorize access="isAuthenticated()">
                        <a class="nav-link" href="${path}/uploadForm">
                            <i class="ni ni-bullet-list-67 text-red"></i> 트랙 현황 조회
                        </a>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        <a class="nav-link" href="${path}/loginView">
                            <i class="ni ni-bullet-list-67 text-red"></i> 트랙 현황 조회
                        </a>
                    </sec:authorize>
                </li>
            </ul>
            <!-- Divider -->
            <hr class="my-3">
            <!-- Heading -->
            <h6 class="navbar-heading text-muted">관리자</h6>
            <!-- Navigation -->
            <ul class="navbar-nav mb-md-3">
                <li class="nav-item">
                        <a class="nav-link" href="${path}/prepare">
                            <i class="ni ni-spaceship"></i> 강의시간표 추가
                        </a>
                </li>
                <li class="nav-item">
                        <a class="nav-link" href="${path}/trackrule">
                            <i class="ni ni-palette"></i> 트랙 규칙 수정
                        </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${path}/prepare">
                        <i class="ni ni-ui-04"></i> 트랙 통계
                    </a>
                </li>

                <hr class="my-3">

                <li class="nav-item">
                    <sec:authorize access="isAuthenticated()">
                        <a class="nav-link" style="color:steelblue" href="${path}/memberLogout">로그아웃</a>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        <a class="nav-link" style="color:steelblue" href="${path}/loginView">로그인/회원가입</a>
                    </sec:authorize>
                </li>

            </ul>

        </div>
    </div>
</nav>