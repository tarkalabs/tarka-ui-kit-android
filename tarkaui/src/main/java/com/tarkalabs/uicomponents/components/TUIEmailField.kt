package com.tarkalabs.uicomponents.components

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.DecorationBox
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.Tags
import com.tarkalabs.uicomponents.components.ChipType.Input
import com.tarkalabs.uicomponents.components.IconButtonStyle.GHOST
import com.tarkalabs.uicomponents.extentions.clickableWithoutRipple
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(
  ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class
) @Composable fun TUIEmailField(
  title: String,
  emailAddressList: List<String>,
  trailingIcon: TarkaIcon,
  tags: TUIEmailFieldTags = TUIEmailFieldTags(),
  trailingIconClick: () -> Unit,
  onItemRemoved: (Int) -> Unit,
  onItemAdd: (String) -> Unit,
) {

  var textData by remember {
    mutableStateOf("")
  }
  var showTextField by remember {
    mutableStateOf(false)
  }

  val focusRequester = remember { FocusRequester() }
  val scope = rememberCoroutineScope()
  Column(verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.clickableWithoutRipple {

      scope.launch {
        showTextField = !showTextField
        delay(100)
        focusRequester.requestFocus()
      }

    }

  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .testTag(tags.parentTag),
      verticalAlignment = Alignment.CenterVertically,
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
          verticalAlignment = Alignment.CenterVertically,
          maxItemsInEachRow = 3
        ) {
          emailAddressList.forEachIndexed { index, email ->
            TUIChip(modifier = Modifier
              .padding(2.dp)
              .testTag(email), type = Input(
              showTrailingDismiss = true, containerColor = TUITheme.colors.surfaceVariant
            ), label = email, tags = tags.chipTags, onClick = {

            }, onDismissClick = {
              onItemRemoved.invoke(index)
            })
          }
        }

        val colors = TextFieldDefaults.colors(
          focusedContainerColor = Color.Transparent,
          unfocusedContainerColor = Color.Transparent,
          focusedIndicatorColor = Color.Transparent,
          unfocusedIndicatorColor = Color.Transparent,
          disabledIndicatorColor = Color.Transparent,
          errorIndicatorColor = Color.Transparent,
          focusedTextColor = TUITheme.colors.inputText
        )
        val interactionSource = remember { MutableInteractionSource() }

        AnimatedVisibility(visible = showTextField) {
          BasicTextField(
            value = textData,
            onValueChange = {
              textData = it
            },
            keyboardActions = KeyboardActions(onDone = {
              onItemAdd.invoke(textData)
              textData = ""

            }),
            keyboardOptions = KeyboardOptions(
              keyboardType = KeyboardType.Email, imeAction = ImeAction.Done
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
                unfocusedIndicatorLineThickness = 1.dp,
              )
              .height(45.dp),
            enabled = true,
            singleLine = true,
            interactionSource = interactionSource,
            textStyle = TUITheme.typography.body7,
          ) {
            DecorationBox(
              value = textData,
              innerTextField = it,
              singleLine = true,
              enabled = true,
              visualTransformation = VisualTransformation.None,
              contentPadding = TextFieldDefaults.contentPaddingWithLabel(
                top = 0.dp, bottom = 0.dp, start = 0.dp, end = 0.dp
              ),
              interactionSource = interactionSource,
              colors = colors,
            )
          }

        }
      }

      TUIIconButton(
        icon = trailingIcon,
        onIconClick = trailingIconClick,
        iconButtonStyle = GHOST,
        tags = tags.iconButtonTag
      )
    }

    Divider(
      color = if(showTextField) TUITheme.colors.primary else TUITheme.colors.surfaceVariant,
      thickness = 2.dp,
      modifier = Modifier.padding(top = 10.dp)
    )


  }
}

data class TUIEmailFieldTags(
  val parentTag: String = Tags.EMAIL_FIELD_TAG,
  val textFieldTag: String = Tags.TEXT_FIELD_TAG,
  val flowRowTag: String = Tags.FLOW_ROW_TAG,
  val iconButtonTag: TUIIconButtonTags = TUIIconButtonTags(),
  val chipTags: TUIChipTags = TUIChipTags()
)

@Preview @Composable fun PreviewTUIEmailField() {
  TUITheme {
    val emailList = remember {
      mutableStateListOf(
        "mike32@soft.com",
        "mike.smith@corp.co",
        "mike32@soft.com",
      )
    }
    Box(modifier = Modifier.fillMaxWidth()) {
      TUIEmailField(title = "To",
        emailAddressList = emailList,
        trailingIcon = TarkaIcons.AddCircle24Regular,
        onItemRemoved = { position ->
          emailList.removeAt(position)
        },
        trailingIconClick = {

        },
        onItemAdd = {
          emailList.add(it)
        })

    }
  }
}