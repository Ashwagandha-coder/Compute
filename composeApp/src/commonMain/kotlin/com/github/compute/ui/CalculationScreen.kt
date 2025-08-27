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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.compute.res.StringRes
import com.github.compute.res.backgroundColorDigitButton
import com.github.compute.res.clearButtonColor
import com.github.compute.res.digitButtonColor
import com.github.compute.res.dividerColor
import com.github.compute.res.inputFieldColor
import com.github.compute.res.operationsButtonColor
import com.github.compute.res.resultButtonBackgroundColor
import com.github.compute.res.resultTextColor
import com.github.compute.viewModel.CalculationViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun ProvideCalculateViewModel(content: @Composable (CalculationViewModel) -> Unit) {
    val viewModel = remember { CalculationViewModel() }
    content(viewModel)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculationScreen(viewModel: CalculationViewModel) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 25.dp, horizontal = 19.dp)
                .statusBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputFieldDigit(viewModel)
            ResultText(viewModel)
            DividerPad()
            CalculationPad(viewModel)
        }
    }
}

@Composable
fun InputFieldDigit(viewModel: CalculationViewModel) {

    Text(
        text = "123 + 456",
        fontSize = 48.sp,
        color = inputFieldColor,
        textAlign = TextAlign.End,
        modifier = Modifier.fillMaxWidth().padding(bottom = 82.dp)
    )
}


@Composable
fun ResultText(viewModel: CalculationViewModel) {
    Text(
        text = "579",
        fontSize = 48.sp,
        color = resultTextColor,
        textAlign = TextAlign.End,
        maxLines = 1,
        modifier = Modifier.fillMaxWidth()
    )
}


@Preview
@Composable
fun DividerPad() {
    Divider(
        thickness = 2.dp,
        color = dividerColor,
        modifier = Modifier.padding(bottom = 25.dp)
    )
}

@Preview
@Composable
fun CalculationPad(
    viewModel: CalculationViewModel
) {

    val buttonModifier = Modifier.width(73.dp).height(75.dp)

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            FirstRowButtons(buttonModifier)

        }
        Row(
            modifier = Modifier.padding(top = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            SecondRowButtons(buttonModifier)
        }
        Row(
            modifier = Modifier.padding(top = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            ThirdRowButtons(buttonModifier)
        }
        Row(
            modifier = Modifier.padding(top = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            FoursRowButtons(buttonModifier)
        }
        Row(
            modifier = Modifier.padding(top = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            FifthRowButtons(buttonModifier)
        }

    }
}

@Composable
fun FirstRowButtons(buttonModifier: Modifier) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = clearButtonColor,
            contentColor = Color.White
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = StringRes.clearButtonMark,
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = operationsButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = StringRes.parenthesesButtonLabel,
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = operationsButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = StringRes.percentageButtonLabel,
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = operationsButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = StringRes.divideButtonLabel,
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
}


@Composable
fun SecondRowButtons(buttonModifier: Modifier) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = "7",
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = "8",
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = "9",
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = operationsButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = StringRes.multipleButtonLabel,
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun ThirdRowButtons(buttonModifier: Modifier) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = "4",
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = "5",
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = "6",
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = operationsButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = StringRes.subtrackButtonLabel,
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun FoursRowButtons(buttonModifier: Modifier) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = "1",
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = "2",
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = "3",
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = operationsButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = StringRes.addingButtonLabel,
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun FifthRowButtons(buttonModifier: Modifier) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = StringRes.addSubtrackButtonLabel,
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = "0",
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = StringRes.dotButtonLabel,
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = resultButtonBackgroundColor,
            contentColor = Color.White
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Text(
            text = StringRes.equalsButtonLabel,
            fontSize = 36.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal
        )
    }
}


@Preview
@Composable
fun CalculationScreenPreview() {
    ProvideCalculateViewModel {
        CalculationScreen(it)
    }
}

