<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

		<div class="col-md-11 bg-info">
			<!-- 보드정보 시작 -->
			<div class="col-md-12 bg-danger">
				<h1>${board.board_nm}</h1>
				<hr>
				<h3>보드 진행도(추가예정)</h3>
			</div>
			<!-- 보드정보 끝 -->

			<!-- 내 카드 목록 시작 -->
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title"><span class="fa fa-fw fa-clipboard"></span>당장 눈 앞에 닥친 카드 목록
							<span class="text-right"><a href="#" class="btn btn-danger"><span class="fa fa-plus"></span>카드추가</a></span>
						</h3>
					</div>
					<table class="table table-condensed">
						<tbody>
							<!-- #################카드반복 시작 -->
							<tr>
								<td>111111</td>
								<td>111111</td>
								<td>111111</td>
								<td>111111</td>
								<td>111111</td>
								<td>111111</td>
							</tr>
							<!-- 카드반복 끝 -->
						</tbody>
					</table>
				</div>
			</div>
			<!-- 카드 목록 끝 -->
			<!-- 옆에서 클릭한 카드 디테일 시작 -->
			<div class="col-md-4">
				<div class="col-md-12 panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">카드제목</h3>
					</div>
					<div class="panel-body">
						카드내용
					</div>
				</div>
			</div>
			<!-- 카드 디테일 끝 -->

		</div>
