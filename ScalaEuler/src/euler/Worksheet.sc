package euler

object Worksheet {
  
  class Container(s: String) {
    def unapply(xs: List[String]): Boolean = xs contains s
  }
  
  val B = new Container("BREAK")                  //> B  : euler.Worksheet.Container = euler.Worksheet$Container@1fff7a1e
  
  List("abc", "BREAK") match {
    case B() => "Yup"
    case _ => "Nope"
  }                                               //> res0: java.lang.String = Yup
  
}