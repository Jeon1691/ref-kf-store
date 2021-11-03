package com.kakaofriends.front.service.mypage;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.core.domain.BoardArticle;
import com.kakaofriends.front.common.external.FileTransferProtocolComponent;
import com.kakaofriends.front.domain.BoardArticleDto;
import com.kakaofriends.front.repository.BoardArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


@Service
public class OneToOneServiceImpl implements OneToOneService {

    @Autowired
    private BoardArticleRepository boardArticleRepository;

    @Autowired
    private FileTransferProtocolComponent fileTransferProtocolComponent;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int registerOneToOneArticle(BoardArticleDto.BoardArticleOneToOneRequest oneToOneArticle) throws Exception {

        //파일이 있을 경우
        if (null != oneToOneArticle.getBdaFile() && oneToOneArticle.getBdaFile().getSize() > 0) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            int ms = cal.get(Calendar.MILLISECOND);

            oneToOneArticle.setOriginalFileName( sdf.format(cal.getTime()) + String.valueOf(ms) + oneToOneArticle.getOriginalFileName().substring(oneToOneArticle.getOriginalFileName().lastIndexOf(".")));
            fileTransferProtocolComponent.uploadFile("/board", oneToOneArticle.getOriginalFileName(), oneToOneArticle.getBdaFile());
        }
        boardArticleRepository.insertOneToOneArticle(oneToOneArticle);
        return 0;
    }

    @Override
    public int findOneToOneArticlesCountByUserId(String userId) {
        return boardArticleRepository.getOneToOneArticlesCountByUserId(userId);
    }

    @Override
    public List<BoardArticle> findOneToOneArticlesByUserId(String userId, PaginationInfo pagination) {
        return boardArticleRepository.getOneToOneArticlesByUserId(userId, pagination);
    }

    @Override
    public List<BoardArticle> findOneToOneAnswersByUserId(String userId, PaginationInfo pagination) {
        return boardArticleRepository.getOneToOneAnswersByUserId(userId, pagination);
    }
}
