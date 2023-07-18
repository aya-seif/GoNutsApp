package com.example.gonutsapp.data

import com.example.gonutsapp.R
import com.example.gonutsapp.ui.home.DonutItem
import com.example.gonutsapp.ui.home.composable.DonutItem
import com.example.gonutsapp.ui.home.DonutOffer
import javax.inject.Inject

class GoNutsDataSource @Inject constructor() {

    fun getDonutOffers(): List<DonutOffer> {
        return listOf(
            DonutOffer(
                isFavorite = false, image = R.drawable.donut_1,
                name = "Strawberry Wheel",
                description = "These Baked Strawberry Donuts are filled with fresh,these Baked Strawberry Donuts are filled with fresh strawberries",
                originalPrice = 16,
                discountedPrice = 20
            ),
            DonutOffer(
                isFavorite = false, image = R.drawable.donut_2,
                name = "Chocolate Glaze",
                description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                originalPrice = 16,
                discountedPrice = 20
            ),
            DonutOffer(
                isFavorite = false, image = R.drawable.donut_1,
                name = "Strawberry Wheel",
                description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                originalPrice = 16,
                discountedPrice = 20
            ),
            DonutOffer(
                isFavorite = false, image = R.drawable.donut_2,
                name = "Chocolate Glaze",
                description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                originalPrice = 16,
                discountedPrice = 20
            ),
            DonutOffer(
                isFavorite = false, image = R.drawable.donut_1,
                name = "Strawberry Wheel",
                description = "These Baked Strawberry Donuts are filled with fresh,these Baked Strawberry Donuts are filled with fresh strawberries",
                originalPrice = 16,
                discountedPrice = 20
            ),
            DonutOffer(
                isFavorite = false, image = R.drawable.donut_2,
                name = "Chocolate Glaze",
                description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                originalPrice = 16,
                discountedPrice = 20
            ),
            DonutOffer(
                isFavorite = false, image = R.drawable.donut_1,
                name = "Strawberry Wheel",
                description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                originalPrice = 16,
                discountedPrice = 20
            ),
            DonutOffer(
                isFavorite = false, image = R.drawable.donut_2,
                name = "Chocolate Glaze",
                description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                originalPrice = 16,
                discountedPrice = 20
            ),
        )
    }

    fun getDonuts() : List<DonutItem>{
        return listOf(
            DonutItem(
                image = R.drawable.donut_3,
                name = "Chocolate Cherry",
                price = 22
            ),
            DonutItem(
                image = R.drawable.donut_4,
                name = "Strawberry Rain",
                price = 22
            ),
            DonutItem(
                image = R.drawable.donut_3,
                name = "Chocolate Cherry",
                price = 22
            ),
            DonutItem(
                image = R.drawable.donut_4,
                name = "Strawberry Rain",
                price = 22
            ),
            DonutItem(
                image = R.drawable.donut_3,
                name = "Chocolate Cherry",
                price = 22
            ),
            DonutItem(
                image = R.drawable.donut_4,
                name = "Strawberry Rain",
                price = 22
            ),
            DonutItem(
                image = R.drawable.donut_3,
                name = "Chocolate Cherry",
                price = 22
            ),
            DonutItem(
                image = R.drawable.donut_4,
                name = "Strawberry Rain",
                price = 22
            ),
        )
    }

}