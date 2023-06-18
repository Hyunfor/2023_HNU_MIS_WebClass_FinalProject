<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<article>
	<h2>board</h2>
	<c:forEach items="${boardKindList}" var="boardVO">
		<div id="board">
			<a href="NajagsoServlet?command=board_detail&boardId=${boardVO.id}">
				<h3>${boardVO.code}</h3>
				<p>${boardVO.name}</p>
			</a>
			<ul>
				<c:forEach items="${boardVO.articles}" var="article">
					<li>${article.title}</li>
				</c:forEach>
			</ul>
		</div>
	</c:forEach>
	<div>
		<tr>
			<td width="642"><input type="text" name="key"> <input
				class="btn" type="button" name="btn_search" value="검색"
				onClick="go_search()"> <input class="btn" type="button"
				name="btn_total" value="전체보기 " onClick="go_total()"> <input
				class="btn" type="button" name="btn_write" value="게시글 등록"
				onClick="go_wrt()"></td>
		</tr>
	</div>
</article>
<%@ include file="../footer.jsp"%>
