package subtask1

class HappyArray {
    private var index: Int = 0

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        var happyArray = sadArray
        for (i in 1..3) {
            happyArray = solution(happyArray)
        }
        return happyArray
    }

    fun solution(sadArray: IntArray): IntArray {
        val happyArray = IntArray(sadArray.size)
        for (elem in sadArray.indices) {
            if (elem == sadArray.indices.last) {
                happyArray[index] = sadArray[elem]
                index = 0
                break
            }
            if (elem == 0) {
                happyArray[index] = sadArray[elem]
                index++
                continue
            }
            if (sadArray[elem] < sadArray[elem - 1] + sadArray[elem + 1]) {
                happyArray[index] = sadArray[elem]
                index++
            }
        }
        val happyArray2: List<Int> = happyArray.filter { it != 0 }
        return happyArray2.toIntArray()
    }
}