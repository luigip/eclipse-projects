import common._

object Excercises {;import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(210); 

  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  };System.out.println("""init: [T](xs: List[T])List[T]""");$skip(209); 

  def flatten(xs: List[Any]): List[Any] = xs match {
    case List() => List()
    case x :: xs => x match {
      case y :: ys => flatten(y :: ys) ::: flatten(xs)
      case y => y :: flatten(xs)
    }
  };System.out.println("""flatten: (xs: List[Any])List[Any]""");$skip(54); val res$0 = 

  flatten(List(List(1, 1), 2, List(3, List(5, 8))));System.out.println("""res0: List[Any] = """ + $show(res$0));$skip(30); 

  val xs = List(3, 5, 1, 6);System.out.println("""xs  : List[Int] = """ + $show(xs ));$skip(13); val res$1 = 

  init(xs);System.out.println("""res1: List[Int] = """ + $show(res$1))}
 
}