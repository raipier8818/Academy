#include <string>
#include <functional>

#include "node.h"

template <typename T>
class List {
public:
    List() : count(0) {
        head = new Node<T>(0, nullptr);
    }
    ~List() {
        // TODO: write your code here
        // release remain nodes before delete head node

        //std::cout << "delete list\n";

        if(count > 0)
        {
            Node<T>* pos = head->next;
            while (pos->next != nullptr)
            {   

                Node<T>* delNode = pos;
                
                //std::cout << "delete Node : " << delNode->value << "\n";
                
                pos = pos->next;
                delete delNode;
            }

            delete pos;
        }


        //std::cout << "delete Node : " << pos->value << "\n";
        //std::cout << "delete Node Ad : " << pos->next << "\n";
        

        count = 0;
        delete head;
    }

    void push_front(T value) {
        // TODO: write your code here
        // create new node with value
        // and add node to front of list

        if(count > 0){
            Node<T>* newNode = new Node<T>(value,nullptr);
            newNode->next = head->next;
            head->next = newNode;
        }
        else{
            Node<T>* newNode = new Node<T>(value,nullptr);
            head->next = newNode;
        }
        //std::cout << "complete push front\n";
        count++;
    }

    void push_back(T value) {
        // TODO: write your code here
        // create new node with value
        // and add node to back of list

        Node<T>* newNode = new Node<T>(value,nullptr);
        Node<T>* pos = head;
        
        while (pos->next != nullptr)
        {
            pos = pos->next;
        }

        pos->next = newNode;
        count++;

    }

    T pop_front() {
        // TODO: write your code here
        // remove front node(not head)
        // and return its value
        // if try to remove head node return 0
        
        if(count > 0){
            T returnNum = head->next->value;
            head->next = head->next->next;
            delete head->next;
            count--;    
            return returnNum;
        }
        else{
            return 0;
        }
    }


    T pop_back() {
        // TODO: write your code here
        // remove back node(not head)
        // and return its value
        // if try to remove head node return 0

        Node<T>* pos = head;
        int s = count;
        if(s > 0)
        {        
            while(s-1 > 0){
                pos = pos->next;
                s--;   
            }

            T returnNum = pos->next->value;
            pos->next = nullptr;
            delete pos->next;

            count--;
            return returnNum;
        }
        else{
            return 0;
        }


    
    }

    size_t size() {
        // TODO: write your code here
        // return current items in list (except head)

        return count;
    }

    void traverse(const std::function<void(const Node<T>&)>& f) {
        for (Node<T>* node = head->next; node != nullptr; node = node->next) {
            f(*node);
        }
    }

private:
    Node<T>* head;
    size_t count;
    
    // OPTIONAL: you can write helper functions
};
