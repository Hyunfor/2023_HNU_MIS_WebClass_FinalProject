<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>

<article>
<h1>게시글 리스트</h1>	
<form name="frm" method="post">
<table>
  <tr>
  <td width="642">
      제목 
     <input type="text" name="key">
     <input class="btn" type="button" name="btn_search" value="검색" onClick="go_search()">
     <input class="btn" type="button" name="btn_total" value="전체보기 " onClick="go_total()">
     <input class="btn" type="button" name="btn_write" value="게시글 등록" onClick="go_wrt()">
  </td>
  </tr>
</table>
<table id="articleList">
    <tr>
        <th>번호</th><th>제목</th><th>내용</th><th>작성자</th><th>등록일</th><th>삭제일</th>
    </tr>
    <c:choose>
    <c:when test="${articleListSize<=0}">
    <tr>
      <td width="100%" colspan="7" align="center" height="23">
        등록된 게시글이 없습니다.
      </td>      
    </tr>
    </c:when>
	<c:otherwise>
	<c:forEach items="${articleList}" var="articleVO">
    <tr>
      <td height="23" align="center" >${articleVO.pseq}</td>
      <td style="text-align: left; padding-left: 50px; padding-right: 0px;">   
        <a href="#" onClick="go_detail('${tpage}', '${articleVO.pseq}')">
    	 ${articleVO.name}     
   		</a>
   	  </td>
      <td><fmt:formatNumber value="${articleVO.price1}"/></td>
      <td><fmt:formatNumber value="${articleVO.price2}"/></td>
      <td><fmt:formatDate value="${articleVO.indate}"/></td>
      <td>
      	<c:choose>
   	 		<c:when test='${articleVO.useyn=="1"}'>미사용</c:when>
   	 		<c:otherwise>사용</c:otherwise>   	 		
   	 	</c:choose>	 
   	  </td> 
    </tr>
    </c:forEach>
    <tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr>
	</c:otherwise>	
</c:choose>  
</table>
</form> 
</article>
<%@ include file="/admin/footer.jsp"%>
</body>
</html>