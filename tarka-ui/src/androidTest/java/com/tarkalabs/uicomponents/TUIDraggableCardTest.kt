import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.tarkalabs.tarkaui.components.card.TUIDraggableCard
import org.junit.Rule
import org.junit.Test

class TUIDraggableCardTest {
  @get:Rule val composable = createComposeRule()

  @Test fun is_passed_things_shown() {
    val testTitle = "test"
    val initialSwitchState = false
    composable.setContent {
      TUIDraggableCard(
        dragIconModifier = Modifier,
        onSwitchCheckedChange = {},
        switchCheckedState = initialSwitchState,
        title = testTitle,

      )
    }
    composable.onNodeWithText(testTitle).assertExists().assertIsDisplayed()
    // TODO: Ask mahendran about this line
    //composable.onNodeWithTag(TUIToggleSwitchTags().parentTag).assertIsToggleable().assertIsNotFocused()
  }
}