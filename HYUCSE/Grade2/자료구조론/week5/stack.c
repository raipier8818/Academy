#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0

//stack구조체 선언 (linked list)
typedef struct StackNode {
	int data;
	struct StackNode* next;
} StackNode;

//stack관련 함수
void pushLinkedStack(StackNode** top, int data) {
	StackNode* newNode = (StackNode*)malloc(sizeof(StackNode));
	newNode->data = data;
	newNode->next = NULL;

	if (*top == NULL) {
		(*top) = newNode;
		return;
	}

	newNode->next = (*top)->next;
	(*top)->next = newNode;

	return;
}
StackNode* popLinkedStack(StackNode** top) {
	StackNode* popNode = (StackNode*)malloc(sizeof(StackNode));
	popNode = (*top);
	popNode->next = NULL;
	(*top) = (*top)->next;

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
		pos = pos->next;
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
		pNode = pNode->next;
	}
	printf("=======================================\n");
}

int main() {
	//가장 윗 부분을 가리키는 top 포인터 선언

	StackNode* top = NULL;
	StackNode* pNode;

	printf("Push 10, 20, 30 called.\n");
	pushLinkedStack(&top, 10);
	pushLinkedStack(&top, 20);
	pushLinkedStack(&top, 30);
	showLInkedStack(top);

	printf("Pop() called.\n");
	pNode = popLinkedStack(&top);
	if (pNode) {
		free(pNode);
		showLInkedStack(top);
	}

	printf("Top() called.\n");
	pNode = topLinkedStack(top);
	if (pNode)
		printf("Top node's data: %d\n", pNode->data);
	else
		printf("The stack is empty.\n");
	showLInkedStack(top);

	deleteLinkedStack(&top);

	return 0;
}