#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0

//stack구조체 선언 (linked list)
typedef struct StackNode {
	int data;
	struct StackNode* nextNode;
} StackNode;

//stack관련 함수
void pushLinkedStack(StackNode** top, int data) {
	StackNode* newNode = (StackNode*)malloc(sizeof(StackNode));
	newNode->data = data;
	newNode->nextNode = NULL;

	if (*top == NULL) {
		(*top) = newNode;
		return;
	}

	newNode->nextNode = (*top)->nextNode;
	(*top)->nextNode = newNode;

	return;
}
StackNode* popLinkedStack(StackNode** top) {
	StackNode* popNode = (StackNode*)malloc(sizeof(StackNode));
	popNode = (*top);
	popNode->nextNode = NULL;
	(*top) = (*top)->nextNode;

	return popNode;
}
StackNode* topLinkedStack(StackNode* top) {
	return top;
}
void deleteLinkedStack(StackNode** top) {
	StackNode* pos = (StackNode*)malloc(sizeof(StackNode));
	pos = *top;

	while (pos != NULL) {
		StackNode* temp = pos;
		pos = pos->nextNode;
		free(temp);
	}

	return;

}

int isEmpty(StackNode* top) {
	if (top == NULL)
		return TRUE;
	else
		return FALSE;
}

void showLInkedStack(StackNode* top) {
	StackNode* pNode = NULL;
	if (isEmpty(top)) {
		printf("the stack is empty\n");
		return;
	}

	pNode = top;
	printf("==============Show Stack===============\n");
	while (pNode != NULL) {
		printf("[%d]\n", pNode->data);
		pNode = pNode->nextNode;
	}
	printf("=======================================\n");
}

typedef struct Node_{
    int data;
    struct Node_* nextNode;
}Node;

typedef struct LinkedList_{
    int size;
    Node* headNode;
}LinkedList;

LinkedList* createList(){
    LinkedList* newList = (LinkedList*)malloc(sizeof(LinkedList));
    newList->headNode = NULL;
    newList->size = 0;
    return newList;
}

Node* createNode(int val){
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = val;
    newNode->nextNode = NULL;
    return newNode;
}


void addNode(LinkedList* list, int index, int val){
    Node* temp = list->headNode;
    Node* newNode = createNode(val);

    for(int i = 0; i < index; i++){
        if(temp == NULL) {
            printf("Index out of range\n");
            return;
        }
        temp = temp->nextNode;
    }
    temp = newNode;
    list->size++;
    printf("Add Node!!\n");

    return;
}

void showNode(LinkedList* list){
    printf("Size of List : %d\n", list->size);
    
    Node* temp = list->headNode;
    for(int i = 0; i < list->size; i++){
        printf("[%d]\n", temp->data);
        temp = temp->nextNode;
    }
    printf("-------------\n");
}

void makeEmpty(LinkedList* list){
    Node* temp = list->headNode;
    while (temp != NULL)
    {
        Node* target = temp;
        temp = temp->nextNode;
        free(target);
    }

    list->headNode = NULL;
    list->size = 0;
}

void reverseList(LinkedList* list, StackNode** top){
    Node* temp = list->headNode;
    int size = list->size;
    for(int i = 0; i < size; i++){
        pushLinkedStack(top, temp->data);
        temp = temp->nextNode;
    }

    makeEmpty(list);

    for(int i = 0; i < size; i++){
        addNode(list, i, popLinkedStack(top)->data);
    }
}


int main(){
    int pos;
    LinkedList* linkedList = (LinkedList*)malloc(sizeof(linkedList));
    linkedList->size = 0;
    linkedList->headNode = NULL;

    StackNode* top = NULL;
    StackNode* pNode;

    addNode(linkedList, 0, 10);
    addNode(linkedList, 5, 100);
    addNode(linkedList, 1, 20);
    addNode(linkedList, 2, 30);
    addNode(linkedList, 1, 50);
    addNode(linkedList, 1, 70);
    addNode(linkedList, 1, 40);

    showNode(linkedList);

    makeEmpty(linkedList);
    showNode(linkedList);
}