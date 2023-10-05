package com.doersweb.tasky.core.util

/**
 * This class is used to handle one time events.
 */
sealed class UiEvent {
    data class NavigateTo(val route: String): UiEvent()
    object NavigateUp: UiEvent()
}
