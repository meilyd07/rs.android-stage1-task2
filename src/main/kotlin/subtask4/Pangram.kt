package subtask4

class Pangram {

    // TODO: Complete the following function
    fun getResult(inputString: String): String {
        val fixed = inputString.replace("\\s+".toRegex(), " ")
        val vowelsSets = setOf('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y')
        val consonantsSet = setOf('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't',
            'v', 'x', 'z', 'w', 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q',
            'R', 'S', 'T', 'V', 'X', 'Z', 'W')
        if (isPangram(fixed)) {
            return sortWordsInString(fixed, vowelsSets)
        } else {
            return sortWordsInString(fixed, consonantsSet)
        }
    }

    private fun sortWordsInString(string: String, sortSet: Set<Char>):String {
        val pairs = mutableListOf<Pair<Int, String>>()
        val words = string.split(" ")

        for (strItem in words) {
            if (strItem.trimIndent().isNotEmpty()) {
                val pair = countAndCapitalizeCharactersInSet(sortSet, strItem)
                pairs.add(pair)
            }
        }

        val positionComparator = compareBy<Pair<Int, String>> {it.first}
        val sortedList = pairs.sortedWith(positionComparator)
        val listOfStrings = sortedList.map { it.second }
        return listOfStrings.joinToString(separator = " ") { it }
    }

    private fun countAndCapitalizeCharactersInSet(inputSet: Set<Char>, word: String): Pair<Int, String> {
        val characters = mutableListOf<Char>()
        var count = 0
        for (i in word.indices) {
            val ichar = word[i]
            if (inputSet.contains(ichar)) {
                count++
                characters.add(ichar.toUpperCase())
            } else {
                characters.add(ichar)
            }
        }

        val resultWord = "$count${characters.joinToString("")}"

        return Pair(count, resultWord)
    }

    private fun isPangram(string: String) : Boolean {
        val resultString = string.toLowerCase().replace("""[^a-z]""".toRegex(), "")

        val newSet = resultString.toSet()
        return (newSet.size == 26)
    }

}
