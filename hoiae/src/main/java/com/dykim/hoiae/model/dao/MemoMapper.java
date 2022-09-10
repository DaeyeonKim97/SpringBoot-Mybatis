package com.dykim.hoiae.model.dao;

import com.dykim.hoiae.model.dto.MemoDTO;
import com.dykim.hoiae.model.dto.ReplyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemoMapper {
    List<MemoDTO> selectAllMemo();
    MemoDTO selectMemoByCode(int code);
    int insertMemo(MemoDTO memo);
    int updateMemo(MemoDTO memo);
    int deleteMemo(int code);

    List<ReplyDTO> selectReplyByMemoCode(int memoCode);
    int insertReply(ReplyDTO reply);
    int deleteReply(int code);
}
