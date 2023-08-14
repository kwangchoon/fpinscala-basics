package fpinscala.datatypes

object EitherSample:
  import Either.*

  case class Name private (value: String)

  object Name:
    def apply(name: String): Either[String, Name] =
      if name == null || name.isEmpty then Left("Name is empty")
      else Right(new Name(name))

  case class Age private (value: Int)

  object Age:
    def apply(age: Int): Either[String, Age] =
      if age < 0 then Left("Age is out of range")
      else Right(new Age(age))

  case class Person(name: Name, age: Age)

  object Person:
    def make(name: String, age: Int): Either[String, Person] =
      Name(name).map2(Age(age))(Person(_, _))

    def makeBoth(name: String, age: Int): Either[List[String], Person] =
      map2Both(Name(name), Age(age), Person(_, _))

end EitherSample

object ValidatedSample:
  import Validated.{Invalid, Valid}

  case class Name private (value: String)

  object Name:
    def apply(name: String): Validated[String, Name] =
      if name == "" || name == null then Invalid(List("Name is empty."))
      else Valid(new Name(name))

  case class Age private (value: Int)

  object Age:
    def apply(age: Int): Validated[String, Age] =
      if age < 0 then Invalid(List("Age is out of range."))
      else Valid(new Age(age))

  case class Person(name: Name, age: Age)

  object Person:
    def make(name: String, age: Int): Validated[String, Person] =
      Name(name).map2(Age(age))(Person(_, _))

end ValidatedSample
