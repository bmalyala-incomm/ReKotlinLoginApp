package com.example.RekotlinLoginApp.actions

import tw.geothings.rekotlin.Action

// all of the actions that can be applied to the state
data class LoginAction(val userName: String, val password: String) : Action