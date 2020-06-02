package com.dao;

import java.util.List;

import com.dto.ScoreDto;

public interface ScoreDao {

	String SELECT_LIST_SQP = " SELECT S_NAME,S_KOR,S_ENG,S_MATH,S_SUM,S_AVG,S_GRADE "
								+ " FROM TB_SCORE "
								+ " ORDER BY S_AVG DESC ";
	String SELECT_ONE_SQL = " SELECT S_NAME,S_KOR,S_ENG,S_MATH,S_SUM,S_AVG,S_GRADE " + " FROM TB_SCORE "
			+ " WHERE S_NAME = ?";
	String INSERT_SQL = " INSERT INTO TB_SCORE "
						+ " VALUES(?,?,?,?,?,?,?) ";
	String UPDATE_SQL = " UPDATE TB_SCORE SET S_KOR = ?, S_ENG = ? , S_MATH = ?,S_SUM = ? ,S_AVG = ROUND(?,2) , S_GRADE = ? "
					+ " WHERE S_NAME = ? ";
	String DELETE_SQL = " DELETE FROM TB_SCORE WHERE S_NAME = ? ";
	String TOP_N_SQL = " SELECT R, S_NAME, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG,S_GRADE " + 
			" FROM " + 
			" (SELECT ROWNUM AS R, S_NAME, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG,S_GRADE " + 
			"	FROM " + 
			"	(SELECT  S_NAME, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG,S_GRADE " + 
			"	FROM TB_SCORE " + 
			"	ORDER BY S_AVG DESC) A " + 
			"	) B " + 
			" WHERE R = ? ";

	public List<ScoreDto> selectList();

	public ScoreDto selectOne(String s_name);

	public int insert(ScoreDto dto);

	public int update(ScoreDto dto);

	public int delete(String s_name);

	public ScoreDto topNSelect(int n);
	// 내가 n등에대한걸 넣으면 n등에 대한 dto를 줄거야
}
