package com.github.compute.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.github.compute.ui.theme.res.inputFieldColor
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputFieldDigitAsOutlined() {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    // Request focus when the composable initially enters the composition
    // and whenever the currentInput text becomes "0" (e.g., after a clear)
    // Adjust the key for LaunchedEffect based on when you want focus to be re-requested.


    OutlinedTextField(
        value = "2 + 7", // Assuming currentInput is TextFieldValue
        onValueChange = {
            // Block direct keyboard input from changing the value if desired.
            // The ViewModel's methods (onDigit, onBackspace) are responsible for updates.
            // If you wanted to allow typing, you'd call a ViewModel method here:
            // viewModel.processTypedInput(it.text.lastOrNull(), it.selection)
        },
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester),
        textStyle = TextStyle(
            fontSize = 48.sp,
            color = inputFieldColor, // Your defined color
            textAlign = TextAlign.End
        ),
        // To prevent the software keyboard from appearing:
        keyboardOptions = KeyboardOptions.Default.copy(
            // No software keyboard
            imeAction = ImeAction.Done // Optional: if keyboard somehow appears
        ),
        keyboardActions = KeyboardActions( // Optional: if keyboard somehow appears
            onDone = { focusManager.clearFocus() }
        ),
        singleLine = true,
        readOnly = false, // IMPORTANT: Set to false to allow focus and cursor
        label = null,
        placeholder = null,
        interactionSource = remember { MutableInteractionSource() } // Good practice for focus indication
    )
}
