import sys
sys.setrecursionlimit(10**6)

def isPrime(num):
    l = int(num**0.5) + 1
    for i in range(2, l):
        if num % i == 0:
            return False
    return True

def dfs(num_str, now):
    global n
    if now == n:
        answer.append(int(num_str))
        return
    for i in range(10):
        if i != 0 and i != 1 and num_str == '':
            if isPrime(i):
                dfs(str(i), now+1)
        elif num_str != '':
            num = int(num_str+str(i))
            if isPrime(num):
                dfs(num_str+str(i), now + 1)

input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    answer = []
    strs = ''
    dfs(strs, 0)
    answer.sort()
    for i in answer:
        print(i)