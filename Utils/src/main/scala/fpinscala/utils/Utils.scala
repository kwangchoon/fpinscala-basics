package fpinscala.utils

def delim(length: Int = 50): Unit = println("\u2500" * length)

def label(title: String, color: String = Console.CYAN): Unit =
  println(color ++ title ++ Console.RESET)

def time[R](block: => R): R = {
  val t0 = System.nanoTime()
  val result = block // call-by-name
  val t1 = System.nanoTime()
  println("Elapsed time: " + (t1 - t0) + "ns")
  result
}
