a = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
word = input()

for i in a:
    word = word.replace(i, '*')
print(len(word))