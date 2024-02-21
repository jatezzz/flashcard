package screens.list

import QuestionObject
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource


@Composable
fun ScrollablePageScreen(
    obj: QuestionObject,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    KamelImage(
        resource = asyncPainterResource(data = obj.primaryImageSmall),
        contentDescription = obj.title,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize().background(Color.Black).alpha(0.5F),
    )


    // Content Section
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Column {

            Text(
                text = obj.artistDisplayName,
                color = Color.Gray,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = obj.title,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = obj.objectDate,
                color = Color.Gray,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(24.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Likes",
                    tint = Color.White
                )
                Text(text = "87", color = Color.White, modifier = Modifier.padding(start = 8.dp))
                Spacer(modifier = Modifier.width(24.dp))
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Comments",
                    tint = Color.White
                )
                Text(text = "2", color = Color.White, modifier = Modifier.padding(start = 8.dp))
                Spacer(modifier = Modifier.width(24.dp))
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Shares",
                    tint = Color.White
                )
                Text(text = "203", color = Color.White, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}