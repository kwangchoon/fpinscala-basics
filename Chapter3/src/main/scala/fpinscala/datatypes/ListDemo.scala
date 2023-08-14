package fpinscala.datatypes

import fpinscala.utils.*

object ListDemo1 /* extends App */ {
  import List.*

  val as = List(1, 2, 3, 4, 5)

  delim()
  println(as)
  println(tail(as))
  println(setHead(as, 77))
  delim()
}

object ListDemo2 /* extends App */ {
  import List.*

  val as = List(1, 2, 3, 4, 5)

  delim()
  println(drop(as, 0))
  println(drop(as, 3))
  println(drop(as, 6))
  delim()
  println(dropWhile(Nil, (x: Int) => x < 3))
  println(dropWhile(as, (x: Int) => x < 3))
  println(dropWhile(as, (x: Int) => x < 6))
  delim()
}

object ListDemo3 /* extends App */ {
  import List.*

  val as = List(1, 2, 3, 4, 5)
  val bs = List(10, 11, 12)

  delim()
  println(append(as, bs))
  println(init(as))
  delim()
}

object ListDemo4 /* extends App */ {
  import List.*

  def sum(as: List[Int]): Int = as match
    case Nil         => 0
    case Cons(x, xs) => x + sum(xs) // + (x, sum(xs))

  def product(as: List[Double]): Double = as match
    case Nil         => 1.0
    case Cons(x, xs) => x * product(xs) // * (x, product(xs))

  val as = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val bs = List(1.0, 2.0, 3.0, 4.0, 5.0)

  delim()
  println("sum = " + sum(as))
  println("product = " + product(bs))
  delim()

  // How to generalize the above two functions?
}

object ListDemo5 /* extends App */ {
  import List.*

  val as = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val bs = List(1.0, 2.0, 3.0, 4.0, 5.0)

  delim()
  println(lengthViaFoldRight(as))
  println(sumViaFoldLeft(as))
  println(productViaFoldLeft(bs))
  delim()
}

object ListDemo6 /* extends App */ {
  import List.*

  val as = List(1, 2, 3, 4, 5)

  // Exercise 3.8
  // See what happens when you pass `Nil` and `Cons` themselves to `foldRight`.
  delim()
  println(
    foldRight(as, Nil: List[Int])(Cons(_, _))
  )
  delim()

  println(reverse(as))
  delim()

  val bs = List(10, 11, 12)
  println(appendViaFoldRight(as, bs))
  delim()
}

object ListDemo7 /* extends App */ {
  import List.*

  delim()
  println(concat(List(List(1, 1), List(2, 2), List(3, 3))))
  delim()
}

object ListDemo8 /* extends App */ {
  import List.*

  val as = List(1, 2, 3, 4, 5)
  delim()
  println(addOne(as))
  delim()

  val bs = List(1.0, 2.0, 3.0, 4.0, 5.0)
  println(doubleToString(bs))
  delim()

  println(map(as)(_ + 1))
  delim()

  println(filter(as)(_ % 2 == 0))
  delim()
}

object ListDemo9 /* extends App */ {
  import List.*

  val as = List(1, 2, 3, 4, 5)

  delim()
  println(flatMap(as)(i => List(i, i)))
  delim()

  println(concat(List(List(1, 2), Nil, List(3, 4))))
  delim()

  println(filterViaFlatMap(as)(_ % 2 == 0))
  delim()
}

object ListDemo10 /* extends App */ {
  import List.*

  val as = List(1, 2, 3, 4, 5)
  val bs = List(11, 12, 13)

  delim()
  println(addPairwise(as, bs))
  delim()

  println(zipWith(as, bs)(_ + _))
  delim()

  val cs = List("hello", "yellow", "mellow")
  println(zipWith(as, cs)((_, _)))
  delim()
}

object ListDemo11 /* extends App */ {
  import List.*

  val as = List(1, 2, 3, 4, 5)

  println(hasSubsequence(as, List(3, 4)))
  println(hasSubsequence(as, List(2, 3, 5)))
  delim()
}
