package week5

object tony_exercises {

	import tony_exercises0._
	import Exercises._;import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(109); 
	
	val One = Succ(Zero);System.out.println("""One  : week5.tony_exercises0.Succ = """ + $show(One ));$skip(21); 
	val Two = Succ(One);System.out.println("""Two  : week5.tony_exercises0.Succ = """ + $show(Two ));$skip(17); val res$0 = 
	
	add(One, Two);System.out.println("""res0: week5.tony_exercises0.Natural = """ + $show(res$0));$skip(62); 
	
	val list123 = new Cons(1, new Cons(2, new Cons(3, Empty)));System.out.println("""list123  : week5.tony_exercises0.Cons[Int] = """ + $show(list123 ));$skip(61); 
  val list456 = new Cons(4, new Cons(5, new Cons(6, Empty)));System.out.println("""list456  : week5.tony_exercises0.Cons[Int] = """ + $show(list456 ));$skip(16); val res$1 = 
	
	sum(list123);System.out.println("""res1: Int = """ + $show(res$1));$skip(19); val res$2 = 
	
	length(list123);System.out.println("""res2: Int = """ + $show(res$2));$skip(61); val res$3 = 

  map[Int, String](list123, x => (x * 12).toString.reverse);System.out.println("""res3: week5.tony_exercises0.List[String] = """ + $show(res$3));$skip(38); val res$4 = 
  
  filter[Int](list123, _ % 2 != 0);System.out.println("""res4: week5.tony_exercises0.List[Int] = """ + $show(res$4));$skip(30); val res$5 = 
  
  append(list123, list456);System.out.println("""res5: week5.tony_exercises0.List[Int] = """ + $show(res$5));$skip(51); 
  
  val xxs = Cons(list123, Cons(list456, Empty));System.out.println("""xxs  : week5.tony_exercises0.Cons[week5.tony_exercises0.Cons[Int]] = """ + $show(xxs ));$skip(18); val res$6 = 
  
  flatten(xxs);System.out.println("""res6: week5.tony_exercises0.List[Int] = """ + $show(res$6));$skip(68); val res$7 = 
  
  flatMap[Int, Int](list123, x => Cons(x, Cons(x * 10, Empty)) );System.out.println("""res7: week5.tony_exercises0.List[Int] = """ + $show(res$7));$skip(19); val res$8 = 
  maximum(list123);System.out.println("""res8: Int = """ + $show(res$8));$skip(48); val res$9 = 
  maximum(new Cons(2, Cons(5, Cons(3, Empty))));System.out.println("""res9: Int = """ + $show(res$9));$skip(49); val res$10 = 
  maximum2(new Cons(2, Cons(5, Cons(3, Empty))));System.out.println("""res10: Int = """ + $show(res$10));$skip(22); val res$11 = 
  
  reverse(list123);System.out.println("""res11: week5.tony_exercises0.List[Int] = """ + $show(res$11))}
}