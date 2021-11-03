package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.common.CommonCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@PrimaryMapper
@Repository
public interface CommonCodeRepository {

    List<CommonCode> findAllByCodeType( @Param( "codeType" ) String codeType );

}