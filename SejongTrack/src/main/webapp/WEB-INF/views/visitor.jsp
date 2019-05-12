<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<%--head.jsp--%>
<%@ include file="include/head.jsp" %>

<%-- Main Header --%>
<%@ include file="include/main-header.jsp" %>

<%-- Left side column. contains the logo and sidebar --%>
<%@ include file="include/main-sidebar.jsp" %>

<script src="https://www.chartjs.org/dist/2.8.0/Chart.min.js"></script>
<script src="https://www.chartjs.org/samples/latest/utils.js"></script>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            접속자 통계
            <small>Sejong univ Track</small>
        </h1>
    </section>
    <%-- Main content --%>
    <section class="content container-fluid">
        <div class="row">
            <div class="col-lg-3 col-xs-6">
                <!-- small box -->
                <div class="small-box bg-aqua">
                    <div class="inner">
                        <h3 id="today"></h3>

                        <p>오늘 접속자 수</p>
                    </div>
                    <div class="icon">
                        <i class="ion ion-person-add"></i>
                    </div>
                </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-3 col-xs-6">
                <!-- small box -->
                <div class="small-box bg-green">
                    <div class="inner">
                        <h3 id="total"></h3>

                        <p>전체 접속자 수</p>
                    </div>
                    <div class="icon">
                        <i class="ion ion-plus"></i>
                    </div>
                </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-3 col-xs-6">
                <!-- small box -->
                <div class="small-box bg-yellow">
                    <div class="inner">
                        <h3 id="todayTrack"></h3>
                        <p>오늘 트랙 현황 조회 수</p>
                    </div>
                    <div class="icon">
                        <i class="ion ion-stats-bars"></i>
                    </div>
                </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-3 col-xs-6">
                <!-- small box -->
                <div class="small-box bg-red">
                    <div class="inner">
                        <h3 id="allTrack"></h3>
                        <p>전체 트랙 현황 조회 수</p>
                    </div>
                    <div class="icon">
                        <i class="ion ion-pie-graph"></i>
                    </div>
                </div>
            </div>
            <!-- ./col -->
        </div>
        <!-- /.row -->
        <!-- Main row -->
        <div class="row">
            <div class="col-md-6">
                <!-- AREA CHART -->
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <i class="fa fa-bar-chart-o"></i>

                        <h3 class="box-title">주간 접속자</h3>

                        <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                            </button>
                        </div>
                    </div>
                    <div class="box-body">
                        <div class="chart">
                            <canvas id="areaChart" style="height:250px"></canvas>
                        </div>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
            <div class="col-md-6">
                <!-- DONUT CHART -->
                <div class="box box-danger">
                    <div class="box-header with-border">
                        <i class="fa fa-bar-chart-o"></i>

                        <h3 class="box-title">브라우저</h3>

                        <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                            </button>
                        </div>
                    </div>
                    <div class="box-body">
                        <div id="canvas-holder">
                            <canvas id="chart-area"></canvas>
                        </div>
                    </div>
                    <!-- /.box-body -->
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
        </div>
        <%-- /.content --%>
</div>
<%-- /.content-wrapper --%>

<%-- Main Footer --%>
<%@ include file="include/main-footer.jsp" %>

</div>
<%-- ./wrapper --%>

<%@ include file="include/plugins.jsp" %>
</body>

<style>
    canvas{
        -moz-user-select: none;
        -webkit-user-select: none;
        -ms-user-select: none;
    }
</style>

<script language="JavaScript">
    $(document).ready(function () {
        getCount();

        function getCount() {

            $.getJSON("/statusAjax/count", function (data) {
                var str = "";

                $("#today").text(data[0]);
                $("#total").text(data[1]);
                $("#todayTrack").text(data[2]);
                $("#allTrack").text(data[3]);
            });
        }
    });

    var Doughnutconfig = {
        type: 'doughnut',
        data: {
            datasets: [{
                data: [
                    randomScalingFactor(),
                    randomScalingFactor(),
                    randomScalingFactor(),
                    randomScalingFactor(),
                    randomScalingFactor(),
                ],
                backgroundColor: [
                    window.chartColors.red,
                    window.chartColors.orange,
                    window.chartColors.yellow,
                    window.chartColors.green,
                    window.chartColors.blue,
                ],
                label: 'Dataset 1'
            }],
            labels: [
                'Red',
                'Orange',
                'Yellow',
                'Green',
                'Blue'
            ]
        },
        options: {
            responsive: true,
            legend: {
                position: 'top',
            },
            animation: {
                animateScale: true,
                animateRotate: true
            }
        }
    };

    var Lineconfig = {
        type: 'line',
        data: {
            labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
            datasets: [{
                label: '오늘 접속자 수',
                fill: false,
                backgroundColor: window.chartColors.blue,
                borderColor: window.chartColors.blue,
                data: [
                    randomScalingFactor(),
                    randomScalingFactor(),
                    randomScalingFactor(),
                    randomScalingFactor(),
                    randomScalingFactor(),
                    randomScalingFactor(),
                    randomScalingFactor()
                ],
            }, {
                label: '오늘 트랙 현황 조회 수',
                fill: false,
                backgroundColor: window.chartColors.orange,
                borderColor: window.chartColors.orange,
                data: [
                    randomScalingFactor(),
                    randomScalingFactor(),
                    randomScalingFactor(),
                    randomScalingFactor(),
                    randomScalingFactor(),
                    randomScalingFactor(),
                    randomScalingFactor()
                ]
            }]
        },
        options: {
            responsive: true,
            title: {
                display: false,
                text: 'Chart.js Line Chart'
            },
            tooltips: {
                mode: 'index',
                intersect: false,
            },
            hover: {
                mode: 'nearest',
                intersect: true
            },
            scales: {
                xAxes: [{
                    display: true,
                    scaleLabel: {
                        display: false,
                        labelString: 'Day'
                    }
                }],
                yAxes: [{
                    display: true,
                    scaleLabel: {
                        display: false,
                        labelString: 'Count'
                    }
                }]
            }
        }
    };

    window.onload = function() {
        var ctx1 = document.getElementById('areaChart').getContext('2d');
        var ctx2 = document.getElementById('chart-area').getContext('2d');

        window.myLine = new Chart(ctx1, Lineconfig);
        window.myDoughnut = new Chart(ctx2, Doughnutconfig);

        window.myDoughnut.options.circumference = Math.PI;
        window.myDoughnut.options.rotation = -Math.PI;
        window.myDoughnut.update();
    };
</script>
</html>