package com.example.assignment_3

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.assignment_3.ui.theme.Assignment_3Theme
import kotlinx.coroutines.launch

@Composable
fun FriendsScreen(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Friends",
            color = Color.Gray,
            fontSize = 40.sp,
            modifier = Modifier.padding(top = 20.dp)
        )
        Text(
            text = "Click on an eligible single user to learn more and see if you are compatible for a date",
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        )
        Row {
            ClickableFriendBox(navController, R.drawable.chandler, "Chandler", "Chandler details")
            ClickableFriendBox(navController, R.drawable.joey, "Joey", "Joey details")
        }
        Row {
            ClickableFriendBox(navController, R.drawable.monica, "Monica", "Monica details")
            ClickableFriendBox(navController, R.drawable.phoebe, "Phoebe", "Phoebe details")
        }
        Row {
            ClickableFriendBox(navController, R.drawable.rachel, "Rachel", "Rachel details")
            ClickableFriendBox(navController, R.drawable.ross, "Ross", "Ross details")
        }
    }
}

@Composable
fun ClickableFriendBox(
    navController: NavController,
    imageId: Int,
    name: String,
    details: String
) {
    val coroutineScope = rememberCoroutineScope()

    Box(
        Modifier
            .padding(10.dp)
            .clickable {
                coroutineScope.launch {
                    navigateToDetailsScreen(navController, name, details, imageId)
                }
            }
    ) {
        Column(
            Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "Profile Picture",
                modifier = Modifier.size(120.dp)
            )
            Text(
                text = name,
                modifier = Modifier.padding(vertical = 4.dp),
            )
        }
    }
}

suspend fun navigateToDetailsScreen(
    navController: NavController,
    name: String,
    details: String,
    imageId: Int
) {
    navController.navigate("details/$name/$details/$imageId")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FriendsPreview() {
    val navController = rememberNavController()
    Assignment_3Theme {
        FriendsScreen(navController = navController)
    }
}
