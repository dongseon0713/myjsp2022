/*     */ package com.project.board.command;
/*     */ 
/*     */ import java.sql.Timestamp;
/*     */ 
/*     */ public class BoardVO
/*     */ {
/*     */   private int num;
/*     */   private String name;
/*     */   private String carpark;
/*     */   private String address;
/*     */   private int open;
/*     */   private int close;
/*     */   private int breaktime;
/*     */   private int lastorder;
/*     */   private String holiday;
/*     */   private String writer;
/*     */   private String city_b;
/*     */   private String city_s;
/*     */   private String title;
/*     */   private String content;
/*     */   private Timestamp regdate;
/*     */   private int hit;
/*     */   private String gdsImg;
/*     */   private String gdsThumbImg;
/*     */ 
/*     */   public BoardVO()
/*     */   {
/*     */   }
/*     */ 
/*     */   public BoardVO(int num, String name, String carpark, String address, int open, int close, int breaktime, int lastorder, String holiday, String writer, String city_b, String city_s, String title, String content, Timestamp regdate, int hit, String gdsImg, String gdsThumbImg)
/*     */   {
/*  33 */     this.num = num;
/*  34 */     this.name = name;
/*  35 */     this.carpark = carpark;
/*  36 */     this.address = address;
/*  37 */     this.open = open;
/*  38 */     this.close = close;
/*  39 */     this.breaktime = breaktime;
/*  40 */     this.lastorder = lastorder;
/*  41 */     this.holiday = holiday;
/*  42 */     this.writer = writer;
/*  43 */     this.city_b = city_b;
/*  44 */     this.city_s = city_s;
/*  45 */     this.title = title;
/*  46 */     this.content = content;
/*  47 */     this.regdate = regdate;
/*  48 */     this.hit = hit;
/*     */   }
/*     */ 
/*     */   public int getNum() {
/*  52 */     return this.num;
/*     */   }
/*     */ 
/*     */   public void setNum(int num) {
/*  56 */     this.num = num;
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  60 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  64 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getCarpark() {
/*  68 */     return this.carpark;
/*     */   }
/*     */ 
/*     */   public void setCarpark(String carpark) {
/*  72 */     this.carpark = carpark;
/*     */   }
/*     */ 
/*     */   public String getGdsThumbImg() {
/*  76 */     return this.gdsThumbImg;
/*     */   }
/*     */ 
/*     */   public void setGdsThumbImg(String gdsThumbImg) {
/*  80 */     this.gdsThumbImg = gdsThumbImg;
/*     */   }
/*     */ 
/*     */   public String getAddress() {
/*  84 */     return this.address;
/*     */   }
/*     */ 
/*     */   public String getGdsImg() {
/*  88 */     return this.gdsImg;
/*     */   }
/*     */ 
/*     */   public void setGdsImg(String gdsImg) {
/*  92 */     this.gdsImg = gdsImg;
/*     */   }
/*     */ 
/*     */   public void setAddress(String address) {
/*  96 */     this.address = address;
/*     */   }
/*     */ 
/*     */   public int getOpen() {
/* 100 */     return this.open;
/*     */   }
/*     */ 
/*     */   public void setOpen(int open) {
/* 104 */     this.open = open;
/*     */   }
/*     */ 
/*     */   public int getClose() {
/* 108 */     return this.close;
/*     */   }
/*     */ 
/*     */   public void setClose(int close) {
/* 112 */     this.close = close;
/*     */   }
/*     */ 
/*     */   public int getBreaktime() {
/* 116 */     return this.breaktime;
/*     */   }
/*     */ 
/*     */   public void setBreaktime(int breaktime) {
/* 120 */     this.breaktime = breaktime;
/*     */   }
/*     */ 
/*     */   public int getLastorder() {
/* 124 */     return this.lastorder;
/*     */   }
/*     */ 
/*     */   public void setLastorder(int lastorder) {
/* 128 */     this.lastorder = lastorder;
/*     */   }
/*     */ 
/*     */   public String getHoliday() {
/* 132 */     return this.holiday;
/*     */   }
/*     */ 
/*     */   public void setHoliday(String holiday) {
/* 136 */     this.holiday = holiday;
/*     */   }
/*     */ 
/*     */   public String getWriter() {
/* 140 */     return this.writer;
/*     */   }
/*     */ 
/*     */   public void setWriter(String writer) {
/* 144 */     this.writer = writer;
/*     */   }
/*     */ 
/*     */   public String getCity_b() {
/* 148 */     return this.city_b;
/*     */   }
/*     */ 
/*     */   public void setCity_b(String city_b) {
/* 152 */     this.city_b = city_b;
/*     */   }
/*     */ 
/*     */   public String getCity_s() {
/* 156 */     return this.city_s;
/*     */   }
/*     */ 
/*     */   public void setCity_s(String city_s) {
/* 160 */     this.city_s = city_s;
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/* 164 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/* 168 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getContent() {
/* 172 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content) {
/* 176 */     this.content = content;
/*     */   }
/*     */ 
/*     */   public Timestamp getRegdate() {
/* 180 */     return this.regdate;
/*     */   }
/*     */ 
/*     */   public void setRegdate(Timestamp regdate) {
/* 184 */     this.regdate = regdate;
/*     */   }
/*     */ 
/*     */   public int getHit() {
/* 188 */     return this.hit;
/*     */   }
/*     */ 
/*     */   public void setHit(int hit) {
/* 192 */     this.hit = hit;
/*     */   }
/*     */ }

/* Location:           C:\Users\JOO\Downloads\project20220311 (1)\
 * Qualified Name:     com.zip.mat.board.command.BoardVO
 * JD-Core Version:    0.6.2
 */