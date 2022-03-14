voters = int(input())
votes = input()

A_count = 0
B_count = 0

for i in range(voters):
    if votes[i] == "A":
        A_count += 1
    elif votes[i] == "B":
        B_count += 1

if A_count == B_count:
    print("Tie")
elif A_count > B_count:
    print("A")
else:
    print("B")
