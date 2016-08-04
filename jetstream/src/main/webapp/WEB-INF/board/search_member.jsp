<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style type="text/css">
   
      .imagebox{
         position: relative;
         width: 50px;
         height: 50px;
         margin-left: 0px;
         margin-right: 0px;
         background: red;
      }
      .initial{
         color : white;
         position: relative;
         z-index: 2;

      }
      .image{
         z-index: 1;
      }   
   </style>
   
   

		<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
			<li class="dropdown-header">검색 결과</li>
			<div id="search-list">
			<c:forEach begin="0" end="4" var="memberResult" items="${memberList}">	
			<li class="media">
				<span class="pull-left">
					<img class="image img-circle img-responsive media-object" src="/jetstream/resources/images/${memberResult.photo}" height="50" width="50">
				</span>
				<div class="media-body">
						<h4 class="media-heading"><a href="javascript:addMember('${memberResult.member_id}')">${memberResult.member_nm}</a></h4>
						<p class="text-muted">${memberResult.email}</p>
				</div>
			</li>
			<li class="divider"></li>			
			</c:forEach>
			</div>
		</ul>