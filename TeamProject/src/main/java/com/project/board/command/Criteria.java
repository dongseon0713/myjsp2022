/*    */ package com.project.board.command;
/*    */ 
/*    */ public class Criteria
/*    */ {
/*    */   private int pageNum;
/*    */   private int count;
/*    */   private String city_b;


/*    */   public Criteria(String city_b)
/*    */   {
/* 14 */     this.pageNum = 1;
/* 15 */     this.count = 10;
/* 16 */     this.city_b = city_b;
/*    */   }
/*    */ 
/*    */   public int getPageStart()
/*    */   {
/* 22 */     return ((this.pageNum - 1) * this.count) + 1;
/*    */   }
/*    */ 
/*    */   public int getPageNum()
/*    */   {
/* 27 */     return this.pageNum;
/*    */   }
/*    */ 
/*    */   public void setPageNum(int pageNum) {
/* 31 */     this.pageNum = pageNum;
/*    */   }
/*    */ 
/*    */   public int getCount() {
/* 35 */     return this.count;
/*    */   }
/*    */ 
/*    */   public int getCount_oracle()
/*    */   {
/* 40 */     return (this.pageNum * this.count);
/*    */   }
/*    */ 
/*    */   public void setCount(int count) {
/* 44 */     this.count = count;
/*    */   }
/*    */ 
/*    */   public String getCity_b() {
/* 48 */     return this.city_b;
/*    */   }
/*    */ 
/*    */   public void setCity_b(String city_b) {
/* 52 */     this.city_b = city_b;
/*    */   }
/*    */
 }

/* Location:           C:\Users\JOO\Downloads\project20220311 (1)\
 * Qualified Name:     com.zip.mat.board.command.Criteria
 * JD-Core Version:    0.6.2
 */