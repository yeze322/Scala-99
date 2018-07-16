// Find the last but one (penultimate) element of a list.
//  1. List(1,2,3) -> 2
//  2. List() -> NoSuchElementException

object Penultimate {
  // Use the builtin api.
  //  init : Selects all elements except the last
  def penultimateBuiltin[A](ls: List[A]): A = {
    ls.init.last
  }

  // Use pattern matching
  def penultimateRecursive[A](ls: List[A]): A =
    ls match {
      case h :: _ :: Nil  => h
      case _ :: tail      => penultimateRecursive(tail)
      case _              => throw new NoSuchElementException
    }
}


// ---------------------------------------------------------
// Test
var ls = List(1,2,3,4,5,6,7,8)

assert(Penultimate.penultimateBuiltin(ls) == 7)
assert(Penultimate.penultimateRecursive(ls) == 7)


// Benchmark
import timer.benchmark

var MAX_N = 9999
benchmark.MeasureTime("Penultimate (builtin)", MAX_N, () => Penultimate.penultimateBuiltin(ls))
benchmark.MeasureTime("Penultimate (patter matching)", MAX_N, () => Penultimate.penultimateRecursive(ls))
