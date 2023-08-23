package com.example.concurrency.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val lightBackground = Color(0xFFFFFFFF)

val TextColorWhite = Color(0xFFFFFFFF)

// Card Colors
val CardBackground = Color(0xFFFFFFFF)
val CardComponentBackground = Color(0xFFE7E6E6)
val CardBorderColor = Color(0xFFC5C5C5)
val CardTextColor = Color(0xFF000000)
val CardButtonBackground = Color(0xFF363636)









fun mixColors(color1: Color, color2: Color, weight: Float): Color {
    val r = (color1.red * weight) + (color2.red * (1 - weight))
    val g = (color1.green * weight) + (color2.green * (1 - weight))
    val b = (color1.blue * weight) + (color2.blue * (1 - weight))
    val a = (color1.alpha * weight) + (color2.alpha * (1 - weight))
    return Color(r, g, b, a)
}