package com.najagso.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.najagso.controller.action.Action;
import com.najagso.dao.ArticleDAO;
import com.najagso.dto.ArticleVO;

public class AdminArticleListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "admin/product/productList.jsp";

		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		if (key == null) {
			key = "";
		}
		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		request.setAttribute("key", key);
		request.setAttribute("tpage", tpage);

		ArticleDAO articleDAO = ArticleDAO.getInstance();
		ArrayList<ArticleVO> productList = articleDAO.listArticle(Integer.parseInt(tpage), key);

		String paging = articleDAO.pageNumber(Integer.parseInt(tpage), key);

		request.setAttribute("articleList", articleList);
		int n = articleList.size();
		request.setAttribute("articleListSize", n);
		request.setAttribute("paging", paging);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
