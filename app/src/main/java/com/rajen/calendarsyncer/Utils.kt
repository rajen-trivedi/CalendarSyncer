package com.rajen.calendarsyncer

import java.text.DateFormatSymbols
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val YMDTHMSFormat = "yyyy-MM-dd'T'HH:mm:ss"
private const val HMADateFormat = "h:mm a"

object Utils {

    fun time12HrFormatForCalendar(date: String, isNextLine: Boolean = false): String {
        return try {
            if (date.isEmpty()) {
                ""
            } else {
                val sdf = SimpleDateFormat(YMDTHMSFormat, Locale.getDefault())
                val customSymbols = DateFormatSymbols(Locale.getDefault()).apply {
                    amPmStrings = arrayOf("am", "pm")
                }
                val output = SimpleDateFormat(
                    if (isNextLine) "h:mm\na" else HMADateFormat,
                    Locale.getDefault()
                )
                output.dateFormatSymbols = customSymbols
                val parsedDate = sdf.parse(date)
                parsedDate?.let { output.format(it) } ?: ""
            }
        } catch (e: ParseException) {
            ""
        } catch (e: Exception) {
            ""
        }
    }

    fun getOnlyDate(date: String): String {
        if (date.isEmpty()) {
            return ""
        }
        return try {
            val inputFormat = SimpleDateFormat(YMDTHMSFormat, Locale.getDefault())
            val outputFormat = "dd"
            val output = SimpleDateFormat(outputFormat, Locale.getDefault())
            val parsedDate: Date? = inputFormat.parse(date)
            parsedDate?.let { output.format(it) } ?: ""
        } catch (e: Exception) {
            ""
        }
    }

    fun getOnlyDayName(date: String): String {
        if (date.isEmpty()) {
            return ""
        }
        return try {
            val inputFormat = SimpleDateFormat(YMDTHMSFormat, Locale.getDefault())
            val outputFormat =  "EE"
            val output = SimpleDateFormat(outputFormat, Locale.getDefault())
            val parsedDate: Date? = inputFormat.parse(date)
            parsedDate?.let { output.format(it) } ?: ""
        } catch (e: Exception) {
            ""
        }
    }
}