package com.hs.s3.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.s3.board.BoardDTO;
import com.hs.s3.board.BoardService;
import com.hs.s3.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;

	// --- getList ---------------------------------------
	public List<BoardDTO> getList(Pager pager) throws Exception {
		long perPage = 10; // 한 페이지당 보여줄 글의 개수
		long perBlock = 5; // 한 블럭 당 보여줄 숫자의 개수

		// -------- startRow, lastRow 계산 ---------
		long startRow = (pager.getCurPage() - 1) * perPage + 1;
		long lastRow = pager.getCurPage() * perPage;

		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		// -----------------------------------------

		// -----------------------------------------
		// 1. totalCount
		long totalCount = noticeDAO.getTotalCount(pager);
		System.out.println("totalCount : " + totalCount);

		// 2. totalPage
		long totalPage = totalCount / perPage;
		if (totalCount % perPage != 0) {
			totalPage++;
		}

		// 3. totalBlock
		long totalBlock = totalPage / perBlock;
		if (totalPage % perBlock != 0) {
			totalBlock++;
		}

		// 4. curBlock
		long curBlock = pager.getCurPage() / perBlock;
		if (pager.getCurPage() % perBlock != 0) {
			curBlock++;
		}

		// 5. startNum, lastNum
		long startNum = (curBlock - 1) * perBlock + 1;
		long lastNum = curBlock * perBlock;

		// 6. curBlock이 마지막 block일때(totalBlock)
		if (curBlock == totalBlock) {
			lastNum = totalPage;
		}

		pager.setStartNum(startNum);
		pager.setLastNum(lastNum);
		
		// 7. 이전, 다음 block 존재 여부
		// 이전
		if (curBlock != 1) {
			pager.setPre(true);
		}

		// 다음
		if (curBlock != totalBlock) {
			pager.setNext(true);
		}


		System.out.println("TotalPage : " + totalPage);
		System.out.println("TotalBlock : " + totalBlock);
		System.out.println("CurBlock : " + curBlock);

		return noticeDAO.getList(pager);
	}

	
	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
}