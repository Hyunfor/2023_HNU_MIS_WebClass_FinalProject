<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>

<article>
<h1>가입된 회원 리스트</h1>	
<form name="frm" method="post">
<table>
  <tr>
  <td width="642">
      제목 
     <input type="text" name="key">
     <input class="btn" type="button" name="btn_search" value="검색" onClick="go_search()">
     <input class="btn" type="button" name="btn_total" value="전체보기 " onClick="go_total()">
  </td>
  </tr>
</table>
<table id="memberList">
    <tr>
        <th>번호</th><th>아이디</th><th>이름</th><th>이메일</th><th>전화번호</th><th>등록일</th>
    </tr>
    <c:choose>
    <c:when test="${memberListSize<=0}">
    <tr>
      <td width="100%" colspan="7" align="center" height="23">
        가입한 회원이 없습니다.
      </td>      
    </tr>
    </c:when>
	<c:otherwise>
	<c:forEach items="${memberList}" var="memberVO">
    <tr>
      <td height="23" align="center" >${memberVO.id}</td>
      <td style="text-align: left; padding-left: 50px; padding-right: 0px;">   
        <a href="#" onClick="go_detail('${tpage}', '${memberVO.id}')">
    	 ${memberVO.name}     
   		</a>
   	  </td>
   	  <td>${memberVO.email}</td>
      <td>${memberVO.phone}</td>
      <td>${memberVO.indate}</td>
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