<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!--베너 광고 들어가는 곳 시작 --->
<div class="clear"></div>
<div id="banner_img">
	<a href="NajagsoServlet?command=index">
        <img src="img/banner01.jpg" width="971" height="103" alt="najagso">
      </a>  
</div>
<!--베너 광고 들어가는 곳 시작--->

<div class="clear"></div>

<div id="front">
	<h2>새로운 올라온 글</h2>
	<div id="newArticle">
		<c:forEach items="${newArticleList }" var="articleVO">
			<div id="article">
				<a href="NajagsoServlet?command=article_detail&id=${articleVO.id}">
					<h3>${articleVO.title}</h3>
					<p>${articleVO.content}</p>
				</a>
			</div>
		</c:forEach>
	</div>
	<div class="clear"></div>

	<h2>인기 글</h2>
	<div id="bestArticle">
		<c:forEach items="${bestArticleList}" var="articleVO">
			<div id="article">
				<a href="NajagsoServlet?command=article_detail&id=${articleVO.id}">
					<h3>${articleVO.title}</h3>
					<p>${articleVO.content}</p>
				</a>
			</div>
		</c:forEach>
	</div>
	<div class="clear"></div>
</div>

<%@ include file="../footer.jsp"%>
