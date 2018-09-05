package euler

object P015 extends App {
  def line(vals: List[Long], i:Int, size: Int):List[Long] = {
    if(i == size * 2) vals
//    else line(List(1L) ++ (vals.sliding(2).toList.map(a => a(0)+a(1))) ++ List (1L), i + 1, size)
    else line((0L::vals).reverse.zip(0L::vals).map(v=>v._1+v._2), i + 1, size)
  }
  val SIZE = 20
  val result = line(List[Long](1,1),1,SIZE)(SIZE)
  println(result)
  
}