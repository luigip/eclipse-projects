package greeter

import scala.util.parsing.combinator.JavaTokenParsers

object MyParser extends JavaTokenParsers {
  def expr  = "{" ~> repsep(paren,",") <~ "}" 
  def paren = "(" ~> decimalNumber <~ ")" ^^ { _.toInt }
}

object Run extends App {
  import MyParser._
  
  val input  = "{(2),(4), (5),( 100)}"
  parse(expr, input) match {
    case Success(xs, _) => xs foreach println
    case _              => println("failed to parse!")
  }
}