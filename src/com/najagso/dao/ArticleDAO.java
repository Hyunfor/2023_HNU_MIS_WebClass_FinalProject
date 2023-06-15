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
				article.setId(rs.getInt("id"));
				article.setName(rs.getString("name"));
				article.setContent(rs.getString("title"));
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
				article.setId(rs.getInt("id"));
				article.setName(rs.getString("name"));
				article.setContent(rs.getString("title"));
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
	public ArticleVO checkPassWord(String pass, String id) {
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
	public void deleteArticle(String id) {
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

	/*
	 * * 관리자 모드에서 사용되는 메소드 *
	 */
	
	// 모든 게시글
	public int totalRecord(String article_name) {
	    int total_pages = 0;    
	    String sql = "select count(*) from article where name like '%'||?||'%'";

	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet pageset = null;
	    
	    try {
	      con = DBManager.getConnection();
	      pstmt = con.prepareStatement(sql);

	      if (article_name.equals("")){
	        pstmt.setString(1, "%");
	      }
	      else{
	        pstmt.setString(1, article_name);
	      }
	      pageset = pstmt.executeQuery();

	      if (pageset.next()) {
	        total_pages = pageset.getInt(1); // 레코드의 개수
	        pageset.close();
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      DBManager.close(con, pstmt);
	    }  
	    return total_pages;
	  }

	  static int view_rows = 5; // 페이지의 개수
	  static int counts = 5; // 한 페이지에 나타낼 상품의 개수

	 //게시글 리스트
	public ArrayList<ArticleVO> listArticle(int tpage, String article_name) {
		ArrayList<ArticleVO> articleList = new ArrayList<ArticleVO>();

		String str = "select id, name, pass, title, content "
				+ " from article where name like '%'||?||'%' order by id desc";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int absolutepage = 1;

		try {
			con = DBManager.getConnection();
			absolutepage = (tpage - 1) * counts + 1;
			pstmt = con.prepareStatement(str, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			if (article_name.equals("")) {
				pstmt.setString(1, "%");
			} else {
				pstmt.setString(1, article_name);
			}

			rs = pstmt.executeQuery();

			if (rs.next()) {
				rs.absolute(absolutepage);
				int count = 0;

				while (count < counts) {
					ArticleVO article = new ArticleVO();
					article.setId(rs.getInt(1));
					article.setPass(rs.getString(2));
					article.setName(rs.getString(3));
					article.setTitle(rs.getString(4));
					article.setContent(rs.getString(5));
					articleList.add(article);
					if (rs.isLast()) {
						break;
					}
					rs.next();
					count++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return articleList;
	}

	// 페이지 넘버
	
	public String pageNumber(int tpage, String name) {
		String str = "";

		int total_pages = totalRecord(name);
		int page_count = total_pages / counts + 1;

		if (total_pages % counts == 0) {
			page_count--;
		}
		if (tpage < 1) {
			tpage = 1;
		}

		int start_page = tpage - (tpage % view_rows) + 1;
		int end_page = start_page + (counts - 1);

		if (end_page > page_count) {
			end_page = page_count;
		}
		if (start_page > view_rows) {
			str += "<a href='NajagsoServlet?command=admin_article_list&tpage=1&key=" + name
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='NajagsoServlet?command=admin_article_list&tpage=" + (start_page - 1);
			str += "&key=<%=article_name%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='NajagsoServlet?command=admin_article_list&tpage=" + i + "&key=" + name + "'>[" + i
						+ "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='NajagsoServlet?command=admin_article_list&tpage=" + (end_page + 1) + "&key=" + name
					+ "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='NajagsoServlet?command=admin_article_list&tpage=" + page_count + "&key=" + name
					+ "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}

}
