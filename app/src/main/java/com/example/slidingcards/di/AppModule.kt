package com.example.slidingcards.di

import com.example.slidingcards.domain.GetBankOptionsUseCase
import com.example.slidingcards.domain.GetDefaultEMIOptionUseCase
import com.example.slidingcards.domain.GetEMIOptionsUseCase

interface AppModule {
	val getEMIOptionsUseCase: GetEMIOptionsUseCase
	val getBankOptionsUseCase: GetBankOptionsUseCase
	val getDefaultEMIOptionUseCase: GetDefaultEMIOptionUseCase
}

class AppModuleImpl : AppModule {

	override val getEMIOptionsUseCase: GetEMIOptionsUseCase by lazy { GetEMIOptionsUseCase() }
	override val getBankOptionsUseCase: GetBankOptionsUseCase by lazy { GetBankOptionsUseCase() }
	override val getDefaultEMIOptionUseCase: GetDefaultEMIOptionUseCase by lazy { GetDefaultEMIOptionUseCase() }
}