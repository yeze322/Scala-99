// Find the last element of a list
//  1. last([1,2,3]) => 3
//  2. last([]) => NoSuchElementException

object Last {
  // Using builtin property of List type.
  def lastBuiltin[T](ls: List[T]): T = ls.last

  // Using pattern matching.
  def lastRecursive[T](ls: List[T]): T =
    ls match {
      case x :: Nil   => x
      case _ :: tail  => lastRecursive(tail)
      case _          => throw new NoSuchElementException
    }
}


// ---------------------------------------------------------
// Test
var numbers = List(1, 2, 3, 4, 5, 6, 7, 8)

assert(Last.lastBuiltin(numbers) == 8)
assert(Last.lastRecursive(numbers) == 8)


// Benchmark
import timer.benchmark

var MAX_N = 99999

benchmark.MeasureTime("last(Builtin)", MAX_N, () => Last.lastBuiltin(numbers))
benchmark.MeasureTime("last(Pattern matching)", MAX_N, () => Last.lastRecursive(numbers))
