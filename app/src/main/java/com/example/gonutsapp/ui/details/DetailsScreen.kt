package com.example.gonutsapp.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.navigation.NavHostController
import com.example.gonutsapp.R
import com.example.gonutsapp.composables.ButtonPrimary
import com.example.gonutsapp.composables.ButtonRounded
import com.example.gonutsapp.ui.theme.Background
import com.example.gonutsapp.ui.theme.Black
import com.example.gonutsapp.ui.theme.BodyMediumNormal
import com.example.gonutsapp.ui.theme.DarkGrey
import com.example.gonutsapp.ui.theme.HeadlineSmallSemiBold
import com.example.gonutsapp.ui.theme.LightGrey
import com.example.gonutsapp.ui.theme.Primary
import com.example.gonutsapp.ui.theme.Secondary
import com.example.gonutsapp.ui.theme.TitleMedium
import com.example.gonutsapp.ui.theme.TitleXLargeSemiBold
import com.example.gonutsapp.ui.theme.White

@Composable
fun DetailsScreen(
    viewModel: DetailsScreenViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val state by viewModel.uiState.collectAsState()
    DetailsContent(state){
        navHostController.navigateBackToHomeScreen()
    }
}

@Composable
fun DetailsContent(state: DetailsScreenUiState , onBackBtnClicked : () -> Unit) {

    LazyColumn {

        item {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Secondary)
            ) {

                IconButton(
                    onClick = { onBackBtnClicked() },
                    modifier = Modifier.padding(top = 32.dp, start = 32.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = state.name,
                        tint = Primary
                    )
                }

                Image(
                    modifier = Modifier
                        .size(220.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 16.dp),
                    painter = painterResource(id = state.image),
                    contentDescription = stringResource(R.string.donut_image),
                    contentScale = ContentScale.FillWidth
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top=16.dp)
                        .background(
                            Background,
                            RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                        )
                        .padding(vertical = 24.dp, horizontal = 40.dp),
                ) {

                    Text(
                        text = state.name,
                        style = HeadlineSmallSemiBold
                    )

                    Text(
                        text = stringResource(R.string.about_gonut),
                        style = TitleMedium.copy(color = DarkGrey),
                        modifier = Modifier.padding(top = 18.dp)
                    )

                    Text(
                        text = state.description,
                        style = BodyMediumNormal.copy(color = LightGrey),
                        modifier = Modifier.padding(top = 16.dp),
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        text = stringResource(R.string.quantity),
                        style = TitleMedium.copy(color = DarkGrey),
                        modifier = Modifier.padding(top = 24.dp)
                    )

                    Row(
                        modifier = Modifier
                            .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        ButtonRounded(modifier = Modifier, color = White, onClick = {}) {
                            Text(text = stringResource(R.string.minus), style = TitleMedium)
                        }
                        ButtonRounded(modifier = Modifier, color = White, onClick = {}) {
                            Text(text = stringResource(R.string._1), style = TitleMedium)
                        }
                        ButtonRounded(modifier = Modifier, color = Black, onClick = {}) {
                            Text(text = stringResource(R.string.add), style = TitleMedium.copy(White))
                        }
                    }

                    Row(
                        modifier = Modifier.padding(top = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(26.dp)
                    ) {
                        Text(text = "£${state.price}", style = HeadlineSmallSemiBold.copy(color = Black))
                        ButtonPrimary(
                            onClick = {},
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = stringResource(R.string.add_to_cart),
                                style = TitleXLargeSemiBold.copy(White),
                            )
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

