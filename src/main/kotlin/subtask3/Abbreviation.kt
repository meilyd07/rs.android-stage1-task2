package subtask3

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        val uppercaseA = a.toUpperCase()
        val bSet = b.toMutableList()
        val aSet = uppercaseA.toMutableList()

        val intersectedA = aSet.intersect(bSet).toMutableList()

        return if (intersectedA == bSet) {
            "YES"
        } else {
            "NO"
        }
    }
}
