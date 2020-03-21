package subtask2

class MiniMaxSum {

    // TODO: Complete the following function
    fun getResult(input: IntArray): IntArray {
        var sumMin: Int = 10000
        var sumMax: Int = 0
        var sumCheck: Int = 0
        var reserveArray = IntArray(input.size)
        var reserveArray2 = input
        for (i in 1..input.size) {
            for (exem in reserveArray2.indices) {
                if (exem != reserveArray2.lastIndex) {
                    sumCheck += reserveArray2[exem]
                    reserveArray[exem + 1] = reserveArray2[exem]
                } else {
                    sumMax = Math.max(sumMax, sumCheck)
                    sumMin = Math.min(sumMin, sumCheck)
                    sumCheck = 0
                    reserveArray[0] = reserveArray2[exem]
                }
            }
            reserveArray2 = reserveArray.clone()
        }
        val result = intArrayOf(sumMin, sumMax)
        return result
    }
}
