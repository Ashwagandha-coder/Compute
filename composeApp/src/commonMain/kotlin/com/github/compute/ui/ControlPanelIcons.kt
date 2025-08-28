package com.github.compute.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import compute.composeapp.generated.resources.Backspace
import compute.composeapp.generated.resources.Res
import compute.composeapp.generated.resources.Root
import compute.composeapp.generated.resources.Ruler
import compute.composeapp.generated.resources.history_icon
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun HistoryIcon(onClick: () -> Unit, modifier: Modifier = Modifier.width(24.dp).height(24.dp)) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(
            painter = painterResource(Res.drawable.history_icon),
            contentDescription = "",
            modifier = modifier.background(color = Color.White)
        )
    }
}

@Preview
@Composable
fun RulerIcon(onClick: () -> Unit, modifier: Modifier = Modifier.width(24.dp).height(24.dp)) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(
            painter = painterResource(Res.drawable.Ruler),
            contentDescription = "",
            modifier = Modifier.width(24.dp).height(24.dp).background(color = Color.White)
        )
    }
}

@Preview
@Composable
fun RootIcon(onClick: () -> Unit, modifier: Modifier = Modifier.width(24.dp).height(24.dp)) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(
            painter = painterResource(Res.drawable.Root),
            contentDescription = "",
            modifier = Modifier.width(24.dp).height(24.dp).background(color = Color.White)
        )
    }
}

@Preview
@Composable
fun BackSpaceIcon(onClick: () -> Unit, modifier: Modifier = Modifier.width(24.dp).height(24.dp)) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(
            painter = painterResource(Res.drawable.Backspace),
            contentDescription = "",
            modifier = Modifier.width(24.dp).height(24.dp).background(color = Color.White)
        )
    }
}