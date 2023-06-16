fun getChildHealthStatus(gender: String, age: Int, height: Int, weight: Int): String {
    val maleStuntingHeights = listOf(72, 82, 83, 84, 85)
    val femaleStuntingHeights = listOf(70, 80, 82, 83, 84)
    val maleWeightRanges = listOf(Pair(9, 15), Pair(10, 15), Pair(13, 16), Pair(15, 17), Pair(16, 19))
    val femaleWeightRanges = listOf(Pair(8, 12), Pair(10, 13), Pair(12, 15), Pair(14, 17), Pair(16, 18))

    val genderChoices = if (gender in listOf("male", "m")) listOf("male", "m") else listOf("female", "f")

    return when {
        age in 1..5 -> {
            val ageIndex = age - 1
            val stuntingHeight = if ("male" in genderChoices) maleStuntingHeights[ageIndex] else femaleStuntingHeights[ageIndex]
            val weightRange = if ("male" in genderChoices) maleWeightRanges[ageIndex] else femaleWeightRanges[ageIndex]
            
            when {
                height < stuntingHeight -> "Stunting"
                weight < weightRange.first -> "Underweight"
                weight > weightRange.second -> "Overweight"
                else -> "Normal"
            }
        }
        else -> "Data Invalid"
    }
}