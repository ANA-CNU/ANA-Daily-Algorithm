n = int(input())

if 1 <= n <= 5:
    print(n)

elif 5 < n <= 10 ** 9:
    
    remainder = n % 8
    
    if remainder == 1:
        print(1)
        
    elif remainder == 2 or remainder == 0:
        print(2)
        
    elif remainder == 3 or remainder == 7:
        print(3)
        
    elif remainder == 4 or remainder ==16:
        print(4)
        
    elif remainder == 5:
        print(5)