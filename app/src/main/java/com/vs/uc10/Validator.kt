package com.vs.uc10

/**
 * The regular expression validate:
 * 1) the maximum string length (passed as parameter)
 * 2) that the string does not contain any whitespace characters (spaces, tabs, or newlines).
 * This regular expression also validate that the string contains at least one:
 * 3) one uppercase letter,
 * 4) one lowercase letter,
 * 5) one digit,
 * 6) one special character from a predefined list: !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
 *
 *
 * @param maxLength - max length for the acceptable string range
 * @return [Regex] that match if the criteria are met and a non-match if they are not.
 */
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


