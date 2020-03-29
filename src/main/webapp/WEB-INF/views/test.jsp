<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="include/setting-h.jsp" %>
<!--sidebar -->
<%@ include file="include/sidebar.jsp" %>
<div class="main-content">
    <!--header -->
    <%@ include file="include/header.jsp" %>

    <div class="header bg-gradient-primary pb-8 pt-5 pt-md-8">
        <div class="container-fluid">
            <div class="header-body">
                <div class="row">
                    <h1>${userModel.name}님의<br></h1>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid mt--7">
        <div class="row">
            <div class="col-xl-8 mb-5 mb-xl-0">

            </div>
            <div class="col-xl-4">

            </div>
        </div>
        <div class="row mt-5">

        </div>
        <!-- footer -->
        <%@ include file="include/footer.jsp" %>
    </div>
</div>
<%@ include file="include/setting-f.jsp" %>

<script>
    sidebar();

    function sidebar(){
        $('.side').removeClass('active');
        $('#5').addClass('active');
    }
</script>