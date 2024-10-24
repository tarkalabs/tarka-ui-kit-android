package com.tarkalabs.tarkaui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.base.IconButtonSize
import com.tarkalabs.tarkaui.components.base.IconButtonStyle
import com.tarkalabs.tarkaui.components.base.TUIIconButton
import com.tarkalabs.tarkaui.components.base.TUIIconButtonTags
import com.tarkalabs.tarkaui.icons.ArrowRedo24
import com.tarkalabs.tarkaui.icons.ArrowUndo24
import com.tarkalabs.tarkaui.icons.Lasso24
import com.tarkalabs.tarkaui.icons.SelectObjectSkew24
import com.tarkalabs.tarkaui.icons.TarkaIcon
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.theme.TUITheme

/**   Displays a customized bottom app bar with listOfIcons,onClickEvent.
 *
 * @param modifier The modifier to customize the TUIAppBottomBar container.
 * @param tags Tags for customizing test accessibility.
 * @param onClickEvent The callback function to be invoked when the icon is clicked.
 * @param icons for providing list of icons to be displayed in bottom bar.
 *  Note : icon and tags should not exceed more 6
 *
 * * How to use TUIAppBottomBar()
 *   TUIAppBottomBar(
 *     icons = pass the list of icons
 *     onClickEvent = { event -> Handle event click based on the icon index}
 *       )
 */

@Composable
fun TUIAppBottomBar(
    modifier: Modifier = Modifier,
    icons: List<TarkaIcon>,
    defaultSelectedItem: Int,
    onClickEvent: (index: Int) -> Unit,
    tags: List<TUIIconButtonTags> = emptyList()
) {
    require(icons.isNotEmpty()) { "icon should not empty" }

    require(defaultSelectedItem < 6 && icons.size <= 6) { "icon and tags should not exceed more 6" }

    var selectedIconIndex by remember { mutableIntStateOf(defaultSelectedItem) }
    var isFirstSelected by remember { mutableStateOf(true) }
    Row(
        modifier = modifier
            .background(color = TUITheme.colors.surface)
            .fillMaxWidth()
            .height(64.dp)
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        icons.forEachIndexed { index, icon ->
            val isIconSelected = index == selectedIconIndex
            Box(
                modifier = Modifier.padding(8.dp)
            ) {
                TUIIconButton(
                    modifier = Modifier.wrapContentSize(),
                    icon = icon,
                    onIconClick = {
                        if (index == selectedIconIndex) {
                            isFirstSelected = false
                        } else {
                            selectedIconIndex = index
                        }
                        onClickEvent(if (isIconSelected) -1 else index)
                    },
                    tags = if (icons.size == tags.size) {
                        tags[index]
                    } else {
                        TUIIconButtonTags()
                    },
                    iconButtonStyle = if (isIconSelected) {
                        IconButtonStyle.Secondary
                    } else {
                        IconButtonStyle.Ghost
                    },
                    buttonSize = IconButtonSize.XL
                )
            }
        }
    }
    TUIDivider()
}

@Preview
@Composable
private fun EamNormalBottomBarPreview() {
    TUITheme {
        Column {
            TUIAppBottomBar(
                icons = listOf(
                    TarkaIcons.Regular.SelectObjectSkew24,
                    TarkaIcons.Regular.Lasso24,
                    TarkaIcons.Regular.ArrowUndo24,
                    TarkaIcons.Regular.ArrowRedo24,
                    TarkaIcons.Regular.ArrowRedo24,
                    TarkaIcons.Regular.ArrowRedo24
                ),
                onClickEvent = { index ->
                    when (index) {
                        0 -> Log.d("test", "1 item clicked")
                        1 -> Log.d("test", "2 item clicked")
                        2 -> Log.d("test", "3 item clicked")
                        3 -> Log.d("test", "4item clicked")
                    }
                },
                defaultSelectedItem = 5
            )
            VerticalSpacer(space = 16)

            TUIAppBottomBar(
                icons = listOf(
                    TarkaIcons.Regular.SelectObjectSkew24,
                    TarkaIcons.Regular.Lasso24,
                    TarkaIcons.Regular.ArrowUndo24,
                    TarkaIcons.Regular.ArrowRedo24,
                    TarkaIcons.Regular.ArrowRedo24
                ),
                onClickEvent = { index ->
                    when (index) {
                        0 -> Log.d("test", "1 item clicked")
                        1 -> Log.d("test", "2 item clicked")
                        2 -> Log.d("test", "3 item clicked")
                        3 -> Log.d("test", "4item clicked")
                    }
                },
                tags = listOf(
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconOne"),
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconTwo"),
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconThree"),
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconFour"),
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconFive")
                ),
                defaultSelectedItem = 3
            )
            VerticalSpacer(space = 16)
            TUIAppBottomBar(
                icons = listOf(
                    TarkaIcons.Regular.SelectObjectSkew24,
                    TarkaIcons.Regular.Lasso24,
                    TarkaIcons.Regular.ArrowUndo24,
                    TarkaIcons.Regular.ArrowRedo24
                ),
                onClickEvent = { index ->
                    when (index) {
                        0 -> Log.d("test", "1 item clicked")
                        1 -> Log.d("test", "2 item clicked")
                        2 -> Log.d("test", "3 item clicked")
                        3 -> Log.d("test", "4item clicked")
                    }
                },
                tags = listOf(
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconOne"),
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconTwo"),
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconThree"),
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconFour")
                ),
                defaultSelectedItem = -1
            )
            VerticalSpacer(space = 16)
            TUIAppBottomBar(
                icons = listOf(
                    TarkaIcons.Regular.SelectObjectSkew24,
                    TarkaIcons.Regular.Lasso24,
                    TarkaIcons.Regular.ArrowUndo24
                ),
                onClickEvent = { index ->
                    when (index) {
                        0 -> Log.d("test", "1 item clicked")
                        1 -> Log.d("test", "2 item clicked")
                        2 -> Log.d("test", "3 item clicked")
                        3 -> Log.d("test", "4item clicked")
                    }
                },
                tags = listOf(
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconOne"),
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconTwo"),
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconThree")
                ),
                defaultSelectedItem = 3
            )
            VerticalSpacer(space = 16)
            TUIAppBottomBar(
                icons = listOf(
                    TarkaIcons.Regular.SelectObjectSkew24,
                    TarkaIcons.Regular.Lasso24
                ),
                onClickEvent = { index ->
                    when (index) {
                        0 -> Log.d("test", "1 item clicked")
                        1 -> Log.d("test", "2 item clicked")
                        2 -> Log.d("test", "3 item clicked")
                        3 -> Log.d("test", "4item clicked")
                    }
                },
                tags = listOf(
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconOne"),
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconTwo")
                ),
                defaultSelectedItem = 3
            )
            VerticalSpacer(space = 16)
            TUIAppBottomBar(
                icons = listOf(
                    TarkaIcons.Regular.SelectObjectSkew24
                ),
                onClickEvent = { index ->
                    when (index) {
                        0 -> Log.d("test", "1 item clicked")
                        1 -> Log.d("test", "2 item clicked")
                        2 -> Log.d("test", "3 item clicked")
                        3 -> Log.d("test", "4item clicked")
                    }
                },
                tags = listOf(
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconOne")
                ),
                defaultSelectedItem = 3
            )
        }
    }
}