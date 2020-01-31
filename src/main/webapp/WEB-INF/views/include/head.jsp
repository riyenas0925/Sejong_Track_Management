<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- try for ajax call ... 403 error By security csrf token -->
    <meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>
    <!-- try for ajax call ... 403 error By security csrf token -->


    <title>Sejong Track</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="plugins/iCheck/square/blue.css">
    <!-- Morris chart -->
    <link rel="stylesheet" href="bower_components/morris.js/morris.css">
    <!-- jvectormap -->
    <link rel="stylesheet" href="bower_components/jvectormap/jquery-jvectormap.css">
    <!-- Date Picker -->
    <link rel="stylesheet" href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="bower_components/bootstrap-daterangepicker/daterangepicker.css">
    <!-- bootstrap wysihtml5 - text editor -->
    <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <!-- toastr -->
    <link rel="stylesheet" href="plugins/toastr/toastr.css"/>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

    <link rel="stylesheet" href="plugins/pace/pace.min.css">

    <style>
        th {
            background-color: #f9f9f9;
        }

        .tbl_hover:hover {
            background-color: #f8d2d8;
            font-weight: bold;
        }

        .btn-hover {
            width: 125px;
            font-size: 16px;
            font-weight: 600;
            color: #fff;
            cursor: pointer;
            height: 55px;
            text-align: center;
            border: none;
            background-size: 300% 100%;

            border-radius: 50px;
            moz-transition: all .4s ease-in-out;
            -o-transition: all .4s ease-in-out;
            -webkit-transition: all .4s ease-in-out;
            transition: all .4s ease-in-out;
        }

        .btn-hover:hover {
            background-position: 100% 0;
            moz-transition: all .4s ease-in-out;
            -o-transition: all .4s ease-in-out;
            -webkit-transition: all .4s ease-in-out;
            transition: all .4s ease-in-out;
        }

        .btn-hover:focus {
            outline: none;
        }

        .btn-hover.color-1 {
            background-image: linear-gradient(to right, #25aae1, #40e495, #30dd8a, #2bb673);
            box-shadow: 0 4px 15px 0 rgba(49, 196, 190, 0.75);
        }

        .btn-hover.color-3 {
            background-image: linear-gradient(to right, #667eea, #764ba2, #6B8DD6, #8E37D7);
            box-shadow: 0 4px 15px 0 rgba(116, 79, 168, 0.75);
        }

        .btn-hover.color-4 {
            background-image: linear-gradient(to right, #fc6076, #ff9a44, #ef9d43, #e75516);
            box-shadow: 0 4px 15px 0 rgba(252, 104, 110, 0.75);
        }

        .btn-hover.color-9 {
            background-image: linear-gradient(to right, #25aae1, #4481eb, #04befe, #3f86ed);
            box-shadow: 0 4px 15px 0 rgba(65, 132, 234, 0.75);
        }

        #home-btn1 {
            margin-bottom: 20px;
        }

        #home-btn2 {
            margin-bottom: 20px;
        }

        .btn-nav1 {
            width: 80px;
            height: 80px;
            border-radius: 40px;
            background-color: #f56954;
            box-shadow: 0 4px 15px 0 rgba(45, 54, 65, 0.75);
            font-size: 16px;
            font-weight: 600;
            color: #fff;
            cursor: pointer;
            border: none;
        }

        .btn-nav2 {
            width: 80px;
            height: 80px;
            border-radius: 40px;
            background-color: #f39c12;
            box-shadow: 0 4px 15px 0 rgba(45, 54, 65, 0.75);
            font-size: 16px;
            font-weight: 600;
            color: #fff;
            cursor: pointer;
            border: none;
        }

        .nav-rb1 {
            z-index: 1;
            position: fixed;
            bottom: 120px;
            right: 20px;
        }

        .nav-rb2 {
            z-index: 1;
            position: fixed;
            bottom: 20px;
            right: 20px;
        }
    </style>

    <%@ include file="../include/plugins.jsp" %>

    <script type="text/javascript">

        function go(text) {
            location.href = text;
            target: _self;
        }
        $(document).ready(function (){
            var userState = sessionStorage.getItem(sessionState);

            if(userState == 'timeout') {
                alert('세션이 만료되었습니다. 로그인 후 이용하세요.');
            }
        });
    </script>
</head>
