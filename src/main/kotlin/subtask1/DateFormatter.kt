package subtask1

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.ResolverStyle
import java.util.*

class DateFormatter {

    // TODO: Complete the following function
    fun toTextDay(day: String, month: String, year: String): String {

        val inputString = "$day.$month.$year"
        var strToDateFormatter = DateTimeFormatter.ofPattern("d.M.uuuu").withResolverStyle(
            ResolverStyle.STRICT)

        return try {
            var date = LocalDate.parse(inputString, strToDateFormatter)
            var toStringFormatter = DateTimeFormatter.ofPattern("d MMMM, EEEE", Locale("ru"))
            var formattedDate = date.format(toStringFormatter)
            formattedDate
        } catch (e: Exception) {
            "Такого дня не существует";
        }


    }
}
