/*    */ package com.project.util;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.text.DecimalFormat;
/*    */ import java.util.Calendar;
/*    */ import java.util.UUID;
/*    */ import net.coobird.thumbnailator.Thumbnails;
/*    */ import net.coobird.thumbnailator.Thumbnails.Builder;
/*    */ import org.springframework.util.FileCopyUtils;
/*    */ 
/*    */ public class UploadFileUtils
/*    */ {
/*    */   static final int THUMB_WIDTH = 300;
/*    */   static final int THUMB_HEIGHT = 300;
/*    */ 
/*    */   public static String fileUpload(String uploadPath, String fileName, byte[] fileData, String ymdPath)
/*    */     throws Exception
/*    */   {
/* 20 */     UUID uid = UUID.randomUUID();
/*    */ 
/* 22 */     String newFileName = uid + "_" + fileName;
/* 23 */     String imgPath = uploadPath + ymdPath;
/*    */ 
/* 25 */     File target = new File(imgPath, newFileName);
/* 26 */     FileCopyUtils.copy(fileData, target);
/*    */ 
/* 28 */     String thumbFileName = "s_" + newFileName;
/* 29 */     File image = new File(imgPath + File.separator + newFileName);
/*    */ 
/* 31 */     File thumbnail = new File(imgPath + File.separator + "s" + File.separator + thumbFileName);
/*    */ 
/* 33 */     if (image.exists()) {
/* 34 */       thumbnail.getParentFile().mkdirs();
/* 35 */       Thumbnails.of(new File[] { image }).size(300, 300).toFile(thumbnail);
/*    */     }
/* 37 */     return newFileName;
/*    */   }
/*    */ 
/*    */   public static String calcPath(String uploadPath) {
/* 41 */     Calendar cal = Calendar.getInstance();
/* 42 */     String yearPath = File.separator + cal.get(1);
/* 43 */     String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(2) + 1);
/* 44 */     String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(5));
/*    */ 
/* 46 */     makeDir(uploadPath, new String[] { yearPath, monthPath, datePath });
/* 47 */     makeDir(uploadPath, new String[] { yearPath, monthPath, datePath + "\\s" });
/*    */ 
/* 49 */     return datePath;
/*    */   }
/*    */ 
/*    */   private static void makeDir(String uploadPath, String[] paths)
/*    */   {
/* 54 */     if (new File(paths[(paths.length - 1)]).exists()) return;
/*    */ 
/* 56 */     for (String path : paths) {
/* 57 */       File dirPath = new File(uploadPath + path);
/*    */ 
/* 59 */       if (!dirPath.exists())
/* 60 */         dirPath.mkdir();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\JOO\Downloads\project20220311 (1)\
 * Qualified Name:     com.zip.mat.util.UploadFileUtils
 * JD-Core Version:    0.6.2
 */