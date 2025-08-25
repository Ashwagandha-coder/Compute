package com.github.compute.viewModel

// In commonMain/kotlin/com/yourpackage/common/CalculatorViewModel.kt

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

// A simple enum for operations for clarity, can be expanded
enum class Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE, NONE
}

class CalculatorViewModel {
    var displayValue by mutableStateOf("0")
        private set // External read-only, internal mutable

    private var firstOperand: Double? = null
    private var secondOperand: Double? = null // For ongoing operations
    private var currentOperation: Operation = Operation.NONE
    private var shouldResetDisplayForNextDigit: Boolean = false

    fun onDigitClick(digit: String) {
        if (displayValue == "0" && digit != ".") {
            if (digit == "00") { // Handle "00" when display is "0"
                displayValue = "0" // Remains "0"
                return
            }
            displayValue = digit
        } else if (shouldResetDisplayForNextDigit) {
            displayValue = digit
            shouldResetDisplayForNextDigit = false
        } else {
            if (displayValue.length < 15) { // Arbitrary limit
                if (digit == "." && displayValue.contains(".")) return // Only one decimal point
                displayValue += digit
            }
        }
    }

    fun onOperatorClick(opSymbol: String) {
        val newOperation = when (opSymbol) {
            "+" -> Operation.ADD
            "-" -> Operation.SUBTRACT
            "*" -> Operation.MULTIPLY
            "/" -> Operation.DIVIDE
            else -> Operation.NONE // Should not happen if buttons are mapped correctly
        }

        if (firstOperand == null) {
            firstOperand = displayValue.toDoubleOrNull() ?: 0.0
        } else if (!shouldResetDisplayForNextDigit) { // There's a second operand typed
            secondOperand = displayValue.toDoubleOrNull() ?: 0.0
            calculateResult() // Calculate intermediate result
            firstOperand = displayValue.toDoubleOrNull() ?: 0.0 // Result becomes first operand
        }
        // else: an operator was pressed after another operator, or after equals.
        // The firstOperand holds the value, just update the operation.

        currentOperation = newOperation
        shouldResetDisplayForNextDigit = true
    }

    fun onEqualsClick() {
        if (firstOperand != null && currentOperation != Operation.NONE && !shouldResetDisplayForNextDigit) {
            secondOperand = displayValue.toDoubleOrNull() ?: 0.0
            calculateResult()
        }
        // After equals, prepare for a new calculation but keep the result displayed
        // If user types a digit, it starts a new number.
        // If user types an operator, the current displayValue becomes the firstOperand.
        firstOperand = null // Reset first operand to allow new calculation starting with an operator
        currentOperation = Operation.NONE
        shouldResetDisplayForNextDigit = true
    }

    private fun calculateResult() {
        if (firstOperand == null || secondOperand == null || currentOperation == Operation.NONE) {
            return
        }

        val result = when (currentOperation) {
            Operation.ADD -> firstOperand!! + secondOperand!!
            Operation.SUBTRACT -> firstOperand!! - secondOperand!!
            Operation.MULTIPLY -> firstOperand!! * secondOperand!!
            Operation.DIVIDE -> {
                if (secondOperand!! == 0.0) {
                    displayValue = "Error"
                    resetCalculatorState(keepError = true)
                    return
                }
                firstOperand!! / secondOperand!!
            }
            Operation.NONE -> displayValue.toDoubleOrNull() ?: 0.0
        }

        displayValue = formatResult(result)
        // firstOperand = result // Update firstOperand for chained operations if needed immediately
        // For this logic, 'onOperatorClick' and 'onEqualsClick' handle setting firstOperand
        secondOperand = null // Reset second operand
        // currentOperation = Operation.NONE // Reset by onEqualsClick or overwritten by new onOperatorClick
        // shouldResetDisplayForNextDigit = true // Set by caller
    }

    private fun formatResult(result: Double): String {
        // Avoid scientific notation for very small/large numbers if not desired
        // and remove trailing .0
        return if (result % 1 == 0.0) {
            result.toLong().toString()
        } else {
            result.toString()
        }
    }


    fun onClearClick() {
        resetCalculatorState()
    }

    private fun resetCalculatorState(keepError: Boolean = false) {
        if (!keepError) {
            displayValue = "0"
        }
        firstOperand = null
        secondOperand = null
        currentOperation = Operation.NONE
        shouldResetDisplayForNextDigit = false
    }

    fun onDeleteClick() {
        if (shouldResetDisplayForNextDigit || displayValue == "Error") return // Don't delete if display should reset or is error

        if (displayValue.length > 1) {
            displayValue = displayValue.dropLast(1)
        } else if (displayValue != "0") {
            displayValue = "0"
        }
        // If displayValue becomes empty after dropLast (e.g., from "-"), set to "0"
        if (displayValue.isEmpty() || displayValue == "-") {
            displayValue = "0"
        }
    }

    fun onPercentageClick() {
        if (displayValue == "Error") return
        val currentValue = displayValue.toDoubleOrNull()
        if (currentValue != null) {
            displayValue = formatResult(currentValue / 100.0)
            // After percentage, it might be an intermediate result or final
            shouldResetDisplayForNextDigit = true // Or false depending on desired follow-up behavior
        }
    }
}
