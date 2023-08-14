package fpinscala.datatypes

enum Either[+E, +A]:
  case Left(value: E)
  case Right(value: A)

  // Exercise 4.6
  // Implement versions of `map`, `flatMap`, `orElse`, and `map2` on Either that operate
  // on the Right value.
  def map[B](f: A => B): Either[E, B] = ???

  def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B] = ???

  def orElse[EE >: E, B >: A](f: => Either[EE, B]): Either[EE, B] = ???

  def map2[EE >: E, B, C](eb: Either[EE, B])(f: (A, B) => C): Either[EE, C] =
    ???

end Either

object Either:
  import scala.util.control.NonFatal
  import Either.*

  // Exercise 4.7
  // Implement `sequence` and `traverse` for Either. These should return the first
  // error that’s encountered, if there is one.
  def sequence[E, A](as: List[Either[E, A]]): Either[E, List[A]] = ???

  def traverse[E, A, B](as: List[A])(f: A => Either[E, B]): Either[E, List[B]] =
    ???

  def catchNonFatal[A](a: => A): Either[Throwable, A] =
    try Right(a)
    catch case NonFatal(t) => Left(t)

  def map2Both[E, A, B, C](
      a: Either[E, A],
      b: Either[E, B],
      f: (A, B) => C
  ): Either[List[E], C] =
    (a, b) match
      case (Right(aa), Right(bb)) => Right(f(aa, bb))
      case (Left(e), Right(_))    => Left(List(e))
      case (Right(_), Left(e))    => Left(List(e))
      case (Left(e1), Left(e2))   => Left(List(e1, e2))

  def map2All[E, A, B, C](
      a: Either[List[E], A],
      b: Either[List[E], B],
      f: (A, B) => C
  ): Either[List[E], C] =
    (a, b) match
      case (Right(aa), Right(bb)) => Right(f(aa, bb))
      case (Left(es), Right(_))   => Left(es)
      case (Right(_), Left(es))   => Left(es)
      case (Left(es1), Left(es2)) => Left(es1 ++ es2)

  def traverseAll[E, A, B](
      as: List[A]
  )(f: A => Either[List[E], B]): Either[List[E], List[B]] =
    as.foldRight(Right(Nil): Either[List[E], List[B]])((a, acc) =>
      map2All(f(a), acc, _ :: _)
    )

  def sequenceAll[E, A](
      as: List[Either[List[E], A]]
  ): Either[List[E], List[A]] =
    traverseAll(as)(identity)

end Either
