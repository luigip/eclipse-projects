package euler

object P076 extends App {
  // Problem 76 Counting summations
  
  var memo = Map[(Int, Int), Int]()               //> memo  : scala.collection.immutable.Map[(Int, Int),Int] = Map()
  
  def c(n: Int, x: Int): Int = {
    if (memo contains (n,x)) memo(n,x) else {
      val xtra = n - x
      val result = n match {
        case `x` => 1
        case  n  => {
          for {
            i <- 1 to (x min xtra)
          } yield c(xtra, i)
        }.sum
      }
      memo += (n,x) -> result
      result
    }
  }                                               //> c: (n: Int, x: Int)Int

  def f(n: Int) = (1 to n).map(i => c(n, i)).sum - 1 

  
  println(f(100))                                          //> res0: Int = 190569291
               
}