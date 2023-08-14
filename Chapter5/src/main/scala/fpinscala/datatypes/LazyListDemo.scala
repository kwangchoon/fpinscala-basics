package fpinscala.datatypes

import fpinscala.utils.*
import LazyList.*

object LazyListDemo0 /* extends App */:
  delim()
  println(empty[Int])
  println(cons(1, cons(2, cons(3, empty[Int]))))
  println(LazyList(1, 2, 3, 4, 5))
  delim()

object LazyListDemo1 /* extends App */:

  def expensive(x: Int): Int = { println(s"expensive($x)"); x }

  delim()
  val x = cons(expensive(42), empty)
  val h1 = x.headOption
  val h2 = x.headOption
  delim()

  val y = Cons(() => expensive(42), () => empty)
  val k1 = y.headOption
  val k2 = y.headOption
  delim()

end LazyListDemo1

object LazyListDemo2 /* extends App */:
  val l1 = LazyList(1, 2, 3, 4, 5)

  delim()
  label("take(3)"); println(l1.take(3).toList)
  delim()
  // println(l1.existsViaFoldRight(_ > 3))

  label("drop(3)"); println(l1.drop(3).toList)
  delim()

  label("takeWhile(_ < 4)")
  println(l1.takeWhile(_ < 4).toList)
  delim()

end LazyListDemo2

object LazyListDemo3 /* extends App */:

  val as = LazyList(1, 2, 3, 4, 5)

  label("exists(_ == 3)")
  println(as.exists(_ == 3))
  delim()

  label("foldRight(0)(_ + _)")
  println(as.foldRight(0)(_ + _))
  delim();

  label("existsViaFoldRight(_ == 3)")
  println(as.existsViaFoldRight(_ == 3))
  delim()

  label("forAll(_ < 10)")
  println(as.forAll(_ < 10))
  label("forAll(_ < 5)")
  println(as.forAll(_ < 5))
  delim()
end LazyListDemo3

object LazyListDemo4 /* extends App */:

  val as = LazyList(1, 2, 3, 4, 5)

  label("takeWhile(_ < 4) via FoldRight")
  println(as.takeWhileViaFoldRight(_ < 4).toList)
  delim()

  label("headOption via FoldRight")
  println(as.headOptionViaFoldRight)
  println(Empty.headOptionViaFoldRight)
  delim()

  label("map(_ + 100) via FoldRight")
  println(as.map(_ + 100).toList)
  delim()

  label("filter(_ % 2 == 0) via FoldRight")
  println(as.filter(_ % 2 == 0).toList)
  delim()

  label("append via FoldRight")
  println(as.append(LazyList(101, 102, 103)).toList)
  delim()

  label("flatMap via FoldRight")
  println(as.flatMap(i => LazyList(i, i + 100)).toList)
  delim()

  label("find")
  println(LazyList((1 to 100_000)*).find(_ % 7 == 0))
  delim()

end LazyListDemo4

object LazyListDemo5 /* extends App */:

  delim()
  label("ones")
  println(ones.take(10).toList)
  delim()

  label("continually")
  println(continually(5).take(10).toList)
  delim()

  label("from(5)")
  println(from(5).take(10).toList)
  delim()

  label("fibs")
  println(fibs.take(20).toList)
  delim()

end LazyListDemo5

object LazyListDemo6 /* extends App */:

  delim()
  label("unfold(0)(s => Some(s, s + 1))")
  println(unfold(0)(s => Some(s, s + 1)).take(10).toList)
  delim()

  label("from via unfold")
  println(fromViaUnfold(5).take(10).toList)
  delim()

  label("continually via unfold")
  println(continuallyViaUnfold(5).take(10).toList)
  delim()

  label("ones via unfold")
  println(onesViaUnfold.take(20).toList)
  delim()

  label("fibs via unfold")
  println(fibsViaUnfold.take(20).toList)
  delim()

end LazyListDemo6

object LazyListDemo7 /* extends App */:

  val as = LazyList(1, 2, 3, 4, 5)

  delim()
  label("map via unfold")
  println(as.mapViaUnfold(_ + 100).toList)
  delim()

  label("take via unfold")
  println(as.takeViaUnfold(3).toList)
  delim()

  label("takeWhile via unfold")
  println(as.takeWhileViaUnfold(_ < 4).toList)
  delim()

  label("zipWith via unfold")
  println(as.zipWithViaUnfold(LazyList(10, 20, 30, 40))(_ + _).toList)
  delim()

  label("zipAll")
  println(as.zipAll(LazyList(10, 20, 30, 40)).toList)
  delim()

end LazyListDemo7

object LazyListDemo8 /* extends App */:

  val as = LazyList(1, 2, 3, 4, 5)

  delim()
  label("startsWith")
  println(as.startsWith(LazyList(1, 2, 3)))
  println(as.startsWith(LazyList(1, 3, 3)))
  println(as.startsWith(LazyList(1, 2, 3, 4, 5)))
  println(as.startsWith(LazyList(1, 2, 3, 4, 5, 6)))
  println(as.startsWith(LazyList(2, 3, 4)))
  delim()

  label("tails")
  println(as.tails.map(_.toList).toList)
  delim()

  label("hasSubsequence")
  println(as.hasSubsequence(LazyList(2, 3)))
  println(as.hasSubsequence(LazyList(2, 4)))
  delim()

  label("scanRight")
  println(as.scanRight(0)(_ + _).toList)
  delim()

end LazyListDemo8
