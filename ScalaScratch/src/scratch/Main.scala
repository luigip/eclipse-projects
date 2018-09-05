package scratch

object Main extends Arith with App {
  val input = "4 / (1 + 1) / 5 + 3 "
  println(parseAll(expr, input).get) // prints 33.0
}

import scala.util.parsing.combinator.JavaTokenParsers

class Arith extends JavaTokenParsers {
  
  type D = Double
  
  def expr:   Parser[D]    = term ~ rep(plus | minus)     ^^ {case a~b => (a /: b)((acc,f) => f(acc))} 
  def plus:   Parser[D=>D] = "+" ~ term                   ^^ {case "+"~b => _ + b}
  def minus:  Parser[D=>D] = "-" ~ term                   ^^ {case "-"~b => _ - b}
  def term:   Parser[D]    = factor ~ rep(times | divide) ^^ {case a~b => (a /: b)((acc,f) => f(acc))}
  def times:  Parser[D=>D] = "*" ~ factor                 ^^ {case "*"~b => _ * b }
  def divide: Parser[D=>D] = "/" ~ factor                 ^^ {case "/"~b => _ / b} 
  def factor: Parser[D]    = fpn | "(" ~> expr <~ ")" 
  def fpn:    Parser[D]    = floatingPointNumber          ^^ (_.toDouble)
  
}