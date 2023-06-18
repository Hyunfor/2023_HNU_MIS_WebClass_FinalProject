package com.najagso.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.najagso.dao.ArticleDAO;
import com.najagso.dto.ArticleVO;
import com.najagso.dto.MemberVO;

public class ArticleViewAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = "article/articleView.jsp";
    
    HttpSession session = request.getSession();
    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

    if (loginUser == null) {
      url = "NajagsoServlet?command=login_form";
    } else {
      int id = Integer.parseInt(request.getParameter("id"));
      ArticleDAO articleDAO = ArticleDAO.getInstance();
      ArticleVO articleVO = articleDAO.selectOneArticleByid(id);
      request.setAttribute("articleVO", articleVO);
    }
    request.getRequestDispatcher(url).forward(request, response);
  }
}
