package greeter

object test extends testing.Benchmark {

  case class Row(time: Int)

  def counts(xs: List[Row], complete: Int = 0, incomplete: Int = 0): (Int,Int) = 
  xs match {
    case Nil => (complete, incomplete)
    case row :: tail => 
      if (row.time == 0) counts(tail, complete + 1, incomplete)
      else               counts(tail, complete, incomplete + 1)

  }
  
  def countsdhg(xs: List[Row]) = {
    val complete = xs.count(_.time == 0)
    (complete, xs.size - complete)
  }
  
  def countsdhg2(xs: List[Row]) = {
    val (complete, incomplete) = xs.iterator.partition(_.time == 0)
    (complete.size, incomplete.size)
  }
  
  val xs = List.fill(5000)(Row(util.Random.nextInt(2)))

  var res = (0, 0) // to avoid method call being optimized away
  
  def run {
    res = counts(xs)     //58  3414
//    res = countsdhg(xs)    //50
    //res = countsdhg2(xs) //333
  }

}

