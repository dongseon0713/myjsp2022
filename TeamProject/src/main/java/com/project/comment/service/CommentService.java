package com.project.comment.service;


import java.util.ArrayList;

import com.project.comment.command.CommentVO;

public interface CommentService
{
  public int submit(CommentVO paramCommentVO);

  public ArrayList<CommentVO> getList(int paramInt);

  public int submitPw(String paramString, int paramInt);

  public int delete(int paramInt);
}