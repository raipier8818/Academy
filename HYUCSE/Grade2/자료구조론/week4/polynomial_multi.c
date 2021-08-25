#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define BUFFSIZE 1024


typedef struct polyTerm_ {
    int exp;
    int coeff;
    struct polyTerm_* next;
} polyTerm;

typedef struct poly_ {
    polyTerm* head;
} poly;

void clearPoly(poly* A) {
    polyTerm* pos = A->head;

    while (pos != NULL)
    {
        polyTerm* temp = pos;
        pos = pos->next;

        free(temp);
    }

    A->head = NULL;
}

poly createPoly() {
    poly newPoly = { NULL };
    return newPoly;
}

void addTerm(poly* A, int exp, int coeff) {
    if (coeff == 0) return;

    polyTerm* pos = A->head;
    polyTerm* newTerm = (polyTerm*)malloc(sizeof(polyTerm));
    newTerm->exp = exp;
    newTerm->coeff = coeff;
    newTerm->next = NULL;


    
    if (pos == NULL) {
        A->head = newTerm;
        return;
    }

    while (pos->next != NULL)
    {
        if (pos->exp == exp) {
            pos->coeff += coeff;
            free(newTerm);
            return;
        }
        if (pos->exp < exp) {
            polyTerm* copy = (polyTerm*)malloc(sizeof(polyTerm));
            copy->coeff = pos->coeff;
            copy->exp = pos->exp;
            copy->next = pos->next;

            pos->coeff = coeff;
            pos->exp = exp;
            pos->next = copy;
            free(newTerm);
            return;
        }
        pos = pos->next;
    }

    if (pos->exp == exp) {
        pos->coeff += newTerm->coeff;
        free(newTerm);
        return;
    }
    if (pos->exp < exp) {
        polyTerm* copy = (polyTerm*)malloc(sizeof(polyTerm));
        copy->coeff = pos->coeff;
        copy->exp = pos->exp;
        copy->next = NULL;

        pos->coeff = coeff;
        pos->exp = exp;
        pos->next = copy;
        free(newTerm);
        return;
    }
    pos->next = newTerm;
    return;
    
    
}
poly multiPoly(poly A, poly B) {
    polyTerm* A_pos = A.head;

    poly C = createPoly();

    while (1)
    {
        if (A_pos == NULL) break;
        polyTerm* B_pos = B.head;
        while (1)
        {
            if (A_pos == NULL || B_pos == NULL) break;
            addTerm(&C, A_pos->exp + B_pos->exp, A_pos->coeff * B_pos->coeff);
            
            B_pos = B_pos->next;
        }
        A_pos = A_pos->next;
    }

    return C;
}

void printPoly_impl(poly A, char* buffer) {
    polyTerm* pos = A.head;

    if (A.head == NULL) {
        char zero[BUFFSIZE] = "0";
        strcat(buffer, zero);
        return;
    }

    while (pos != NULL)
    {
        char temp[BUFFSIZE] = "";
        if (pos == A.head) {
            sprintf(temp, "%dx^%d", pos->coeff, pos->exp);
            strcat(buffer, temp);
            pos = pos->next;
            continue;
        }


        if (pos->coeff > 0) {
            sprintf(temp, "+%dx^%d", pos->coeff, pos->exp);
        }
        else if (pos->coeff < 0) {
            sprintf(temp, "%dx^%d", pos->coeff, pos->exp);
        }

        strcat(buffer, temp);
        pos = pos->next;
    }

    // char endline[10] = "\n";
    // strcat(buffer, endline);
}

void printPoly(poly A) {
    char buffer[BUFFSIZE] = "";
    printPoly_impl(A, buffer);
    printf(buffer);
}


void testPoly(const char* testCaseFileName) {
    int breakFlag = 0;
    int breakPoint = -1;
    FILE* fp = fopen(testCaseFileName, "r");
    poly A = createPoly();
    poly B = createPoly();

    int T;
    fscanf(fp, "%d\n", &T);

    char lastTrue[BUFFSIZE] = "";
    char lastAnswer[BUFFSIZE] = "";

    while (T--) {
        char inputOp0, inputOp1;
        char inputStr[BUFFSIZE] = "";
        char buffer[BUFFSIZE] = "";
        int caseNum;

        fscanf(fp, "%d %c ", &caseNum, &inputOp0);

        if (inputOp0 == 'a') {
            int exp, coeff;
            fscanf(fp, "%c %d %d\n", &inputOp1, &exp, &coeff);
            if (inputOp1 == 'A') {
                addTerm(&A, exp, coeff);
            }
            else if (inputOp1 == 'B') {
                addTerm(&B, exp, coeff);
            }
        }

        else if (inputOp0 == 'p') {
            fscanf(fp, "%c\n%s\n", &inputOp1, inputStr);
            if (inputOp1 == 'A') {
                printPoly_impl(A, buffer);
            }
            else if (inputOp1 == 'B') {
                printPoly_impl(B, buffer);
            }

            if (strcmp(inputStr, buffer) != 0) {
                breakFlag = 1;
                breakPoint = caseNum;
                strcpy(lastTrue, inputStr);
                strcpy(lastAnswer, buffer);
                break;
            }
        }

        else if (inputOp0 == 'c') {
            fscanf(fp, "%c\n", &inputOp1);
            if (inputOp1 == 'A') {
                clearPoly(&A);
            }
            else if (inputOp1 == 'B') {
                clearPoly(&B);
            }
        }

        else if (inputOp0 == 'm') {
            fscanf(fp, "%s\n", inputStr);
            printPoly_impl(multiPoly(A, B), buffer);
            if (strcmp(inputStr, buffer) != 0) {
                breakFlag = 1;
                breakPoint = caseNum;
                strcpy(lastTrue, inputStr);
                strcpy(lastAnswer, buffer);
                break;
            }
        }
    }

    fclose(fp);

    if (breakFlag) {
        printf("Test failed on case# %d\n", breakPoint);
        printf("True: %s\nAnswer: %s", lastTrue, lastAnswer);
    }
    else {
        printf("TEST DONE.\n");
    }
}

int main() {
    poly A = createPoly();
   

    testPoly("testCases.txt");

    return 0;
}
