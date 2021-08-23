// file: contacts.cc
#include <iostream>

struct student_t {
    int id;
    std::string name;
    std::string phone;
};

int main() {
    int N, M;
    std::cin >> N;
    
    // write code here
    // You need to declare student_type as an array.
    
    student_t arr[100];

    // run N-loops 
    for (int i = 0; i < N; i++) {
        int input_id;
        std::string input_name;
        std::string input_phone;
        
        std::cin >> input_id;
        std::cin >> input_name;
        std::cin >> input_phone;
        
        // write code here
        // put the entered information into the declared student information.

        arr[i].id = input_id;
        arr[i].name = input_name;
        arr[i].phone = input_phone;

    }
    
    std::cin >> M;
    
    // write code here
    // run M-loops
    // and print out student information after input student id
    
    for (int i = 0; i < M; i++){
        int check_id, check = 0;
        std::cin >> check_id;
        for (int j = 0; j < N; j++){
            if (check_id == arr[j].id){
                std::cout << arr[j].name << "," << arr[j].phone << std::endl;
                check = 1;
                break;
            }
        }
        if (check == 0){
            std::cout << "Unknown" << std::endl;
        }
    }


    return 0;
}