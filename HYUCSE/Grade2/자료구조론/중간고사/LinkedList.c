#include "LinkedList.h"

List* createList(){
    List* newList = (List*)malloc(sizeof(List));
    newList->head = NULL;
    return newList;
}

int IsEmpty(List* list){
    return list->head->next == NULL;
}

Node* find(int target, List list){
    Node* temp = list.head->next;

    while (temp != NULL && temp->element != target)
    {
        temp = temp->next;
    }

    return temp;
}

void delete(int target, List list){
    Node* temp = findPrev(target, list);
    if(temp != NULL){
        Node* targetNode = temp->next;
        temp->next = targetNode->next;
        free(targetNode);
    }
}

Node* findPrev(int target, List list){
    Node* temp = list.head;
    while (temp->next != NULL && temp->next->element != target)
    {
        temp = temp->next;
    }
    return temp;
}

void insert(int val, List list, Node* pos){
    Node* temp = (Node*)malloc(sizeof(Node));

    if(temp != NULL){
        temp->element = val;
        temp->next = pos->next;
        pos->next = temp;
    }
}

Node* invert(List list){
    Node* middle;
    Node* trail;
    Node* lead = list.head->next;
    middle = NULL;

    while (lead != NULL)
    {
        trail = middle;
        middle = lead;
        lead = lead->next;
        middle->next = trail;
    }

    list.head->next = middle;
    return middle;
}