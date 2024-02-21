import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

data object ListScreen : Screen {
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun Content() {
        // Obtain the screen height
//        val screenHeight = LocalConfiguration.current.screenHeightDp.dp
        val screenHeight = LocalDensity.current.density
        val screenModel: ListScreenModel = getScreenModel()

        val navigator = LocalNavigator.currentOrThrow

        val objects by screenModel.objects.collectAsState()

        AnimatedContent(objects.isNotEmpty()) { objectsAvailable ->
            if (objectsAvailable) {
                val state = rememberPagerState { objects.size }
                VerticalPager(
                    state = state,
                    modifier = Modifier.fillMaxSize(),
                ) { page ->
                    BoxWithConstraints(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        val itemWidth = maxWidth
                        val itemHeight = maxHeight
                        ObjectFrame(
                            obj = objects[page],
                            onClick = { navigator.push(DetailScreen(objects[page].objectID)) },
                            modifier = Modifier.background(Color.LightGray)
                                .requiredSize(itemWidth, itemHeight),
                        )
                    }
                }
            } else {
                EmptyScreenContent(Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
private fun ObjectFrame(
    obj: QuestionObject,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier.clickable { onClick() }) {
        KamelImage(
            resource = asyncPainterResource(data = obj.primaryImageSmall),
            contentDescription = obj.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth().aspectRatio(1f).background(Color.LightGray),
        )

        Spacer(Modifier.height(2.dp))

        Text(
            obj.title, style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold)
        )
        Text(obj.artistDisplayName, style = MaterialTheme.typography.body2)
        Text(obj.objectDate, style = MaterialTheme.typography.caption)
    }
}
