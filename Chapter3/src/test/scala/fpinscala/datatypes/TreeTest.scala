package fpinscala.datatypes

import fpinscala.utils.*

import Tree.*

class TreeTest extends munit.FunSuite:

  test("size, depth, maximum, map".ignore) {
    val tree = Branch(
      Branch(Leaf(1), Leaf(2)),
      Branch(Leaf(3), Leaf(4))
    )

    delim()

    println(s"size = ${tree.size}")
    println(s"depth = ${tree.depth}")
    println(s"maximum = ${tree.maximum}")
    println(tree.map(_ + 1))
    delim()
  }

  test("size, depth, maximum, map via fold".ignore) {
    val tree = Branch(
      Branch(Leaf(1), Leaf(2)),
      Branch(Leaf(3), Leaf(4))
    )

    println(s"size = ${tree.sizeViaFold}")
    println(s"depth = ${tree.depthViaFold}")
    println(s"maximum = ${tree.maximumViaFold}")
    println(tree.mapViaFold(_ + 1))
    delim()
  }
