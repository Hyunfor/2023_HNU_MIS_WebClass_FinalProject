package com.najagso.dao;

import java.util.ArrayList;

import com.najagso.dto.ArticleVO;
import com.najagso.dto.BoardVO;

public class BoardDAO {

	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	public ArrayList<BoardVO> listKindBoard(String kind) {
		ArrayList<BoardVO> boardList = new ArrayList<>();

		if (kind.equals("자유")) {
			// 게시판 ID, 코드, 이름 설정하여 BoardVO 객체 생성
			BoardVO board = new BoardVO();
			board.setId(1);
			board.setCode("free");
			board.setName("자유게시판");

			// 해당 게시판에 속한 게시글을 가져옴
			ArticleDAO articleDAO = ArticleDAO.getInstance();
			ArrayList<ArticleVO> articles = articleDAO.getArticlesByBoard(board.getCode());
			board.setArticles(articles);

			// 생성된 BoardVO 객체를 리스트에 추가
			boardList.add(board);
		} else if (kind.equals("일상")) {
			// 게시판 ID, 코드, 이름 설정하여 BoardVO 객체 생성
			BoardVO board = new BoardVO();
			board.setId(2);
			board.setCode("daily");
			board.setName("일상게시판");

			// 해당 게시판에 속한 게시글을 가져옴
			ArticleDAO articleDAO = ArticleDAO.getInstance();
			ArrayList<ArticleVO> articles = articleDAO.getArticlesByBoard(board.getCode());
			board.setArticles(articles);

			// 생성된 BoardVO 객체를 리스트에 추가
			boardList.add(board);
		} else if (kind.equals("취미")) {
			// 게시판 ID, 코드, 이름 설정하여 BoardVO 객체 생성
			BoardVO board = new BoardVO();
			board.setId(3);
			board.setCode("hobby");
			board.setName("취미게시판");

			// 해당 게시판에 속한 게시글을 가져옴
			ArticleDAO articleDAO = ArticleDAO.getInstance();
			ArrayList<ArticleVO> articles = articleDAO.getArticlesByBoard(board.getCode());
			board.setArticles(articles);

			// 생성된 BoardVO 객체를 리스트에 추가
			boardList.add(board);
		}

		return boardList;

	}

}
