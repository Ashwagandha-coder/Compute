package com.github.compute.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.compute.ui.theme.res.backgroundColorDigitButton
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun ImageCalculateButton(
    linkPicture: DrawableResource,
    buttonModifier: Modifier,
    iconModifier: Modifier,
    contentColor: Color
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColorDigitButton,
            contentColor = contentColor
        ), onClick = {}, modifier = buttonModifier, shape = RoundedCornerShape(9.dp)
    ) {
        Icon(
            painter = painterResource(linkPicture),
            contentDescription = "Operation Icon",
            modifier = iconModifier
        )
    }
}
