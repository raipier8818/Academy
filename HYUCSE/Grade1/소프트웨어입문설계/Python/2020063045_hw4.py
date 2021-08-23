FirstString = input("Input first string : ")
SecondString = input("Input second string : ")

checknum = 0

for i in range(0,len(FirstString)):
    if SecondString[:i] in FirstString and SecondString[i:] in FirstString:
        checknum = 1
        break
    else:
        continue

if checknum == 1:
    print('Circular string to right', len(FirstString) - i,'times.')
else:
    print('Not circular identical!')
