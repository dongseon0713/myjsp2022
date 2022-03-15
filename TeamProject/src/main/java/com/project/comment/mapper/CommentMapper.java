package com.project.comment.mapper;

import java.util.ArrayList;

import com.project.comment.command.CommentVO;

public interface CommentMapper {
  public void submit(CommentVO paramCommentVO);

  public ArrayList<CommentVO> getList(int paramInt);

  public int submitPw(String paramString, int paramInt);

  public void delete(int paramInt);
}