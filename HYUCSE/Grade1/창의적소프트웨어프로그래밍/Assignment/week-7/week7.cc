#include <iostream>
#include <vector>
#include <string>
#include <queue>
#include <algorithm>

std::queue<std::string> q;

int main() {

    int n;
    std::cin >> n;

    for (int i = 0; i < n; i++) {
        int m;
        std::string name;
        std::cin >> m;
        std::vector<std::string> v;

        for (int j = 0; j < m; j++) {
            std::cin >> name;
            v.push_back(name);
        }

        std::sort(v.begin(),v.end());
        for(int ll = 0; ll < m; ll++){
            q.push(v[ll]);
        }
            
        // for(int k = 0; k < v.size(); k++){
        //     std::cout << "// " << v[k] << std::endl;
        // }
        // std::cout << q.size() << std::endl;
    }

    while(!q.empty()){
        std::cout << q.front() << std::endl;
        q.pop();
    }
}