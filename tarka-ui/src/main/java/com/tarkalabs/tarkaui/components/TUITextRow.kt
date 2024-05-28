package com.tarkalabs.tarkaui.components

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.R
import com.tarkalabs.tarkaui.components.TextRowStyle.DateStyle
import com.tarkalabs.tarkaui.components.TextRowStyle.Title
import com.tarkalabs.tarkaui.components.TextRowStyle.TitleWithDescription
import com.tarkalabs.tarkaui.components.TextRowStyle.TitleWithNotAvailable
import com.tarkalabs.tarkaui.components.base.IconButtonStyle.Ghost
import com.tarkalabs.tarkaui.components.base.TUIIconButton
import com.tarkalabs.tarkaui.components.base.TUIIconButtonTags
import com.tarkalabs.tarkaui.icons.Circle24
import com.tarkalabs.tarkaui.icons.TarkaIcon
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.theme.TUITheme

/**
 * A composable function that represents a text row in a UI.
 * It displays a title, a description, and optional icons, button, and info icon.
 *
 * @param modifier: The modifier to apply to the row.
 * @param iconOne: The optional first icon to display.
 * @param iconTwo: The optional second icon to display.
 * @param buttonTitle: The optional title for the button.
 * @param infoIcon: The optional info icon to display.
 * @param onIconOneClick: The callback function when the first icon is clicked.
 * @param onIconTwoClick: The callback function when the second icon is clicked.
 * @param onButtonClick: The callback function when the button is clicked.
 * @param onInfoIconClick: The callback function when the info icon is clicked.
 * @param onTextRowClick: The callback function when the text row is clicked.
 * @param paddingValues: The padding values to apply to the row.
 * @param tags: The tags for the component.
 *
 * The TUITextRow composable function creates a row that represents a text item in a UI.
 * It handles click events and provides callback functions for customization. The row displays
 * a title and a description. It can also include optional icons, a button, and an info icon.
 * The appearance and behavior of the row can be modified using the provided modifiers and callbacks.
 *
 * Example usage:
 *
 * TUITextRow(
 *   title = "Account",
 *   description = "Manage your account settings",
 *   iconOne = TarkaIcons.Settings,
 *   onIconOneClick = { /* Handle icon one click event */ },
 *   buttonTitle = "Edit",
 *   onButtonClick = { /* Handle button click event */ },
 *   onTextRowClick = { /* Handle text row click event */ }
 * )
 *
 */

@Composable
fun TUITextRow(
    modifier: Modifier = Modifier,
    title: String,
    style: TextRowStyle = Title,
    iconOne: TarkaIcon? = null,
    iconTwo: TarkaIcon? = null,
    buttonTitle: String? = null,
    infoIcon: TarkaIcon? = null,
    onIconOneClick: () -> Unit = {},
    onIconTwoClick: () -> Unit = {},
    onButtonClick: () -> Unit = {},
    onInfoIconClick: (() -> Unit)? = {},
    onTextRowClick: (() -> Unit)? = null,
    menuItemList: List<TUIPopUpMenu>? = null,
    onMenuItemClick: ((TUIPopUpMenu) -> Unit)? = null,
    paddingValues: PaddingValues = PaddingValues(),
    tags: TUITextRowTags = TUITextRowTags(),
) {

    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier
            .defaultMinSize(minHeight = 40.dp)
            .testTag(tags.parentTag)
            .then(if (onTextRowClick == null) Modifier else Modifier.clickable { onTextRowClick() })
            .padding(paddingValues),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1f)) {
            when (style) {
                is TitleWithDescription -> {
                    TUITextRowTitleWithDescription(title, style)
                }

                is Title -> {
                    TUITextRowTitle(title)
                }

                is DateStyle -> {
                    TUIDateStyle(title, style)
                }

                is TitleWithNotAvailable -> {
                    TUITextRowTitleWithNotAvailable(title, style)
                }
            }

        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (iconOne != null) TUIIconButton(
                icon = iconOne,
                onIconClick = onIconOneClick,
                iconButtonStyle = Ghost,
                tags = tags.iconOneTags
            )
            if (iconTwo != null) TUIIconButton(
                icon = iconTwo,
                onIconClick = onIconTwoClick,
                iconButtonStyle = Ghost,
                tags = tags.iconTwoTags

            )
            if (buttonTitle != null) {
                OutlinedButton(
                    modifier = Modifier
                        .height(40.dp)
                        .width(90.dp)
                        .testTag(tags.buttonTag),
                    onClick = onButtonClick
                ) {
                    Text(text = buttonTitle)
                }
            }
            if (infoIcon != null) {
                Box(modifier = Modifier.wrapContentSize(Alignment.BottomEnd)) {
                    Icon(
                        painter = painterResource(id = infoIcon.iconRes),
                        contentDescription = infoIcon.contentDescription,
                        tint = TUITheme.colors.utilityOutline,
                        modifier = Modifier
                            .then(
                                if (onInfoIconClick == null && menuItemList.isNullOrEmpty()) Modifier else Modifier.clickable(
                                    onClick = {
                                        if (!menuItemList.isNullOrEmpty()) {
                                            expanded = !expanded
                                        } else {
                                            onInfoIconClick?.invoke()
                                        }
                                    })
                            )
                            .height(40.dp)
                            .width(24.dp)
                            .testTag(tags.infoIconTag)
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .background(TUITheme.colors.surface)
                            .align(Alignment.TopEnd),
                    ) {
                        menuItemList?.forEach { item ->
                            TUIMobileOverlayMenuItem(
                                title = stringResource(id = item.title),
                                isSelected = false,
                                style = MobileOverlayMenuItemStyle.Title,
                                onMobileOverlayMenuItemClick = {
                                    expanded = false
                                    onMenuItemClick?.invoke(item)
                                },
                                modifier = Modifier.defaultMinSize(minWidth = 160.dp),
                                leadingContent = MobileOverlayMenuItemLeadingContentType.Icon(item.icon)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TUIDateStyle(
    title: String,
    style: DateStyle,
) {
    Text(
        text = title,
        style = TUITheme.typography.body8,
        color = TUITheme.colors.inputTextDim
    )
    VerticalSpacer(space = 4)
    Box(modifier = Modifier) {
        val color = TUITheme.colors.utilityOutline
        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(4f, 4f), 0f)
        Canvas(
            Modifier
                .width(0.dp)
                .height(5.dp)
                .align(Alignment.CenterStart)
        ) {
            drawLine(
                color = color,
                start = Offset(16f, -2f),
                end = Offset(16f, 20f),
                pathEffect = pathEffect
            )
        }
        Column(modifier = Modifier) {
            Row {
                Icon(
                    painter = painterResource(id = TarkaIcons.Regular.Circle24.iconRes),
                    contentDescription = TarkaIcons.Regular.Circle24.contentDescription,
                    modifier = Modifier
                        .height(18.dp)
                        .width(12.dp)
                        .align(Alignment.CenterVertically),
                    tint = TUITheme.colors.utilityOutline
                )
                if (style.startDate == null) {
                    Text(
                        text = stringResource(id = style.primaryNotAvailableText),
                        style = TUITheme.typography.body7,
                        color = TUITheme.colors.utilityDisabledContent,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                } else {
                    Text(
                        text = style.startDate,
                        style = TUITheme.typography.body7,
                        color = TUITheme.colors.onSurface,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

            }
            Row {
                Icon(
                    painter = painterResource(id = TarkaIcons.Regular.Circle24.iconRes),
                    contentDescription = TarkaIcons.Regular.Circle24.contentDescription,
                    modifier = Modifier
                        .height(18.dp)
                        .width(12.dp)
                        .align(Alignment.CenterVertically),
                    tint = TUITheme.colors.utilityOutline
                )
                if (style.endDate == null) {
                    Text(
                        text = stringResource(id = style.primaryNotAvailableText),
                        style = TUITheme.typography.body7,
                        color = TUITheme.colors.utilityDisabledContent,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                } else {
                    Text(
                        text = style.endDate,
                        style = TUITheme.typography.body7,
                        color = TUITheme.colors.onSurface,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
        }

    }
}

@Composable
private fun TUITextRowTitle(title: String) {
    Text(
        text = title,
        style = TUITheme.typography.heading7,
        color = TUITheme.colors.onSurface
    )
}

@Composable
private fun TUITextRowTitleWithDescription(title: String, style: TitleWithDescription) {
    Text(
        text = title,
        style = TUITheme.typography.body8,
        color = TUITheme.colors.onSurface.copy(alpha = 0.7f)
    )
    VerticalSpacer(space = 4)
    Text(
        text = style.description,
        style = TUITheme.typography.body7,
        color = TUITheme.colors.onSurface
    )
}

@Composable
private fun TUITextRowTitleWithNotAvailable(
    title: String, style: TitleWithNotAvailable
) {
    Text(
        text = title,
        style = TUITheme.typography.body8,
        color = TUITheme.colors.onSurface.copy(alpha = 0.7f)
    )
    VerticalSpacer(space = 4)
    Text(
        text = style.text,
        style = TUITheme.typography.body7,
        color = TUITheme.colors.utilityDisabledContent
    )
}

sealed class TextRowStyle {
    data class TitleWithDescription(val description: String) : TextRowStyle()

    data class DateStyle(
        val startDate: String? = "",
        val endDate: String? = "",
        @StringRes val primaryNotAvailableText: Int = R.string.not_availble,
    ) : TextRowStyle()

    data class TitleWithNotAvailable(val text: String) : TextRowStyle()

    object Title : TextRowStyle()
}

interface TUIPopUpMenu {
    @get:StringRes
    val title: Int
    val icon: TarkaIcon
}

data class TUITextRowTags(
    val parentTag: String = "TUITextRow",
    val iconOneTags: TUIIconButtonTags = TUIIconButtonTags(parentTag = "TUITextRow_IconOne"),
    val iconTwoTags: TUIIconButtonTags = TUIIconButtonTags(parentTag = "TUITextRow_IconTwo"),
    val buttonTag: String = "TUITextRow_Button",
    val infoIconTag: String = "TUITextRow_InfoIcon",
)

@Preview(showBackground = true)
@Composable
fun TUITextRowPreview() {

    TUITextRow(
        title = "Duration", style = DateStyle(
            null, "Jan 20 3000 friday march 32"
        ), onTextRowClick = {
            Log.d("TAG", "TUITextRowPreview: ")
        }, onInfoIconClick = null
    )
}
