package scratch

object ParenParser {
 
  def parse(s: String) = {
    var res = Vector[String]()
    var depth = 0
    var block = ""
    for (c <- s) {
      block += c
      c match {
        case '[' => depth += 1
        case ']' => depth -= 1
                    if (depth == 0) {
                      res :+= block
                      block = ""
                    }
        case _   =>
      }
    }
    res
  }
  
} 
  
  
object Test extends App {
  import ParenParser._

  // TEST
  val t1 = "[hello:=[notting],[hill]][3.4(4.56676|5.67787)][the[hill[is[high]]not]]"
  val r1 = List("[hello:=[notting],[hill]]", "[3.4(4.56676|5.67787)]", "[the[hill[is[high]]not]]")
  val t2 = "[f[sad][add]dir][er][p]"
  val r2 = List("[f[sad][add]dir]", "[er]","[p]")
  
  parse(t1) foreach println
  parse(t2) foreach println
  
  println("t1: " + (parse(t1) == r1))
  println("t2: " + (parse(t2) == r2))
  
}