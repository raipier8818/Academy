#include "BinarySearchTree.h"

Tree* create(){
    Tree* newTree = (Tree*)malloc(sizeof(Tree));
    newTree->head = NULL;

    return newTree;
}

Node* search(Tree* target, int val){
    Node* pos = target->head;

    while(pos != NULL){
        if(pos->data == val) return pos;
        else if(pos->data > val) pos = pos->leftChild;
        else pos = pos->rightChild;
    }

    return pos;
}

void insert(Tree* target, int val){
    Node* temp = target->head;

    while (temp != NULL)
    {
        if(temp->data > val){
            temp = temp->leftChild;
        }else{
            temp = temp->rightChild;
        }
    }

    temp->data = val;
    temp->leftChild = NULL;
    temp->rightChild = NULL;    
}


// have to do it!!
void deleteVal(Tree* target, int val){
    Node* pos = target->head;

    if(pos == NULL) return;

    while(1){
        
    }


    if(pos != NULL){
        if(pos->leftChild == NULL && pos->rightChild == NULL){
            free(pos);
            return;
        }
        else if(pos->leftChild == NULL){

        }
    }
}