#include <iostream>
#include <vector>
#include <unordered_map>

#include "college.h"
#include "user.h"
#include "building.h"

int n,b,u,c;

int main() {
    std::unordered_map<std::string, College*> colleges;
    std::unordered_map<size_t, Building*> buildings;
    std::unordered_map<size_t, User*> users;

    std::cin >> n;
    for(int i = 0; i < n; i++){
        std::string CollegeName;
        std::cin >> CollegeName;
        College* college = new College(CollegeName);

        if(colleges.find(CollegeName) != colleges.end()){
            std::cout << "Name duplicated error" <<std::endl;
            continue;
        }
        colleges.insert(std::make_pair(CollegeName,college));
    }

    std::cin >> b;
    for(int i = 0; i < b; i++){
        std::string building_name, college_name;
        size_t building_id, rooms;

        std::cin >> building_name >> building_id >> college_name >> rooms;
        
        if(colleges.find(college_name) == colleges.end()){
            std::cout << "College not exist error" << std::endl;
            continue;
        }
        bool check = false;
        for(auto i = buildings.begin(); i != buildings.end(); i++){
            if(building_id == (*i).second->getId()){
                std::cout << "Id duplicated error" << std::endl;
                check = true;
                break;
            }
            
        }

        if(check) continue;


        auto K = colleges.find(college_name);

        Building* building = new Building(building_name,building_id,*((*K).second),rooms);
        buildings.insert(std::make_pair(rooms,building));
    }

    std::cin >> u;
    for(int i = 0; i < u; i++){
        std::string user_position, user_name, college_name;
        size_t user_id;

        std::cin >> user_position >> user_name >> user_id >> college_name;
        if(colleges.find(college_name) == colleges.end()) {
            std::cout << "College not exist error" << std::endl;
        }
        auto K = colleges.find(college_name);

        if(user_position == "student"){
            users.insert(std::make_pair(user_id,new Student(user_name,user_id,*(*K).second)));
        }
        else if(user_position == "professor"){
            users.insert(std::make_pair(user_id,new Professor(user_name,user_id,*((*K).second))));
        }
        else if(user_position == "employee"){
            users.insert(std::make_pair(user_id,new Employee(user_name,user_id,*((*K).second))));
        }
    }

    std::cin >> c;
    for(int i = 0; i < c; i++){
        std::string command;
        size_t user_ID, building_ID;

        std::cin >> command;
        if(command == "enter"){
            std::cin >> user_ID >> building_ID;
            
            auto iter = users.begin();
            auto buildingIter = buildings.begin();


            for(; iter != users.end(); iter++){
                if((*iter).second->getId() == user_ID){
                    break;
                }
            }

            for(; buildingIter != buildings.end(); buildingIter++){
                if((*buildingIter).second->getId() == building_ID){
                    break;
                }
            }
            if(iter == users.end()){
                // ????
                continue;
            }
            if(buildingIter == buildings.end()){
                // ????
                continue;
            }


            if(!(*buildingIter).second->enter((*iter).second)){
                std::cout << "Not enter error" << std::endl;
            }


        }
        if(command == "exit"){
            std::cin >> user_ID >> building_ID;    
            auto iter = users.begin();
            auto buildingIter = buildings.begin();


            for(; iter != users.end(); iter++){
                if((*iter).second->getId() == user_ID){
                    break;
                }
            }

            for(; buildingIter != buildings.end(); buildingIter++){
                if((*buildingIter).second->getId() == building_ID){
                    break;
                }
            }


            if(iter == users.end()){
                // ????
                continue;
            }
            if(buildingIter == buildings.end()){
                // ????
                continue;
            }



            if(!(*buildingIter).second->exit((*iter).second)){
                // ?????
                continue;
            }

        }
        if(command == "total"){
            std::cin >> building_ID;
            auto buildingIter = buildings.begin();

            for(; buildingIter != buildings.end(); buildingIter++){
                if((*buildingIter).second->getId() == building_ID){
                    break;
                }
            }


            std::cout << (*buildingIter).second->total() << std::endl;

        }


        if(command == "clean"){
            std::cin >> user_ID;
            
            auto iter = users.begin();
            auto buildingIter = buildings.begin();
            bool check = false;

            for(; iter != users.end(); iter++){
                if((*iter).second->getId() == user_ID){
                    break;
                }
            }

            if(iter == users.end()){
                // ????
                continue;
            };
            bool aa = false;
            for(; buildingIter != buildings.end(); buildingIter++){
                auto checkRooms = (*buildingIter).second->returnRoom();
                for(auto roomNum = checkRooms.begin(); roomNum != checkRooms.end(); roomNum++){
                    for(auto roomuser = (*roomNum).begin(); roomuser != (*roomNum).end(); roomuser++){
                        if((*roomuser)->getId() == user_ID){
                            if(dynamic_cast<Employee*>((*iter).second)){
                                check = true;
                                break;
                            }else{
                                check = true;
                                aa = true;
                                break;
                            }
                        }


                    }

                    if(check) break;

                }
                if(aa){
                    std::cout << "Permission error" << std::endl;
                    break;
                }
                if(check){
                    for(auto roomNum = checkRooms.begin(); roomNum != checkRooms.end(); roomNum++){
                        for(auto roomuser = (*roomNum).begin(); roomuser != (*roomNum).end(); roomuser++){
                            if((*roomuser)->getId() == user_ID) continue;

                            (*buildingIter).second->exit((*roomuser));
                        }
                    }
                    break;
                }
            }

            if(buildingIter == buildings.end()){
                std::cout << "Nothing to clean error" << std::endl;
            }


        }


        if(command == "attendance"){
            std::cin >> user_ID;

            if(!dynamic_cast<Professor*>(users[user_ID])){
                std::cout << "Permission error" << std::endl;
                continue;
            }

            auto buildingIter = buildings.begin();
            bool check = false;


            for(; buildingIter != buildings.end(); buildingIter++){
                auto checkRoom = (*buildingIter).second->returnRoom();
                for(auto roomNum = checkRoom.begin(); roomNum != checkRoom.end(); roomNum++){
                    for(auto roomUser = (*roomNum).begin(); roomUser != (*roomNum).end(); roomUser++){
                        if((*roomUser)->getId() == user_ID){
                            check = true;                
                            break;
                        }
                    }
                    if(check){
                        for(auto roomUser = (*roomNum).begin(); roomUser != (*roomNum).end(); roomUser++){
                            if(dynamic_cast<Student*>((*roomUser))){
                                std::cout << (*roomUser)->getId() << std::endl;
                            }
                        }
                        break;
                    }
                    
                }

                if(check) break;
            }



        }
        if(command == "where"){
            std::cin >> user_ID;

            auto buildingIter = buildings.begin();
            bool check = false;

            for(; buildingIter != buildings.end(); buildingIter++){
                auto checkRoom = (*buildingIter).second->returnRoom();
                for(auto roomNum = checkRoom.begin(); roomNum != checkRoom.end(); roomNum++){
                    for(auto roomUser = (*roomNum).begin(); roomUser != (*roomNum).end(); roomUser++){
                        if((*roomUser)->getId() == user_ID){
                            
                            std::cout << (*buildingIter).second->getName() << std::endl;
                            
                            check = true;           
                            break;
                        }
                    }
                    if(check) break;
                    
                }
                if(check) break;

            }
        }
        if(command == "all"){
            std::cin >> building_ID;

            auto buildingIter = buildings.begin();
            bool check = false;

            for(; buildingIter != buildings.end(); buildingIter++){
                if((*buildingIter).second->getId() == building_ID){
                    
                    auto checkRoom = (*buildingIter).second->returnRoom();

                    for(auto roomNum = checkRoom.begin(); roomNum != checkRoom.end(); roomNum++){
                        for(auto roomUser = (*roomNum).begin(); roomUser != (*roomNum).end(); roomUser++){
                           std::cout << (*roomUser)->getName() << std::endl;
                        }
                    }

                    break;
                }
            }

            
        }
    }


    return 0;
}
