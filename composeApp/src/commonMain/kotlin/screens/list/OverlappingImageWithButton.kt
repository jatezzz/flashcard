package screens.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun OverlappingImageWithButton(
    imageUrl: String,
    onButtonClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .size(96.dp) // Set the size of the outer box
            .padding(16.dp) // Optional padding
    ) {
        // Image from the URL
        KamelImage(
            resource = asyncPainterResource(data = imageUrl),
            contentDescription = "Profile image",
            modifier = Modifier
                .size(80.dp) // Size of the image
                .align(Alignment.Center), // Align the image in the center of the Box
            contentScale = ContentScale.Crop
        )

        // Plus Button
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add",
            tint = Color.White,
            modifier = Modifier
                .size(24.dp) // Size of the plus icon
                .align(Alignment.BottomCenter) // Position at the bottom center
                .background(
                    Color(0xFFFFEB3B),
                    shape = CircleShape
                ) // Yellow background with circular shape
                .clickable(onClick = onButtonClick) // Assign a click action
                .padding(16.dp) // Padding to position the plus icon correctly
        )
    }
}