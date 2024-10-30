import styled from "styled-components";

export const Box = styled.div`
  width: 100vw;
  height: 100vh;
  margin: 0;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

export const Body = styled.div`
  border: none;
  width: 50%;
  height: 70%;
  border-radius: 10px;
  box-shadow: 0px 2px 4px rgba(0,0,0,0.4);
  display: flex;
  flex-direction: column;
  align-items: center;
  overflow: hidden;
`;

export const TitleBox = styled.div`
  width: 100%;
  background-color: #82AEF5;
`;

export const InputBox = styled.div`
  width: 100%;
  border: none;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  padding: 15px;
  border-bottom: 1px solid #eee;
`;

export const Input = styled.input`
  width: 20%;
  padding: 10px;
  border: none;
  background-color: #eee;
  outline: #ccc;
  border-radius: 10px;
`;

export const Btn = styled.button`
  width: 70px;
  border-radius: 10px;
  background-color: #82AEF5;
  color: white;
  padding: 5px;
  border: 1px solid  #82AEF5;
  cursor: pointer;
  &:hover{
    background-color: #5F7DFF;
    border: 1px solid #5F7DFF;
  }
`;


export const Title = styled.h2`
  text-align: center;
  color: white;
`;

export const Ul = styled.ul`
  width: 70%;
  height: 100%;
  padding: 0;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  gap: 10px; /* 리스트 아이템 간격을 고정 */
`;

export const ListBox = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
`;

export const Li = styled.li`
  width: 100%;
  margin-top: 15px;
  margin-bottom: 15px;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
`;

export const Line = styled.span`
  width: 100%;
  border: 1px solid #ccc;
  margin-top: 7px;
`;

export const Div = styled.div`
  width: 25%;
`;

export const DelBtn = styled.button`
  background-color: #fff;
  border: 1px solid #f44336;
  /* padding: 10px; */
  border-radius: 3px;
  color: red;
  cursor: pointer;
  &:hover{
    background-color: #d32f2f;
    border: 1px solid #d32f2f;
  }
`;

