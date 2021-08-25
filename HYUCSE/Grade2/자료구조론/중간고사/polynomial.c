#include <stdio.h>
#include <stdlib.h>
#define MAX_TERMS 100

typedef struct polynomial{
    float coeff;
    int expon;
    struct polynomial* next;
} poly;

typedef struct{
    poly* head;
} pPoly;


poly Zero();
int IsZero(poly* A);
float Coef(poly* A, int expon);
int LeadExp(poly A, int expon);
poly Attach(poly A, float coeff, int expon);
poly Remove(poly A, int expon);
poly SingleMult(poly A, float coeff, int expon);
poly Add(poly A, poly B);

int main(){
    
}