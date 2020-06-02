package com.dto;

public class ScoreDto {

	private String s_name;
	private int s_kor;
	private int s_eng;
	private int s_math;
	private int s_sum;
	private double s_avg;
	private String s_grade;
	private int s_R;
	
	
	public ScoreDto() {
		
	}

	public ScoreDto(String s_name, int s_kor, int s_eng, int s_math, int s_sum, double s_avg, String s_grade) {
		super();
		this.s_name = s_name;
		this.s_kor = s_kor;
		this.s_eng = s_eng;
		this.s_math = s_math;
		this.s_sum = s_sum;
		this.s_avg = s_avg;
		this.s_grade = s_grade;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getS_kor() {
		return s_kor;
	}

	public void setS_kor(int s_kor) {
		this.s_kor = s_kor;
	}

	public int getS_eng() {
		return s_eng;
	}

	public void setS_eng(int s_eng) {
		this.s_eng = s_eng;
	}

	public int getS_math() {
		return s_math;
	}

	public void setS_math(int s_math) {
		this.s_math = s_math;
	}

	public int getS_sum() {
		return s_sum;
	}

	public void setS_sum(int s_sum) {
		this.s_sum = s_sum;
	}

	public double getS_avg() {
		return s_avg;
	}

	public void setS_avg(double s_avg) {
		this.s_avg = s_avg;
	}

	public void setS_grade(String s_grade) {
		this.s_grade = s_grade;
	}
	public String getS_grade() {
		return s_grade;
	}
	
	public void setS_R(int s_R) {
		this.s_R = s_R;
	}
	public int getS_R() {
		return s_R;
	}
	public String toString() {
		
		return  s_name + "\t"
				+ s_kor + "\t"
				+ s_eng + "\t"
				+ s_math + "\t"
				+ s_sum + "\t"
				+ s_avg + "\t"
				+ s_grade;
	}
}
