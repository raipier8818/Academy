#include <stdio.h>

int main(void){
	int num;
	int i;
	while (1){

		printf("�ܼ��� �Է��Ͻÿ�: \n");
		scanf("%d",&num);
		if ((num>0)&&(num<10)){
			
			printf("*******%d��*******\n",num);
			for(i=1;i<=9;i++){
				printf("%d*%d=%d\n",num,i,num*i);
			}
			printf("*****************\n");
		}else{
			printf("�߸��� �Է� �����Դϴ�.");
			break;
		}
	}
		return 0;
}
