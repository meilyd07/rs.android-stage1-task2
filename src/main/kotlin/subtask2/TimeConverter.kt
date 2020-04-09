package subtask2

class TimeConverter {

    // TODO: Complete the following function
    fun toTextFormat(hour: String, minute: String): String {
        if ((hour.length <= 2) &&
            (hour.isNotEmpty()) &&
            (minute.length <= 2) &&
            (minute.isNotEmpty())) {

            if ((hour.matches("[0-9]+".toRegex())) && (minute.matches("[0-9]+".toRegex()))) {
                val integerHourValue = hour.toInt()
                val integerMinuteValue = minute.toInt()

                //check rules
                //At minutes = 0, use o' clock. For 1 <= minutes <= 30, use past, and for 30 < minutes use to.
                if ((integerHourValue == 0) || (integerHourValue >= 24)) {
                    return "";
                }

                if (integerMinuteValue == 0) {
                    val hourUnits = integerHourValue % 10
                    val hourTens = integerHourValue / 10
                    tensNumberAndUnitToWord(hourTens, hourUnits)
                    return "${tensNumberAndUnitToWord(hourTens, hourUnits)} o' clock"
                } else {
                    if ((integerMinuteValue >= 1) && (integerMinuteValue <= 30)) {

                        val minuteUnits = integerMinuteValue % 10
                        val minuteTens = integerMinuteValue / 10
                        val hourUnits = integerHourValue % 10
                        val hourTens = integerHourValue / 10
                        return "${resultMinutesLabeledToWord(minuteTens, minuteUnits)} past ${tensNumberAndUnitToWord(hourTens, hourUnits)}"
                    } else if ((integerMinuteValue > 30) && (integerMinuteValue <= 59)) {

                        val nextHourValue = integerHourValue + 1;
                        val hourUnits = nextHourValue % 10;
                        val hourTens = nextHourValue / 10;

                        val lastMinutesValue = 60 - integerMinuteValue;
                        val minuteUnits = lastMinutesValue % 10;
                        val minuteTens = lastMinutesValue / 10;

                        return "${resultMinutesLabeledToWord(minuteTens, minuteUnits)} to ${tensNumberAndUnitToWord(hourTens, hourUnits)}"
                    } else {
                        return ""
                    }
                }

            } else {
                return ""
            }
            return ""
        } else {
            return ""
        }
    }

    private fun resultMinutesLabeledToWord(tensNumber: Int, unitsNumber:Int): String {
        var resultMinutesLabeled: String = ""
        val minutesText = tensNumberAndUnitToWord(tensNumber, unitsNumber)
        resultMinutesLabeled = when (minutesText) {
            "one" -> {
                "one minute"
            }
            "fifteen" -> {
                "quarter"
            }
            "thirty" -> {
                "half"
            }
            else -> {
                "$minutesText minutes"
            }
        }
        return resultMinutesLabeled
    }

    private fun tensNumberAndUnitToWord(tensNumber: Int, unitsNumber: Int):String {
        return if (tensNumber == 0) {
            unitsNumberToWord(unitsNumber)
        } else if (tensNumber == 1) {
            val tensArray = arrayOf("ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
            tensArray[unitsNumber]
        } else if ((tensNumber >= 2) && (tensNumber < 6)) {
            val listTensArray = arrayOf("twenty", "thirty", "forty", "fifty")
            if (unitsNumber == 0) listTensArray[tensNumber - 2] else "${listTensArray[tensNumber - 2]} ${unitsNumberToWord(unitsNumber)}"

        } else {
            ""
        }
    }

    private fun unitsNumberToWord(number:Int): String {
        val array = arrayOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        return if ((number >= 0) && (number < 10)) array[number] else ""
    }
}
