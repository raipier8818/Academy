import random

word ="cat dog ant"
dic = word.split()
take = 0

def pickword():
    a = random.randint(0,len(dic)-1)
    return dic[a]

 
def printunder(secretword,right,wrong):
    i = 0
    while i < len(secretword):
        if secretword[i] in right:
            print(secretword[i], end=" ")
        else:
            print("_",end=" ")
        i+=1
    print()

draw = ['''
            +---+
            |   |
            |   |
            O   |
           /|\  |
            |   |
           / \  |
                |
                |
          =========''','''
            +---+
            |   |
            |   |
            O   |
           /|\  |
            |   |
           /    |
                |
                |
          =========''','''
            +---+
            |   |
            |   |
            O   |
           /|\  |
            |   |
                |
                |
                |
          =========''','''
            +---+
            |   |
            |   |
            O   |
           /|\  |
                |
                |
                |
                |
          =========''','''
            +---+
            |   |
            |   |
            O   |
           /|   |
                |
                |
                |
                |
          =========''','''
            +---+
            |   |
            |   |
            O   |
            |   |
                |
                |
                |
                |
          =========''','''
            +---+
            |   |
            |   |
            O   |
                |
                |
                |
                |
                |
          =========''','''
            +---+
            |   |
            |   |
                |
                |
                |
                |
                |
                |
          =========''']


wrong = ""
right = ""
secretword = pickword()
while True:

    print(draw[take])
    printunder(secretword,right,wrong)
    
    letter = input("input : ")
    if letter in right+wrong:
        print("You already input that.")
        continue
    elif letter in secretword :
        right = right + letter
    else :
        wrong = wrong + letter
        take +=1
        

    if right == secretword:
        print(secretword)
        print("YES!")
            
    if take == 9:
        if right == secretword:
            print()
        else:
            print("No!")


    
