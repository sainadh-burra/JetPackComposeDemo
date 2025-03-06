package com.demo.composedemo1.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val LightColors = lightColorScheme(
    primary = Color(0xFF6200EE),
    onPrimary = Color.White,
    background = Color(0xFFF0F0F0),
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    primaryContainer = Color.Black,
    secondaryContainer = Color.Gray
)

val DarkColors = darkColorScheme(
    primary = Color(0xFFBB86FC),
    onPrimary = Color.Black,
    background = Color(0xFF121212),
    onBackground = Color.Black,
    surface = Color.Black,
    onSurface = Color.Black,
    primaryContainer = Color.White,
    secondaryContainer = Color.LightGray
)