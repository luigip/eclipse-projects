
object scratch {

trait Square {
  def filled: Boolean
}

type Board = Seq[Square]




	  def filled(b: Board): Square = {
	    if (b.isEmpty) throw new NoSuchElementException
	    else if (b.head.filled) b.head
	    else filled(b.tail)
	  }
  
}