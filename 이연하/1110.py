n=int(input())
num = n
cyc = 0

while True:
    a= num//10   #십의자리
    b= num%10    #일의 자리
    c= (a+b)%10 #(십의자리+일의자리)의 일의자리
    num=(b*10)+c  #주어진 수의 오른쪽 자리수+합의 오른쪽자리수
    cyc=cyc+1
    if(num==n): break

print(cyc)
