a = int(input("단수를 입력하시오 : \n"))

if a < 10:
    
    print("*********%i단*********" %a)
    for i in range(1,10):
        print("%i*%i= %i" %(a,i,a*i))
    print("*********************")

else:
    print("잘못된 입력 범위 입니다.")

