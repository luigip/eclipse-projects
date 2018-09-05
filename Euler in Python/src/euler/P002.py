'''
Created on 8 Mar 2012

@author: Rhys
'''
a, b = 1, 1
t = 0
while b < 4000000:
    if b % 2 == 0:
        t += b
    a, b = b, a + b
    
print t

# OK