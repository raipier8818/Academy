#include <stdio.h>

int main(void){
	
	int numstr[100000];
	int num;
	scanf("%d",&num);
	int n;
	
	for(int i = 0; i < num; i++){
		scanf("%d", &numstr[i]);	
	}
	
	int max = 0, sum = 0;
	
	for(int i = 0; i < num; i++){
		for(int k = i; k < num; k++){
			sum = 0;
			for(int j = i; j <= k; j++){
				sum += numstr[j];
			}
			if(max < sum){
				max = sum;
			}
		}
	}
	printf("%d", max);
	
	
}
