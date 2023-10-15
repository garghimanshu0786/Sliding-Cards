package com.example.slidingcards.presentation.ui.compose

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slidingcards.R
import com.example.slidingcards.presentation.ui.theme.SlidingCardsTheme
import com.example.slidingcards.presentation.ui.theme.text12Sp
import com.example.slidingcards.presentation.ui.theme.text20Sp


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TitleSubtitleViewPreview() = SlidingCardsTheme {
	Column {
		TitleSubtitleView(
			title = R.string.app_name, subtitle = R.string.app_name
		)
	}
}

@Composable
fun TitleSubtitleView(@StringRes title: Int, @StringRes subtitle: Int) {
	Text(
		text = stringResource(title),
		style = text20Sp()
	)
	Spacer(modifier = Modifier.height(16.dp))
	Text(text = stringResource(subtitle), style = text12Sp())
	Spacer(modifier = Modifier.height(16.dp))
}
