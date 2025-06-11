package com.mbarker99.notemark.core.presentation.designsystem.textfields

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mbarker99.notemark.core.presentation.designsystem.theme.NoteMarkTheme

@Composable
fun BaseTextField(
    text: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hintText: String? = null,
    hintTextStyle: TextStyle = MaterialTheme.typography.bodyLarge.copy(
        color = MaterialTheme.colorScheme.onSurfaceVariant
    ),
    labelText: String? = null,
    labelTextStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    Column(
        modifier = modifier
    ) {
        if (labelText != null) {
            Text(
                text = labelText,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(Modifier.height(7.dp))
        }
        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            modifier = modifier,
            textStyle = hintTextStyle,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            decorationBox = { innerTextField ->
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.surface,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(vertical = 16.dp)
                        .padding(start = 16.dp)
                        .padding(end = 12.dp)
                ) {
                    if (text.isBlank() && hintText != null) {
                        Text(
                            text = hintText,
                            style = hintTextStyle
                        )
                    } else {
                        innerTextField()
                    }
                }
            }
        )
    }

}

@Preview
@Composable
private fun BaseTextFieldPreview() {
    NoteMarkTheme {
        BaseTextField(
            text = "",
            onValueChange = { },
            hintText = "john.doe@example.com",
            labelText = "Email",
            modifier = Modifier.background(Color.White)
        )
    }
}