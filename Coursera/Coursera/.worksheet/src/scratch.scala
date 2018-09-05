
object scratch {

trait Square {
  def filled: Boolean
}

type Board = Seq[Square];import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(242); 




	  def filled(b: Board): Square = {
	    if (b.isEmpty) throw new NoSuchElementException
	    else if (b.head.filled) b.head
	    else filled(b.tail)
	  };System.out.println("""filled: (b: scratch.Board)scratch.Square""")}
  
}