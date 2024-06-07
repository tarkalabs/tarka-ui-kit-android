package com.tarkalabs.tarkaui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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


@Composable
fun TUIAppBottomBar(
    modifier: Modifier = Modifier,
    itemIconOne: TarkaIcon? = null,
    itemIconTwo: TarkaIcon? = null,
    itemIconThree: TarkaIcon? = null,
    itemIconFour: TarkaIcon? = null,
    itemIconFive: TarkaIcon? = null,
    temIconSix: TarkaIcon? = null,
    onFirstItemClicked: () -> Unit = {},
    onSecondItemClicked: () -> Unit = {},
    onThirdItemClicked: () -> Unit = {},
    onFourthItemClicked: () -> Unit = {},
    onFifthItemClicked: () -> Unit = {},
    onSixthItemClicked: () -> Unit = {},
    tags: TUIAppBottomBarTag = TUIAppBottomBarTag(),
    color: Color = Color.Transparent,
) {

    Column(
        modifier = modifier
            .background(color = TUITheme.colors.surface)
            .fillMaxWidth()
            .sizeIn(maxHeight = 64.dp)
            .wrapContentHeight(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BottomAppBar(
            containerColor = color,
            modifier = Modifier.fillMaxWidth(),
            actions = {

                if (itemIconOne != null) {
                    TUIIconButton(
                        modifier = Modifier.weight(1f),
                        onIconClick = {
                            onFirstItemClicked()
                        },
                        tags = tags.itemIconOneTags,
                        icon = itemIconOne,
                        iconButtonStyle = IconButtonStyle.Ghost,
                        buttonSize = IconButtonSize.XL
                    )
                }

                if (itemIconTwo != null) {
                    TUIIconButton(
                        modifier = Modifier
                            .weight(1f),
                        icon = itemIconTwo, tags = tags.itemIconThreeTags,
                        iconButtonStyle = IconButtonStyle.Ghost,
                        onIconClick = {
                            onSecondItemClicked()
                        },
                        buttonSize = IconButtonSize.XL
                    )
                }

                if (itemIconThree != null) {
                    TUIIconButton(
                        modifier = Modifier.weight(1f),
                        onIconClick = {
                            onThirdItemClicked()
                        },
                        icon = itemIconThree,
                        tags = tags.itemIconTwoTags,
                        iconButtonStyle = IconButtonStyle.Ghost,
                        buttonSize = IconButtonSize.XL
                    )
                }

                if (itemIconFour != null) {
                    TUIIconButton(
                        modifier = Modifier.weight(1f),
                        icon = itemIconFour,
                        tags = tags.itemIconThreeTags,
                        iconButtonStyle = IconButtonStyle.Ghost,
                        onIconClick = {
                            onFourthItemClicked()
                        },
                        buttonSize = IconButtonSize.XL
                    )
                }

                if (itemIconFive != null) {
                    TUIIconButton(
                        modifier = Modifier.weight(1f),
                        icon = itemIconFive,
                        tags = tags.itemIconThreeTags,
                        iconButtonStyle = IconButtonStyle.Ghost,
                        onIconClick = {
                            onFifthItemClicked()
                        },
                        buttonSize = IconButtonSize.XL
                    )
                }

                if (temIconSix != null) {
                    TUIIconButton(
                        modifier = Modifier.weight(1f),
                        icon = temIconSix,
                        tags = tags.itemIconThreeTags,
                        iconButtonStyle = IconButtonStyle.Ghost,
                        onIconClick = {
                            onSixthItemClicked()
                        },
                        buttonSize = IconButtonSize.XL
                    )
                }
            }
        )
        TUIDivider()

    }

}


data class TUIAppBottomBarTag(
    val itemIconOneTags: TUIIconButtonTags = TUIIconButtonTags(parentTag = "TUITopBar_itemIconOne"),
    val itemIconTwoTags: TUIIconButtonTags = TUIIconButtonTags(parentTag = "TUITopBar_itemIconTwo"),
    val itemIconThreeTags: TUIIconButtonTags = TUIIconButtonTags(parentTag = "TUITopBar_itemIconThree"),
    val itemIconFourTags: TUIIconButtonTags = TUIIconButtonTags(parentTag = "TUITopBar_itemIconFour"),
    val itemIconFiveTags: TUIIconButtonTags = TUIIconButtonTags(parentTag = "TUITopBar_itemIconFive"),
    val itemIconSixTags: TUIIconButtonTags = TUIIconButtonTags(parentTag = "TUITopBar_itemIconSix"),
)


@Preview
@Composable
fun EamNormalBottomBar(
) {
    TUITheme {
        Column {
            TUIAppBottomBar(
                itemIconOne = TarkaIcons.Regular.SelectObjectSkew24,
                itemIconTwo = TarkaIcons.Regular.Lasso24,
                itemIconThree = TarkaIcons.Regular.ArrowUndo24,
                itemIconFour = TarkaIcons.Regular.ArrowRedo24,
                itemIconFive = TarkaIcons.Regular.Delete24,
                temIconSix = TarkaIcons.Regular.Delete24,
            )
        }
    }
}

