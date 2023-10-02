def mul(n, k, b):
    if k == 0:
        return 1

    temp = mul(n, k//2, b)
    if k%2 == 1:
        return ((temp*temp)%b*n)%b
    else:
        return (temp*temp)%b

T = int(input())
for _ in range(T):
    a, b = map(int, input().split())
    k, n = map(int, input().split())

    a *= mul(10, k-1, b)
    a %= b

    ans = ''
    for _ in range(n):
        a *= 10
        ans+=str(a//b)
        a %= b

    print(ans)