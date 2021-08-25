#ifndef LINKED_LIST
#define LINKED_LIST

#include <stdlib.h>

#define TRUE 1
#define FALSE 0

typedef struct Node_{
    int element;
    struct Node_* next;
}Node;

typedef struct List_{
    Node* head;
}List;

List* createList();
int IsEmpty(List* list);
Node* find(int target, List list);
void delete(int target, List list);
Node* findPrev(int target, List list);
void insert(int val, List list, Node* pos);
Node* invert(List list);

#endif