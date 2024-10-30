package org.example.springboottest.Dto.Response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springboottest.Entity.Book;
import org.example.springboottest.Entity.Category;

@Getter
@Setter
@NoArgsConstructor
public class GetBookListResponseDto {
    private Long id;
    private String bookTitle;
    private String bookAuthor;
    private Category bookCategory;

    public GetBookListResponseDto(Book book) {
        this.id = book.getId();
        this.bookTitle = book.getBookTitle();
        this.bookAuthor = book.getBookAuthor();
        this.bookCategory = book.getBookCategory();
    }
}
