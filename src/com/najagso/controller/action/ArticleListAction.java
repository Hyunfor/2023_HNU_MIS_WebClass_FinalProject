package com.najagso.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.najagso.dao.ArticleDAO;
import com.najagso.dto.ArticleVO;
import com.najagso.dto.MemberVO;

public class ArticleListAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = "article/articleList.jsp";
    
    HttpSession session = request.getSession();
    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");    
    
    if (loginUser == null) {
      url = "NajagsoServlet?command=login_form";
    } else {
      ArticleDAO articleDAO = ArticleDAO.getInstance();      
      ArrayList<ArticleVO> articleList = articleDAO.listArticle(0, loginUser.getId());
      request.setAttribute("articleList", articleList);
    }
    request.getRequestDispatcher(url).forward(request, response);
  }
}
