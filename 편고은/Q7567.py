dishes = input()

height = 10

for i in range(1, len(dishes)):
    if dishes[i] == dishes[i - 1]:
        height += 5
    else:
        height += 10

print(height)
