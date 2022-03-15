/*    */ package com.project.board.service;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
	 	 import com.project.board.command.BoardVO;
		 import com.project.board.command.Criteria;
		 import com.project.board.mapper.BoardMapper;
/*    */ 
/*    */ @Service
/*    */ public class BoardServiceImpl implements BoardService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private BoardMapper mapper;
/*    */ 
/*    */   public ArrayList<BoardVO> getList(Criteria cri)
/*    */   {
/* 32 */     ArrayList<BoardVO> list = mapper.pagingList(cri);
/*    */ 
/* 34 */     return list;
/*    */   }
/*    */ 
/*    */   public int getTotal(String city_b)
/*    */   {
/* 40 */     int total = mapper.getTotal(city_b);
/*    */ 
/* 42 */     return total;
/*    */   }
/*    */ 
/*    */   public void register(BoardVO vo)
/*    */   {
/* 48 */     System.out.println(vo.getTitle());
/* 49 */     System.out.println(vo.getWriter());
/* 50 */     System.out.println(vo.getCity_b());
/*    */ 
/* 52 */     mapper.insertBoard(vo);
/*    */   }
/*    */ 
/*    */   public BoardVO getContent(int num)
/*    */   {
/* 59 */     BoardVO vo = mapper.getContent(num);
/*    */ 
/* 61 */     return vo;
/*    */   }
/*    */ 
/*    */   public void updateBoard(BoardVO vo)
/*    */   {
/* 67 */     boolean bool = mapper.updateBoard(vo);
/*    */ 
/* 69 */     System.out.println("업데이트 성공? : " + bool);
/*    */   }
/*    */ 
/*    */   public void deleteBoard(int num)
/*    */   {
/* 76 */     mapper.deleteBoard(num);
/*    */   }

	@Override
	public int getmodifyinfo(int num, String user_id) {
		
		int result = mapper.getmodifyinfo(num, user_id);
		
		return result;
	}
	
	@Override
	public void boardHit(int num) {
		mapper.upHit(num);
	}
	
	@Override
	public ArrayList<BoardVO> getSearchList(Criteria cri)
	{
		ArrayList<BoardVO> list = mapper.pagingSearchList(cri);
	
	   return list;
	   
	   }
	
	@Override
		public int getSearchTotal(String city_b) {
			int total = mapper.getSearchTotal(city_b);
			return total;
		}
/*    */ }