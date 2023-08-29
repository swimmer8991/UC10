package com.vs.uc10

fun getPattern(maxLength: Int): Regex {
    val maxL = maxLength.coerceAtLeast(0)

    val acceptableRange = ".{0,$maxL}"
    val atLeastOneUpperCaseLetter = "(?=.*[A-Z])"
    val atLeastOneLowerCaseLetter = "(?=.*[a-z])"
    val atLeastOneDigit = "(?=.*[0-9])"
    val specialCharacters = "!\"#\\$%&'\\(\\)\\*\\+,-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~"
    val atLeastOneSpecialCharacter = "(?=.*[$specialCharacters])"
    val notContainAnyWhitespaceCharacters = "(?=\\S+$)"

    return Regex(
        "^" +
                atLeastOneUpperCaseLetter +
                atLeastOneLowerCaseLetter +
                atLeastOneDigit +
                atLeastOneSpecialCharacter +
                notContainAnyWhitespaceCharacters +
                acceptableRange +
                "$"
    )
}


