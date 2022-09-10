package com.dykim.hoiae.service;

import com.dykim.hoiae.model.dao.MemoMapper;
import com.dykim.hoiae.model.dto.MemoDTO;
import com.dykim.hoiae.model.dto.ReplyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemoService {
    private final MemoMapper memoMapper;

    @Autowired
    public MemoService(MemoMapper memoMapper) {
        this.memoMapper = memoMapper;
    }

    public List<MemoDTO> selectAllMemo(){
        return memoMapper.selectAllMemo();
    }

    public MemoDTO selectMemoByCode(int code){
        return memoMapper.selectMemoByCode(code);
    }

    @Transactional
    public boolean insertMemo (MemoDTO memo) throws Exception {

        int result = memoMapper.insertMemo(memo);
        if(result <= 0){
            throw new Exception("메모 등록 실패");
        }

        return result > 0;
    }

    @Transactional
    public boolean updateMemo (MemoDTO memo) throws Exception {
        int result = memoMapper.updateMemo(memo);
        if(result <= 0){
            throw new Exception("메모 업데이트 실패");
        }

        return result > 0;
    }

    @Transactional
    public boolean deleteMemo (int code) throws Exception {
        int result = memoMapper.deleteMemo(code);

        if(result <= 0){
            throw new Exception("메모 삭제 실패");
        }

        return result > 0;
    }

    public List<ReplyDTO> selectReplyByMemoCode(int memoCode){
        return memoMapper.selectReplyByMemoCode(memoCode);
    }

    @Transactional
    public boolean insertReply(ReplyDTO reply) throws Exception {
        int result = memoMapper.insertReply(reply);

        if(result <= 0){
            throw new Exception("답글 작성 실패");
        }

        return result > 0;
    }

    @Transactional
    public boolean deleteReply(int code) throws Exception {
        int result = memoMapper.deleteReply(code);

        if(result <= 0){
            throw new Exception("답글 삭제 실패");
        }

        return result > 0;
    }
}
