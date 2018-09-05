'''
    Created on 8 Mar 2012
    
    @author: Rhys
'''
s = 0
for i in xrange(1, 1000):
    if (i%3 == 0 or i%5 == 0):
        s += i
print s

# or

print sum([i for i in range(1000) if (i%3 == 0 or i%5 == 0)])

    