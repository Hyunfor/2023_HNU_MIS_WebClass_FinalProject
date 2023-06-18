package com.najagso.controller;

import com.najagso.admin.controller.AdminArticleListAction;
import com.najagso.admin.controller.AdminIndexAction;
import com.najagso.admin.controller.AdminLoginAction;
import com.najagso.admin.controller.AdminLogoutAction;
import com.najagso.admin.controller.AdminMemberListAction;
import com.najagso.admin.controller.AdminQnaDetailAction;
import com.najagso.admin.controller.AdminQnaListAction;
import com.najagso.admin.controller.AdminQnaResaveAction;
import com.najagso.controller.action.Action;
import com.najagso.controller.action.BoardKindAction;
import com.najagso.controller.action.ContractAction;
import com.najagso.controller.action.IdCheckFormAction;
import com.najagso.controller.action.IndexAction;
import com.najagso.controller.action.JoinAction;
import com.najagso.controller.action.JoinFormAction;
import com.najagso.controller.action.LoginAction;
import com.najagso.controller.action.LoginFormAction;
import com.najagso.controller.action.LogoutAction;
import com.najagso.controller.action.MyPageAction;
import com.najagso.controller.action.QnaListAction;
import com.najagso.controller.action.QnaViewAction;
import com.najagso.controller.action.QnaWriteAction;
import com.najagso.controller.action.QnaWriteFormAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory  :" + command);
		
		/* 일반 유저 */
		if (command.equals("index")) {
			action = new IndexAction();
		} else if (command.equals("contract")) {
			action = new ContractAction();
		} else if (command.equals("catagory")) {
			action = new BoardKindAction();
		} else if (command.equals("login_form")) {
			action = new LoginFormAction();
		} else if (command.equals("login")) {
			action = new LoginAction();
		} else if (command.equals("logout")) {
			action = new LogoutAction();
		} else if (command.equals("join_form")) {
			action = new JoinFormAction();
		} else if (command.equals("id_check_form")) {
			action = new IdCheckFormAction();
		} else if (command.equals("join")) {
			action = new JoinAction();
		} else if (command.equals("mypage")) {
			action = new MyPageAction();
		} else if (command.equals("qna_list")) {
			action = new QnaListAction();
		} else if (command.equals("qna_write_form")) {
			action = new QnaWriteFormAction();
		} else if (command.equals("qna_write")) {
			action = new QnaWriteAction();
		} else if (command.equals("qna_view")) {
			action = new QnaViewAction();
		}

		// 관리자
		if (command.equals("admin_login_form")) {
			action = new AdminIndexAction();
		} else if (command.equals("admin_login")) {
			action = new AdminLoginAction();
		} else if (command.equals("admin_logout")) {
			action = new AdminLogoutAction();
		} else if (command.equals("admin_article_list")) {
			action = new AdminArticleListAction();
		} else if (command.equals("admin_member_list")) {
			action = new AdminMemberListAction();
		} else if (command.equals("admin_qna_list")) {
			action = new AdminQnaListAction();
		} else if (command.equals("admin_qna_detail")) {
			action = new AdminQnaDetailAction();
		} else if (command.equals("admin_qna_repsave")) {
			action = new AdminQnaResaveAction();
		}
		return action;
	}

}