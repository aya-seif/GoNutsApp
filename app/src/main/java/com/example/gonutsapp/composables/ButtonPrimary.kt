package com.example.gonutsapp.composables

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gonutsapp.ui.theme.Primary

@Composable
fun ButtonPrimary(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    Button(
        onClick = { onClick() },
        modifier = modifier.height(56.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Primary)
    ) {
        content()
    }
}