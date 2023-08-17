package fpinscala.rand

import fpinscala.utils.*
import fpinscala.rng.SimpleRNG
import Rand.*

val rng = SimpleRNG(42)

object RandDemo1 /* extends App */:

  delim()
  label("unit(42)")
  println(unit(42)(rng))
  delim()

  label("map(unit(42))(_ + 1)")
  println(map(unit(42))(_ + 1)(rng))
  delim()

  label("doubleViaMap(rng)")
  println(doubleViaMap(rng))
  delim()

end RandDemo1

/*
 * Combining State Actions Tests
 */
object RandDemo2 /* extends App */:

  label("map2(unit(1), unit(7))(_ + _)")
  println(map2(unit(1), unit(7))(_ + _)(rng))

  label("both(unit(1), unit(7))")
  println(both(unit(1), unit(7))(rng))

  label("randIntDouble(rng)")
  println(randIntDouble(rng))

  label("randDoubleInt(rng)")
  println(randDoubleInt(rng))
  delim()

end RandDemo2

object RandDemo3 /* extends App */:

  label("sequence(List(int, int, int))(rng)")
  println(sequence(List(int, int, int))(rng))

  label("intsViaSequence(3)(rng)")
  println(intsViaSequence(3)(rng))
  delim()

end RandDemo3

/*
 * Neting State Actions Tests
 */
object RandDemo4 /* extends App */:

  label("nonNegativeLessThan_Manual(100)(rng)")
  println(nonNegativeLessThan_Manual(100)(rng))
  delim()

  label("nonNegativeLessThan(100)(rng)")
  println(nonNegativeLessThan(100)(rng))
  delim()

end RandDemo4
