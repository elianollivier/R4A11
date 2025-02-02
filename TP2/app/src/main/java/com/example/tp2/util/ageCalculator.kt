package com.example.tp2

import java.time.Year

object AgeCalculator {
    fun calculateAge(birthYear: Int): Int {
        val currentYear = Year.now().value
        return currentYear - birthYear
    }
}
