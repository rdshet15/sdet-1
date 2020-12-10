fistList = [12,3,53,2,33,55]
secondList = [6,4,76,33,66,77]

#declare one 3rd list to store 
thirdList = []

for num in fistList:
    if num % 2 != 0:
        thirdList.append(num)

for num in secondList:
    if num % 2 == 0:
        thirdList.append(num)

print("Third list is :  ", thirdList)