#ifndef __ANIMAL_H__
#define __ANIMAL_H__

#include <vector>
#include <algorithm>

#include "food.h"

class Animal {
public:
    int point;
    std::vector<Food> stomach;

    Animal(int point) : point(point) {}

    virtual void eat(Food& food);
    virtual Food pop();
    virtual void fight(Animal& animal);
};

class Lion : public Animal {
public:
    Lion(int point)
    : Animal(point * 3) {

    }

    void eat(Food& food){
        this->point = food.point;
        this->stomach.push_back(food);
    }

    Food pop(){
        Food returnFood = {0};
        if(this->stomach.size() == 0) return returnFood;

        int min_food = 0;
        for(int i = 0; i < this->stomach.size(); i++){
            if(stomach[min_food].point > stomach[i].point) min_food = i;
        }

        returnFood = this->stomach[min_food];
        returnFood.point = std::max(0,returnFood.point-10);
        stomach.erase(stomach.begin()+min_food);

        return returnFood;

    }

    void fight(Animal& animal){
        animal.point = std::max(0,animal.point - this->point/2);
        if(animal.point <= 0) this->point += 10;
        else this->point += 5;
    }

    void shout(){
        if(this->point <= 0) return;
        if(this->stomach.size() == 0) return;

        this->point = std::max(0,this->point - 5);
        
        int max_food = 0;
        for(int i = 0; i < this->stomach.size(); i++){
            if(this->stomach[max_food].point < this->stomach[i].point) max_food = i;
        }

        this->stomach.erase(stomach.begin() + max_food);

    }
};

class Rabbit : public Animal{
public:
    Rabbit(int point)
    : Animal(point * 2) {
        
    }
    
    void eat(Food& food){
        this->point = food.point;
        this->stomach.push_back(food);
    }

    Food pop(){
        Food returnFood = {0};
        if(this->stomach.size() == 0) return returnFood;

        int max_food = 0;
        for(int i = 0; i < this->stomach.size(); i++){
            if(stomach[max_food].point < stomach[i].point) max_food = i;
        }

        returnFood = this->stomach[max_food];
        returnFood.point = std::max(0,returnFood.point-10);
        
        stomach.erase(stomach.begin()+max_food);

        return returnFood;
    }

    void fight(Animal& animal){
        animal.point = std::max(0,animal.point - this->point/2);
        this->point = std::max(0,this->point - 5);
    }

    void run(){
        if(this->point <= 0) return;
        if(this->stomach.size() == 0) return;


        this->point = std::max(0,this->point - 10);
        
        int min_food = 0;
        
        for(int i = 0; i < this->stomach.size(); i++){
            if(this->stomach[min_food].point > this->stomach[i].point) min_food = i;
        }

        stomach.erase(stomach.begin() + min_food);
    }
};

class Human : public Animal {
public:
    Human(int point)
    : Animal(point) {

    }

    bool DoSleep = false;
    
    void eat(Food& food){
        this->point += (this->DoSleep) ? food.point*2 : food.point;
        this->stomach.push_back(food);
        this->DoSleep = false;
    }

    Food pop(){
        Food returnFood = {0};
        if(this->stomach.size() == 0) return returnFood;
        returnFood = this->stomach[stomach.size()-1];
        returnFood.point -= 10;
        this->stomach.pop_back();
        return returnFood;
    }

    void fight(Animal& animal){
        if(this->stomach.size() == 0){
            this->point = 0;
            return;
        }

        animal.point = std::max(0,animal.point - this->point/2);
        this->stomach.erase(this->stomach.begin());
    }

    void sleep(){
        this->point = std::max(0,this->point - (int)this->stomach.size());
        this->DoSleep = true;
    }
};

#endif
