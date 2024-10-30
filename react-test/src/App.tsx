import React, { useEffect, useState } from "react";
import "./App.css";
import axios from "axios";
import {
  Body,
  Box,
  Btn,
  DelBtn,
  Div,
  Input,
  InputBox,
  Li,
  Line,
  ListBox,
  Title,
  TitleBox,
  Ul,
} from "./styles/style";
import { queries } from "@testing-library/react";

interface BookResponse {
  id: number;
  bookTitle: string;
  bookAuthor: string;
  bookCategory: "인문" | "사회" | "과학기술" | "기타";
}

interface BookRequest {
  id: null;
  bookTitle: string;
  bookAuthor: string;
  bookCategory: "인문" | "사회" | "과학기술" | "기타";
}

function App() {
  const [books, setBooks] = useState<BookResponse[]>([]);

  const [request, setRequest] = useState<BookRequest>({
    id: null,
    bookTitle: "",
    bookAuthor: "",
    bookCategory: "기타",
  });

  const fetchBooks = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/test/books");
      console.log(response.data);

      if (response.data) {
        setBooks(response.data);
      }
    } catch (e) {
      console.error("데이터 로딩 실패", e);
    }
  };

  const handlePost = async (e: React.MouseEvent<HTMLButtonElement>) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:8080/api/test/books",
        request
      );
      fetchBooks();
    } catch (error) {
      console.error("데이터 전송 실패:", error);
    }
  };

  useEffect(() => {
    fetchBooks();
  }, []);

  const handleDelete = async (bookId: number) => {
    try {
      await axios.delete(`http://localhost:8080/api/test/books/${bookId}`);
      console.log("Deleted book ID:", bookId);
      // 삭제 후 목록 갱신
      fetchBooks();
    } catch (e) {
      console.error("삭제 실패", e);
    }
  };

  return (
    <Box>
      <Body>
        <TitleBox>
          <Title>Book - test</Title>
        </TitleBox>
        <InputBox>
          <Input
            placeholder="제목"
            value={request.bookTitle}
            onChange={(e) =>
              setRequest({ ...request, bookTitle: e.target.value })
            }
          />
          <Input
            placeholder="저자"
            value={request.bookAuthor}
            onChange={(e) =>
              setRequest({ ...request, bookAuthor: e.target.value })
            }
          />
          <Input
            placeholder="카테고리"
            value={request.bookCategory}
            onChange={(e) =>
              setRequest({
                ...request,
                bookCategory: e.target.value as BookRequest["bookCategory"],
              })
            }
          />
          <Btn onClick={handlePost}>제출</Btn>
        </InputBox>
        <Ul>
          {books.map((book) => (
            <Li key={book.id}>
              <ListBox>
                <Div>제목: {book.bookTitle}</Div>
                <Div>저자: {book.bookAuthor}</Div>
                <Div>분류: {book.bookCategory}</Div>
                <DelBtn
                  onClick={(e: React.MouseEvent) => handleDelete(book.id)}
                >
                  X
                </DelBtn>
              </ListBox>
              <Line />
            </Li>
          ))}
        </Ul>
      </Body>
    </Box>
  );
}

export default App;
