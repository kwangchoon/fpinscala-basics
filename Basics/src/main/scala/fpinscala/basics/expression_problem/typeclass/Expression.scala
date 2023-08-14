package fpinscala.basics.expression_problem.typeclass3

import fpinscala.utils.*

object Expression:
  case class Literal(value: Double)
  case class Add[A, B](lhs: A, rhs: B)

  trait Stringify[A]:
    def stringify(a: A): String

  given literalStringify: Stringify[Literal] with
    def stringify(a: Literal): String = a.value.toString

  given addStingify[A, B](using
      s1: Stringify[A],
      s2: Stringify[B]
  ): Stringify[Add[A, B]] with
    def stringify(expr: Add[A, B]): String =
      "(" + s1.stringify(expr.lhs) + " + " + s2.stringify(expr.rhs) + ")"

end Expression

object EvaluationOP:
  import Expression.{given, *}

  trait Eval[A]:
    def eval(a: A): Double

  given literalEval: Eval[Literal] with
    def eval(a: Literal): Double = a.value

  given addEval[A, B](using e1: Eval[A], e2: Eval[B]): Eval[Add[A, B]] = new:
    def eval(expr: Add[A, B]): Double =
      e1.eval(expr.lhs) + e2.eval(expr.rhs)

end EvaluationOP

object MulType:
  import Expression.{given, *}, EvaluationOP.{given, *}

  case class Mul[A, B](lhs: A, rhs: B)

  given mulStringify[A, B](using
      s1: Stringify[A],
      s2: Stringify[B]
  ): Stringify[Mul[A, B]] with
    def stringify(expr: Mul[A, B]): String =
      "(" + s1.stringify(expr.lhs) + " * " + s2.stringify(expr.rhs) + ")"

  given mulEval[A, B](using
      e1: Eval[A],
      e2: Eval[B]
  ): Eval[Mul[A, B]] = new:
    def eval(expr: Mul[A, B]): Double =
      e1.eval(expr.lhs) * e2.eval(expr.rhs)

end MulType

object ExprDemo /* extends App */:
  import Expression.{given, *}, EvaluationOP.{given, *}, MulType.{given, *}

  def printExpressions[A](expr: A)(using p: Stringify[A]) = {
    p.stringify(expr)
  }

  def expressionEvaluator[A](expr: A)(using e: Eval[A]) = {
    e.eval(expr)
  }

  delim()
  // (3 + 4) * 7
  val expr = Mul(Add(Literal(3), Literal(4)), Literal(7))
  println(printExpressions(expr))
  println(expressionEvaluator(expr))

  delim()

  // TODO
  // (3 * 4) + 7
  val expr2 = Add(Mul(Literal(3), Literal(4)), Literal(7))

  val as = List(expr, expr2)
  // as.foreach { a =>
  //   println(printExpressions(a))
  //   println(expressionEvaluator(a))
  // }

end ExprDemo
