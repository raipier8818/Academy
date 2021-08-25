#ifndef STACK_
#define STACK_

#include <stdlib.h>

typedef struct Node_{
    int element;
    struct Node_* next;
}Node;

typedef struct Stack_{
    Node* head;
}Stack;

Stack* create();
int isEmpty(Stack* stack);
void makeEmpty(Stack* stack);
void push(int target, Stack* stack);
void pop(Stack* stack);
int top(Stack* stack);

#endif