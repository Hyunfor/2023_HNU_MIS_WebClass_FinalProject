package com.najagso.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.najagso.dao.ArticleDAO;
import com.najagso.dao.BoardDAO;
import com.najagso.dto.ArticleVO;
import com.najagso.dto.BoardVO;

public class BoardKindAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="board/boardKind.jsp";
		
		String kind=request.getParameter("kind").trim();
		
		BoardDAO boardDAO = BoardDAO.getInstance();
        ArrayList<BoardVO> boardKindList = boardDAO.listKindBoard(kind);

        // 게시판별로 게시글을 불러옴
        ArticleDAO articleDAO = ArticleDAO.getInstance();
        for (BoardVO board : boardKindList) {
            ArrayList<ArticleVO> articles = articleDAO.getArticlesByBoard(board.getCode());
            board.setArticles(articles);
        }

        request.setAttribute("boardKindList", boardKindList);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
