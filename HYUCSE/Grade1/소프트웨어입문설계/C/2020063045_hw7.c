#include <stdio.h>
int divisor(int a, int b) {
    
    if (b != 0) {
        return divisor(b, a % b);
    }
    else {
        return a;
    }
}


int main(void) {
    int a, b;
    scanf("%d %d", &a, &b);
    if (a < b) {
        int c = a;
        a = b;
        b = c;
    }
    int div = divisor(a, b);
    printf("%d", div);
    return 0;
}
