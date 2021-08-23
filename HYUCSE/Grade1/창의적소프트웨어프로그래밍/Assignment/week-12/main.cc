#include <bits/stdc++.h>
#include "vector.h"

int main(){
    auto v = Vector<int>();

    std::cout << v.begin() << std::endl;
    std::cout << v.end() << std::endl;

    std::cout << v[0] << std::endl;

    std::cout << v.empty() << std::endl;
    std::cout << v.size() << " " << v.capacity() << std::endl;

    v.push_back(1);
    v.push_back(2);
    v.push_back(3);

    auto iter = v.begin();
    v.insert(iter+1, 10000);

    std::cout << v.empty() << std::endl;
    std::cout << v.size() << " " << v.capacity() << std::endl;

    for(auto i = v.begin(); i != v.end(); i++){
        std::cout << *i << " ";
    }
    std::cout << std::endl;

    v.pop_back();
    v.pop_back();

    for(int i = 0; i < v.size(); i++){
        std::cout << v[i] << " ";
    }
    std::cout << std::endl;    

    v.erase(v.begin());

    for(int i = 0; i < v.size(); i++){
        std::cout << v[i] << " ";
    }
    std::cout << std::endl;    



    v.push_back(1);
    v.push_back(2);
    v.insert(v.begin() + 1, 44);
    std::cout << v;
}