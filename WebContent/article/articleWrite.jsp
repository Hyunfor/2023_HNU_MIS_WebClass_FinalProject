<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<article>
	<form name="formm" method="post"
		action="NajagsoServlet?command=article_write">
		<fieldset>
			<legend>Board Info</legend>
			<label>Title</label> <input type="text" name="title" size="77"><br>
			<label>Content</label>
			<textarea rows="8" cols="65" name="content"></textarea>
			<br>
		</fieldset>
		<div class="clear"></div>
		<div id="buttons" style="float: right">
			<input type="submit" value="글쓰기" class="submit"> <input
				type="reset" value="취소" class="cancel"> <input type="button"
				value="목록으로" class="submit"
				onclick="location.href='NajagsoServlet?command=index'">
		</div>
	</form>
</article>
<%@ include file="../footer.jsp"%>