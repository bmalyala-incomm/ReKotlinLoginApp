package com.example.RekotlinLoginApp.reducers

import com.example.RekotlinLoginApp.actions.LoginAction
import com.example.RekotlinLoginApp.state.AppState
import com.example.RekotlinLoginApp.state.AuthenticationState
import com.example.RekotlinLoginApp.state.LoggedInState
import tw.geothings.rekotlin.Action

fun loginReducer(action: Action, state: AppState?): AppState {
// if no state has been provided, create the default state
    var newstate = state ?: AppState(
        authenticationState = AuthenticationState(
            loggedInState = LoggedInState.notLoggedIn,
            userName = ""
        )
    )

    return newstate.copy(authenticationState = (::authenticationReducer)(action, newstate.authenticationState))
}
fun authenticationReducer(action: Action, state: AuthenticationState?): AuthenticationState {

    val newState =  state ?: AuthenticationState(LoggedInState.notLoggedIn,userName = "")
    when(action) {
        is LoginAction -> {
            println("inside login Reducer")
            if(action.userName.equals("team5")){
                return newState.copy(
                    loggedInState = LoggedInState.loggedIn,
                    userName = action.userName)
            } else{
                println("return notLoggedIn state user is not authenticated")
                return newState.copy(
                    loggedInState = LoggedInState.notLoggedIn,
                    userName = action.userName)
            }
                      }
         }
    println("new state in reducer class:"+newState)
    return newState
    }

