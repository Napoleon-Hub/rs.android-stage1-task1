package subtask3

class BillCounter {

    private var fairlySplit = "Bon Appetit"
    private var sumOfMoney : Double = 0.0

    // TODO: Complete the following function
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        for (elem in bill.indices) {
            if(elem != k){
                sumOfMoney += bill[elem]
            } else continue
        }
        return if((sumOfMoney/2).toInt() == b) fairlySplit
        else {
            fairlySplit = (b - (sumOfMoney/2).toInt()).toString()
            fairlySplit
        }
    }
}
