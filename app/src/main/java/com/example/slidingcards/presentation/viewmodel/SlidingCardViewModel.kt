package com.example.slidingcards.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.slidingcards.domain.GetBankOptionsUseCase
import com.example.slidingcards.domain.GetDefaultEMIOptionUseCase
import com.example.slidingcards.domain.GetEMIOptionsUseCase
import com.example.slidingcards.domain.SavePaymentDetailsUseCase
import com.example.slidingcards.presentation.state.CardViewModelState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SlidingCardViewModel @Inject constructor(
	private val getBankOptionsUseCase: GetBankOptionsUseCase,
	private val emiOptionsUseCase: GetEMIOptionsUseCase,
	private val defaultEMIOptionUseCase: GetDefaultEMIOptionUseCase,
	private val savePaymentDetailsUseCase: SavePaymentDetailsUseCase,
) : ViewModel() {
	private val viewModelState = MutableStateFlow(CardViewModelState())
	val uiState = viewModelState.map { it.toUiState() }
		.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), viewModelState.value.toUiState())

	fun setPaymentAmount(amount: String) =
		viewModelState.update { it.copy(paymentAmount = amount.filter { it.isDigit() }) }

	fun loadEMIOptions() = viewModelState.update {
		val emiOptions = emiOptionsUseCase()
		it.copy(
			emiOptionsMap = emiOptions,
			selectedEMIOption = defaultEMIOptionUseCase(emiOptions)
		)
	}

	fun onEMISelectionChanged(key: String) =
		viewModelState.update { it.copy(selectedEMIOption = key) }

	fun loadBankOptions() = viewModelState.update {
		it.copy(bankOptionsMap = getBankOptionsUseCase())
	}

	fun onBankSelectionChanged(key: String) = viewModelState.update { it.copy(selectedBank = key) }

	fun save() {
		if (savePaymentDetailsUseCase(
				viewModelState.value.selectedBank,
				viewModelState.value.paymentAmount,
				viewModelState.value.selectedEMIOption
			)
		) {
			viewModelState.value = CardViewModelState()
		} else {
			//Error saving data
		}
	}

}