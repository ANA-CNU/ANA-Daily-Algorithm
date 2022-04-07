x = input()
dial = list(['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ'])
time = 0

for i in range(len(x)):
    for j in range(len(dial)):
        if (x[i] in dial[j]) == True:
            time = time + (j + 3)

print(time)
