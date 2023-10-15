package com.example.slidingcards.presentation.state

data class CardViewModelState(
	val paymentAmount: String = "",
	val selectedEMIOption: String = "",
	val emiOptionsMap: Map<String, String> = emptyMap(),
	val selectedBank: String = "",
	val bankOptionsMap: Map<String, String> = emptyMap()
) {
	fun toUiState() = CardUIState(
		paymentAmount,
		selectedEMIOption,
		emiOptionsMap,
		selectedBank,
		bankOptionsMap
	)
}

data class CardUIState(
	val paymentAmount: String,
	val selectedEMIOption: String,
	val emiOptionsMap: Map<String, String>,
	val selectedBank: String,
	val bankOptionsMap: Map<String, String>
)