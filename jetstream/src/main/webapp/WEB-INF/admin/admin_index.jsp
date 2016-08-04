<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr" session="true" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="http://cdn.oesmith.co.uk/morris-0.4.1.min.js"></script>
<title>Insert title here</title>
<!-- 참고 부트스닙 http://bootsnipp.com/snippets/KBNdD -->
<style>
#tab1primary{
 padding : 0px 0px 100px 80px
}
</style>
</head>
<body>

<script type="text/javascript">
$(function(){
    $('.nav-tabs a:first',this.$page).tab('show')
    $('.nav-tabs li:gt(0)',this.$page).each(function(){
        $(this).addClass('disabled');
        $('a',$(this)).attr('data-toggle','');
    });
    
    $('.next-tab').on('click',function(){
        var $panel = $(this).closest('.panel');
        var $tabs = $('.nav-tabs li',$panel);
        var $tab = $('.nav-tabs li.active',$panel);
        var index  = $tabs.index($tab);
        if (index < 0) {
            return; //no hope for you!
        }
        index++;
        var $next_tab = $('a',$tabs.eq(index));
        if (!$next_tab.length) {
            return;
        }
        $next_tab.parents('li').removeClass('disabled');
        $next_tab.attr('data-toggle','tab');
        $next_tab.tab('show');
    });
    $('.previous-tab').on('click',function(){
        var $panel = $(this).closest('.panel');
        var $tabs = $('.nav-tabs li',$panel);
        var $tab = $('.nav-tabs li.active',$panel);
        var index  = $tabs.index($tab);
        if (index < 0) {
            return; //no hope for you!
        }
        index--;
        var $previous_tab = $('a',$tabs.eq(index));
        if (!$previous_tab.length) {
            return;
        }
        $previous_tab.parents('li').removeClass('disabled');
        $previous_tab.data('toggle','tab');
        $previous_tab.tab('show');    });
});
jQuery(document).ready(function($) {
var jsonData = '${datalist}';
var obj = JSON.parse(jsonData);

Morris.Line({
element: 'line-example',
data: obj,
xkey: 'day',
ykeys: ['member_cn','board_cn'],
labels: ['Person','Object']
});
});

</script>

<div class="container">
    <div class="page-header">
        <h1>Page for Admin</h1>
    </div>
    <div class="row">
        <div class="col-md-15">
            <div class="panel with-nav-tabs panel-primary">
                <div class="panel-heading clearfix">
                    <div class="pull-left">
                        <h1 class="panel-title">Jetstream</h1>
                    </div>
    <!--  Member, board, chart 탭 부분 -->
                    <div class="pull-right">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab1primary" data-toggle="tab">Chart</a></li>
                            <li><a href="#tab2primary" data-toggle="tab">Member</a></li>
                            <li><a href="#tab3primary" data-toggle="tab">Board</a></li>
                        </ul>
                    </div>
         <!--  Member, board, chart 탭 부분 여기까지-->               
                </div>
                <div class="panel-body">
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab1primary">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="pull-right">
                                        <button class="btn btn-default next-tab" type="button"><span class="glyphicon glyphicon-chevron-right"></span> Next</button>
                                    </div>
                                </div>
                                
                                <div class="tab-content">
                                <div class="col-lg-12">
		                            <div class="container">
	
	<div class="container-fluid">
  <div class="row">
    <div class="col-sm-10">
        <h3>Chart in 08/01~08/31</h3>  
    </div>
  </div><!--/row-->
  <hr>
  <div class="row">
    <div class="col-md-10">
        <div id="line-example" style="height: 250px;"></div>
    </div>
  </div>
</div>
</div>
</div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="tab2primary">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="pull-right">
                                        <button class="btn btn-default previous-tab" type="button"><span class="glyphicon glyphicon-chevron-left"></span> Previous</button>
                                        <button class="btn btn-default next-tab" type="button"><span class="glyphicon glyphicon-chevron-right"></span> Next</button>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                </div>
                                 <div class="col-lg-12">
                         			   <jsp:include page="readmember.jsp"></jsp:include>
                                </div>
                            </div>
                         <br>
                        </div>
                        <div class="tab-pane fade" id="tab3primary">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="pull-right">
                                        <button class="btn btn-default previous-tab" type="button"><span class="glyphicon glyphicon-chevron-left"></span> Previous</button>
                                    </div>
                                </div>
                            </div>
                           		  <div class="col-lg-12">
									<jsp:include page="readboard.jsp"></jsp:include>
                                </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</div>
</div>
</body>
</html>