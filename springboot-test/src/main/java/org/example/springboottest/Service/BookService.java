package org.example.springboottest.Service;


import lombok.RequiredArgsConstructor;
import org.example.springboottest.Dto.Request.PostBookRequestDto;
import org.example.springboottest.Dto.Response.GetBookListResponseDto;
import org.example.springboottest.Dto.Response.GetBookResponseDto;
import org.example.springboottest.Dto.Response.PostBookResponseDto;
import org.example.springboottest.Dto.Response.ResponseDto;
import org.example.springboottest.Entity.Book;
import org.example.springboottest.Repository.BookRepository;
import org.example.springboottest.common.constant.ResponseMessage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    // 1. 게시글 생성(Post)
    public ResponseDto<PostBookResponseDto> createBook(PostBookRequestDto requestDto) {
        PostBookResponseDto data = null;

        try{
            Book book = Book.builder()
                    .bookTitle(requestDto.getBookTitle())
                    .bookAuthor(requestDto.getBookAuthor())
                    .bookCategory(requestDto.getBookCategory())
                    .build();

            bookRepository.save(book);

            data = new PostBookResponseDto(book);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 2. 전체 책 조회
    public ResponseDto<List<GetBookListResponseDto>> getAllBooks() {
        List<GetBookListResponseDto> data = null;
        try{
            List<Book> books = bookRepository.findAll();
                data = books.stream()
                    .map(GetBookListResponseDto::new)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
         return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 3. 특정 ID 책 조회
    public ResponseDto<GetBookResponseDto> getBookById(Long id) {
        GetBookResponseDto data = null;

        try {
            Optional<Book> optionalBook = bookRepository.findById(id);
            if(optionalBook.isPresent()) {
                data = new GetBookResponseDto(optionalBook.get());
            }else {
                return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_DATA);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }


    // 4, 특정 ID 책 수정
    public ResponseDto<PostBookResponseDto> updateBook(Long id, PostBookRequestDto updateDto) {
        PostBookResponseDto data = null;

        try{
            Optional<Book> optionalBook = bookRepository.findById(id);

            if(optionalBook.isPresent()) {
                Book book = optionalBook.get();
                book.setBookTitle(updateDto.getBookTitle());
                book.setBookAuthor(updateDto.getBookAuthor());
                book.setBookCategory(updateDto.getBookCategory());

                bookRepository.save(book);
                data = new PostBookResponseDto(book);
            } else {
                ResponseDto.setFailed(ResponseMessage.NOT_EXIST_DATA);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 5. 책 삭제
    public ResponseDto<Void> deleteBook(Long id) {
        try{
            if(!bookRepository.existsById(id)) {
                return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_DATA);
            }

            bookRepository.deleteById(id);
            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
    }
}
