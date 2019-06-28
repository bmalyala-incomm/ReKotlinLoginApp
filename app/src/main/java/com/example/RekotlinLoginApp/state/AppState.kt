package com.example.RekotlinLoginApp.state

import tw.geothings.rekotlin.StateType

data class AuthenticationState(var loggedInState: LoggedInState,
                               var userName: String): StateType

enum class LoggedInState {
    notLoggedIn,
    loggedIn
}
data class AppState(
    var authenticationState: AuthenticationState
): StateType