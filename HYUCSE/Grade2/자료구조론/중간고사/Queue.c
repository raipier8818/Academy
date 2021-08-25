#include "Queue.h"
#include <stdio.h>

void makeEmpty(Queue* queue){
    queue->size = 0;
    queue->front = 1;
    queue->rear = 0;
}

int succ(int val, Queue* queue){
    if(++val == queue->capacity) val = 0;
    return val;
}

int isFull(Queue* queue){
    return queue->size == queue->capacity;
}

void enqueue(int target, Queue* queue){
    if(!isFull(queue)){
        queue->size++;
        queue->rear = succ(queue->rear, queue);
        queue->array[queue->rear] = target;
    }
}

int isEmpty(Queue* queue){
    return queue->size == 0;
}

int dequeue(Queue* queue){
    if(isEmpty(queue)) return -1;
    return queue->array[queue->front++];
}