package com.mbarker99.notemark.core.presentation.designsystem.buttons

import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mbarker99.notemark.core.presentation.designsystem.theme.NoteMarkTheme
import com.mbarker99.notemark.core.presentation.designsystem.theme.OnSurfaceOpacity12

// needs filled and unfilled variants
@Composable
fun PrimaryButton(
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
            containerColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContentColor = OnSurfaceOpacity12
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        leadingIcon?.invoke()
        if (leadingIcon != null) {
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall,
            color  = if (enabled) {
                MaterialTheme.colorScheme.onPrimary
            } else {
                OnSurfaceOpacity12
            }
        )
        if (trailingIcon != null) {
            Spacer(modifier = Modifier.width(8.dp))
        }
        trailingIcon?.invoke()
    }
}

@Preview
@Composable
private fun PrimaryButtonPreview() {
    NoteMarkTheme { 
        PrimaryButton(
            text = "Button",
            onClick = { },
            enabled = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = null
                )
            },
            trailingIcon = { }
        )
    }
}