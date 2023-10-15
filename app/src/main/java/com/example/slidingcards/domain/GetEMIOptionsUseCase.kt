package com.example.slidingcards.domain

import javax.inject.Inject

class GetEMIOptionsUseCase @Inject constructor() {

	operator fun invoke() = mapOf("emi1" to "EMI Option 1", "emi2" to "EMI Option 2")
}