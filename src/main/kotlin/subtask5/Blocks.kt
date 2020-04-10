package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any? {

        return when (blockB) {
            Int :: class -> {

                var totalSum = 0
                for(item in blockA) {
                    if (item is Int) {
                        totalSum += item.toInt()
                    }
                }
                totalSum

            }
            String :: class -> {

                val concatString: StringBuilder = StringBuilder()
                for (item in blockA) {
                    if (item is String) {
                        concatString.append(item)
                    }
                }
                concatString.toString()
            }
            LocalDate :: class -> {

                var dateIndex = -1
                for ((i, value) in blockA.withIndex()) {
                    if (value is LocalDate) {
                        if (dateIndex < 0) {
                            dateIndex = i
                        } else {
                            if (value > (blockA[i] as LocalDate)) {
                                dateIndex = i
                            }
                        }
                    }
                }

                if (dateIndex > 0) {
                    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
                    (blockA[dateIndex] as LocalDate).format(formatter)
                } else {
                    null
                }
            }
        else -> {
                null
            }
        }
    }
}
