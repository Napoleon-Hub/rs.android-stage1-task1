package subtask5

class HighestPalindrome {

    private var maxPol: Int = -1
    private var changeString: String = ""
    private var changeStringToInt: Int = 0

    // Fucking beautiful magic
    // TODO: Complete the following function
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        val charMass: CharArray = digitString.toCharArray()
        for (char in charMass.indices) {
            for (i: Char in '0'..'9') {
                val charMassReserve: CharArray = digitString.toCharArray()
                charMassReserve[char] = i
                if (k >= 2) {
                    if (char != charMass.lastIndex) {
                        for (f in (char + 1)..charMass.lastIndex) {
                            val saveChar = charMass[f]
                            for (y: Char in '0'..'9') {
                                charMassReserve[f] = y
                                if (k == 3) {
                                    if (char < charMass.lastIndex - 1) {
                                        for (p in (char + 2)..charMass.lastIndex) {
                                            val saveChar2 = charMass[p]
                                            for (u: Char in '0'..'9') {
                                                charMassReserve[p] = u
                                                if (isPalindrome(charMassReserve)) {
                                                    changeString = String(charMassReserve)
                                                    changeStringToInt = changeString.toInt()
                                                    maxPol =
                                                        maxPol.coerceAtLeast(changeStringToInt)
                                                }
                                                if (u == '9') {
                                                    charMassReserve[p] = saveChar2
                                                }
                                            }
                                        }
                                    }
                                } else if (isPalindrome(charMassReserve)) {
                                    changeString = String(charMassReserve)
                                    changeStringToInt = changeString.toInt()
                                    maxPol = maxPol.coerceAtLeast(changeStringToInt)
                                }
                                if (y == '9') {
                                    charMassReserve[f] = saveChar
                                }
                            }
                        }
                    }
                } else if (isPalindrome(charMassReserve)) {
                    changeString = String(charMassReserve)
                    changeStringToInt = changeString.toInt()
                    maxPol = maxPol.coerceAtLeast(changeStringToInt)
                }
            }
        }
        return maxPol.toString()
    }

    private fun isPalindrome(text: CharArray): Boolean {
        var forward = 0
        var backward = text.size - 1
        while (backward > forward) {
            val forwardChar: Char = text[forward++]
            val backwardChar: Char = text[backward--]
            if (forwardChar != backwardChar)
                return false
        }
        return true
    }
}
