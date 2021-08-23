import random
take = 0
guessnumber = random.randint(0,21)


name = input("Hello! What is your name?\n")
print("Well,",name+", I am thinking of a number between 1 and 20,\nTake a guess.")

while take<6:
    guess = int(input())


    if guess == guessnumber :
        print("Good job,",name+"! You guessed my number in",take+1,"guesses")
        break
    elif guess<guessnumber :
        print("Your guess is too low.")
    elif guess>guessnumber :
        print("Your guess is too high.")
    take=take+1
    
if take==6:

    if guess == guessnumber :
        print("Good job,",name+"! You guessed my number in",take+1,"guesses")
    else :
        print("You lose!")
        print("The number that I thought is",guessnumber,end = ".")
