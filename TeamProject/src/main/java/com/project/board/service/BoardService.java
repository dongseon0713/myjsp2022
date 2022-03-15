package com.project.board.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.project.board.command.BoardVO;
import com.project.board.command.Criteria;

public  interface BoardService
{
  public  ArrayList<BoardVO> getList(Criteria paramCriteria);
  
  public ArrayList<BoardVO> getSearchList(Criteria paramCriteria);

  public  int getTotal(String city_b);
  
  public int getSearchTotal(String city_b);

  public  void register(BoardVO paramBoardVO);

  public  BoardVO getContent(int paramInt);

  public  void updateBoard(BoardVO paramBoardVO);

  public  void deleteBoard(int paramInt);
  
  public int getmodifyinfo(@Param("num") int num, @Param("user_id") String user_id);
  
  public void boardHit(int num);
}