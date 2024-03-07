package com.example.assignment_3

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment_3.ui.theme.Assignment_3Theme

@Composable
fun FiveStarRating(
    modifier: Modifier = Modifier,
    initialRating: Int = 0,
    onRatingChanged: (Int) -> Unit
) {
    var rating by remember { mutableStateOf(initialRating) }

    Row(modifier = modifier) {
        (1..5).forEach { index ->
            val starIcon: Painter = if (index <= rating) {
                painterResource(id = R.drawable.ic_star_outline)
            } else {
                painterResource(id = R.drawable.ic_star_filled)
            }

            Image(
                painter = starIcon,
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        rating = index
                        onRatingChanged(index)
                    }
                    .padding(4.dp)
                    .size(40.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FiveStarRatingPreview() {
    Assignment_3Theme {
        // Preview content here
        var rating by remember { mutableStateOf(0) }

        FiveStarRating(
            initialRating = rating,
            onRatingChanged = { newRating ->
                rating = newRating
                // Do something with the new rating value
            }
        )
    }
}
