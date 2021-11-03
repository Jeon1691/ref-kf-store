package com.kakaofriends.front.repository;


import com.kakaofriends.core.domain.Config;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@PrimaryMapper
public interface ConfigRepository {

	@Results({
			@Result(property = "cfSeq", column = "CF_SEQ"),
			@Result(property = "cfId", column = "CF_ID"),
			@Result(property = "cfName", column = "CF_NAME"),
			@Result(property = "cfValue", column = "CF_VALUE")
	})
	@Select("SELECT CF_SEQ, CF_ID, CF_NAME, CF_VALUE FROM CONFIG WHERE CF_ID = #{cfId}")
	Config findByCfId(String cfId);
}
