package com.example.slidingcards.presentation.ui.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.slidingcards.R
import com.example.slidingcards.presentation.ui.theme.Color151B23
import com.example.slidingcards.presentation.ui.theme.Color2A316F
import com.example.slidingcards.presentation.ui.theme.Color3E3138
import com.example.slidingcards.presentation.ui.theme.text20Sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentBottomSheet(
	paymentAmount: String,
	setPaymentAmount: (String) -> Unit,
	emiOptions: Map<String, String>,
	selectedEMIOption: String,
	onEMISelectionChanged: (String) -> Unit,
	loadEMIOptions: () -> Unit,
	allBanks: Map<String, String>,
	selectedBank: String,
	onBankSelectionChanged: (String) -> Unit,
	loadBankOptions: () -> Unit,
	onFinish: () -> Unit,
	onDismiss: () -> Unit,
) {
	Column(Modifier.fillMaxSize()) {
		ModalBottomSheet(
			sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
			onDismissRequest = onDismiss,
			dragHandle = null
		) {
			Column(
				Modifier
					.fillMaxWidth()
					.background(Color151B23)
					.fillMaxHeight(.9f)
			) {
				Column(
					Modifier
						.padding(32.dp)
						.weight(1f)
				) {
					TitleSubtitleView(R.string.select_payment_amount, R.string.select_any_amount)
					NumericKeyboard(paymentAmount, setPaymentAmount)
				}

				SlidingBottomSheetCard(
					enabled = paymentAmount.isNotBlank(),
					cardIndex = 2,
					cardColor = Color2A316F,
					onOpen = loadEMIOptions,
					cardHeader = {
						Text(
							text = stringResource(id = if (paymentAmount.isNotBlank()) R.string.select_your_payment_method else R.string.enter_amount_to_proceed),
							style = text20Sp()
						)
					},
				) {
					Column(
						Modifier
							.padding(32.dp)
							.weight(1f)
					) {
						TitleSubtitleView(R.string.choose_emi_option, R.string.select_emi_option)
						VerticalRadioButtonView(
							emiOptions,
							selectedEMIOption,
							onEMISelectionChanged
						)
					}
					SlidingBottomSheetCard(
						enabled = selectedEMIOption.isNotBlank(),
						cardIndex = 3,
						cardColor = Color3E3138,
						onOpen = loadBankOptions,
						cardHeader = {
							Text(
								text = stringResource(id = R.string.select_your_bank_account),
								style = text20Sp()
							)
						},
						content = {
							Column(
								Modifier
									.padding(32.dp)
									.weight(1f)
							) {
								TitleSubtitleView(
									R.string.select_your_bank_account,
									R.string.select_bank
								)
								VerticalRadioButtonView(
									allBanks,
									selectedBank,
									onBankSelectionChanged
								)
							}
							AnimatedVisibility(visible = selectedBank.isNotBlank()) {
								Button(
									onClick = onFinish,
									modifier = Modifier
										.fillMaxWidth()
										.padding(32.dp)
								) {
									Text(stringResource(id = R.string.finish))
								}
							}
						})
				}
			}
		}
	}
}


