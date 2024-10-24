package com.tarkalabs.tarkaui.components.email

import android.util.Patterns
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.DecorationBox
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.ChipType.Input
import com.tarkalabs.tarkaui.components.TUIChip
import com.tarkalabs.tarkaui.components.TUIChipTags
import com.tarkalabs.tarkaui.components.TUIDivider
import com.tarkalabs.tarkaui.components.base.IconButtonStyle.Ghost
import com.tarkalabs.tarkaui.components.base.TUIIconButton
import com.tarkalabs.tarkaui.components.base.TUIIconButtonTags
import com.tarkalabs.tarkaui.extentions.clickableWithoutRipple
import com.tarkalabs.tarkaui.icons.AddCircle24
import com.tarkalabs.tarkaui.icons.Dismiss20
import com.tarkalabs.tarkaui.icons.TarkaIcon
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.icons.TarkaIcons.Filled
import com.tarkalabs.tarkaui.theme.TUITheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * A composable function that represents an email field style.
 * @param modifier The modifier to be applied to the composable.
 * @param title The title text to be displayed above the email field.
 * @param emailAddressList The list of email addresses to be displayed as chips.
 * @param trailingIcon The icon to be displayed at the end of the email field.
 * @param tags The tags to be used for testing.
 * @param trailingIconClick The callback function to be invoked when the trailing icon is clicked.
 * @param onItemRemoved The callback function to be invoked when a chip is removed.
 * @param onItemAdd The callback function to be invoked when a new email is added.
 * @param onInvalidEmail The callback function to be invoked when user enter a invalid email address.
 */
@OptIn(
  ExperimentalLayoutApi::class,
  ExperimentalMaterial3Api::class
)
@Composable
fun TUIEmailField(
  modifier: Modifier = Modifier,
  title: String,
  emailAddressList: ImmutableList<String>,
  trailingIcon: TarkaIcon,
  tags: TUIEmailFieldTags = TUIEmailFieldTags(),
  trailingIconClick: () -> Unit,
  onItemRemoved: (Int) -> Unit,
  onItemAdd: (String) -> Unit,
  onInvalidEmail: () -> Unit,
  showTextField: Boolean = false,
  toggleTextFieldVisibility: () -> Unit = {}
) {
  var textData by rememberSaveable {
    mutableStateOf("")
  }

  val focusRequester = remember { FocusRequester() }
  val scope = rememberCoroutineScope()
  val interactionSource = remember { MutableInteractionSource() }

  Column(
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier
      .testTag(tags.parentTag)
      .clickableWithoutRipple {
        scope.launch {
          toggleTextFieldVisibility.invoke()
          delay(100)
          if (showTextField) {
            focusRequester.requestFocus()
          }
        }
      }

  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth(),
      verticalAlignment = Alignment.Top
    ) {
      Text(
        text = title,
        style = TUITheme.typography.body7,
        color = TUITheme.colors.utilityOutline,
        modifier = Modifier.padding(15.dp)
      )
      Column(
        modifier = Modifier.weight(1f)
      ) {
        FlowRow(
          modifier = Modifier.testTag(tags.flowRowTag),
          horizontalArrangement = Arrangement.Start,
          verticalArrangement = Arrangement.Center,
          maxItemsInEachRow = 3
        ) {
          emailAddressList.forEachIndexed { index, email ->
            TUIChip(
              modifier = Modifier
                .padding(2.dp)
                .testTag(email),
              type = Input(
                trailingIcon = Filled.Dismiss20,
                containerColor = TUITheme.colors.surfaceVariant
              ),
              label = email,
              tags = tags.chipTags,
              onClick = {
              },
              onDismissClick = {
                onItemRemoved.invoke(index)
              }
            )
          }
        }

        val colors = TextFieldDefaults.colors(
          focusedContainerColor = Color.Transparent,
          unfocusedContainerColor = Color.Transparent,
          focusedIndicatorColor = Color.Transparent,
          unfocusedIndicatorColor = Color.Transparent,
          disabledIndicatorColor = Color.Transparent,
          errorIndicatorColor = Color.Transparent,
          focusedTextColor = TUITheme.colors.inputText,
          unfocusedTextColor = TUITheme.colors.inputText
        )

        AnimatedVisibility(visible = showTextField) {
          BasicTextField(
            value = textData,
            onValueChange = {
              textData = it
            },
            keyboardActions = KeyboardActions(onDone = {
              if (Patterns.EMAIL_ADDRESS.matcher(textData).matches()) {
                onItemAdd.invoke(textData)
                textData = ""
              } else {
                onInvalidEmail()
              }
            }),
            keyboardOptions = KeyboardOptions(
              keyboardType = KeyboardType.Email,
              imeAction = ImeAction.Done
            ),
            modifier = Modifier
              .fillMaxWidth()
              .focusRequester(focusRequester)
              .testTag(tags.textFieldTag)
              .indicatorLine(
                enabled = true,
                isError = false,
                colors = colors,
                interactionSource = interactionSource,
                focusedIndicatorLineThickness = 1.dp,
                unfocusedIndicatorLineThickness = 1.dp
              )
              .height(45.dp),
            enabled = true,
            singleLine = true,
            interactionSource = interactionSource,
            textStyle = TUITheme.typography.body7.copy(
              color = TUITheme.colors.inputText
            ),
            cursorBrush = SolidColor(TUITheme.colors.inputText)
          ) {
            DecorationBox(
              value = textData,
              innerTextField = it,
              singleLine = true,
              enabled = true,
              visualTransformation = VisualTransformation.None,
              contentPadding = TextFieldDefaults.contentPaddingWithLabel(
                top = 0.dp,
                bottom = 0.dp,
                start = 0.dp,
                end = 0.dp
              ),
              interactionSource = interactionSource,
              colors = colors
            )
          }
        }
      }

      TUIIconButton(
        icon = trailingIcon,
        onIconClick = trailingIconClick,
        iconButtonStyle = Ghost,
        tags = tags.iconButtonTag
      )
    }

    TUIDivider(
      color = if (showTextField) TUITheme.colors.primary else TUITheme.colors.surfaceVariant,
      thickness = if (showTextField) 2 else 1,
      modifier = Modifier.padding(top = 10.dp)
    )
  }
}

data class TUIEmailFieldTags(
  val parentTag: String = "TUIEmailField",
  val textFieldTag: String = "TUIEmailField_TextField",
  val flowRowTag: String = "TUIEmailField_Flowrow",
  val iconButtonTag: TUIIconButtonTags = TUIIconButtonTags(),
  val chipTags: TUIChipTags = TUIChipTags()
)

@Preview @Composable
private fun PreviewTUIEmailField() {
  TUITheme {
    val emailList = remember {
      mutableStateListOf<String>()
    }
    var showEditText by remember { mutableStateOf(false) }
    var showEditText2 by remember { mutableStateOf(false) }
    Column(modifier = Modifier.background(color = TUITheme.colors.surface)) {
      Box(modifier = Modifier.fillMaxWidth()) {
        TUIEmailField(
          title = "To",
          emailAddressList = emailList.toImmutableList(),
          trailingIcon = TarkaIcons.Regular.AddCircle24,
          onItemRemoved = { position ->
            emailList.removeAt(position)
          },
          trailingIconClick = {
          },
          onItemAdd = {
            emailList.add(it)
          },
          onInvalidEmail = {
          },
          showTextField = showEditText,
          toggleTextFieldVisibility = {
            showEditText = !showEditText
            showEditText2 = false
          }
        )
      }

      Box(modifier = Modifier.fillMaxWidth()) {
        TUIEmailField(
          title = "Cc",
          emailAddressList = emailList.toImmutableList(),
          trailingIcon = TarkaIcons.Regular.AddCircle24,
          onItemRemoved = { position ->
            emailList.removeAt(position)
          },
          trailingIconClick = {
          },
          onItemAdd = {
            emailList.add(it)
          },
          onInvalidEmail = {
          },
          showTextField = showEditText2,
          toggleTextFieldVisibility = {
            showEditText = false
            showEditText2 = !showEditText2
          }
        )
      }
      TextField(
        value = "",
        onValueChange = {
        },
        modifier = Modifier
          .fillMaxWidth()
          .padding(20.dp)
          .onFocusChanged {
            if (it.hasFocus) {
              showEditText = false
              showEditText2 = false
            }
          },
        label = { Text(text = "PlaceHolder") }
      )

      Button(
        onClick = {
          showEditText = true
          showEditText2 = false
        }
      ) {
        Text(text = "Field One")
      }

      Button(onClick = {
        showEditText = false
        showEditText2 = true
      }) {
        Text(text = "Field Two")
      }
    }
  }
}