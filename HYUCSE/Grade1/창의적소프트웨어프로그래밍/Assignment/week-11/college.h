#ifndef __COLLEGE_H__
#define __COLLEGE_H__ 

#include <string>

class College {
public:
    College(const std::string& name)
    : name(name) {}

    std::string getCollegeName(){
        return name;
    }

private:
    std::string name;
};

#endif
