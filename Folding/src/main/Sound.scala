package main

object Sound {

}

import javax.sound.sampled._

object SinSoundMain extends App {
  val SAMPLE_RATE = 44100
  val SAMPLE_SIZE = 16
  val CHANNELS = 1
  val SIGNED = true
  val BIG_ENDIAN = true
  val format = new AudioFormat(SAMPLE_RATE, SAMPLE_SIZE, CHANNELS, SIGNED, BIG_ENDIAN)
  
  var info = new DataLine.Info(classOf[SourceDataLine], format);

  val auline = (AudioSystem.getLine(info)).asInstanceOf[SourceDataLine]
  auline.open(format)
  auline.start

  val start = System.currentTimeMillis()

  var index = 0
  var count = 0
  
  val FREQUENCY = 800.0
  val secs = 1.0 
  
  def toPhase(x: Int, freq: Double) = math.sin(x * freq / SAMPLE_RATE * math.Pi)
//  def toIndex(p: Double, freq: Double) = (math.asin(p) * SAMPLE_RATE / freq).toInt
  
  // number of samples in 200 oscillations
  val ssize = (200 * SAMPLE_RATE / FREQUENCY).toInt 
//  val ssize = 50000
  
  
  val bs = new Array[Byte](ssize * 2)
  var j = 0
  
  while (j < ssize) {
    val s = toPhase(j + index, FREQUENCY)
    val ss = (s * Short.MaxValue).toShort
    bs(j * 2) = (ss >> 8).toByte
    bs(j * 2 + 1) = (ss & 0xFF).toByte
    j += 2
  }  
  
  // play 10s
  while(index < SAMPLE_RATE * secs ) {   
    
    println("before write " + count)
    println(System.currentTimeMillis() - start)
    
    auline.write(bs, 0, bs.length)
    
    println("after write")
    println(System.currentTimeMillis() - start)
    
    index += ssize
    count += 1
  }

  println(System.currentTimeMillis() - start)
  
  // cleanup      
  auline.drain
  auline.close
}
