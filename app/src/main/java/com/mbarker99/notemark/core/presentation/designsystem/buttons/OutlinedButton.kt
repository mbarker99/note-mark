package com.mbarker99.notemark.core.presentation.designsystem.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mbarker99.notemark.core.presentation.designsystem.theme.NoteMarkTheme
import com.mbarker99.notemark.core.presentation.designsystem.theme.OnSurfaceOpacity12

@Composable
fun OutlinedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.primary,
        ),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
    ) {
        leadingIcon?.invoke()
        if (leadingIcon != null) {
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall,
            color  = MaterialTheme.colorScheme.primary
        )
        if (trailingIcon != null) {
            Spacer(modifier = Modifier.width(8.dp))
        }
        trailingIcon?.invoke()
    }
}

@Preview
@Composable
private fun OutlinedButtonPreview() {
    NoteMarkTheme {
        OutlinedButton(
            text = "Label",
            onClick = { },
            enabled = true,
            leadingIcon = {
                /*Icon(
                    imageVector = Icons.Default.Build,
                    conte   ntDescription = null
                )*/
            },
            trailingIcon = { }
        )
    }
}