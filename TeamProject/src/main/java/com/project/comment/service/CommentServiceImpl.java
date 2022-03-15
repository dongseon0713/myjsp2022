/*    */ package com.project.comment.service;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;

import com.project.comment.command.CommentVO;
import com.project.comment.mapper.CommentMapper;
/*    */ 
/*    */ @Service
/*    */ public class CommentServiceImpl implements CommentService {
/*    */ 
/*    */   @Autowired
/*    */   private CommentMapper mapper;
/*    */ 
/*    */   public int submit(CommentVO vo)
/*    */   {
/* 20 */     mapper.submit(vo);
/*    */ 
/* 22 */     int result = 1;
/*    */ 
/* 24 */     return result;
/*    */   }
/*    */ 
/*    */   public ArrayList<CommentVO> getList(int num)
/*    */   {
/* 30 */     ArrayList<CommentVO> list = mapper.getList(num);
/*    */ 
/* 32 */     return list;
/*    */   }
/*    */ 
/*    */   public int submitPw(String pw, int num)
/*    */   {
/* 39 */     int result = mapper.submitPw(pw, num);
/*    */ 
/* 41 */     return result;
/*    */   }
/*    */ 
/*    */   public int delete(int num)
/*    */   {
/* 48 */     mapper.delete(num);
/*    */ 
/* 50 */     int result = 1;
/*    */ 
/* 52 */     return result;
/*    */   }
/*    */ }

/* Location:           C:\Users\JOO\Downloads\project20220311 (1)\
 * Qualified Name:     com.zip.mat.comment.service.CommentServiceImpl
 * JD-Core Version:    0.6.2
 */