package fpinscala.datatypes

import fpinscala.utils.*

import Validated.*
import ValidatedSample.Person

object ValidatedDemo /* extends App */:
  delim()
  label("Both invald, both errors reported")
  val p2 = Person.make("", -1)
  println(p2)
  delim()

  label(
    "Each successive use of `map2` does not add another layer of List to the error type"
  )
  val p3 = Person.make("", 34)
  val p4 = Person.make("", -1)
  val pair: Validated[String, (Person, Person)] =
    p3.map2(p4)((_, _))
  println(pair)
  delim()

end ValidatedDemo
