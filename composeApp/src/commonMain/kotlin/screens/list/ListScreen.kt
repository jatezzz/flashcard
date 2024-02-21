import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import screens.list.TikTokLikeScreen


data object ListScreen : Screen {
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun Content() {
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
                            .clickable { navigator.push(DetailScreen(objects[page].objectID)) }
                    ) {
                        val itemWidth = maxWidth
                        val itemHeight = maxHeight
                        TikTokLikeScreen(
                            obj = objects[page],
                            onClick = { },
                            modifier = Modifier
                                .background(Color.LightGray)
                                .requiredSize(itemWidth, itemHeight),
                        )

                    }

                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    TopAppBar(
                        backgroundColor = Color.Transparent,
                        contentColor = Color.White,
                        elevation = 0.dp
                    ) {
                        Row {
                            Spacer(modifier = Modifier.weight(1.0F))
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search"
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier
                            .weight(1f)

                    )
                    // Bottom section - Navigation
                    BottomNavigation(
                        backgroundColor = Color.Black.copy(alpha = 0.3f),
                        contentColor = Color.White
                    ) {
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.Home,
                                    contentDescription = "Home"
                                )
                            },
                            selected = false,
                            onClick = { /*TODO*/ }
                        )
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search"
                                )
                            },
                            selected = false,
                            onClick = { /*TODO*/ }
                        )
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Add"
                                )
                            },
                            selected = false,
                            onClick = { /*TODO*/ }
                        )
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    contentDescription = "Notifications"
                                )
                            },
                            selected = false,
                            onClick = { /*TODO*/ }
                        )
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = "Profile"
                                )
                            },
                            selected = false,
                            onClick = { /*TODO*/ }
                        )
                    }
                }
            } else {
                EmptyScreenContent(Modifier.fillMaxSize())
            }
        }
    }
}
