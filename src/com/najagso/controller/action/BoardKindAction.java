package com.najagso.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.najagso.dao.BoardDAO;
import com.najagso.dto.BoardVO;

public class BoardKindAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="product/productKind.jsp";
		
		String kind=request.getParameter("kind").trim();
		
		BoardDAO boardDAO=BoardDAO.getInstance();
		ArrayList<BoardVO>boardKindList= boardDAO.listKindBoard(kind);
		
		request.setAttribute("boardKindList", boardKindList);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
