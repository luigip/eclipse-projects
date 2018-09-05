
plast = 0
pn = 1
exp = 0
sumprob = 0
for i in range(2, 1001) :
    pn = (i - 1)/999.0 * (1 - sumprob) 
    print i, pn
    exp += i * pn
    sumprob += pn
    plast = pn

    
print exp
print pn
print plast
print sumprob
print pn - plast
print i