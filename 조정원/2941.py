import sys

crot_alp=str(sys.stdin.readline()[:-1])
crot_alp=list(crot_alp)
alp_num=len(crot_alp)

for i in range(alp_num-2):
    if crot_alp[i]=='d' and crot_alp[i+1]=='z' and crot_alp[i+2]=='=':
        crot_alp[i]=8
        crot_alp[i+1]=0
        crot_alp[i+2]=0
for i in range(alp_num-1):
    if crot_alp[i]=='c' and crot_alp[i+1]=='=':
        crot_alp[i]=1
        crot_alp[i+1]=0
    if crot_alp[i]=='c' and crot_alp[i+1]=='-':
        crot_alp[i]=2
        crot_alp[i+1]=0
    if crot_alp[i]=='d' and crot_alp[i+1]=='-':
        crot_alp[i]=3
        crot_alp[i+1]=0
    if crot_alp[i]=='l' and crot_alp[i+1]=='j':
        crot_alp[i]=4
        crot_alp[i+1]=0
    if crot_alp[i]=='n' and crot_alp[i+1]=='j':
        crot_alp[i]=5
        crot_alp[i+1]=0
    if crot_alp[i]=='s' and crot_alp[i+1]=='=':
        crot_alp[i]=6
        crot_alp[i+1]=0
    if crot_alp[i]=='z' and crot_alp[i+1]=='=':
        crot_alp[i]=7
        crot_alp[i+1]=0

while True:
    if 0 in crot_alp:
        crot_alp.remove(0)
    else:
        break
print(len(crot_alp))
