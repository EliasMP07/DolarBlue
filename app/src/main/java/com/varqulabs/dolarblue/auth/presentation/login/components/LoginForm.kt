package com.varqulabs.dolarblue.auth.presentation.login.components

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.varqulabs.dolarblue.R
import com.varqulabs.dolarblue.auth.presentation.login.LoginEvent
import com.varqulabs.dolarblue.auth.presentation.login.LoginState
import com.varqulabs.dolarblue.core.presentation.desingsystem.components.DolarBlueActionButton
import com.varqulabs.dolarblue.core.presentation.desingsystem.components.DolarBluePasswordTextField
import com.varqulabs.dolarblue.core.presentation.desingsystem.components.DolarBlueTextField

@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
    context: Context,
    state: LoginState,
    eventHandler: (LoginEvent) -> Unit
){

    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
    ){

        DolarBlueTextField(
            state = state.email,
            error = state.emailError?.asString(context),
            startIcon = null,
            endIcon = null,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Next)
                }
            ),
            onTextChange = {
                eventHandler(LoginEvent.OnEmailChange(it))
            },
            title = stringResource(R.string.title_email_field)
        )

        Spacer(modifier = Modifier.height(20.dp))

        DolarBluePasswordTextField(
            state = state.password,
            startIcon = null,
            isClickableText = {

            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            error = state.passwordError?.asString(context),
            additionalInfo = stringResource(R.string.text_forgot_password),
            onTextChange = {
                eventHandler(LoginEvent.OnPasswordChange(it))
            },
            title = stringResource(R.string.title_password_field)
        )

        Spacer(modifier = Modifier.height(20.dp))

        DolarBlueActionButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            text = stringResource(R.string.text_button_login),
            onClick = {
                eventHandler(LoginEvent.OnClickLogin)
            }
        )

    }

}