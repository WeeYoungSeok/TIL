package com.dao;

import static com.db.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.ScoreDto;

public class ScoreDaoImpl implements ScoreDao {
	// Impl은 implements 뜻

	@Override
	public List<ScoreDto> selectList() {
		Connection con = getConnection();
		Statement stmt = null;

		ResultSet rs = null;

		List<ScoreDto> list = new ArrayList<ScoreDto>();

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SELECT_LIST_SQP);

			while (rs.next()) {
				ScoreDto dto = new ScoreDto();
				dto.setS_name(rs.getString(1));
				dto.setS_kor(rs.getInt(2));
				dto.setS_eng(rs.getInt(3));
				dto.setS_math(rs.getInt(4));
				dto.setS_sum(rs.getInt(5));
				dto.setS_avg(rs.getDouble(6));
				dto.setS_grade(rs.getString(7));

				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
		}

		return list;
	}

	@Override
	public ScoreDto selectOne(String s_name) {
		Connection con = getConnection();
		PreparedStatement pstm = null;

		ResultSet rs = null;

		ScoreDto dto = new ScoreDto();
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setString(1, s_name);

			rs = pstm.executeQuery();
			while (rs.next()) {
				dto.setS_name(rs.getString(1));
				dto.setS_kor(rs.getInt(2));
				dto.setS_eng(rs.getInt(3));
				dto.setS_math(rs.getInt(4));
				dto.setS_sum(rs.getInt(5));
				dto.setS_avg(rs.getDouble(6));
				dto.setS_grade(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}

		return dto;
	}

	@Override
	public int insert(ScoreDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;

		int res = 0;
		try {
			pstm = con.prepareStatement(INSERT_SQL);
			pstm.setString(1, dto.getS_name());
			pstm.setInt(2, dto.getS_kor());
			pstm.setInt(3, dto.getS_eng());
			pstm.setInt(4, dto.getS_math());
			pstm.setInt(5, dto.getS_sum());
			pstm.setDouble(6, dto.getS_avg());
			pstm.setString(7, dto.getS_grade());

			res = pstm.executeUpdate();

			if (res > 0) {
				commit(con);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
	}

	@Override
	public int update(ScoreDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;

		int res = 0;
		try {
			pstm = con.prepareStatement(UPDATE_SQL);
			pstm.setInt(1, dto.getS_kor());
			pstm.setInt(2, dto.getS_eng());
			pstm.setInt(3, dto.getS_math());
			pstm.setInt(4, dto.getS_sum());
			pstm.setDouble(5, dto.getS_avg());
			pstm.setString(6, dto.getS_grade());

			pstm.setString(7, dto.getS_name());

			res = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
	}

	@Override
	public int delete(String s_name) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			pstm.setString(1, s_name);

			res = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
	}

	@Override
	public ScoreDto topNSelect(int n) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ScoreDto dto = new ScoreDto();
		ResultSet rs = null;
		try {
			pstm = con.prepareStatement(TOP_N_SQL);
			pstm.setInt(1, n);

			rs = pstm.executeQuery();

			while (rs.next()) {
				// 첫번째 컬럼은 ROWNUM이여서 2부터

				dto.setS_name(rs.getString(2));
				dto.setS_kor(rs.getInt(3));
				dto.setS_eng(rs.getInt(4));
				dto.setS_math(rs.getInt(5));
				dto.setS_sum(rs.getInt(6));
				dto.setS_avg(rs.getDouble(7));
				dto.setS_grade(rs.getString(8));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}

		return dto;
	}

}
