fi = [0,1]

while (True):
    menu = ['''***************''',
        '''1. Calculate''',
        '''2. Show it!''',
        '''3. Initialize''',
        '''4. Quit''',
        '''***************'''
        ]

    line = len(menu)




    for i in range(0,line):
        print(menu[i])


    num = int(input("Input : "))


    if num == 1:
        finum = int(input("Input the number : "))
        for a in range(0,finum-1):
            new = fi[a]+fi[a+1]
            fi.append(new)


    if num == 2:
        for k in range(0,len(fi)):
            print(fi[k], end = " ")

    if num == 3:
        fi = [0,1]

    if num == 4:
        break
    else:
        print()

