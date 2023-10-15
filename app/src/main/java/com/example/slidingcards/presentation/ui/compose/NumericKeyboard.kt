package com.example.slidingcards.presentation.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.slidingcards.presentation.ui.theme.SlidingCardsTheme

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NumericKeyboardPreview() = SlidingCardsTheme {
	Column {
		NumericKeyboard(paymentAmount = "123", {})
	}
}

@Composable
fun NumericKeyboard(
	paymentAmount: String,
	setPaymentAmount: (String) -> Unit,
	modifier: Modifier = Modifier
) {
	TextField(
		value = paymentAmount, onValueChange = setPaymentAmount, keyboardOptions = KeyboardOptions(
			keyboardType = KeyboardType.Number,
			imeAction = ImeAction.Done
		),
		modifier = modifier.fillMaxWidth()
	)
}
