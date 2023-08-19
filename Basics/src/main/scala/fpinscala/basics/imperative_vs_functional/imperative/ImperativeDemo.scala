package fpinscala.basics.imperative_vs_functional.imperative

import fpinscala.utils.*

object Imperative {

  @main
  def main: Unit = {
    delim()
    println("Good morning, what is your name?")

    val name = scala.io.StdIn.readLine()

    println(s"Nice to meet you, $name!")
    delim()
  }
}
