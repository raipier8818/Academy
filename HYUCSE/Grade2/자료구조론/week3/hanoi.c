#include <stdio.h>

void hanoi(int n, char from, char middle, char to){
    if(n == 1){
        printf("%d번 원판을 %c에서 %c로 이동\n", n, from, to);
        return;
    }

    hanoi(n-1,from,middle,to);
    printf("%d번 원판을 %c에서 %c로 이동\n", n, from, middle);
    hanoi(n-1,middle,from,to);
}


int main(){
    int n;
    printf("원판의 개수를 입력하시오 : ");
    scanf("%d", &n);

    hanoi(n,'A','B','C');
    int count = 1;
    for(int i = 0; i < n; i++) count *= 2;
    printf("총 이동횟수 : %d\n", --count);
}