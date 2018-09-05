
object worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(33); 

  val x = 10;System.out.println("""x  : Int = """ + $show(x ));$skip(17); 

  val y = x + 1;System.out.println("""y  : Int = """ + $show(y ))}

}