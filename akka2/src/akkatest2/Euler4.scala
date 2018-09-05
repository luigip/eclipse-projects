package akkatest2

import akka.actor._
import akka.routing.RoundRobinRouter

sealed trait Euler4Message
case object Calculate extends Euler4Message
case class Work(range1: Seq[Int], range2: Seq[Int]) extends Euler4Message
case class Result(value: Int) extends Euler4Message
case class FinalResult(value: Int, duration: Long)

class Worker extends Actor {

  def calculate(r1: Seq[Int], r2: Seq[Int]): Int = {
    def isPalindrome(x: Int) = {
      val s = x.toString
      s.reverseIterator.sameElements(s.iterator)
    }
    var max = 0
    // count down so that we don't have to check if palindrome so often
    var i = r1.last
    while (i >= r1.head) {
      // for some reason counting down here increases the run-time :/
      var j = r2.head
      while (j <= r2.last) {
        val r = i * j
        if (r > max && isPalindrome(r)) max = r
        j += 1
      }
      i -= 1
    }
    max
  } 

  def receive = { case Work(r1, r2) => sender ! Result(calculate(r1, r2)) }   
}

class Master(nrOfDigits: Int, nrOfWorkers: Int, chunkSize: Int) extends Actor {
  
  var nrOfResults: Int = 0
  var maxResult = 0
  var sentAll = false
  var nrMessages = 0
  
  val start: Long = System.currentTimeMillis
  val min = math.pow(10, nrOfDigits - 1).toInt
  val max = math.pow(10, nrOfDigits).toInt 
  val range = min until max
  val workerRouter = 
    context.actorOf(Props[Worker].withRouter(RoundRobinRouter(nrOfWorkers)))

  def receive = {
    case Calculate =>
      for (i <- range.grouped(chunkSize)) { // grouped produces an Iterator 
        workerRouter ! Work(i, range)
        nrMessages += 1
      }
      sentAll = true
      
    case Result(value) =>
      if (value > maxResult) maxResult = value
      nrOfResults += 1
      if (sentAll && nrOfResults == nrMessages) {
         println("Result = "+ maxResult 
                +"\nTime in ms: "+ (System.currentTimeMillis - start))
         context.system.shutdown()
      }
  }
}

object Euler4 extends App {
  val master =  ActorSystem().actorOf(Props(new Master(4, 2, 5000)))
  master ! Calculate
}

