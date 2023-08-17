package fpinscala.rng

import fpinscala.utils.*
import RNG.*

val rng   = SimpleRNG(42)
val rng_7 = SimpleRNG(-7)

object RngDemo1 /* extends App */:

  delim()
  label("int")
  println(int(rng))
  println(int(rng_7))
  delim()

  label("randomPair")
  println(randomPair(rng))
  println(randomPair(rng_7))
  delim()

  label("nonNegativeInt")
  println(nonNegativeInt(rng))
  println(nonNegativeInt(rng_7))
  delim()

  label("double")
  println(double(rng))
  delim()

end RngDemo1

object RngDemo2 /* extends App */:

  delim()
  label("intDouble, doubleInt, double3")
  println(intDouble(rng))
  println(doubleInt(rng))
  println(double3(rng))
  delim()

  label("ints")
  println(ints(5)(rng))
  delim()

end RngDemo2
