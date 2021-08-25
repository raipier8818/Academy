#include <stdio.h>
#include <stdlib.h>
#define max(a,b) ((a) > (b) ? (a) : (b))

typedef struct AvlNode{
    int element;
    struct AvlNode* left;
    struct AvlNode* right;
    int height;
}AvlNode;

int Height(AvlNode* tree){
    if(tree == NULL) return -1;
    else return tree->height;
}

AvlNode* rotateLL(AvlNode* tree){
    AvlNode* temp;

    temp = tree->left;
    tree->left = temp->right;
    temp->right = tree;

    tree->height = max(Height(tree->left), Height(tree->right)) + 1;
    temp->height = max(Height(temp->left), tree->height) + 1;

    return temp;
}

AvlNode* rotateRR(AvlNode* tree){
    AvlNode* temp;

    temp = tree->right;
    tree->right = temp->left;
    temp->left = tree;

    tree->height = max(Height(tree->left), Height(tree->right)) + 1;
    temp->height = max(Height(temp->left), tree->height) + 1;


    return temp;
}

AvlNode* rotateLR(AvlNode* tree){
    tree->left = rotateRR(tree->left);
    return rotateLL(tree);
}

AvlNode* rotateRL(AvlNode* tree){
    tree->right = rotateLL(tree->right);
    return rotateRR(tree);
}

AvlNode* insert(int x, AvlNode* tree){
    if(tree == NULL){
        tree = malloc(sizeof(AvlNode));
        if(tree == NULL) return;
        else{
            tree->element = x;
            tree->left = NULL;
            tree->right = NULL;
            tree->height = 0;
        }
    }else if(x < tree->element){
        tree->left = insert(x, tree->left);
        if(Height(tree->left) - Height(tree->right) == 2){
            if(tree->left->element > x){
                tree = rotateLL(tree);
            }
            else{
                tree = rotateLR(tree);
            }
        }
    }else if(tree->element < x){
        tree->right = insert(x, tree->right);
        if(Height(tree->right) - Height(tree->left) == 2){
            if(tree->right->element > x){
                tree = rotateRL(tree);
            }
            else{
                tree = rotateRR(tree);
            }
        }
    }

    tree->height = max(Height(tree->left),Height(tree->right)) + 1;
    return tree;
}