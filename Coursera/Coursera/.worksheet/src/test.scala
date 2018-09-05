object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(87); 

  val xs = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e);System.out.println("""xs  : List[Symbol] = """ + $show(xs ));$skip(161); 

  def pack1[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case _ =>
      val (ys, zs) = xs span (_ == xs.head)
      ys :: pack(zs)
  };System.out.println("""pack1: [T](xs: List[T])List[List[T]]""");$skip(147); 
  
  def pack[T](xs: List[T]): List[List[T]] = xs.headOption map { x =>
      val (ys, zs) = xs span (x==)
      ys :: pack(zs)
  } getOrElse Nil;System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(15); val res$0 = 
  
  pack(xs);System.out.println("""res0: List[List[Symbol]] = """ + $show(res$0))}

}