import sys

while True:
    try:
        n=int(sys.stdin.readline())
        i=1
        while True:
            if n>=i+1 and n<=i*9:
                print('Baekjoon wins.')
                break
            else:
                i*=9
            if n>=i+1 and n<=i*2:
                print('Donghyuk wins.')
                break
            else:
                i*=2
    except:
        break
