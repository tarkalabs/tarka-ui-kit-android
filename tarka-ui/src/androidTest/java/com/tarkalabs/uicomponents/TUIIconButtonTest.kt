import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.tarkalabs.tarkaui.icons.Delete24
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.uicomponents.components.base.TUIIconButton
import com.tarkalabs.uicomponents.components.base.TUIIconButtonTags
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIIconButtonTest {
  @get:Rule val composable = createComposeRule()

  private val tags = TUIIconButtonTags(parentTag = "testTag")

  @Test fun icon_Button_Displayed() {
    composable.setContent {
      TUIIconButton(icon = TarkaIcons.Regular.Delete24, tags = tags) {}
    }
    composable.onNodeWithTag(tags.parentTag).assertIsDisplayed()
  }

  @Test fun icon_Button_Click_Triggered() {
    val onClick: () -> Unit = mock()

    composable.setContent {
      TUIIconButton(icon = TarkaIcons.Regular.Delete24, tags = tags, onIconClick = onClick)
    }
    composable.onNodeWithTag(tags.parentTag).performClick()

    verify(onClick).invoke()
  }
}