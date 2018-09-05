package euler

object P024 extends App {
//  val result = List.range(0, 10).permutations.take(1000000).toList.last.mkString.toLong
//  println(result)
//  
  def ps(s: String): Seq[String] = if(s.size == 1) Seq(s) else 
  s.flatMap(c => ps(s.filterNot(_ == c)).map(c +))
  val r = ps("0123456789")(999999).toLong
  println(r)
}

object P025 extends App {
  lazy val fibb: Stream[BigInt] = {
    1 #:: 1 #:: fibb.zip(fibb.tail).map(i => i._1 + i._2)
  }
  val result = fibb.takeWhile(_.toString.length < 1000).length + 1
  println(result)
}