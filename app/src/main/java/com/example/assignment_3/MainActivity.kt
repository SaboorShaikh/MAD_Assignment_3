package com.example.assignment_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment_3.ui.theme.Assignment_3Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment_3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { navController.navigate("task2") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Task2")
                }
                Button(
                    onClick = { navController.navigate("task3") },
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Task3")
                }
            }
        }
        composable("task2") {
            Task2(navController)
        }
        composable("task3") {
            Task3(navController)
        }
    }
}

@Composable
fun Task2(navController: NavController) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(onSignUpClick = { navController.navigate("signup") })
        }
        composable("signup") {
            SignUpScreen(onLoginClick = { navController.navigate("login") })
        }
    }
}

@Composable
fun Task3(navController: NavController) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "friends") {
        composable("friends") {
            FriendsScreen(navController = navController)
        }
        composable("details/{name}/{details}/{imageId}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val details = backStackEntry.arguments?.getString("details") ?: ""
            val imageId = backStackEntry.arguments?.getInt("imageId") ?: 0
            DetailsScreen(name = name, details = details, imageId = imageId)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment_3Theme {
        MainScreen()
    }
}
