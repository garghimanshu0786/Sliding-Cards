package com.example.slidingcards.presentation.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slidingcards.presentation.ui.theme.SlidingCardsTheme
import com.example.slidingcards.presentation.ui.theme.text16Sp


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VerticalRadioButtonViewPreview() = SlidingCardsTheme {
	VerticalRadioButtonView(
		allValues = mapOf("value1" to "Value 1", "value2" to "Value2"),
		selectedValue = "value1"
	) {}
}

@Composable
fun VerticalRadioButtonView(
	allValues: Map<String, String>,
	selectedValue: String,
	onSelectionChanged: ((String) -> Unit)
) {
	Column {
		allValues.values.forEach { value ->
			Row(
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier.padding(top = 32.dp),
			) {
				val key = remember(
					allValues,
					value
				) { allValues.filterValues { it == value }.keys.first() }
				RadioButton(
					selected = remember(
						allValues,
						value,
						selectedValue
					) { value == allValues.filterKeys { it == selectedValue }.values.firstOrNull() },
					onClick = {
						onSelectionChanged(key)
					},
				)
				Column {
					Text(
						text = value,
						style = text16Sp(),
					)
				}
			}
		}
	}
}