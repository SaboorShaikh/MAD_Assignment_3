package com.example.assignment_3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.assignment_3.ui.theme.Assignment_3Theme

@Composable
fun DetailsScreen(
    name: String,
    details: String,
    imageId: Int
) {
    Row {
        CustomTopAppBar(
            title = "Details Activity",
            onBackClick = { /* Handle back navigation */ },
            onMenuClick = { /* Handle menu icon click */ }
        )
    }
    Row {
        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 80.dp, start = 30.dp, end = 30.dp, bottom = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            var rating by remember { mutableStateOf(0) }
            FiveStarRating(
                initialRating = rating,
                onRatingChanged = { newRating ->
                    rating = newRating
                    // Do something with the new rating value
                }
            )

            Image(
                modifier = Modifier
                    .padding(top = 40.dp, bottom = 40.dp)
                    .size(width = 300.dp, height = 300.dp),
                painter = painterResource(id = imageId),
                contentDescription = name,
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = details,
                fontSize = 19.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailsScreenPreview() {
    Assignment_3Theme {
        // Preview content here
//        var rating by remember { mutableStateOf(0) }
//        DetailsScreen(text = "Chandler Muriel Being was born in April 8, 1968, " +
//                "in the quaint town of Willow Springs, " +
//                "nestled amidst the rolling hills of the American Midwest. " +
//                "From a young age, Chandler showed a remarkable aptitude for creativity and wit, " +
//                "often leaving his friends and family in stitches with his quick humor and sharp observations.",
//            imgResource = R.drawable.chandler)
    }
}
