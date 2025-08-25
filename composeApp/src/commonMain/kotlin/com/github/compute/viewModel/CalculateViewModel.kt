package com.github.compute.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculateViewModel : ViewModel() {

    private val defaultValue = "0"
    var displayValue = mutableStateOf(defaultValue)
        private set

    var resultValue = mutableStateOf("-")
        private set

    private var firstOperand = 0.0
    private var secondOperand = 0.0
    private var operation = StateOperation.None


    fun onDigitClick(digit: Int) {
        if (operation == StateOperation.None) {
            firstOperand = (firstOperand * 10 + digit)
            displayValue.value = digit.toString()
        } else {
            secondOperand = (secondOperand * 10 + digit)
            displayValue.value = digit.toString()
        }
    }

    fun onOperatorClick(symbol: String) {
        operation = when (symbol) {
            "+" -> StateOperation.Add
            "-" -> StateOperation.Subtract
            "*" -> StateOperation.Multiply
            "/" -> StateOperation.Divide
            else -> StateOperation.None
        }


    }

    fun onEqualsClick() {
        when (operation) {
            StateOperation.Add -> resultValue.value = (firstOperand + secondOperand).toString()
            StateOperation.Subtract -> resultValue.value =
                (firstOperand - secondOperand).toString()

            StateOperation.Multiply -> resultValue.value =
                (firstOperand * secondOperand).toString()

            StateOperation.Divide -> resultValue.value = (firstOperand / secondOperand).toString()
            StateOperation.None -> {}
        }
        onClearClick()
    }

    fun onClearClick() {
        firstOperand = 0.0
        secondOperand = 0.0
        operation = StateOperation.None
        displayValue.value = defaultValue

    }


}