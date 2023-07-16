package com.example.gonutsapp.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.gonutsapp.R
import com.example.gonutsapp.ui.theme.HeadlineLargeSemiBold
import com.example.gonutsapp.ui.theme.Secondary
import com.example.gonutsapp.ui.theme.TitleLargeSemiBold
import com.example.gonutsapp.ui.theme.TitleMedium
import com.example.gonutsapp.ui.theme.White

@Composable
fun OnBoardingScreen() {
    OnBoardingContent()
}

@Composable
fun OnBoardingContent() {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.background(Secondary).fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.bg_onboarding),
                contentScale = ContentScale.Fit,
                alignment = Alignment.TopStart
            )
            .padding(horizontal = 40.dp),
        verticalArrangement = Arrangement.Bottom
    ) {

        Text(text = stringResource(id = R.string.Gonuts_with_Donuts), style = HeadlineLargeSemiBold)

        Text(text = stringResource(id = R.string.Gonuts_Details), style = TitleMedium)

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth().padding(top = 30.dp, bottom = 46.dp),
            colors = ButtonDefaults.buttonColors(containerColor = White)
        ) {
            Text(
                text = stringResource(id = R.string.get_started),
                style = TitleLargeSemiBold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }

}


