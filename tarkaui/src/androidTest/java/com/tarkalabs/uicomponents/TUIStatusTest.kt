import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.tarkalabs.uicomponents.components.TUIStatus
import org.junit.Rule
import org.junit.Test

class TUIStatusTest {
  @get:Rule val composable = createComposeRule()


  @Test fun status_Displayed() {
    composable.setContent {
      TUIStatus(text = "Connected", status = true,testTag = "TAGS")
    }
    composable.onNodeWithTag("TAGS").assertIsDisplayed()
    composable.onNodeWithText("Connected").assertIsDisplayed()
  }
}