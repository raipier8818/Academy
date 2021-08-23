#include <stdio.h>

int main(void){
	int num;
	int i;
	while (1){

		printf("단수를 입력하시오: \n");
		scanf("%d",&num);
		if ((num>0)&&(num<10)){
			
			printf("*******%d단*******\n",num);
			for(i=1;i<=9;i++){
				printf("%d*%d=%d\n",num,i,num*i);
			}
			printf("*****************\n");
		}else{
			printf("잘못된 입력 범위입니다.");
			break;
		}
	}
		return 0;
}
