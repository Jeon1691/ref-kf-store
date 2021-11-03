package com.kakaofriends.front.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by breeze.hwi@kakaocorp.com on 2017. 11. 10.
 */
@Data
public class Migration {
    private String tableName;           // 대상 테이블

    private String columnName;          // 대상 컬럼

    private String targetId;            // 기존 카카오 ID

    private Long id;                    // 신규 회원 ID

    private int count;                  // 대상 수

    private LocalDateTime createDate;   // 마이그레이션 시간
}
