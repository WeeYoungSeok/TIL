package com.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.biz.*;
import com.dto.ScoreDto;

public class ScoreView {
	
	static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("**********\n")
		  .append("1.전체출력\n")
		  .append("2.선택출력\n")
		  .append("3.추      가\n")
		  .append("4.수      정\n")
		  .append("5.삭      제\n")
		  .append("6.1등출력\n")
		  .append("7.2등출력\n")
		  .append("8.n등출력\n")
		  .append("9.종     료\n");
		  
		System.out.println(sb);
		System.out.println("번호 선택 : ");
		int select = sc.nextInt();
		return select;
		
		
	}
	
	public static void main(String[] args) {
		ScoreBiz biz = new ScoreBizImpl();
		
		int select = 0;
		
		
		while(select != 9) {
			select = getMenu();
			switch(select) {
			case 1:
				System.out.println("---전체 출력---");
				System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
				List<ScoreDto> selectList = biz.selectList();
				for(ScoreDto dto : selectList) {
					System.out.println(dto);
				}
				
				
				break;
			case 2:
				System.out.println("---선택 출력---");
				System.out.println("출력할 이름 : ");
				String selectName = sc.next();
				ScoreDto selectDto = biz.selectOne(selectName);
				
				if(selectDto.getS_name()==null) {
					// 주소값이 null인거라서 비교연산자를 써줘야함
					// 문자 "null"이면 equals임
					System.out.println("이름이 없습니다");
				} else {
				System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
				System.out.println(selectDto);
				}
				
				break;
			case 3:
				System.out.println("---추      가---");
				System.out.println("이름 : ");
				String insertName = sc.next();
				
				int insertKor;
				int insertEng;
				int insertMath;
				
				try {
					System.out.println("국어 점수 : ");
					insertKor = sc.nextInt();
					System.out.println("영어 점수 : ");
					insertEng = sc.nextInt();
					System.out.println("수학 점수 : ");
					insertMath = sc.nextInt();
				} catch (InputMismatchException e) {
					// TODO Auto-generated catch block
					System.out.println("숫자만 넣어주세요.");
					System.out.println("다시 실행해주세요.");
					
					select = 9;
					continue;
				}
				
				
				ScoreDto insertDto = new ScoreDto(insertName,insertKor,insertEng,insertMath,0,0,"");
				int insertRes = biz.insert(insertDto);
				//int insertRes = biz.insert(new ScoreDto(insertName,insertKor,insertEng,insertMath,0,0,""));
				if(insertRes > 0) {
					System.out.println("추가 성공!");
				} else {
					System.out.println("추가 실패!");
				}
				break;
			case 4:
				System.out.println("---수      정---");
				System.out.println("점수 수정할 이름 : ");
				String updateName = sc.next();
				int updateKor;
				int updateEng;
				int updateMath;
				try {
					System.out.println("수정할 국어 점수 : ");
					updateKor = sc.nextInt();
					System.out.println("수정할 영어 점수 : ");
					updateEng = sc.nextInt();
					System.out.println("수정할 수학 점수 : ");
					updateMath = sc.nextInt();
				} catch (InputMismatchException e) {
					// TODO Auto-generated catch block
					System.out.println("숫자만 넣어주세요.");
					System.out.println("다시 실행해주세요.");
					
					select = 9;
					continue;
				}
				
				ScoreDto updateDto = new ScoreDto(updateName,updateKor,updateEng,updateMath,0,0,"");
				int updateRes = biz.update(updateDto);
				if(updateRes > 0) {
					System.out.println("수정 성공!");
				} else {
					System.out.println("수정 실패!");
					
				}
				break;
			case 5:
				System.out.println("---삭      제---");
				System.out.println("삭제할 이름 : ");
				String deleteName = sc.next();
				int res = biz.delete(deleteName);
				
				if(res > 0) {
					System.out.println("삭제 성공!");
				} else {
					System.out.println("삭제 실패!");
					
				}
				break;
			case 6:
				System.out.println("---1등 출력---");
				System.out.println(biz.topNSelect(1));
				break;
			case 7:
				System.out.println("---2등 출력---");
				System.out.println(biz.topNSelect(2));
				break;
			case 8:
				System.out.println("---n등 출력---");
				int topN;
				try {
					System.out.println("n등 : ");
					topN = sc.nextInt();
				} catch (InputMismatchException e) {
					// TODO Auto-generated catch block
					System.out.println("숫자만 넣어주세요.");
					System.out.println("다시 실행해주세요.");
					
					select = 9;
					continue;
				}
				ScoreDto topDto = biz.topNSelect(topN);
				if(topDto.getS_name()==null) {
					System.out.println("존재하지않는 등수입니다.");
				} else {
				System.out.println(topDto);
				}
				break;
			case 9:
				System.out.println("종료!");
				break;
			}
		}
		
	}

}
