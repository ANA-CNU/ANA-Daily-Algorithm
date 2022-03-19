input = __import__('sys').stdin.readline
if __name__ == "__main__":
    line = input().strip()
    stack = []
    for i in range(len(line)):
        if line[i] == 'A':
            if i+1 < len(line) and len(stack) >= 2 and line[i+1] == 'P':
                for _ in range(2):
                    stack.pop()
            else:
                print('NP')
                exit()
        elif line[i] == 'P':
            stack.append(line[i])
    line = "".join(stack)
    if line == 'P':
        print('PPAP')
    else:
        print('NP')
