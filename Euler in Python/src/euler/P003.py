'''
Created on 8 Mar 2012

@author: Rhys
'''
n = 600851475143
d = 2
while d*d <= n :
    if n % d == 0:
        n /= d
    else: 
        d+=1
    
print n

# OK