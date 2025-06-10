package com.mbarker99.notemark.core.presentation.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mbarker99.notemark.R

val Inter = FontFamily(
    Font(
        resId = R.font.inter_medium,
        weight = FontWeight.Medium
    ),
    Font(
        resId = R.font.inter_regular,
        weight = FontWeight.Normal
    )
)

val SpaceGrotesk = FontFamily(
    Font(
        resId = R.font.spacegrotesk_bold,
        weight = FontWeight.Bold
    ),
    Font(
        resId = R.font.spacegrotesk_medium,
        weight = FontWeight.Medium
    )
)

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = SpaceGrotesk,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        lineHeight = 40.sp,
        color = OnSurface
    ),
    titleMedium = TextStyle(
        fontFamily = SpaceGrotesk,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 36.sp,
        color = OnSurface
    ),
    titleSmall = TextStyle(
        fontFamily = SpaceGrotesk,
        fontWeight = FontWeight.Medium,
        fontSize = 17.sp,
        lineHeight = 24.sp,
        color = OnSurface
    ),
    bodyLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        lineHeight = 24.sp,
        color = OnSurface
    ),
    bodyMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = 20.sp,
        color = OnSurface
    ),
    bodySmall = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 20.sp,
        color = OnSurface
    )
)