package com.najagso.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.najagso.dao.ArticleDAO;
import com.najagso.dto.ArticleVO;
import com.najagso.dto.MemberVO;

public class ArticleWriteAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = "NajagsoServlet?command=qna_list";
    
    HttpSession session = request.getSession();
    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");    
    
    if (loginUser == null) {
      url = "NajagsoServlet?command=login_form";
    }else{      
      ArticleVO articleVO = new  ArticleVO();
      articleVO.setTitle(request.getParameter("title"));
      articleVO.setContent(request.getParameter("content"));      
      ArticleDAO articleDAO =  ArticleDAO.getInstance();
      articleDAO.insertArticle(articleVO);      
    }    
    response.sendRedirect(url);
  }
}
