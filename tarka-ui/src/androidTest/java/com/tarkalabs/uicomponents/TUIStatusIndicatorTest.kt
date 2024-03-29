import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.tarkalabs.tarkaui.components.TUIStatus.ON
import com.tarkalabs.tarkaui.components.TUIStatusIndicator
import com.tarkalabs.tarkaui.components.TUIStatusIndicatorTags
import org.junit.Rule
import org.junit.Test

class TUIStatusIndicatorTest {
  @get:Rule val composable = createComposeRule()

  var tags = TUIStatusIndicatorTags(parentTag = "TAGS")
  @Test fun status_Displayed() {
    composable.setContent {
      TUIStatusIndicator(text = "Connected", status = ON, tags = tags)
    }
    composable.onNodeWithTag("TAGS").assertIsDisplayed()
    composable.onNodeWithText("Connected").assertIsDisplayed()
  }
}