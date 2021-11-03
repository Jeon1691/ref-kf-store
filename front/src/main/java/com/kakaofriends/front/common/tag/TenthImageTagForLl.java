package com.kakaofriends.front.common.tag;

import com.kakaofriends.front.utils.TenthUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

/**
 * tenth2 썸네일 커스텀 태그
 */
public class TenthImageTagForLl extends RequestContextAwareTag {

	private static final long serialVersionUID = 1L;

	@Autowired
	private TenthUtill tenthUtill; // application의 설정값을 사용하기 위해 추가

	private String type; //Tenth2 경로 폴더명
	private String imageName; //이미지 파일 명
	private String altVal; //alt 값을 사용하기 위해 추가

	@Override
	protected int doStartTagInternal() throws Exception {
		tenthUtill = getRequestContext().getWebApplicationContext().getBean(TenthUtill.class);
		try {
			JspWriter out = pageContext.getOut();

			String imgSrc = tenthUtill.tenth2ThumbnailPath(imageName, type);


			out.println("<img data-src=\"" + imgSrc + "\" class=\"thumb_g\" alt=\"" + altVal + "\">");
			return EVAL_PAGE;
		} catch (IOException e) {
			throw new JspException();
		}
	}

	public void setType(String type) {
		this.type = type;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public void setAltVal(String altVal) {
		this.altVal = altVal;
	}
}