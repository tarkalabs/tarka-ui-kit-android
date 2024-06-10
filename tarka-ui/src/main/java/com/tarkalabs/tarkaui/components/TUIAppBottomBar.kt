package com.tarkalabs.tarkaui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.base.IconButtonSize
import com.tarkalabs.tarkaui.components.base.IconButtonStyle
import com.tarkalabs.tarkaui.components.base.TUIIconButton
import com.tarkalabs.tarkaui.components.base.TUIIconButtonTags
import com.tarkalabs.tarkaui.icons.ArrowRedo24
import com.tarkalabs.tarkaui.icons.ArrowUndo24
import com.tarkalabs.tarkaui.icons.Delete24
import com.tarkalabs.tarkaui.icons.Lasso24
import com.tarkalabs.tarkaui.icons.SelectObjectSkew24
import com.tarkalabs.tarkaui.icons.TarkaIcon
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.theme.TUITheme


sealed class BottomBarClickEvent(val index: Int) {
    class ItemClick(index: Int) : BottomBarClickEvent(index)
}


/**   Displays a customized bottom app bar with listOfIcons,onClickEvent.
 *
 * @param modifier The modifier to customize the TUIAppBottomBar container.
 * @param tags Tags for customizing test accessibility.
 * @param onClickEvent The callback function to be invoked when the icon is clicked.
 * @param icons for providing list of icons to be displayed in bottom bar.
 * @param color: the colors to be applied to the bottom app bar.
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
    icons: List<TarkaIcon?> = emptyList(),
    onClickEvent: (BottomBarClickEvent) -> Unit = {},
    tags: List<TUIIconButtonTags> = emptyList(),
    color: Color = Color.Transparent,
) {
    Column(
        modifier = modifier
            .background(color = TUITheme.colors.surface)
            .fillMaxWidth()
            .sizeIn(maxHeight = 64.dp)
            .wrapContentHeight()
    ) {
        BottomAppBar(
            containerColor = color,
            modifier = Modifier.fillMaxWidth(),
            actions = {
                icons.forEachIndexed { index, icon ->
                    icon?.let {
                        TUIIconButton(
                            modifier = Modifier.weight(1f),
                            icon = it,
                            onIconClick = { onClickEvent(BottomBarClickEvent.ItemClick(index)) },
                            tags = tags[index],
                            iconButtonStyle = IconButtonStyle.Ghost,
                            buttonSize = IconButtonSize.XL
                        )
                    }
                }
            }
        )
        TUIDivider()
    }
}

@Preview
@Composable
fun EamNormalBottomBar() {
    TUITheme {
        Column {
            TUIAppBottomBar(
                icons = listOf(
                    TarkaIcons.Regular.SelectObjectSkew24,
                    TarkaIcons.Regular.Lasso24,
                    TarkaIcons.Regular.ArrowUndo24,
                    TarkaIcons.Regular.ArrowRedo24,
                    TarkaIcons.Regular.Delete24,
                ),
                onClickEvent = { event ->
                    when (event.index) {
                        0 -> Log.d("test", "1 item clicked")
                        1 -> Log.d("test", "2 item clicked")
                        2 -> Log.d("test", "3 item clicked")
                        3 -> Log.d("test", "4item clicked")
                        4 -> Log.d("test", "5 item clicked")

                    }
                },
                tags = listOf(
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconOne"),
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconTwo"),
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconThree"),
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconFour"),
                    TUIIconButtonTags(parentTag = "TUITopBar_itemIconFive"),
                )
            )
        }
    }
}
