#include <stdio.h>

void hanoi(int n, char from, char middle, char to){
    if(n == 1){
        printf("%d�� ������ %c���� %c�� �̵�\n", n, from, to);
        return;
    }

    hanoi(n-1,from,middle,to);
    printf("%d�� ������ %c���� %c�� �̵�\n", n, from, middle);
    hanoi(n-1,middle,from,to);
}


int main(){
    int n;
    printf("������ ������ �Է��Ͻÿ� : ");
    scanf("%d", &n);

    hanoi(n,'A','B','C');
    int count = 1;
    for(int i = 0; i < n; i++) count *= 2;
    printf("�� �̵�Ƚ�� : %d\n", --count);
}