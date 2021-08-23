# Vector.h Report

private : element, s, c

1. element : vector의 원소가 담기는 배열의 주소
2. s : vector의 size, vector의 원소의 개수
3. c : vector의 capacity, element가 가지는 메모리 크기

## 1. Constructor

- input : None → size는 0, capacity는 1로 설정
- input : (size_t) n → size는 n, capacity는 2n으로 설정
- input : (size_t) n, (T) val → size는 n, capacity는 2n으로 설정, n개의 값을 val로 초기화
- input : (Vector<T>) copy → copy의 모든 값을 복사

## 2. Methods

- capacity() : c를 반환
- size() : s를 반환
- empty() : s == 0 일때 true를 반환
- clear() : s에 0을 대입, c에 1을 대입, element를 초기화
- insert(T* position, T val) : position(포인터)에 val을 대입
- insert(T* position, size_t n, T val) : position(포인터)에 n개의 val을 대입
- erase(T* position) : position의 값을 삭제
- erase(T* f_position, T* s_position) : [f_position, s_position)의 값을 삭제
- push_back(T a) : a를 제일 뒤에 삽입
- pop_back() : 제일 마지막 값을 삭제
- resize(T a) : a > capacity이면, Vector가 a의 capacity를 가지도록 element를 확장
- operator[size_t index] : element[index] 값을 반환

## 3. Operator

- "==" : Vector의 size가 같고, 모든 요소의 값이 같으면 true, 아니면 false를 반환
- ">" : Vector의 size를 비교해서 크면 true를 반환, size가 같으면 원소를 하나씩 비교해서 크면 true를 반환
- "<" : Vector의 size를 비교해서 작으면 true를 반환, size가 같으면 원소를 하나씩 비교해서 작으면 true를 반환
- ">=" : Vector의 size를 비교해서 크거나 같으면 true를 반환, size가 같으면 원소를 하나씩 비교해서 크거나 같으면 true를 반환
- <= : Vector의 size를 비교해서 작거나 같으면 true를 반환, size가 같으면 원소를 하나씩 비교해서 작거나 같으면 true를 반환
- ">>" : 원소를 Vector의 size만큼 받아서 Vector에 push back함
- "<<" : Vector의 원소를 comma를 기준으로 구분해서 출력함
- "=" : 다른 Vector의 size와 capacity와 모든 element의 값을 복사함