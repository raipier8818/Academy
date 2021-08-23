#include <string>
#include <functional>

#include "double_linked_node.h"

template <typename T>
class List {
public:
    List() : count(0) {
        head = new Node<T>(0, nullptr, nullptr);
        tail = new Node<T>(0, nullptr, nullptr);

        head->next = tail;
        tail->prev = head;
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
        delete tail;
    }

    void push_front(T value) {
        // TODO: write your code here
        // create new node with value
        // and add node to front of list

        Node<T>* newNode = new Node<T>(value, nullptr, nullptr);
        newNode->prev = head;
        newNode->next = head->next;

        head->next->prev = newNode;
        head->next = newNode;
        count++;
    }
    void push_back(T value) {
        // TODO: write your code here
        // create new node with value
        // and add node to back of list

        Node<T>* newNode = new Node<T>(value, nullptr, nullptr);
        newNode->prev = tail->prev;
        newNode->next = tail;

        tail->prev->next = newNode;
        tail->prev = newNode;
        count++;
    }
    T pop_front() {
        // TODO: write your code here
        // remove front node(not head)
        // and return its value
        // if try to remove head node return 0
        
        if(count > 0)
        {
            Node<T>* popNode = head->next;
            head->next = popNode->next;
            popNode->next->prev = head;
            count--;
            return popNode->value;
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

        if(count > 0)
        {        
            Node<T>* popNode = tail->prev;
            tail->prev = popNode->prev;
            popNode->prev->next = tail;
            count--;
            return popNode->value;
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

    void reverse_traverse(const std::function<void(const Node<T>&)>& f) {
        for (Node<T>* node = tail->prev; node != nullptr; node = node->prev) {
            f(*node);
        }
    }

private:
    Node<T>* head;
    Node<T>* tail;
    size_t count;
    
    // OPTIONAL: you can write helper functions
};
