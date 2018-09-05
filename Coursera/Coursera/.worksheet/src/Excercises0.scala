import common._

object Excercises0 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(211); 

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

  init(xs);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(502); 
 
  // MERGE SORT
  def msort[T <% Ordered[T]](xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, ys1) => ys1
      case (xs1, Nil) => xs1
      case (x :: xs1, y :: ys1) =>
        if (x < y) x :: merge(xs1, ys)
        else       y :: merge(xs, ys1)
    }
    xs match {
      case Nil => Nil
      case List(x) => List(x)
      case (x :: xs1) =>
        val (a, b) = xs splitAt (xs.length / 2)
        merge(msort(a), msort(b))
    }
  };System.out.println("""msort: [T](xs: List[T])(implicit evidence$1: T => Ordered[T])List[T]""");$skip(42); val res$2 = 
  
  msort(List(1, 5, -3, 3, 2, 0, 8, 1));System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(40); val res$3 = 
  msort(List("dog", "cat", "elephant"));System.out.println("""res3: List[java.lang.String] = """ + $show(res$3));$skip(55); 
 
  val data = List("a", "a", "a", "b", "c", "c", "a");System.out.println("""data  : List[java.lang.String] = """ + $show(data ));$skip(215); 
 
  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil      => Nil
    case x :: xs1 =>
      val (as, bs) = xs span (_ == x)
      as :: pack(bs)
  };System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(16); val res$4 =                                                //
  
  pack(data);System.out.println("""res4: List[List[java.lang.String]] = """ + $show(res$4));$skip(99); 
  
  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())( f(_) :: _ );System.out.println("""mapFun: [T, U](xs: List[T], f: T => U)List[U]""");$skip(80); 

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)( (x, a) => a + 1 );System.out.println("""lengthFun: [T](xs: List[T])Int""");$skip(52); val res$5 = 
    
    
  mapFun(List(1,2,3), (x: Int) => x * 10);System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(46); val res$6 = 
  lengthFun(List("ca", "dog", "rat","sdfgs"));System.out.println("""res6: Int = """ + $show(res$6))}
}
























;