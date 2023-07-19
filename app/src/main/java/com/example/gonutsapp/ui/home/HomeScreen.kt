package com.example.gonutsapp.ui.home

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.gonutsapp.R
import com.example.gonutsapp.ui.details.navigateToDonutDetails
import com.example.gonutsapp.ui.home.composable.DonutItem
import com.example.gonutsapp.ui.home.composable.DonutOffersItem
import com.example.gonutsapp.ui.home.composable.TopBar
import com.example.gonutsapp.ui.theme.Background
import com.example.gonutsapp.ui.theme.Blue
import com.example.gonutsapp.ui.theme.BodyMedium
import com.example.gonutsapp.ui.theme.HeadlineSmallSemiBold
import com.example.gonutsapp.ui.theme.Primary
import com.example.gonutsapp.ui.theme.Secondary
import com.example.gonutsapp.ui.theme.TitleLargeSemiBold

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val state by viewModel.uiState.collectAsState()
    HomeContent(state = state, onDonutOfferClick = {
        navController.navigateToDonutDetails(it)
    })

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeContent(state: HomeUiState, onDonutOfferClick: (Int) -> Unit) {

    LazyColumn(modifier = Modifier.background(Background)) {

        stickyHeader {
            TopBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.lets_gonuts),
                        style = HeadlineSmallSemiBold,
                        modifier = Modifier.padding(top = 40.dp, start = 32.dp)

                    )
                },
                subTitle = {
                    Text(
                        text = stringResource(R.string.order_donuts),
                        style = BodyMedium,
                        modifier = Modifier.padding(start = 32.dp)
                    )

                },
                leading = {
                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .padding(top = 40.dp, end = 32.dp)
                            .background(Secondary, RoundedCornerShape(15.dp))
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = stringResource(R.string.search_icon),
                            tint = Primary
                        )
                    }
                },
                modifier = Modifier.background(Background)
            )
        }
        item {

            Column() {

                Text(
                    text = stringResource(R.string.today_offers),
                    style = TitleLargeSemiBold,
                    modifier = Modifier.padding(start = 32.dp, top = 32.dp)
                )

                LazyRow(
                    contentPadding = PaddingValues(start = 32.dp, end = 64.dp, top = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(72.dp)
                ) {
                    itemsIndexed(state.donutOffers) { index, item ->
                        DonutOffersItem(
                            state = item, modifier = Modifier
                                .background(
                                    if (index % 2 == 0) Blue else Secondary,
                                    RoundedCornerShape(20.dp)
                                )
                                .clickable { onDonutOfferClick(index) }
                        )
                    }
                }

                Text(
                    text = stringResource(R.string.donuts),
                    style = TitleLargeSemiBold,
                    modifier = Modifier.padding(start = 32.dp, top = 24.dp)
                )

                LazyRow(
                    modifier = Modifier.padding(top = 24.dp),
                    contentPadding = PaddingValues(32.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    itemsIndexed(state.donutsList) { index, item ->
                        DonutItem(state = item)
                    }
                }
            }
        }
    }
}

