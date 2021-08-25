#ifndef BINARY_SEARCH_TREE
#define BINARY_SEARCH_TREE

#include <stdlib.h>

typedef struct Node_{
    int data;
    struct Node_* leftChild;
    struct Node_* rightChild;
}Node;

typedef struct Tree_{
    Node* head;
}Tree;

Tree* create();

Node* search(Tree* target, int val);

void insert(Tree* target, int val);

void deleteVal(Tree* target, int val);



#endif