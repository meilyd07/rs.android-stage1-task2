package subtask6

class Fibonacci {

    // TODO: Complete the following function
    fun productFibonacciSequenceFor(n: Int): IntArray {
        val fibonacciArray = mutableListOf<Int>()
        for (i in 0 until n) {
            fibonacciArray.add(getFibonacci(i))
        }

        var j = 1
        val count = fibonacciArray.count() - 1;
        var resultIndex = -1;

        while (j < count) {
            val previousMultiply = fibonacciArray[j-1] * fibonacciArray[j]
            if (previousMultiply <= n) {
                resultIndex = j - 1
                if (previousMultiply == n) {
                    break
                }
            } else {
                resultIndex = j - 1
                break
            }
            j++
        }

        if (resultIndex > 0) {
            val multiplyProduct = fibonacciArray[resultIndex] * fibonacciArray[resultIndex + 1]
            return intArrayOf(fibonacciArray[resultIndex], fibonacciArray[resultIndex + 1], if (multiplyProduct == n) 1 else 0)
        } else {
            return intArrayOf()
        }
    }

    private fun getFibonacci(number: Int): Int {
        var a = 0
        var b = 1

        var i = 0
        while (i < number) {
            val tempValue = a
            a = b
            b += tempValue
            i++
        }
        return a
    }
}
