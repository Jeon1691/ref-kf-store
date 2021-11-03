package com.kakaofriends.front.domain;

import com.kakaofriends.core.common.configuration.persistence.type.BoardReplyType;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

public class BoardArticleDto {

	@Data
	public static class BoardArticleOneToOneRequest {
		private String bdaBdid = "oneone";
		private Long bdaBdcseq;
		private String bdaOwnerid;
		@Length(min = 1, max = 20)
		private String bdaOwnername;
		@Email
		private String bdaEmail;
		@Length(min = 1, max = 20)
		private String bdaPhone;
		private String bdaName;
		private MultipartFile bdaFile;
		private String bdaContent;
		private Boolean replyyn = false;
		private String bdaCpCode;
		private BoardReplyType bdaEtc3;
		private String originalFileName;
		private String bdaReplyyn = "N";
		private Long bdaLevelnum = 1L;
		private Long bdaStepnum = 1L;
		private Long bdaCmcount = 0L;
		private Long bdaStatus = 1L;
		private String bdaLanguage;
		private String bdaUse = "Y";
	}
}
