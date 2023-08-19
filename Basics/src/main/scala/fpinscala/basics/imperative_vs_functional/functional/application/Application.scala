package fpinscala.basics
package imperative_vs_functional.functional
package application

import fpinscala.basics.imperative_vs_functional.functional.fplibrary.*

def putStrLn(line: String): IO[Unit] = IO(println(line))
def getStrLn: IO[String]             = IO(scala.io.StdIn.readLine())

def getDescription(): IO[Unit] =
  for {
    _    <- putStrLn("Good morning, what is your name?")
    name <- getStrLn
    _    <- putStrLn(s"Nice to meet you, $name!")
  } yield ()
