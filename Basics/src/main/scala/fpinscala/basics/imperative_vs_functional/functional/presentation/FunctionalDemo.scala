package fpinscala.basics
package imperative_vs_functional.functional
package presentation

import fpinscala.utils.*
import fpinscala.basics.imperative_vs_functional.functional.fplibrary.*
import fpinscala.basics.imperative_vs_functional.functional.application.*

object Functional {

  @main
  def main: Unit = {
    // Nothing happens
    val program: IO[Unit] = getDescription()

    // When interpreted, effects materialized
    delim()
    program.unsafeRun
    delim()
  }

}
