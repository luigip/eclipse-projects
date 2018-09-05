package euler

object P004R extends App {
  def isPalindrome (n: Int) = n.toString == n.toString.reverse
  val R = 100 until 1000
  val pals = {
    for (i <- R; j <- R; if isPalindrome(i * j)) yield (i * j)
  }
  println (pals max)
}

object P004J extends App {
//  def isPalindrome (n: Int) = n.toString == n.toString.reverse
  def isPalindrome(x: Int): Boolean = {val string = x.toString;string.reverseIterator.sameElements(string.iterator)}
  val R = 100 until 1000
  val xs = for (i <- R par; j <- R) yield i * j
  val pals = xs filter isPalindrome

  val t0 = System.currentTimeMillis
  for(i <- 1 to 100)
    println (pals max)
  println(System.currentTimeMillis - t0)
}

object P0044 extends App {
  def isPalindrome(x: Int): Boolean = {val string = x.toString;string.reverseIterator.sameElements(string.iterator)}

  def products(min: Int, max: Int) = for { 
    x <- min to max par; 
    y <- min to max par; 
    if isPalindrome(x * y) 
  } yield ( x * y)


  val t0 = System.currentTimeMillis
//  for(i <- 1 to 100)
    println (products(1000, 9999).max)
  println(System.currentTimeMillis - t0)
}