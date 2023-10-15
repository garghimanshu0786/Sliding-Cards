package com.example.slidingcards.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.slidingcards.R
import com.example.slidingcards.presentation.ui.compose.HomeScreen
import com.example.slidingcards.presentation.ui.theme.SlidingCardsTheme
import com.example.slidingcards.presentation.utils.showToast
import com.example.slidingcards.presentation.viewmodel.SlidingCardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			SlidingCardsTheme {
				val viewModel: SlidingCardViewModel = hiltViewModel()

				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					val uiState by viewModel.uiState.collectAsStateWithLifecycle()
					val showPaymentSheet = remember { mutableStateOf(false) }

					HomeScreen(
						showPaymentSheet = showPaymentSheet,
						paymentAmount = uiState.paymentAmount,
						setPaymentAmount = viewModel::setPaymentAmount,
						selectedEMIOption = uiState.selectedEMIOption,
						emiOptions = uiState.emiOptionsMap,
						onEMISelectionChanged = viewModel::onEMISelectionChanged,
						loadEMIOptions = viewModel::loadEMIOptions,
						allBanks = uiState.bankOptionsMap,
						loadBankOptions = viewModel::loadBankOptions,
						onBankSelectionChanged = viewModel::onBankSelectionChanged,
						selectedBank = uiState.selectedBank,
						onFinish = {
							viewModel.save()
							showPaymentSheet.value = false
							showToast(getString(R.string.successfully_submitted))
						}
					)
				}
			}
		}
	}
}


