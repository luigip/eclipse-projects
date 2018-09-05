object Cood
{
  valimport scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62);  up = Cood(0, 2)
  val;$skip(30);  upRight = Cood(1, 1)
  val;$skip(26);  downRight = Cood(1, -1)
  val;$skip(30);  down = Cood(0, - 2)
  val;$skip(28);  downLeft = Cood(-1, -1)
  val;$skip(85);  upLeft = Cood(- 1, 1)
  val dirns;$skip(34); : List[Cood] = List[Cood](up, upRight, downRight, down, downLeft, upLeft)
}
case class Cood(x: Int, y: Int);System.out.println("""up  : Cood = """ + $show(up ));System.out.println("""upRight  : Cood = """ + $show(upRight ));System.out.println("""downRight  : Cood = """ + $show(downRight ));System.out.println("""down  : Cood = """ + $show(down ));System.out.println("""downLeft  : Cood = """ + $show(downLeft ));System.out.println("""upLeft  : Cood = """ + $show(upLeft ));System.out.println("""dirns  : List[Cood] = """ + $show(dirns ))}
{
  def +(operand: Cood): Cood = Cood(x + operand.x, y + operand.y)
  def -(operand: Cood): Cood = Cood(x - operand.x, y - operand.y)
  def *(operand: Int): Cood = Cood(x * operand, y * operand)
}