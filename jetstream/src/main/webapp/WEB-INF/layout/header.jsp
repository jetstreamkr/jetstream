<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.ui-autocomplete {
	position: absolute;
	top: 100%;
	left: 0;
	z-index: 1000;
	float: left;
	display: none;
	min-width: 160px;
	_width: 160px;
	padding: 4px 0;
	margin: 2px 0 0 0;
	list-style: none;
	background-color: #ffffff;
	border-color: #ccc;
	border-color: rgba(0, 0, 0, 0.2);
	border-style: solid;
	border-width: 1px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
	-moz-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
	-webkit-background-clip: padding-box;
	-moz-background-clip: padding;
	background-clip: padding-box;
	*border-right-width: 2px;
	*border-bottom-width: 2px;
	font-size: 18px; . ui-menu-item > a.ui-corner-all { display : block;
	padding: 3px 15px;
	clear: both;
	font-weight: normal;
	line-height: 18px;
	color: #555555;
	white-space: nowrap; &. ui-state-hover , &.ui-state-foucs { color :
	#ffffff;
	text-decoration: none;
	background-color: #0088cc;
	border-radius: 0px;
	-webkit-border-radius: 0px;
	-moz-border-radius: 0px;
	background-image: none;
}
}
}

.ui-autocomplete-category {
    font-weight: bold;
    padding: .2em .4em;
    margin: .8em 0 .2em;
    line-height: 1.5;
  }
</style>

<script type="text/javascript">

var aa ;

$(document).ready(function() {
	
	$.widget("custom.catcomplete", $.ui.autocomplete, {
	      _create: function() {
	    	this._super();
	        this.widget().menu( "option", "items", "> :not(.ui-autocomplete-category)" );
	      },
	      _renderMenu: function( ul, items ) {
	    	  var that = this,
	          currentCategory = "";
	        $.each( items, function( index, item ) {
	        	var li;
	            if ( item.category != currentCategory ) {
	              ul.append( "<li class='ui-autocomplete-category'>" + item.category + "</li>" );
	              currentCategory = item.category;
	            }
	            li = that._renderItemData( ul, item );
	            if ( item.category ) {
	              li.attr( "aria-label", item.category + " : " + item.label );
	            }
	        });
	      }
	});	
  });

function searchAjax() {
	     
	 $.ajax({
	       url : "member/board_search.do",
	       type:"POST",
	       datatype:"json",
	       data : { searchData : $("#autoValue").val() },
        success : function(data) {
        	aa = JSON.parse(data)
	       }
	   });  
	   
	$('#autoValue').catcomplete({
		delay: 0,
		source : aa
	}); 
	
}
</script>

	<div class="navbar navbar-default navbar-inverse navbar-static-top navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/jetstream/dashboard.do"><span>JetStream</span></a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-ex-collapse">
				<c:if test="${sessionScope.member.email != null}">
					<form class="navbar-form navbar-left" role="search" action="">
						<div class="form-group">
							<div class="input-group">
								<input type="search" id="autoValue" class="form-control"
									onkeyup="searchAjax();" placeholder="Search"> <span
									class="input-group-btn"> <a class="btn btn-success"
									type="submit"><span class="fa fa-fw fa-search"></span>Search</a>
								</span>
							</div>
						</div>
					</form>
				</c:if>
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${sessionScope.member.email != null}">
							<li class="active"><a href="#"><b>${member.member_nm}(${member.email})님 <span class="fa fa-fw fa-heart text-danger"></span></b></a></li>
							<li><a href="/jetstream/logout.do">로그아웃</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="/jetstream/signin.do">회원가입</a></li>
							<li><a href="/jetstream/login.do">로그인</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>