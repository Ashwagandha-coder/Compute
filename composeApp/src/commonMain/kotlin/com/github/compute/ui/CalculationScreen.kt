package com.github.compute.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.compute.res.backgroundColorDigitButton
import com.github.compute.res.dividerColor
import com.github.compute.res.inputFieldColor
import com.github.compute.res.resultButtonColor
import com.github.compute.res.resultColor
import com.github.compute.viewModel.CalculateViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun ProvideCalculateViewModel(content: @Composable (CalculateViewModel) -> Unit) {
    val viewModel = remember { CalculateViewModel() }
    content(viewModel)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculationScreen(viewModel: CalculateViewModel) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 25.dp, horizontal = 19.dp)
                .statusBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            InputFieldDigit(viewModel)
            ResultText(viewModel)
            DividerPad()
            CalculationPad(viewModel)
        }
    }
}

@Composable
fun InputFieldDigit(viewModel: CalculateViewModel) {
    var state = remember { mutableStateOf(0) }

    Text(
        text = viewModel.displayValue.value,
        fontSize = 48.sp,
        color = inputFieldColor,
        textAlign = TextAlign.End,
        modifier = Modifier.fillMaxWidth().padding(bottom = 82.dp)
    )
}


@Composable
fun ResultText(viewModel: CalculateViewModel) {
    Text(
        text = viewModel.resultValue.value,
        fontSize = 48.sp,
        color = resultColor,
        textAlign = TextAlign.End,
        modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)
    )
}


@Preview
@Composable
fun DividerPad() {
    Divider(
        thickness = 2.dp,
        color = dividerColor,
        modifier = Modifier.padding(vertical = 25.dp)
    )
}

@Preview
@Composable
fun CalculationPad(
    viewModel: CalculateViewModel
) {
    val buttons = listOf(
        listOf("7", "8", "9", "/"),
        listOf("4", "5", "6", "*"),
        listOf("1", "2", "3", "-"),
        listOf("0", "C", "=", "+")
    )

    val buttonModifier = Modifier.width(73.dp).height(75.dp)

    Column(
        modifier = Modifier.padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        buttons.forEach { rowButton ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                rowButton.forEach { text ->
                    when (text) {
                        "=" -> CalculateButton(
                            text,
                            onClick = { viewModel.onEqualsClick() },
                            modifier = buttonModifier,
                            buttonColors = ButtonDefaults.buttonColors(
                                contentColor = Color.White, containerColor = resultButtonColor
                            )
                        )

                        "C" -> CalculateButton(
                            text,
                            onClick = { viewModel.onClearClick() },
                            modifier = buttonModifier,
                            buttonColors = ButtonDefaults.buttonColors(
                                contentColor = Color.White, containerColor = Color.Red
                            )
                        )

                        "+", "-", "*", "/" -> CalculateButton(
                            text,
                            onClick = { viewModel.onOperatorClick(text) },
                            modifier = buttonModifier,
                            buttonColors = ButtonDefaults.buttonColors(
                                contentColor = Color.Black,
                                containerColor = backgroundColorDigitButton
                            )
                        )

                        else -> CalculateButton(
                            text,
                            onClick = { viewModel.onDigitClick(text.toInt()) },
                            modifier = buttonModifier,
                            buttonColors = ButtonDefaults.buttonColors(
                                contentColor = Color.Black,
                                containerColor = backgroundColorDigitButton
                            )
                        )
                    }
                }
            }
        }
    }

}


@Composable
fun CalculateButton(
    text: String, onClick: () -> Unit, modifier: Modifier, buttonColors: ButtonColors
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = buttonColors,
        shape = RoundedCornerShape(9.dp)
    ) {
        Text(text = text, fontFamily = FontFamily.Default, fontSize = 36.sp)
    }
}


@Preview
@Composable
fun CalculationScreenPreview() {
    ProvideCalculateViewModel {
        CalculationScreen(it)
    }
}

