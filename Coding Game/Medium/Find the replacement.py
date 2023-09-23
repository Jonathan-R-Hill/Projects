x = input()
y = input()

checkx = []
ans = []

xlist = []
ylist = []

# Adding the string to the lists above
for i in range(len(x)):
    xlist.append(x[i])
    ylist.append(y[i])


for i in range(len(xlist)):     # For the index for checking changes

    if xlist[i] == ylist[i]:

        checkx.append(xlist[i]) # If it is the same as y add to list to check if it appears again and changes

    else:

        if xlist[i] in checkx:  # If the letter would be changed else where it can't be used so prints CAN'T

            ans = []
            ans.append("CAN'T")
            break

        if (f"{xlist[i]}->{ylist[i]}") in ans:  # If the change is already in the answer skip adding it again (avoids duplicates)
        
            pass
        
        else:

            ans.append(f"{xlist[i]}->{ylist[i]}")   # Adds the change to the ans list


if y == x:

    ans = []
    ans.append("NONE")


for i in ans:

    print(i)
