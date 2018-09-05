'''
Created on 8 Mar 2012

@author: Rhys
'''
def isPalindrome(x):
    return repr(x) == repr(x)[::-1]

r = 0
i = 100
while i < 1000:
    j = 100
    while j < 1000:
        res = i * j
        if isPalindrome(res) and res > r:
            r = res
        j += 1
    i += 1
            
print r

#OK: 906609

# Would be better to do it with for a in xrange(100, 999) etc