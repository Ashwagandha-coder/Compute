package com.github.compute.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import compute.composeapp.generated.resources.Inter_28pt_Regular
import compute.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun getRegularFontFamily() = FontFamily(Font(resource = Res.font.Inter_28pt_Regular, weight = FontWeight.Normal))

