import sys

star_number=1
blank_number=1
star=int(sys.stdin.readline())
blank_number=star
for i in range(star):
    blank_number-=1
    print(' '*blank_number+'*'*star_number)
    star_number+=2
star_number-=2
for i in range(star-1):
    star_number-=2
    blank_number+=1
    print(' '*blank_number+'*'*star_number)
