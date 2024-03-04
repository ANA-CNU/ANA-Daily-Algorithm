def main():
    
    pipe = input()
    stack = []
    
    result = 0

    for i in range(len(pipe)):
        if pipe[i] == '(':
            stack.append('(')
        elif pipe[i] == ')':
            stack.pop()
            if pipe[i-1] == '(':
                result += len(stack)
            else:
                result += 1
            
    print(result)

if __name__ == '__main__':
    main()