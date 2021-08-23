def binary(n, num, count):
    print(count,num[len(num)//2]-1)

    if num[len(num)//2-1]>n:
        num = num[:len(num)//2-1]
        count += 1

        binary(n,num, count)
    elif num[len(num)//2-1]<n:
        num = num[len(num)//2:]
        count += 1
        binary(n,num, count)
        
    else:
        print(count)

n = int(input())

num = list(range(1,1001))
count = 1
binary(n, num, count)
