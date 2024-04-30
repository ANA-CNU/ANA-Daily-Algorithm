import sys
input=sys.stdin.readline

ls=list(input().rstrip())
dic={'+':1,'-':1,'*':2,'/':2,'(':0}
stack=[]
put=[]
for j in range(len(ls)):
    if(ls[j]=='+' or ls[j]=='-' or ls[j]=='*' or ls[j]=='/' or ls[j]=='(' or ls[j]==')'):
        if not stack :
            stack.append(ls[j])
        else:
            op=ls[j]
            
            if(ls[j]==')'):
                while(stack[-1]!='('):
                    put.append(stack.pop())
                stack.pop()
            elif(ls[j]=='('):
                stack.append('(')
            else:
                if stack[-1]=='(':
                    stack.append(op)
                else:
                    while(stack and dic[stack[-1]]>=dic[op]):
                        put.append(stack.pop())
                    stack.append(op)
                   
    else:
        put.append(ls[j])
while stack:
    put.append(stack.pop())
for u in range(len(put)):
    print(put[u], end='')            
        
