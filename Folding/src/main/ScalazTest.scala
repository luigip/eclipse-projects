package main

object ScalazTest extends App {

//  import scalaz._
//  import Scalaz._

  def split[T](lst: List[T], index: Int) = {
   
    def go(lst1: List[T], lst2: List[T], index: Int): (List[T], List[T]) = index match {
      case 0 => (lst1.reverse, lst2)
      case x => go(lst2.head :: lst1, lst2.tail, index - 1)
    }
    
    go(List.empty[T], lst, index max 0 min lst.length)
  }

  val res = split("acde".toList, 100)
  println(res)
  "abc" andThen print
}