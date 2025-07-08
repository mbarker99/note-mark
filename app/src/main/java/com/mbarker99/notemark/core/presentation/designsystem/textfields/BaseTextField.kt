package com.mbarker99.notemark.core.presentation.designsystem.textfields

import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mbarker99.notemark.R
import com.mbarker99.notemark.core.presentation.designsystem.textfields.model.TextFieldType
import com.mbarker99.notemark.core.presentation.designsystem.theme.NoteMarkTheme

@Composable
fun BaseTextField(
    text: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    type: TextFieldType = TextFieldType.DEFAULT,
    hintText: String,
    labelText: String? = null,
    labelTextStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    isPassword: Boolean = false
) {
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    var isError by remember {
        mutableStateOf(false)
    }

    val errorText: String? = when (type) {
        TextFieldType.USERNAME -> stringResource(R.string.username_error)
        TextFieldType.PASSWORD -> stringResource(R.string.password_error)
        TextFieldType.EMAIL -> stringResource(R.string.email_error)
        TextFieldType.DEFAULT -> ""
    }

    Column(
        modifier = modifier
    ) {
        if (labelText != null) {
            Text(
                text = labelText,
                style = labelTextStyle
            )
            Spacer(Modifier.height(6.dp))
        }
        OutlinedTextField(
            value = text,
            onValueChange = { text ->
                isError = when (type) {
                    TextFieldType.USERNAME -> text.length < 3
                    TextFieldType.PASSWORD -> {
                        !(text.length > 8 && text.contains("[0-9]".toRegex()))
                    }
                    TextFieldType.EMAIL -> !Patterns.EMAIL_ADDRESS.matcher(text).matches()
                    TextFieldType.DEFAULT -> true
                }
                onValueChange(text)
            },
            isError = isError,
            visualTransformation = if (isPassword && !isPasswordVisible) {
                PasswordVisualTransformation('*')
            } else VisualTransformation.None,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                focusedBorderColor = if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
                focusedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                unfocusedBorderColor = Color.Transparent,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                cursorColor = MaterialTheme.colorScheme.primary
            ),
            shape = RoundedCornerShape(12.dp),
            placeholder = {
                Text(
                    text = hintText,
                    style = MaterialTheme.typography.bodyLarge
                )
            },
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            trailingIcon = {
                if (isPassword) {
                    IconButton(
                        onClick = {
                            isPasswordVisible = !isPasswordVisible
                        }
                    ) {
                        if (!isPasswordVisible) {
                            Icon(
                                imageVector = Icons.Outlined.Visibility,
                                contentDescription = "Hide password",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Outlined.VisibilityOff,
                                contentDescription = "Show password",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            },
            supportingText = {
                if (isError) {
                    Text(
                        text = errorText.toString(),
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall
                    )
                } else {
                    ""
                }
            },
            modifier = Modifier.fillMaxWidth()
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
            isPassword = true,
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
        )
    }
}