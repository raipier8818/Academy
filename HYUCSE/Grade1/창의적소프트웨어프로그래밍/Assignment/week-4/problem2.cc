#include <iostream>

template <typename T>
struct dynamic_array {
    T* pointer = nullptr;
    size_t cap = 0;

public:
    dynamic_array(size_t cap)
    : cap(cap) {
        this->pointer = new T[cap];
    }

    void printArr(){
        std::cout << "---" << std::endl;
        for(int i = 0; i < cap; i++){
            std::cout << pointer[i] << std::endl;
        }
        std::cout << "---" << std::endl;

    }

    void push_front(const T& element) {
        // TODO: push_front
        // if array is [2,3] and pop_front(1) called
        // then array should be [1,2,3]

        pointer = (T*)realloc(pointer, cap+1);
        for(int i = cap; i > 0; i--){
            pointer[i] = pointer[i-1];
        }
        pointer[0] = element;
        cap++;
    }

    void push_back(const T& element) {
        // TODO: push_back
        // if array is [1,2] and pop_front(3) called
        // then array should be [1,2,3]

        pointer = (T*) realloc(pointer,cap+1);
        pointer[cap] = element;
        cap++;

    }

    T pop_front() {
        // TODO: pop front
        // if array is [1,2,3], and pop_front called
        // then array should be [2,3] and return 1

        T returnNum = pointer[0];
        for(int i = 0; i < cap-1; i++){
            pointer[i] = pointer[i+1];
        }
        pointer = (T*)realloc(pointer,cap-1);
        cap--;

        return returnNum;

    }

    T pop_back() {
        // TODO: pop back
        // if array is [1,2,3], and pop_front called
        // then array should be [1,2] and return 3

        T returnNum = pointer[cap-1];
        pointer = (T*)realloc(pointer,cap-1);
        cap--;

        return returnNum;
    }

    ~dynamic_array() {
        delete[] this->pointer;
    }
};

int main() {

    {
        auto v = dynamic_array<int>(3);
        v.pointer[0] = 1;
        v.pointer[1] = 2;
        v.pointer[2] = 3;
        v.printArr();

        v.push_front(9);
        v.push_back(5);
        v.printArr();

        std::cout << v.pop_back() << std::endl;
        std::cout << v.pop_front() << std::endl;

        v.printArr();

    }
    return 0;
}