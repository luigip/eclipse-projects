package scratch

object RoundRobin extends testing.Benchmark {

  var res: List[Seq[Int]] = _
  
  def run {
    
    for (i <- 1 to 100000) {
      res = roundR(List(1, 2, 3, 4, 5, 6, 7), 3)
    }
    
    assert(res == List(List(1, 4, 7), List(2, 5), List(3, 6)))
  }
  
  def round[T](xs: Seq[T], n: Int) = {  // 183

    def go(ys: Seq[T], i: Int, out: Seq[Seq[T]]): Seq[Seq[T]] = ys match {
      case Nil => out
      case head :: tail => go(tail, (i+1) % n, out.updated(i, out(i) :+ head))
    }

    go(xs, 0, Vector.fill(n)(Vector.empty)).map(_.toList).toList
  }

  def round2[T](l: List[T], n: Int) =  //504 
    (0 until n).map{ i => l.drop(i).sliding(1, n).flatten.toList }.toList
  
  def roundRobin(l:List[Int],n:Int) =  //84 
    { (for(i <- 0 until n) yield l.filter(_ % n==i)).toList }

  def roundRobin2[T](xs:List[T],n:Int) = {// 119
    val zs = xs.zipWithIndex
    (0 until n).toList map {i => zs filter (_._2 % n == i ) map (_._1) }
  }
  
  def roundM[A](xs: List[A], c: Int) = {  //361
        val n = Stream.iterate(c)(c +).find(_ >= xs.length).get
        val ys = xs.map(Some(_)).padTo(n, None)
        ys.grouped(c).toList.transpose.map(_.flatten)
      }

  def roundR[T](xs: Seq[T], n: Int) = //218
    xs.zipWithIndex.groupBy(_._2 % n).toList.sortBy(_._1).map(_._2 map (_._1))
  
}