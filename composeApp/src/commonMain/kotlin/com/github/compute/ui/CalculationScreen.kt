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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.compute.ui.theme.getRegularFontFamily
import com.github.compute.ui.theme.res.StringRes
import com.github.compute.ui.theme.res.backgroundColorDigitButton
import com.github.compute.ui.theme.res.clearButtonColor
import com.github.compute.ui.theme.res.digitButtonColor
import com.github.compute.ui.theme.res.dividerColor
import com.github.compute.ui.theme.res.inputFieldColor
import com.github.compute.ui.theme.res.operationsButtonColor
import com.github.compute.ui.theme.res.resultButtonBackgroundColor
import com.github.compute.ui.theme.res.resultTextColor
import com.github.compute.viewModel.CalculationViewModel
import compute.composeapp.generated.resources.Res
import compute.composeapp.generated.resources.divider
import compute.composeapp.generated.resources.multiple
import compute.composeapp.generated.resources.parentheses
import compute.composeapp.generated.resources.percentage
import compute.composeapp.generated.resources.plus_minus
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
            HistoryIcon()
            DividerLine()
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
fun DividerLine() {
    Divider(
        thickness = 1.dp,
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
        TextWrapper(
            text = StringRes.clearButtonMark
        )
    }
    val iconModifier = Modifier.width(20.23.dp).height(29.dp)
    ImageCalculateButton(
        iconModifier = iconModifier,
        buttonModifier = buttonModifier,
        linkPicture = Res.drawable.parentheses,
        contentColor = operationsButtonColor
    )
    ImageCalculateButton(
        iconModifier = iconModifier,
        buttonModifier = buttonModifier,
        linkPicture = Res.drawable.percentage,
        contentColor = operationsButtonColor
    )
    ImageCalculateButton(
        buttonModifier = buttonModifier,
        iconModifier = iconModifier,
        linkPicture = Res.drawable.divider,
        contentColor = operationsButtonColor
    )
}


@Composable
fun SecondRowButtons(buttonModifier: Modifier) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        TextWrapper(
            text = "7"
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        TextWrapper(
            text = "8"
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        TextWrapper(
            text = "9"
        )
    }
    ImageCalculateButton(
        iconModifier = Modifier.width(20.23.dp).height(29.dp),
        buttonModifier = buttonModifier,
        linkPicture = Res.drawable.multiple,
        contentColor = operationsButtonColor
    )
}

@Composable
fun ThirdRowButtons(buttonModifier: Modifier) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        TextWrapper(
            text = "4"
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        TextWrapper(
            text = "5"
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        TextWrapper(
            text = "6"
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = operationsButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        TextWrapper(
            text = StringRes.subtrackButtonLabel
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
        TextWrapper(
            text = "1"
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        TextWrapper(
            text = "2"
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        TextWrapper(
            text = "3"
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = operationsButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        TextWrapper(
            text = StringRes.addingButtonLabel
        )
    }
}

@Composable
fun FifthRowButtons(buttonModifier: Modifier) {
    val iconModifier = Modifier.width(54.dp).height(43.dp)
    ImageCalculateButton(
        iconModifier = iconModifier,
        buttonModifier = buttonModifier,
        linkPicture = Res.drawable.plus_minus,
        contentColor = digitButtonColor
    )
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        TextWrapper(
            text = "0"
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = digitButtonColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        TextWrapper(
            text = StringRes.dotButtonLabel
        )
    }
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = resultButtonBackgroundColor,
            contentColor = Color.White
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        TextWrapper(
            text = StringRes.equalsButtonLabel
        )
    }
}

@Composable
fun TextWrapper(text: String) {
    Text(
        text = text,
        fontSize = 36.sp,
        fontFamily = getRegularFontFamily()
    )
}


@Preview
@Composable
fun CalculationScreenPreview() {
    ProvideCalculateViewModel {
        CalculationScreen(it)
    }
}

