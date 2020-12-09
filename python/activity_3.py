user1 = input("What is player1 name   ")
user2 = input("What is player2 name   ")
user1_answer = input(user1 + "  Do you want scissor, rock or paper?   ")
user2_answer = input(user2 + "  Do you want scissor, rock or paper?  ")

if user1_answer == user2_answer:
    print("It is tie")
elif user1_answer == 'rock':
    if user2_answer == 'scissor':
        print("rock wins")
    else:
        print("paper wins")
elif user1_answer == "scissor":
    if user2_answer == "paper":
        print("scissor wins")
    else:
        print("rock wins")
elif user1_answer == "paper":
    if user2_answer == "rock":
        print("paper wins")
    else:
        print("scissor wins")    
else:
    print("Invid input, Please enter rock, scissor or paper. try again!! ")

