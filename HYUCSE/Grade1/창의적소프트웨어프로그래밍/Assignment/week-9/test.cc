#include <bits/stdc++.h>
using namespace std;


int main(){
    int n ;
    cin >> n;
    bool check = true;
    int returnNum = 0;
    returnNum += check ? n*2 : n;
    cout << returnNum << endl;
    check = false;
    returnNum = check ? n*2 : n;
    cout << returnNum << endl;

}