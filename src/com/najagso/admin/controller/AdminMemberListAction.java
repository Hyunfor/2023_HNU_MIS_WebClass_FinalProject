package com.najagso.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.najagso.controller.action.Action;
import com.najagso.dao.MemberDAO;
import com.najagso.dto.MemberVO;

public class AdminMemberListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "admin/member/memberList.jsp";

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

		MemberDAO memberDAO = MemberDAO.getInstance();
		ArrayList<MemberVO> memberList = memberDAO.listMember(Integer.parseInt(tpage), key);

		request.setAttribute("memberList", memberList);
		int n = memberList.size();
		request.setAttribute("memberListSize", n);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
