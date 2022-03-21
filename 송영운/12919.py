from collections import deque
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    s = input().strip()
    t = input().strip()
    q = deque()
    q.append(t)
    YesNo = False
    ls = len(s)
    while q:
        w = q.popleft()
        first, last = w[0], w[-1]
        if len(w) == ls:
            if w == s:
                YesNo = True
                break
        if len(w) == 1:
            continue
        if last == 'B' and first == 'B':
            rw = w[::-1]
            q.append(rw[:-1])
        elif last == 'A' and first == 'B':
            rw = w[::-1]
            q.append(rw[:-1])
            q.append(w[:-1])
        elif last == 'A' and first == 'A':
            q.append(w[:-1])

    if YesNo == True:
        print(1)
    else:
        print(0)