#include "Stack.h"

Stack* create(){
    Stack* newStack = (Stack*)malloc(sizeof(Stack));
    newStack->head = NULL;
    return newStack;
}

int isEmpty(Stack* stack){
    return stack->head->next == NULL;
}

void makeEmpty(Stack* stack){
    if(stack->head == NULL) return;
    while(!isEmpty(stack)){
        pop(stack);
    }
}

void push(int target, Stack* stack){
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->element = target;

    newNode->next = stack->head->next;
    stack->head->next = newNode;
}

void pop(Stack* stack){
    if(stack->head->next == NULL) return;
    Node* temp = stack->head->next;
    stack->head->next = temp->next;

    free(temp);
}

int top(Stack* stack){
    if(!isEmpty(stack)) return stack->head->next->element;
    return INT_MAX;
}