package com.najagso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.najagso.dto.ArticleVO;

import util.DBManager;

public class ArticleDAO {
	
	private ArticleDAO() {
	  }

	private static ArticleDAO instance = new ArticleDAO();

	public static ArticleDAO getInstance() {
		return instance;
	}

	// 새로운 글
	public ArrayList<ArticleVO> listNewArticle() {
		ArrayList<ArticleVO> articleList = new ArrayList<ArticleVO>();
		String sql = "select *  from new_art_view";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ArticleVO article = new ArticleVO();
				article.setPseq(rs.getInt("pseq"));
				article.setName(rs.getString("name"));
				article.setPrice2(rs.getInt("price2"));
				article.setImage(rs.getString("image"));
				articleList.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return articleList;
	}

	// 베스트 글
	public ArrayList<ArticleVO> listBestArticle() {
		ArrayList<ArticleVO> articleList = new ArrayList<ArticleVO>();
		String sql = "select *  from best_art_view";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ArticleVO article = new ArticleVO();
				article.setPseq(rs.getInt("pseq"));
				article.setName(rs.getString("name"));
				article.setPrice2(rs.getInt("price2"));
				article.setImage(rs.getString("image"));
				articleList.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return articleList;
	}

	// 게시글 목록 가져오기
		public List<ArticleVO> selectAllBoards() {
			String sql = "SELECT * FROM ARTICLE ORDER BY NUM DESC";

			List<ArticleVO> list = new ArrayList<ArticleVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				// 결과 값으로 리스트에 담기
				while (rs.next()) {

					ArticleVO aVo = new ArticleVO();

					aVo.setId(rs.getInt("id"));
					aVo.setName(rs.getString("name"));
					aVo.setPass(rs.getString("pass"));
					aVo.setTitle(rs.getString("title"));
					aVo.setContent(rs.getString("content"));
					aVo.setReadcount(rs.getInt("readcount"));
					aVo.setWritedate(rs.getTimestamp("writedate"));

					// 리스트에 담기
					list.add(aVo);

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					DBManager.close(conn, pstmt, rs);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			return list;

		}

		// 게시글 작성
		public void insertArticle(ArticleVO aVo) {
			String sql = "INSERT INTO article(" + "id, name, pass, title, content)"
					+ "values(article_seq.nextval, ?, ?, ?, ?, ?)";

			Connection conn = null;
			PreparedStatement pstmt = null;

			try {

				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, aVo.getName());
				pstmt.setString(2, aVo.getPass());
				pstmt.setString(3, aVo.getTitle());
				pstmt.setString(4, aVo.getContent());

				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					DBManager.close(conn, pstmt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		// 게시글 조회수 증가
		public void updateReadCount(String id) {
			String sql = "UPDATE ARTICLE SET READCOUNT=READCOUNT+1 WHERE ID=?";

			Connection conn = null;
			PreparedStatement pstmt = null;

			try {

				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, id);

				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					DBManager.close(conn, pstmt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		// 게시판 글 상세 보기 : 글번호로 찾아온다 : 실패시 null;
		public ArticleVO selectOneArticleByid(String id) {
			String sql = "SELECT * FROM ARTICLE WHERE ID = ?";

			ArticleVO aVo = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				conn = DBManager.getConnection();
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);

				rs = pstmt.executeQuery();

				if (rs.next()) {

					aVo = new ArticleVO();

					aVo.setId(rs.getInt("id"));
					aVo.setName(rs.getString("name"));
					aVo.setPass(rs.getString("pass"));
					aVo.setTitle(rs.getString("title"));
					aVo.setContent(rs.getString("content"));
					aVo.setWritedate(rs.getTimestamp("writedate"));
					aVo.setReadcount(rs.getInt("readcount"));

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					DBManager.close(conn, pstmt, rs);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return aVo;

		}

		// 게시글 수정
		public void updateArticle(ArticleVO aVo) {
			String sql = "UPDATE ARTICLE SET NAME=?, PASS=?, " + "TITLE=?, CONTENT=? WHERE ID=?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {

				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, aVo.getName());
				pstmt.setString(3, aVo.getPass());
				pstmt.setString(4, aVo.getTitle());
				pstmt.setString(5, aVo.getContent());
				pstmt.setInt(6, aVo.getId());

				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					DBManager.close(conn, pstmt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		// 게시글 번호와 비밀번호 체크
		public ArticleVO checkPassWord(String pass, String id){
			String sql = "SELECT * FROM ARTICLE WHERE PASS=? AND ID=?";
		
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArticleVO aVo = null;
			
			try {

				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, pass);
				pstmt.setString(2, id);

				rs = pstmt.executeQuery();

				if (rs.next()) {

					aVo = new ArticleVO();

					aVo.setId(rs.getInt("id"));
					aVo.setName(rs.getString("name"));
					aVo.setPass(rs.getString("pass"));
					aVo.setTitle(rs.getString("title"));
					aVo.setContent(rs.getString("content"));
					aVo.setReadcount(rs.getInt("readcount"));
					aVo.setWritedate(rs.getTimestamp("writedate"));

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					DBManager.close(conn, pstmt, rs);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return aVo;
			
		}
		
		// 게시글 삭제
		public void deleteArticle(String id){
			String sql = "DELETE ARTICLE WHERE id=?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {

				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, id);

				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					DBManager.close(conn, pstmt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}

	}
