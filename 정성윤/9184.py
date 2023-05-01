dp = [[[0]*(50) for _ in range(50)] for _ in range(50)] # dp 테이블 생성 0을 채운 list 50개 안에 0을 채운 list 50 개안에 0을 채운 list 50개 만들기;

def w(a,b,c): 
    if a <= 0 or  b <= 0 or c <= 0: # a,b,c 세개다 - 일때 return 1
        return 1 
    if a > 20 or b > 20 or c > 20: # a,b,c 세개다 20을 넘을경우 3개 전부 20으로 맞춰서 w 재귀
        return(w(20,20,20))

    if dp[a][b][c]: # dp 테이블에 a,b,c 값이 있으면 return 
        return dp[a][b][c]

    if a < b and b < c: # a<b and b<c일 경우 dp a,b,c 안에 값을 넣기
        dp[a][b][c] = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c)
        return dp[a][b][c]
    else: # 그 외 나머지 경우 계산해서 dp 테이블에 넣어주기
        dp[a][b][c] = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1, b, c-1)-w(a-1,b-1,c-1)
        return dp[a][b][c]
while True: # a,b,c가 -1 만 나올 때까지 input 받기
    a,b,c = map(int,input().split()) # a,b,c로 input 받기
    if a == -1 and b == -1 and c == -1:
        break
    print(f"w({a}, {b}, {c}) = {w(a,b,c)}") # w함수 실행


"""
tlqkf 코드는 이해가 되는데 이걸 답 안보고 짤 수 있다는게 가능한가 싶다
"""