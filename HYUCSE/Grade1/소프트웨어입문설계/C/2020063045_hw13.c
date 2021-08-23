#include <stdio.h>


int arr[100];
int main(void){
	int num;
	int count = -1;
	while (1){
		scanf("%d",&num);
		if(num==0){
			printf("%d\n", count+1);
			printf("%d\n", arr[count]);
			for(int i = count; i >= 0; i--){
				printf("%d ", arr[i]);	
			}
			printf("\n");
			break;
			
		}
		else if(num==1){
			int n;
			scanf("%d",&n);
			count++;
			arr[count] = n;
		}
		else if(num==2){
			arr[count] = NULL;
			count--;
		}
	}
}
