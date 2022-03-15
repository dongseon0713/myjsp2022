/*    */ package com.project.comment.command;
/*    */ 
/*    */ import java.sql.Timestamp;
/*    */ 
/*    */ public class CommentVO
/*    */ {
/*    */   private int num;
/*    */   private int uniquenum;
/*    */   private String writer;
/*    */   private String pw;
/*    */   private String content;
/*    */   private Timestamp regdate;
/*    */ 
/*    */   public CommentVO()
/*    */   {
/*    */   }
/*    */ 
/*    */   public CommentVO(int num, int uniquenum, String writer, String pw, String content, Timestamp regdate)
/*    */   {
/* 18 */     this.num = num;
/* 19 */     this.num = uniquenum;
/* 20 */     this.writer = writer;
/* 21 */     this.pw = pw;
/* 22 */     this.content = content;
/* 23 */     this.regdate = regdate;
/*    */   }
/*    */ 
/*    */   public int getNum() {
/* 27 */     return this.num;
/*    */   }
/*    */ 
/*    */   public void setNum(int num) {
/* 31 */     this.num = num;
/*    */   }
/*    */ 
/*    */   public int getUniquenum() {
/* 35 */     return this.uniquenum;
/*    */   }
/*    */ 
/*    */   public void setUniquenum(int uniquenum) {
/* 39 */     this.uniquenum = uniquenum;
/*    */   }
/*    */ 
/*    */   public String getWriter() {
/* 43 */     return this.writer;
/*    */   }
/*    */ 
/*    */   public void setWriter(String writer) {
/* 47 */     this.writer = writer;
/*    */   }
/*    */ 
/*    */   public String getPw() {
/* 51 */     return this.pw;
/*    */   }
/*    */ 
/*    */   public void setPw(String pw) {
/* 55 */     this.pw = pw;
/*    */   }
/*    */ 
/*    */   public String getContent() {
/* 59 */     return this.content;
/*    */   }
/*    */ 
/*    */   public void setContent(String content) {
/* 63 */     this.content = content;
/*    */   }
/*    */ 
/*    */   public Timestamp getRegdate() {
/* 67 */     return this.regdate;
/*    */   }
/*    */ 
/*    */   public void setRegdate(Timestamp regdate) {
/* 71 */     this.regdate = regdate;
/*    */   }
/*    */ }

/* Location:           C:\Users\JOO\Downloads\project20220311 (1)\
 * Qualified Name:     com.zip.mat.comment.command.CommentVO
 * JD-Core Version:    0.6.2
 */