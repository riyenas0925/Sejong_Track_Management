<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Sejong Track</title>

    <!-- try for ajax call ... 403 error By security csrf token -->
    <meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>

    <!-- toastr -->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" />
    <!-- Favicon -->
    <link href="../resources/img/brand/favicon.png" rel="icon" type="image/png">
    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
    <!-- Icons -->
    <link href="../resources/js/plugins/nucleo/css/nucleo.css" rel="stylesheet" />
    <link href="../resources/js/plugins/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet" />
    <!-- CSS Files -->
    <link href="https://d2yq4mgd7yd6ui.cloudfront.net/css/argon-dashboard.css?v=1.1.1" rel="stylesheet" />

    <style>
        .wrap-loading{ /*화면 전체를 어둡게 합니다.*/
            position: fixed;
            left:0;
            right:0;
            top:0;
            bottom:0;
            background: rgba(0,0,0,0.2); /*not in ie */
            filter: progid:DXImageTransform.Microsoft.Gradient(startColorstr='#20000000',endColorstr='#20000000');    /* ie */
            z-index:999999;
        }

        .wrap-loading div{ /*로딩 이미지*/
            position: fixed;
            top:20%;
            width:100%;
            text-align:center;
            z-index:999999;
        }
        .display-none{ /*감추기*/
            display:none;
        }
    </style>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body class="">