package es.mobiledev.common.extensions

import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

fun Date?.isToday() =
    this?.let { date ->
        date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() == LocalDate.now()
    } ?: false
