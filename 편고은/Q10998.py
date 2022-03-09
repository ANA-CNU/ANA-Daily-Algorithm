string = input()

a = 0

if len(string) % 2 == 0:
    for i in range(len(string) // 2):
        if string[i] == string[-1 - i]:
            continue
        else:
            a += 1

else:
    for i in range((len(string) - 1) // 2):
        if string[i] == string[-1 - i]:
            continue
        else:
            a += 1

if a == 0:
    print(1)
else:
    print(0)