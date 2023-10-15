package com.example.slidingcards.domain

import javax.inject.Inject

class GetDefaultEMIOptionUseCase @Inject constructor() {

	operator fun invoke(emiOptions: Map<String, String>) = emiOptions.keys.firstOrNull().orEmpty()
}