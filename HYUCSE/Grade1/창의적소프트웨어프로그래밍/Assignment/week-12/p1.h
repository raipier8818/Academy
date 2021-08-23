// p1.h
#include <deque>
#include <functional>
#include <algorithm>
template <typename T>
class Array {
    std::deque<T> _arr;
    public:
    Array() {}
    
    template <typename F>
    friend Array<F>& operator+(Array<F>& arr, const F& a);
    
    template <typename F>
    friend Array<F>& operator+=(Array<F>& arr, const F& a);
    
    template <typename F>
    friend Array<F>& operator-(Array<F>& arr, const F& a);
    
    template <typename F>
    friend Array<F>& operator-=(Array<F>& arr, const F& a);
    
    template <typename F>
    friend Array<F>& operator*(Array<F>& arr, const F& a);
    
    template <typename F>
    friend Array<F>& operator/(Array<F>& arr, const F& a);

    T& operator[](size_t index){
        return _arr[index];
    }

    size_t size() const{
        return _arr.size();
    }

    void view(const std::function<void(const T&)>& f) {
        for (auto t : _arr) {
            f(t);
        }
    }
};

template<typename F>

Array<F>& operator+(Array<F>& arr, const F& a){
    arr._arr.push_back(a);
    return arr;
}

template<typename F>

Array<F>& operator+=(Array<F>& arr, const F& a){
    arr._arr.push_front(a);
    return arr;
}

template<typename F>

Array<F>& operator-(Array<F>& arr, const F& a){
    auto it = std::find(arr._arr.begin(),arr._arr.end(), a);
    if(it != arr._arr.end())
    {
        arr._arr.erase(it);
    }
    return arr;
}

template<typename F>

Array<F>& operator-=(Array<F>& arr, const F& a){
    auto it = std::find(arr._arr.rbegin(),arr._arr.rend(), a);
    if(it != arr._arr.rend())
    {
        arr._arr.erase(std::next(it).base());
    }
    return arr;
}

template<typename F>

Array<F>& operator*(Array<F>& arr, const F& a){
    for(auto& v : arr._arr){
        v *= a;
    }
    
    return arr;
}

template<typename F>

Array<F>& operator/(Array<F>& arr, const F& a){
    for(auto& v : arr._arr){
        v /= a;
    }
    return arr;
}