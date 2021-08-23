#ifndef __BUILDING_H__
#define __BUILDING_H__

#include <vector>
#include <set>

#include "college.h"
#include "user.h"
#include "utility.h"

class Building {
public:
    Building(const std::string& name, size_t id, College& college, size_t size)
    : name(name), id(id), college(college), rooms(size) {
    }

    std::string getName() const {
        return name;
    }

    size_t getId() const {
        return id;
    }

    College& getCollege() const {
        return college;
    }

    bool CanEnter(std::set<User*> room){
        for(auto iter = room.begin(); iter != room.end(); iter++){
            if(dynamic_cast<Professor*>(*iter)){
                return false;
            }
        }
        return true;
    }

    std::vector<std::set<User*>> returnRoom(){
        return rooms;
    }


    bool enter(User* user){
        if(dynamic_cast<Professor*>(user)){
            while(true){
                auto randomRoom = util::select_randomly(rooms.begin(),rooms.end());
                if(CanEnter(*randomRoom)){
                    (*randomRoom).insert(user);
                    return true;
                }
            }
        }

        if(dynamic_cast<Student*>(user)){
            if(this->getCollege().getCollegeName() != user->getCollege().getCollegeName()) return false;
            auto randomRoom = util::select_randomly(rooms.begin(),rooms.end());
            (*randomRoom).insert(user);
            return true;
        }

        if(dynamic_cast<Employee*>(user)){
            auto randomRoom = util::select_randomly(rooms.begin(),rooms.end());
            (*randomRoom).insert(user);
            return true;
        }

        return false;
    }

    bool exit(User* user){
        for(auto i = rooms.begin(); i != rooms.end(); i++){
            for(auto j = (*i).begin(); j != (*i).end(); j++){
                if((*j)->getId() == user->getId()){
                    (*i).erase(j);
                    return true;
                }
            }
        }
        return false;
    }

    size_t total() const{
        return rooms.size();
    }

private:
    std::string name;
    size_t id;
    College& college;

    std::vector<std::set<User*>> rooms;
};

#endif
