package com.kakaofriends.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardArticleExpansion {
    private BoardArticle boardArticle;
    private BoardCategory boardCategory;
}
