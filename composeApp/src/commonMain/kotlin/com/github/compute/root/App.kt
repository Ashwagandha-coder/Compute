package com.github.compute.root


import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.github.compute.ui.CalculationScreen
import com.github.compute.ui.ProvideCalculateViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {
        ProvideCalculateViewModel { viewModel ->
            CalculationScreen(viewModel)
        }

    }
}