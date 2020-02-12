<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="include/setting-h.jsp" %>

<div class="main-content" id="top">
    <!--header -->
    <%@ include file="include/header.jsp" %>

    <div class="header pb-8 pt-5 pt-md-7">
        <div class="container-fluid">
            <div class="header-body">
                <div class="row">
                    <div class="col-12 ct-content">
                        <div class="ct-page-title">
                            <h1 class="ct-title">error page</h1>
                        </div>
                        <p class="ct-lead">${exceptionData.getMessage()}</p>
                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container-fluid mt--7">
        <div class="row">
            <c:forEach items="${exceptionData.getStackTrace()}" var="stack">
                <li>${stack.toString()}</li>
            </c:forEach>
        </div>
    </div>
</div>
<%@ include file="include/setting-f.jsp" %>

<script>
    jQuery(document).ready(function(){
        var navBg = $('#navbar-main');

        navBg.addClass('bg-gradient-primary-1');
    });
</script>