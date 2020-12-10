fruit_shop = {
    "apple": 10,
    "banana": 20,
    "orange": 30,
    "grapes": 40
    }


Search_item = input("Please enter fruit name:  ").lower()
if (Search_item in fruit_shop):
    print("Yes,",Search_item, "is available")
else:
    print("No,", Search_item, "is not available")
    