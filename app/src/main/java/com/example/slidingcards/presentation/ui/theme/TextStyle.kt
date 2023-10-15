package com.example.slidingcards.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp


@Composable
fun text12Sp(
	textColor: Color = Color.Gray,
	fontWeight: FontWeight = FontWeight.Normal,
	lineHeight: TextUnit = 12.sp
) = TextStyle(
	fontSize = 12.sp,
	lineHeight = lineHeight,
	fontWeight = fontWeight,
	color = textColor,
)


@Composable
fun text16Sp(
	textColor: Color = Color.Black,
	fontWeight: FontWeight = FontWeight.Normal,
	lineHeight: TextUnit = 16.sp
) = TextStyle(
	fontSize = 16.sp,
	lineHeight = lineHeight,
	fontWeight = fontWeight,
	color = textColor,
)


@Composable
fun text20Sp(
	textColor: Color = Color.LightGray,
	fontWeight: FontWeight = FontWeight.Normal,
	lineHeight: TextUnit = 20.sp
) = TextStyle(
	fontSize = 20.sp,
	lineHeight = lineHeight,
	fontWeight = fontWeight,
	color = textColor,
)
