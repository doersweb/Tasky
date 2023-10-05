import androidx.navigation.NavController
import com.doersweb.tasky.core.util.UiEvent

fun NavController.navigate(uiEvent: UiEvent.NavigateTo) {
    this.navigate(uiEvent.route)
}