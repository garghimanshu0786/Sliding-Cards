package com.example.slidingcards.domain

import javax.inject.Inject

class SavePaymentDetailsUseCase @Inject constructor() {

	operator fun invoke(
		selectedBank: String,
		paymentAmount: String,
		selectedEMIOption: String
	): Boolean {
		// Save data to server
		return true
	}
}