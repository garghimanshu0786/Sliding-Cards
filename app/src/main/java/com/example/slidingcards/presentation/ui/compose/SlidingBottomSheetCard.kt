package com.example.slidingcards.presentation.ui.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slidingcards.presentation.ui.theme.Color3E3138
import com.example.slidingcards.presentation.ui.theme.SlidingCardsTheme

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SlidingBottomSheetCardPreview() = SlidingCardsTheme {
	SlidingBottomSheetCard(
		enabled = true,
		cardIndex = 2,
		cardColor = Color3E3138,
		onOpen = {},
		cardHeader = {},
		content = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
		/*
		Card Index should be less than 10
		 */
fun SlidingBottomSheetCard(
	enabled: Boolean,
	cardIndex: Int,
	cardColor: Color,
	onOpen: () -> Unit,
	cardHeader: @Composable () -> Unit,
	content: @Composable () -> Unit
) {
	var show by remember { mutableStateOf(false) }
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.height(100.dp)
			.clip(RoundedCornerShape(32.dp, 32.dp, 0.dp, 0.dp))
			.background(cardColor)
			.then(if (enabled) Modifier.clickable {
				show = true
				onOpen()
			} else Modifier),
		contentAlignment = Alignment.Center
	) {
		cardHeader()
	}
	AnimatedVisibility(show) {
		ModalBottomSheet(
			sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
			onDismissRequest = { show = false },
			dragHandle = null
		) {
			Column(
				Modifier
					.fillMaxWidth()
					.background(cardColor)
					.fillMaxHeight((0.8 - 0.1 * (cardIndex - 2)).toFloat())
			) {
				content()
			}
		}
	}
}
