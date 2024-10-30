package org.example.springboottest.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, name = "book_title")
    private String bookTitle;

    @Column(nullable = false, length = 100, name = "book_author")
    private String bookAuthor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100, name = "book_category")
    private Category bookCategory;


    @Builder
    public Book(String bookTitle, String bookAuthor, Category bookCategory) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookCategory = bookCategory;
    }
}
