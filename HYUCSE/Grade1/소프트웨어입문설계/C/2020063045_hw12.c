#include <stdio.h>
#include <string.h>

int main(void){
	
	char string[1000];
	scanf("%s",string);
	
	int n = strlen(string);
	printf("%s\n", string);
	
	for(int i = n-1; i > 0; i--){
		char a = string[n-1];
		for(int k = n-1; k >= 0; k--){
			string[k+1] = string[k]; 
		}
		string[n] = NULL;
		string[0] = a;
		printf("%s\n",string);
	}
	
	
}
