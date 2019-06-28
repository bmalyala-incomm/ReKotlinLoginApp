package com.example.RekotlinLoginApp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.example.RekotlinLoginApp.actions.LoginAction
import com.example.RekotlinLoginApp.reducers.loginReducer
import com.example.RekotlinLoginApp.state.AppState
import com.example.RekotlinLoginApp.state.LoggedInState

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import tw.geothings.rekotlin.Store
import tw.geothings.rekotlin.StoreSubscriber
import java.util.*


// The global application store, which is responsible for managing the appliction state.
val mainStore = Store(
    reducer = ::loginReducer,
    state = null
)

class MainActivity : AppCompatActivity(), StoreSubscriber<AppState>{

   /* private val textView: TextView by lazy {
        this.findViewById(R.id.textView) as TextView
    }

    private val user_name: EditText by lazy {
        this.findViewById(R.id.userName) as EditText
    }

    private val password: EditText by lazy {
        this.findViewById(R.id.password) as EditText
    }

    private val submitButton: Button by lazy {
        this.findViewById(R.id.submit) as Button
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // when button is tapped, an action is dispatched to the store
        // in order to update the application state
        this.submit.setOnClickListener {
            println("submit calling dispatch LoginReducer class")
            mainStore.dispatch(LoginAction(userName = userName.text.toString(),
                password = password.text.toString()))
            //subscribe for state change
            mainStore.subscribe(this)
        }
    }



    override fun newState(state: AppState) {
        // when the state changes, the UI is updated to reflect the current state
       println("inside newState after state change:" +state+',' +Date().getTime())
        if(state.authenticationState.loggedInState.equals(LoggedInState.loggedIn) && state.authenticationState.userName.equals("team5")){
            println("authenticated:true")
            val successIntent = Intent(this, SuccessActivity::class.java)
           startActivity(successIntent)
        } else{
            println("authenticated:false")
        }

    }
}

