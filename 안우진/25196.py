# 처음엔 속력이 같은게 있을 때 s와 e가 겹치지 않으면 -1이라 생각함
# 그러나 lcm까지도 만족하는 t가 없으면 -1
# 3마리의 새들 중 주기가 길고 s-e+1이 짧은 것을 기준으로 탐색함

def gcd(a,b):
    if b==0: return a
    return gcd(b,a%b)
def lcm(a,b):
    return a*b//gcd(a,b)
info=[]
for i in range(3):
    v,s,e=map(int,input().split())
    info.append((v,s,e))
    
upper=lcm(lcm(info[0][0],info[1][0]),info[2][0])
    
info.sort(key=lambda x : (x[2]-x[1]+1)/x[0])
k=0
while 1:
    for i in range(info[0][1],info[0][2]+1):
        t=info[0][0]*k+i
        if t>=upper:
            print(-1)
            exit()
        if info[1][1] <= t%info[1][0] <= info[1][2] and info[2][1] <= t%info[2][0] <= info[2][2]:
            print(t)
            exit()
    k+=1
