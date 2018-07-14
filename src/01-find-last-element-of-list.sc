// Find the last element of a list
//  1. last([1,2,3]) => 3
//  2. last([]) => Null

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


// Test
var numbers = List(1, 2, 3, 4, 5, 6, 7, 8)

assert(Last.lastBuiltin(numbers) == 8)
assert(Last.lastRecursive(numbers) == 8)


// Benchmark
var MAX_N = 99999

var t1 = System.nanoTime()
for (i <- 1 to MAX_N) {
  Last.lastBuiltin(numbers)
  Last.lastBuiltin(numbers)
  Last.lastBuiltin(numbers)
}
var builtinTime = System.nanoTime() - t1

var t2 = System.nanoTime()
for (i <- 1 to MAX_N) {
  Last.lastRecursive(numbers)
  Last.lastBuiltin(numbers)
  Last.lastBuiltin(numbers)
}
var recTime = System.nanoTime() - t2

println("Ratio (recursive / builtin)", recTime.toFloat/builtinTime.toFloat)
