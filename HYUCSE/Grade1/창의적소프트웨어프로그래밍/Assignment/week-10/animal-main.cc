// animal-main.cc

#include <iostream>
#include <vector>
#include <string>
#include "animal.h"

std::vector<Animal*> animals;

char a;
std::string name;
int age;
std::string favoriteToy;
int numStripes;

int main() {
    while (true)
    {
        std::cin >> a;
        if(a == '0') break;
        if(a == 'z'){
            std::cin >> name >> age >> numStripes;
            Animal* z = new Zebra(name,age,numStripes);
            animals.push_back(z);
        }
        if(a == 'c'){
            std::cin >> name >> age >> favoriteToy;
            Animal* c = new Cat(name,age,favoriteToy);
            animals.push_back(c);
        }

    }

    for(int i = 0; i < animals.size(); i++){
        animals[i]->printInfo();
        delete animals[i];
    }
    
}