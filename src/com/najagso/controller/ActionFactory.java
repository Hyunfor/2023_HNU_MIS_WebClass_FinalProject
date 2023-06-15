package com.najagso.controller;

import com.najagso.admin.controller.AdminArticleListAction;
import com.najagso.admin.controller.AdminIndexAction;
import com.najagso.admin.controller.AdminLoginAction;
import com.najagso.admin.controller.AdminLogoutAction;
import com.najagso.controller.action.Action;
import com.najagso.controller.action.ContractAction;
import com.najagso.controller.action.IdCheckFormAction;
import com.najagso.controller.action.IndexAction;
import com.najagso.controller.action.JoinAction;
import com.najagso.controller.action.JoinFormAction;
import com.najagso.controller.action.LoginAction;
import com.najagso.controller.action.LoginFormAction;
import com.najagso.controller.action.LogoutAction;

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
		}
		return action;
	}

}