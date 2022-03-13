n = int(input())

for i in range(n):
    num, string = input().split()

    for j in range(len(string)):
        print(string[j] * int(num), end="")
    print()