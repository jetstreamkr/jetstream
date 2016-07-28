<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-md-1" id="sideMenu">
	<ul class="nav nav-pills nav-stacked">
		<li class="text-center">
			<a href="/jetstream/board/board_main.do?board_id=${board.board_id}"><span class="fa fa-3x fa-home"></span><br>Main</a>
		</li>
		<li class="text-center">
			<a href="/jetstream/board/board_list.do?board_id=${board.board_id}"><span class="fa fa-3x fa-list"></span><br>List</a>
		</li>
		<li class="text-center">
			<a href="/jetstream/board/board_cal.do?board_id=${board.board_id}"><span class="fa fa-3x fa-calendar"></span><br>Calendar</a>
		</li>
		<li class="text-center">
			<a href="/jetstream/board/board_set.do?board_id=${board.board_id}"><span class="fa fa-3x fa-gear"></span><br>Setting</a>
		</li>
	</ul>
</div>
