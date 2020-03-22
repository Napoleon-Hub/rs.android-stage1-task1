package subtask4

import java.util.*
import java.util.stream.Collectors

class StringParser {
    private var reserveArray: Array<String> = Array(10) { "" }

    companion object {
        private var newWord: String = ""
    }

    private var counter: Int = 0
    private var index: Int = 0
    private var counterTheSameWords: Int = 0
    private var counterTheSameSigns: Int = 0

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        var newMass = reserveCounter(inputString)
        for (i in 1..2) {
            newMass = reserveCounter(Arrays.stream(newMass).collect(Collectors.joining()))
        }
        for (char in reserveArray[0]) {
            if (char != '>' && counterTheSameSigns == 1) {
                newWord += char
            } else if(char == '>') {
                counterTheSameSigns = 0
                reserveArray[index] = newWord
            }
            if (char == '<') {
                counterTheSameSigns = 1
            }
        }
        val happyArray: List<String> = reserveArray.filter { it != "" }
        return happyArray.toTypedArray()
    }

    private fun reserveCounter(inputString: String): Array<String> {
        for (char in inputString) {
            if (counter == 1) {
                if (char != '>') {
                    newWord += char
                } else {
                    if (counterTheSameSigns == 1) {
                        newWord += char
                        counterTheSameSigns--
                    } else {
                        for (numbers in reserveArray.indices) {
                            if (reserveArray[numbers] == newWord) break
                            if (reserveArray[numbers] != newWord && numbers == reserveArray.lastIndex)
                                counterTheSameWords = 1
                        }
                        if (counterTheSameWords == 1) {
                            reserveArray[index] = newWord
                            index++
                            counterTheSameWords = 0
                        }
                        newWord = ""
                        counter = 0
                    }
                }
                if (char == '<') counterTheSameSigns++
            }

            if (char == '<' && counter == 0) counter = 1

            if (counter == 2) {
                if (char != ')') {
                    newWord += char
                } else {
                    for (numbers in reserveArray.indices) {
                        if (reserveArray[numbers] == newWord) break
                        if (reserveArray[numbers] != newWord && numbers == reserveArray.lastIndex)
                            counterTheSameWords = 1
                    }
                    if (counterTheSameWords != 0) {
                        reserveArray[index] = newWord
                        index++
                    }
                    newWord = ""
                    counter = 0
                }
            }

            if (char == '(' && counter == 0) counter = 2

            if (counter == 3) {
                if (char != ']') {
                    newWord += char
                } else {
                    for (numbers in reserveArray.indices) {
                        if (reserveArray[numbers] == newWord) break
                        if (reserveArray[numbers] != newWord && numbers == reserveArray.lastIndex)
                            counterTheSameWords = 1
                    }
                    if (counterTheSameWords != 0) {
                        reserveArray[index] = newWord
                        index++
                    }
                    newWord = ""
                    counter = 0
                }
            }

            if (char == '[' && counter == 0) counter = 3
        }
        val happyArray: List<String> = reserveArray.filter { it != "" }
        counterTheSameWords = 0
        counterTheSameSigns = 0
        return happyArray.toTypedArray()
    }
}
