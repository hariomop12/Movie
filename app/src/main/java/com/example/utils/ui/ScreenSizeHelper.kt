package com.example.utils.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class ScreenSize {
    SMALL,
    NORMAL,
    LARGE,
    XLARGE
}

@Composable
fun getScreenSize(): ScreenSize {
    val configuration = LocalConfiguration.current
    val screenWithDp = configuration.screenWidthDp.dp

    return when {
        screenWithDp < 600.dp -> ScreenSize.SMALL
        screenWithDp < 840.dp -> ScreenSize.NORMAL
        screenWithDp < 1280.dp -> ScreenSize.LARGE
        else -> ScreenSize.XLARGE
    }

}

@Composable
fun getScreenWidth(): Dp {
    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp.dp
}

@Composable
fun getScreenHeight(): Dp {
    val configuration = LocalConfiguration.current
    return configuration.screenHeightDp.dp
}