package com.najagso.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.najagso.dao.QnaDAO;
import com.najagso.dto.MemberVO;
import com.najagso.dto.QnaVO;

public class ArticleWriteAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = "NonageServlet?command=qna_list";
    
    HttpSession session = request.getSession();
    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");    
    
    if (loginUser == null) {
      url = "NajagsoServlet?command=login_form";
    }else{      
      QnaVO qnaVO = new QnaVO();
      qnaVO.setTitle(request.getParameter("title"));
      qnaVO.setContent(request.getParameter("content"));      
      QnaDAO qnaDAO = QnaDAO.getInstance();
      qnaDAO.insertqna(qnaVO, loginUser.getId());      
    }    
    response.sendRedirect(url);
  }
}
