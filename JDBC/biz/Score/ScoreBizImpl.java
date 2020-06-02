package com.biz;

import java.util.List;

import com.dao.*;
import com.dto.ScoreDto;

public class ScoreBizImpl implements ScoreBiz {

	private ScoreDao dao = new ScoreDaoImpl();

	@Override
	public List<ScoreDto> selectList() {
		return dao.selectList();
	}

	@Override
	public ScoreDto selectOne(String s_name) {
		
		return dao.selectOne(s_name);
	}

	@Override
	public int insert(ScoreDto dto) {

		
		int sum = Sum(dto.getS_kor(),dto.getS_eng(),dto.getS_math());
		double avg = Avg(sum);
		String grade = Grade(avg);
		
		String a = String.format("%.2f", avg);
		double b = Double.parseDouble(a);
		
		
		dto.setS_sum(sum);
		dto.setS_avg(b);
		dto.setS_grade(grade);
		
//		dto.setS_sum(dto.getS_kor() + dto.getS_eng() + dto.getS_math());
//
//		dto.setS_avg((double) dto.getS_sum() / 3);
//
//		String Savg = String.format("%.2f", dto.getS_avg());
//		double Davg = Double.parseDouble(Savg);
//		dto.setS_avg(Davg);
//
//		if (dto.getS_avg() <= 100 && dto.getS_avg() >= 90) {
//			dto.setS_grade("A");
//		} else if (dto.getS_avg() <= 89 && dto.getS_avg() >= 80) {
//			dto.setS_grade("B");
//		} else if (dto.getS_avg() <= 79 && dto.getS_avg() >= 70) {
//			dto.setS_grade("C");
//		} else if (dto.getS_avg() <= 69 && dto.getS_avg() >= 60) {
//			dto.setS_grade("D");
//		} else if (dto.getS_avg() <= 59) {
//			dto.setS_grade("F");
//		}
		return dao.insert(dto);
	}

	@Override
	public int update(ScoreDto dto) {
		
		dto.setS_sum(dto.getS_kor() + dto.getS_eng() + dto.getS_math());

		dto.setS_avg((double) dto.getS_sum() / 3);

		//String Savg = String.format("%.2f", dto.getS_avg());
		//double Davg = Double.parseDouble(Savg);
		//dto.setS_avg(Davg);
		//dao에 있는 sql문에 ROUND를 써주어서 소수점을 잘라도되고
		//ROUND를 안쓰고 여기서 포매터로 잘라주어도된다.
		

		if (dto.getS_avg() <= 100 && dto.getS_avg() >= 90) {
			dto.setS_grade("A");
		} else if (dto.getS_avg() <= 89 && dto.getS_avg() >= 80) {
			dto.setS_grade("B");
		} else if (dto.getS_avg() <= 79 && dto.getS_avg() >= 70) {
			dto.setS_grade("C");
		} else if (dto.getS_avg() <= 69 && dto.getS_avg() >= 60) {
			dto.setS_grade("D");
		} else if (dto.getS_avg() <= 59) {
			dto.setS_grade("F");
		}
		
	
		return dao.update(dto);
	}

	@Override
	public int delete(String s_name) {
		return dao.delete(s_name);
	}

	@Override
	public ScoreDto topNSelect(int n) {

		return dao.topNSelect(n);
	}
	private int Sum(int kor,int eng, int math) {
		return kor + eng + math;
	}
	private double Avg(int sum) {
		return (double)sum/3;
	}
	
	private String Grade(double avg) {
		if (avg <= 100 && avg >= 90) {
			return "A";
		} else if (avg <= 89 && avg >= 80) {
			return "B";
		} else if (avg <= 79 && avg >= 70) {
			return"C";
		} else if (avg <= 69 && avg >= 60) {
			return"D";
		} else {
			return"F";
		}
	}

}
