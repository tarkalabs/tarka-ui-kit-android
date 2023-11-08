import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsNotFocused
import androidx.compose.ui.test.assertIsToggleable
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.tarkalabs.uicomponents.components.TUIDraggableCard
import com.tarkalabs.uicomponents.components.TUIDraggableCardTags
import com.tarkalabs.uicomponents.components.TUIToggleSwitchTags
import org.junit.Rule
import org.junit.Test

class TUIDraggableCardTest {
  @get:Rule val composable = createComposeRule()

  private val tags = TUIDraggableCardTags(parentTag = "testTag")

  @Test fun is_passed_things_shown() {
    val testTitle = "test"
    val initialSwitchState = false
    composable.setContent {
      TUIDraggableCard(
        trailIconModifier = Modifier,
        onSwitchCheckChange = {},
        switchCheckedState = initialSwitchState,
        title = testTitle
      )
    }
    composable.onNodeWithTag(tags.titleTag).assertTextEquals(testTitle)
    composable.onNodeWithTag(TUIToggleSwitchTags().parentTag).assertIsToggleable()
    composable.onNodeWithTag(TUIToggleSwitchTags().parentTag).assertIsNotFocused()
  }
}