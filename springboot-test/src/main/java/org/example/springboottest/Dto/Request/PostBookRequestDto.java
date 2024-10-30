package org.example.springboottest.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springboottest.Entity.Category;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostBookRequestDto {
    private String bookTitle;
    private String bookAuthor;
    private Category bookCategory;
}
