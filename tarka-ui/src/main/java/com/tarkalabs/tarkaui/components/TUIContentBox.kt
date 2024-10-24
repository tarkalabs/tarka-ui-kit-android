package com.tarkalabs.tarkaui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.icons.ChevronRight24
import com.tarkalabs.tarkaui.icons.TarkaIcons.Regular
import com.tarkalabs.tarkaui.theme.TUITheme

/**
 * This Composable function is used to Show the content box in a list to pick the particular from User.
 *
 * @param modifier - used to modify the properties, behaviours of composes.
 * @param title - title of the ContentBox.
 * @param onContentBoxClicked - lambda block which will be invoked while clicking this ContentBox.
 *
 * */

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TUIContentBox(
    modifier: Modifier = Modifier,
    title: String,
    tags: TUIContentBoxTags = TUIContentBoxTags(),
    onContentBoxClicked: () -> Unit
) {
    Row(
        modifier = modifier
            .background(color = TUITheme.colors.surface)
            .testTag(tags.title)
            .semantics { testTagsAsResourceId = true }
            .clickable {
                onContentBoxClicked()
            }
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = title,
            color = TUITheme.colors.inputText,
            style = TUITheme.typography.heading6
        )
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        ) {
            Icon(
                modifier = Modifier
                    .align(Alignment.End)
                    .size(24.dp),
                painter = painterResource(id = Regular.ChevronRight24.iconRes),
                contentDescription = Regular.ChevronRight24.contentDescription,
                tint = TUITheme.colors.utilityOutline
            )
        }
    }
}

data class TUIContentBoxTags(
    val title: String = "TUIContentBox_Title"
)

@Preview
@Composable
private fun ContentBoxPreview() {
    TUITheme {
        TUIContentBox(title = "text") {}
    }
}