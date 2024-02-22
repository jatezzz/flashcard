package screens.list

import QuestionObject
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
        contentScale = ContentScale.Fit,
        modifier = Modifier.fillMaxSize().background(Color.Black).alpha(0.9F),
    )

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, bottom = 60.dp, start = 8.dp, end = 8.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom
        ) {
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
        }
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            OverlappingImageWithButton(
                imageUrl = obj.objectURL,
                onButtonClick = {}
            )
            Spacer(modifier = Modifier.height(24.dp))
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Likes",
                modifier = Modifier.requiredSize(40.dp),
                tint = Color.White
            )
            Text(text = "87", color = Color.White)
            Spacer(modifier = Modifier.height(20.dp))
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Comments",
                modifier = Modifier.requiredSize(40.dp),
                tint = Color.White
            )
            Text(text = "2", color = Color.White)
            Spacer(modifier = Modifier.height(20.dp))
            Icon(
                imageVector = Icons.Default.List,
                contentDescription = "Save",
                modifier = Modifier.requiredSize(40.dp),
                tint = Color.White
            )
            Text(text = "2", color = Color.White)
            Spacer(modifier = Modifier.height(20.dp))
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Shares",
                modifier = Modifier.requiredSize(40.dp),
                tint = Color.White
            )
            Text(text = "203", color = Color.White)
        }

    }
}
