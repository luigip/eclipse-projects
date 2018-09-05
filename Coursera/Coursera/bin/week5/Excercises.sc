import common._

object Excercises0 {

  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }                                               //> init: [T](xs: List[T])List[T]

  def flatten(xs: List[Any]): List[Any] = xs match {
    case List() => List()
    case x :: xs => x match {
      case y :: ys => flatten(y :: ys) ::: flatten(xs)
      case y => y :: flatten(xs)
    }
  }                                               //> flatten: (xs: List[Any])List[Any]

  flatten(List(List(1, 1), 2, List(3, List(5, 8))))
                                                  //> res0: List[Any] = List(1, 1, 2, 3, 5, 8)

  val xs = List(3, 5, 1, 6)                       //> xs  : List[Int] = List(3, 5, 1, 6)

  init(xs)                                        //> res1: List[Int] = List(3, 5, 1)
 
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
  }                                               //> msort: [T](xs: List[T])(implicit evidence$1: T => Ordered[T])List[T]
  
  msort(List(1, 5, -3, 3, 2, 0, 8, 1))            //> res2: List[Int] = List(-3, 0, 1, 1, 2, 3, 5, 8)
  msort(List("dog", "cat", "elephant"))           //> res3: List[java.lang.String] = List(cat, dog, elephant)
 
  val data = List("a", "a", "a", "b", "c", "c", "a")
                                                  //> data  : List[java.lang.String] = List(a, a, a, b, c, c, a)
 
  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil      => Nil
    case x :: xs1 =>
      val (as, bs) = xs span (_ == x)
      as :: pack(bs)
  }                                               //
                                                  //> pack: [T](xs: List[T])List[List[T]]
  
  pack(data)                                      //> res4: List[List[java.lang.String]] = List(List(a, a, a), List(b), List(c, c
                                                  //| ), List(a))
  
  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())( f(_) :: _ )         //> mapFun: [T, U](xs: List[T], f: T => U)List[U]

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)( (x, a) => a + 1 )           //> lengthFun: [T](xs: List[T])Int
    
    
  mapFun(List(1,2,3), (x: Int) => x * 10)         //> res5: List[Int] = List(10, 20, 30)
  lengthFun(List("ca", "dog", "rat","sdfgs"))     //> res6: Int = 4
}
























;