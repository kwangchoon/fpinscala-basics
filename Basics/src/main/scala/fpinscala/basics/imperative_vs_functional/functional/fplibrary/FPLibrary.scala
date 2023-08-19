package fpinscala.basics
package imperative_vs_functional.functional
package fplibrary

// Minimal IO monad. DO NOT USE IN PRODUCTION!
trait IO[A] { self =>
  def unsafeRun: A

  def map[B](f: A => B): IO[B] =
    flatMap(a => IO.pure(f(a)))

  def flatMap[B](f: A => IO[B]): IO[B] = new IO[B] {
    def unsafeRun: B = f(self.unsafeRun).unsafeRun
  }
}

object IO {
  def apply[A](a: => A): IO[A] = new IO[A] {
    def unsafeRun: A = a
  }

  def pure[A](a: => A): IO[A] = apply(a)
}
