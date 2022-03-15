/*     */ package com.project.board.command;
/*     */ 
/*     */ public class PageVO
/*     */ {
/*     */   private int startPage;
/*     */   private int endPage;
/*     */   private int total;
/*     */   private int pageNum;
/*     */   private boolean next;
/*     */   private boolean prev;
/*     */   private Criteria cri;
/*     */ 
/*     */   public PageVO(int total, Criteria cri)
/*     */   {
/*  22 */     this.total = total;
/*  23 */     this.cri = cri;
/*  24 */     this.pageNum = cri.getPageNum();
/*     */ 
/*  31 */     this.endPage = ((int)Math.ceil(cri.getPageNum() / (double)10) * 10);
/*     */ 
/*  34 */     this.startPage = (this.endPage - 9);
/*     */ 
/*  38 */     int realEnd = (int)Math.ceil(this.total / (double)10);
/*     */ 
/*  41 */     if (this.endPage > realEnd) {
/*  42 */       this.endPage = realEnd;
/*     */     }
/*     */ 
/*  48 */     this.prev = (this.startPage > 1);
/*     */ 
/*  51 */     this.next = (realEnd > this.endPage);
/*     */   }
/*     */ 
/*     */   public int getStartPage()
/*     */   {
/*  56 */     return this.startPage;
/*     */   }
/*     */ 
/*     */   public void setStartPage(int startPage) {
/*  60 */     this.startPage = startPage;
/*     */   }
/*     */ 
/*     */   public int getEndPage() {
/*  64 */     return this.endPage;
/*     */   }
/*     */ 
/*     */   public void setEndPage(int endPage) {
/*  68 */     this.endPage = endPage;
/*     */   }
/*     */ 
/*     */   public int getTotal() {
/*  72 */     return this.total;
/*     */   }
/*     */ 
/*     */   public void setTotal(int total) {
/*  76 */     this.total = total;
/*     */   }
/*     */ 
/*     */   public int getPageNum() {
/*  80 */     return this.pageNum;
/*     */   }
/*     */ 
/*     */   public void setPageNum(int pageNum) {
/*  84 */     this.pageNum = pageNum;
/*     */   }
/*     */ 
/*     */   public boolean isNext() {
/*  88 */     return this.next;
/*     */   }
/*     */ 
/*     */   public void setNext(boolean next) {
/*  92 */     this.next = next;
/*     */   }
/*     */ 
/*     */   public boolean isPrev() {
/*  96 */     return this.prev;
/*     */   }
/*     */ 
/*     */   public void setPrev(boolean prev) {
/* 100 */     this.prev = prev;
/*     */   }
/*     */ 
/*     */   public Criteria getCri() {
/* 104 */     return this.cri;
/*     */   }
/*     */ 
/*     */   public void setCri(Criteria cri) {
/* 108 */     this.cri = cri;
/*     */   }
/*     */ }

/* Location:           C:\Users\JOO\Downloads\project20220311 (1)\
 * Qualified Name:     com.zip.mat.board.command.PageVO
 * JD-Core Version:    0.6.2
 */