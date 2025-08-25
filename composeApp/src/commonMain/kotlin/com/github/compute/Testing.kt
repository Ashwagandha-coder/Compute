package com.github.compute

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CalculatorPad(
    onDigitClick: (String) -> Unit, onOperatorClick: (String) -> Unit, modifier: Modifier = Modifier
) {
    val buttons = listOf(
        listOf("7", "8", "9", "/"),
        listOf("4", "5", "6", "*"),
        listOf("1", "2", "3", "-"),
        listOf("0", ".", "=", "+") // Example: added "." and "=" for more calculator-like feel
        // You can adjust this last row as needed
    )

    Column(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp) // Space between rows
    ) {
        buttons.forEach { rowItems ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp), // Space between buttons in a row
                modifier = Modifier.fillMaxWidth()
            ) {
                rowItems.forEach { item ->
                    CalculatorButton(
                        text = item, onClick = {
                            when (item) {
                                in "0".."9", "." -> onDigitClick(item)
                                in listOf("+", "-", "*", "/") -> onOperatorClick(item)
                                // Handle "=" or other special buttons if needed
                                "=" -> { /* TODO: Implement equals logic if it's part of this pad */
                                }
                            }
                        }, modifier = Modifier.weight(1f) // Distribute space equally
                    )
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(
    text: String, onClick: () -> Unit, modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.aspectRatio(1.5f) // Adjust aspect ratio as needed for button shape
            .padding(4.dp)
    ) {
        Text(text, fontSize = 20.sp) // Adjust font size as needed
    }
}


// You would integrate CalculatorPad into your main screen like CalculationScreen
// For example, in CalculationScreen.kt:

// ... (imports from CalculationScreen.kt)
// import com.github.compute.ui.CalculatorPad // Assuming you put CalculatorPad in this package

@Composable
fun YourMainCalculatorScreen() { // Renamed to avoid conflict if in same file
    // State for display, current number, operation etc. would go here
    // var displayValue by remember { mutableStateOf("0") }
    // var currentInput by remember { mutableStateOf("") }
    // var currentOperator by remember { mutableStateOf<String?>(null) }
    // var previousInput by remember { mutableStateOf<String?>(null) }


    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display Area (e.g., a Text composable)
        Text(
            text = "0", // Replace with your displayState
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)
            // .align(Alignment.End) // To align text to the right like a calculator
        )

        CalculatorPad(
            onDigitClick = { digit ->
                // TODO: Append digit to current input
                println("Digit clicked: $digit")
            }, onOperatorClick = { operator ->
                // TODO: Handle operator logic
                println("Operator clicked: $operator")
            }, modifier = Modifier.fillMaxWidth()
        )

        // You might have other buttons here (e.g., Clear, +/-)
    }
}


@Preview
@Composable
fun CalculatorPadPreview() {
    MaterialTheme {
        CalculatorPad(onDigitClick = {}, onOperatorClick = {})
    }
}

@Preview
@Composable
fun YourMainCalculatorScreenPreview() {
    MaterialTheme {
        YourMainCalculatorScreen()
    }
}
