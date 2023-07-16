package com.example.gonutsapp.ui.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.gonutsapp.R
import com.example.gonutsapp.ui.home.DonutOffer
import com.example.gonutsapp.ui.theme.BodyMediumSemiBoldSpanStyle
import com.example.gonutsapp.ui.theme.BodySmallNormal
import com.example.gonutsapp.ui.theme.Primary
import com.example.gonutsapp.ui.theme.TitleSmallMedium
import com.example.gonutsapp.ui.theme.TitleXLargeSemiBoldSpanStyle
import com.example.gonutsapp.ui.theme.White


@Composable
fun DonutOffersItem(state: DonutOffer, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .width(193.dp)
            .padding(16.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.favorite),
            contentDescription = state.name,
            modifier = Modifier
                .background(White, CircleShape)
                .padding(horizontal = 8.dp, vertical = 9.dp)
                .size(24.dp),
            tint = Primary
        )

        Image(
            painter = painterResource(id = state.image),
            modifier = Modifier
                .offset(x = 94.dp)
                .size(138.dp),
            contentDescription = state.name,
        )

        Text(
            text = state.name,
            style = TitleSmallMedium,
            modifier = Modifier.padding(top = 17.dp, bottom = 9.dp)
        )

        Text(
            text = state.description,
            style = BodySmallNormal,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = buildAnnotatedString {
                withStyle(BodyMediumSemiBoldSpanStyle) {
                    append("\$${state.discountedPrice}")
                }
                withStyle(TitleXLargeSemiBoldSpanStyle) {
                    append(" \$${state.originalPrice}")
                }
            },
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 4.dp),
        )
    }
}