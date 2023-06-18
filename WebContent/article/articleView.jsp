<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<article>
	<form name="formm" method="post">
		<table id="notice">
			<tr>
				<th>제목</th>
				<td>${articleVO.title}</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td><fmt:formatDate value="${articleVO.writedate}" type="date" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${articleVO.content}</td>
			</tr>
		</table>
		<div class="clear"></div>
		<div id="buttons" style="float: right">
			<input type="button" value="목록보기" class="submit"
				onclick="location.href='NajagsoServlet?command=article_list'"> <input
				type="button" value="작성 취소" class="cancel"
				onclick="location.href='NajagsoServlet?command=index'">
		</div>
	</form>
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>