s=list(map(int,open(0).read().split()))
a=["number_theory","geometry"]
b=["hanbyeol",a[1]]
p=print
for i in range(s[0]):
    c=i*5+1
    o=s[c]+s[c+1]+s[c+2]
    if o>1:p(b[0])
    elif o==0:p(a[s[c+3]%2])
    else:p(b[s[c+2]and s[c+3]%2])