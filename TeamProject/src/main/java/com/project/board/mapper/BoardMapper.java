package com.project.board.mapper;

import java.util.ArrayList;
import com.project.board.command.BoardVO;
import com.project.board.command.Criteria;

public  interface BoardMapper
{
  public  ArrayList<BoardVO> pagingList(Criteria paramCriteria);

  public  ArrayList<BoardVO> pagingSearchList(Criteria paramCriteria);
  
  public  int getTotal(String paramString);

  public  void insertBoard(BoardVO paramBoardVO);

  public  BoardVO getContent(int paramInt);

  public  boolean updateBoard(BoardVO paramBoardVO);

  public  void deleteBoard(int paramInt);

  public  void upHit(int paramInt);
  
  public int getmodifyinfo(int num, String user_id);
  
  public int getSearchTotal(String paramString);
 
}
