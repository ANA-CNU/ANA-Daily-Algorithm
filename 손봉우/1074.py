N, r, c = map(int, input().split())

ans = 0

def solve(m):
    global ans, r, c
    if m == -1:
        return
    
    a = pow(2, m)
    t = pow(2, 2*m)

    if c < a and r < a:
        solve(m-1)
    elif c >= a and r < a:
        ans += t
        c -= a
        solve(m-1)
    elif c < a and r >= a:
        ans += t*2
        r -= a
        solve(m-1)
    else:
        ans += t*3
        c -= a
        r -= a
        solve(m-1)

solve(N-1)
print (ans)