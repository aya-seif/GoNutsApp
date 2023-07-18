package com.example.gonutsapp.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gonutsapp.R
import com.example.gonutsapp.ui.theme.Background
import com.example.gonutsapp.ui.theme.Black
import com.example.gonutsapp.ui.theme.BodyMediumNormal
import com.example.gonutsapp.ui.theme.DarkGrey
import com.example.gonutsapp.ui.theme.HeadlineSmallSemiBold
import com.example.gonutsapp.ui.theme.LightGrey
import com.example.gonutsapp.ui.theme.Primary
import com.example.gonutsapp.ui.theme.Secondary
import com.example.gonutsapp.ui.theme.TitleMedium
import com.example.gonutsapp.ui.theme.White

@Composable
fun DetailsScreen(
    viewModel: DetailsScreenViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    DetailsContent(state)
}

@Composable
fun DetailsContent(state: DetailsScreenUiState) {

    LazyColumn() {
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Secondary)
            ) {

                IconButton(
                    onClick = { },
                    modifier = Modifier.padding(top = 40.dp, start = 32.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = state.name,
                        tint = Primary
                    )
                }

                Image(
                    modifier = Modifier
                        .size(240.dp)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.donut_1),
                    contentDescription = stringResource(R.string.donut_image),
                    contentScale = ContentScale.FillWidth
                )

                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Background,
                            RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                        )
                        .padding(40.dp),
                ) {

                    Text(
                        text = stringResource(R.string.strawberry_wheel),
                        style = HeadlineSmallSemiBold
                    )

                    Text(
                        text = stringResource(R.string.about_gonut),
                        style = TitleMedium.copy(color = DarkGrey),
                        modifier = Modifier.padding(top = 32.dp)
                    )

                    Text(
                        text = stringResource(R.string.soft_cake),
                        style = BodyMediumNormal.copy(color = LightGrey),
                        modifier = Modifier.padding(top = 16.dp),
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        text = stringResource(R.string.quantity),
                        style = TitleMedium.copy(color = DarkGrey),
                        modifier = Modifier.padding(top = 26.dp)
                    )

                    Row(
                        modifier = Modifier
                            .padding(top = 18.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        RoundedShape(modifier = Modifier, color = White) {
                            Text(text = "-")
                        }
                        RoundedShape(modifier = Modifier, color = White) {
                            Text(text = "-")
                        }
                        RoundedShape(modifier = Modifier, color = Black) {
                            Text(text = "+" , style = HeadlineSmallSemiBold)
                        }
                    }


                }

            }
        }
    }


}

@Composable
fun RoundedShape(modifier: Modifier = Modifier, color: Color, content: @Composable () -> Unit) {
    Box(
        modifier = modifier
            .background(color, RoundedCornerShape(15.dp))
            .padding(horizontal = 16.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}