package timer

package object benchmark {
  def MeasureTime(taskName: String, repeatTimes: Int, fn: () => Any): Long = {
    var startTime = System.currentTimeMillis()
    fn()
    for (i <- 1 to repeatTimes) {
      fn()
    }
    var endTime = System.currentTimeMillis()
    println(taskName, endTime - startTime)
    endTime - startTime
  }
}


