package org.example.springboottest.Controller;


import lombok.RequiredArgsConstructor;
import org.example.springboottest.Dto.Request.PostBookRequestDto;
import org.example.springboottest.Dto.Response.GetBookListResponseDto;
import org.example.springboottest.Dto.Response.GetBookResponseDto;
import org.example.springboottest.Dto.Response.PostBookResponseDto;
import org.example.springboottest.Dto.Response.ResponseDto;
import org.example.springboottest.Service.BookService;
import org.example.springboottest.common.constant.ApiMappingPattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(ApiMappingPattern.BOOK)
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    public static final String MENU_POST = "/";


    @PostMapping
    public ResponseEntity<ResponseDto<PostBookResponseDto>> createBook(@RequestBody PostBookRequestDto requestDto) {
        ResponseDto<PostBookResponseDto> result = bookService.createBook(requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    // 전체 책 조회
    @GetMapping
    public ResponseEntity<List<GetBookListResponseDto>> getAllBooks() {
        ResponseDto<List<GetBookListResponseDto>> books = bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(books.getData());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetBookResponseDto> getBookById(@PathVariable Long id) {
        GetBookResponseDto book = bookService.getBookById(id).getData();
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PostBookResponseDto> updateBook(
            @PathVariable Long id, @RequestBody PostBookRequestDto requestDto
    ) {
        ResponseDto<PostBookResponseDto> updatedBook = bookService.updateBook(id, requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedBook.getData());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Void>> deleteBook(@PathVariable Long id) {
        ResponseDto<Void> result = bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
