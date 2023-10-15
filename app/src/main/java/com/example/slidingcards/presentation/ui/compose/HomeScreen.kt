package com.example.slidingcards.presentation.ui.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.slidingcards.R
import com.example.slidingcards.presentation.ui.theme.SlidingCardsTheme

@Preview
@Composable
fun HomeScreenPreview() = SlidingCardsTheme {
	HomeScreen(
		showPaymentSheet = remember { mutableStateOf(false) },
		paymentAmount = "",
		setPaymentAmount = {},
		emiOptions = emptyMap(),
		selectedEMIOption = "",
		onEMISelectionChanged = {},
		loadBankOptions = {},
		allBanks = emptyMap(),
		selectedBank = "",
		onBankSelectionChanged = {},
		loadEMIOptions = {},
		onFinish = {}
	)
}

@Composable
fun HomeScreen(
	showPaymentSheet: MutableState<Boolean>,
	paymentAmount: String,
	setPaymentAmount: (String) -> Unit,
	emiOptions: Map<String, String>,
	selectedEMIOption: String,
	onEMISelectionChanged: ((String) -> Unit),
	loadEMIOptions: () -> Unit,
	allBanks: Map<String, String>,
	selectedBank: String,
	onBankSelectionChanged: (String) -> Unit,
	loadBankOptions: () -> Unit,
	onFinish: () -> Unit,
) {
	Column(
		modifier = Modifier.fillMaxSize(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center,
	) {
		Button(onClick = {
			showPaymentSheet.value = true
		}) {
			Text(text = stringResource(id = if (showPaymentSheet.value) R.string.close else R.string.start_flow))
		}

		AnimatedVisibility(showPaymentSheet.value) {
			PaymentBottomSheet(
				paymentAmount,
				setPaymentAmount,
				emiOptions,
				selectedEMIOption,
				onEMISelectionChanged,
				loadEMIOptions,
				allBanks,
				selectedBank,
				onBankSelectionChanged,
				loadBankOptions,
				onFinish
			) { showPaymentSheet.value = false }
		}
	}
}