package euler

object P065 extends App {
  
  val nterms = 100                              

//  def simplify(a: BigInt, b: BigInt) = {
//    val g = gcd(a, b)
//    (a/g, b/g)
//  }                                            
//  
//  def gcd(a: BigInt, b: BigInt): BigInt =
//    if (b == 0) a
//    else gcd(b, a % b)                          

  val ecf = 2 #:: Stream.from(1).flatMap(x => List(1, 2 * x, 1))
                                            
  def term(n: Int) = ecf.take(n).foldRight((BigInt(0), BigInt(1))) { case (e, (num, denom)) =>
    (denom, e * denom + num)
  }.swap                                     

  val sumDigits = term(nterms)._1.toString.map(_.asDigit).sum
                                     

  

  println(sumDigits)                           
}