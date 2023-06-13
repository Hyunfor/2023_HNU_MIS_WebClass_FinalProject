package com.najagso.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.najagso.dao.ArticleDAO;
import com.najagso.dto.ArticleVO;

public class IndexAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {    
    String url = "/index.jsp";
    
    ArticleDAO articleDAO=ArticleDAO.getInstance();
    ArrayList<ArticleVO> newArticleList = articleDAO.listNewArticle();
    ArrayList<ArticleVO> bestArticleList = articleDAO.listBestArticle();
    
    request.setAttribute("newArticleList", newArticleList);
    request.setAttribute("bestArticleList", bestArticleList);
    
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }
}
