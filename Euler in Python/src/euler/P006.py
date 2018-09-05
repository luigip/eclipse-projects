n = 100
sum_squares = 0
sums = 0
for i in xrange(1, n + 1):
    sum_squares += i * i
    sums += i
print sums * sums - sum_squares

#OK