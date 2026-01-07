package es.mobiledev.commonandroid.util

import java.time.Instant

fun getCurrentEpochMilli(): Long = Instant.now().toEpochMilli()
