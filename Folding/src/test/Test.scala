package test
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import folding.Folding._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Test extends FunSuite with ShouldMatchers {

  test("LT")   { fold("LT")   should equal ( Seq(2,1,3,4) ) }
  test("RB")   { fold("RB")   should equal ( Seq(3,4,2,1) ) }
  test("RBLT") { fold("RBLT") should equal ( Seq(2,3,15,14,13,16,4,1,5,8,12,9,10,11,7,6) ) }
  test("LLTT") { fold("LLTT") should equal ( Seq(12,9,10,11,7,6,5,8,4,1,2,3,15,14,13,16) ) }
  
  test("Seq 1") { unfold(Seq(2,1,3,4)) should equal ("LT") }
  test("Seq 2") { unfold(Seq(3,4,2,1)) should equal ("RB") }
  test("Seq 3") { unfold(Seq(2,3,15,14,13,16,4,1,5,8,12,9,10,11,7,6)) should equal ("RBLT") }
  test("Seq 4") { unfold(Seq(12,9,10,11,7,6,5,8,4,1,2,3,15,14,13,16)) should equal ("LLTT") }
  
}