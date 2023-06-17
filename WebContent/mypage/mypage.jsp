<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.jsp"%>
<article>
	<h2>My Page(${title})</h2>
	<form name="formm" method="post">
		<table id="articleList">
			<tr>
				<th>작성일</th>
				<th>게시판</th>
				<th>제목</th>
				</th>
			</tr>
			<c:forEach items="${articleList}" var="articleVO">
				<tr>
					<td><fmt:formatDate value="${articleVO.indate}" type="date" /></td>
					<td>${articleVO.boad}</td>
					<td>${articleVO.title}</td>
					<td><a
						href="NajagsoServlet?command=article_detail&oseq=${articleVO.oseq}">
							조회 </a></td>
				</tr>
			</c:forEach>
		</table>

		<div class="clear"></div>
		<div id="buttons" style="float: right">
			<input type="button" value="메인화면으로" class="cancel"
				onclick="location.href='NajagsoServlet?command=index'">
		</div>
	</form>
</article>
<%@ include file="../footer.jsp"%>
