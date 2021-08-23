#include <iostream>
#include <vector>
#include <algorithm>

class Person {
public:
    std::string name;
    int assets;

    Person(std::string name, int assets)
    : name(name), assets(assets) {
    }
};

bool operator==(const Person& lhs, const Person& rhs) {
    return &lhs == &rhs;
}


class Vehicle {
public:
    float max_speed, cur_speed;
    int max_passengers;
    std::vector<Person *> passengers;

    Vehicle(float max_speed, int max_passengers)
    : max_speed(max_speed), cur_speed(0), max_passengers(max_passengers) {
    }

    void start() {
        cur_speed = max_speed;
    }

    void stop() {
        cur_speed = 0.f;
    }

    int size() {
        return passengers.size();
    }

    virtual void get_in(Person& person) { }
    virtual void get_off(Person& person) { }
};

class Car : public Vehicle {
public:
    Person& owner;

    Car(float max_speed, int max_passengers, Person& owner)
    : Vehicle(max_speed, max_passengers), owner(owner) {
        start();
    }

    void get_in(Person& person) {
        if(size() >= max_passengers) return;

        if(size() == 0 && person == owner) 
        {
            this->passengers.push_back(&person);
            return;
        }
        if(size() > 0){
            this->passengers.push_back(&person);
        }
    }
    
    void get_off(Person& person) {
        if(person == owner){
            this->passengers.clear();
            return;
        }
        for(int i = 0; i < size(); i++){
            if(person == *(this->passengers[i])) {this->passengers.erase(this->passengers.begin()+i); return;}
        }
    }
};

class Bus : public Vehicle {
    int charge;

    Bus(float max_speed, int max_passengers, int charge)
    : Vehicle(max_speed, max_passengers), charge(charge) {
        start();
    }

    void get_in(Person& person) {
        if(size() < this->max_passengers){
            if(person.assets >= charge)
            {
                person.assets -= charge;
                this->passengers.push_back(&person);
            }
        }
    }
    void get_in(std::vector<Person *> people) {
        for(int i = 0; i < people.size(); i++){
            if(size() >= this->max_passengers) return;

            if(people[i]->assets < charge) continue;
            people[i]->assets -= charge;
            this->passengers.push_back(people[i]);
        }
    }
    void get_off(Person& person) {
        for(int i = 0; i < this->passengers.size(); i++){
            if(*this->passengers[i] == person){
                this->passengers.erase(this->passengers.begin()+i);
                return; 
            }
        }
    }
    void get_off(std::vector<Person *> people) {
        for(int i = 0; i < people.size(); i++){
            for(int j = 0; j < size(); j++){
                if(*people[i] == *this->passengers[j]) {
                    this->passengers.erase(this->passengers.begin()+j); 
                    break;
                }
            }
        }
    }

    void start(){
        this->cur_speed = this->max_speed/2;
    }
};

class Taxi : public Vehicle {
    int charge;

    Taxi(float max_speed, int max_passengers, int charge)
        : Vehicle(max_speed, max_passengers), charge(charge) {
    }

    void get_in(Person& person) {

        if (size() > 0) return;

        if(size() < this->max_passengers){
            if(person.assets >= charge)
            {
                this->passengers.push_back(&person);
            }
        }
    }

    void get_in(std::vector<Person *> people) {
        if(people.size() > this->max_passengers) return;
        if(size() > 0) return;

        for(int i = 0; i < people.size(); i++){
            this->passengers.push_back(people[i]);
        }
    }

    void get_off(Person& person) {
        for(int i = 0; i < size(); i++){
            if(*this->passengers[i] == person){
                this->passengers[i]->assets -= charge;
                this->passengers.erase(this->passengers.begin()+i);
                return; 
            }
        }
    }
    void get_off(std::vector<Person *> people) {
        for(int i = 0; i < people.size(); i++){
            for(int j = 0; j < size(); j++){
                if(*people[i] == *this->passengers[j]) {
                    this->passengers[i]->assets -= charge;
                    this->passengers.erase(this->passengers.begin()+j); 
                    break;
                }
            }
        }
    }
};

int main() {
    Person jiun{"jiun", 300};

    Car jiun_car{30, 3, jiun};

    Person jisu1{"jisu1", 100};
    Person jisu2{"jisu2", 100};
    Person jisu3{"jisu3", 100};
    Person jisu4{"jisu4", 100};

    jiun_car.get_in(jiun);
    jiun_car.get_in(jisu1);
    jiun_car.get_in(jisu2);

    for (auto v : jiun_car.passengers) {
        std::cout << v->name << std::endl;
    }
}
