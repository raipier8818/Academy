#include <stdio.h>
#include <stdlib.h>

int list[7] = {38, 27, 43, 3, 9, 82, 10};

void merge(int list[], int left, int mid, int right)
{
    int i, j, k, l;
    i = left;
    j = mid;
    k = left;
    int *temp = (int *)malloc(sizeof(int) * 7);

    while (i <= mid && j <= right)
    {
        if (list[i] > list[j])
        {
            temp[k++] = list[j++];
        }
        else
        {
            temp[k++] = list[i++];
        }
    }

    while (i <= mid)
    {
        temp[k++] = list[i++];
    }
 
    while (j <= right)
    {
        temp[k++] = list[j++];
    }

    for(l = left; l < right; l++){
        list[l] = temp[l];
    }
}


void mergesort(int list[], int left, int right){
    int mid;
    if(left < right){
        mid = (left + right) / 2;
        mergesort(list, left, mid);
        mergesort(list, mid + 1, right);
        merge(list, left, mid, right);
    }
}


int main(){
    int i = 0;
    mergesort(list, 0,6);

    for(; i < 7; i++){
        printf("%d\t", list[i]);
    }

    printf("\n");
}