package com.example.slidingcards.domain

import javax.inject.Inject

class GetBankOptionsUseCase @Inject constructor() {

	operator fun invoke() = mapOf("bank1" to "State Bank Of India", "bank2" to "HDFC Bank")
}