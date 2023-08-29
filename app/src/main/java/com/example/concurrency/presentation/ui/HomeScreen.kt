package com.example.concurrency.presentation.ui

import android.os.Handler
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.animation.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.concurrency.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.core.app.ActivityCompat.finishAffinity
import com.example.concurrency.domain.Constants
import com.example.concurrency.presentation.compare.CompareViewModel
import com.example.concurrency.presentation.convert.ConvertViewModel
import com.example.concurrency.presentation.favorites.FavoritesViewModel
import com.example.concurrency.ui.theme.CardTextColor
import com.example.concurrency.ui.theme.SelectedTab
import com.example.concurrency.ui.theme.UnSelectedTab
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

@Composable
fun AppHomeScreen(
    favoritesViewModel: FavoritesViewModel,
    convertViewModel: ConvertViewModel,
    compareViewModel: CompareViewModel
) {

    var isSplashScreenVisible by remember { mutableStateOf(true) }
    if (isSplashScreenVisible) {
        SplashScreen()
    } else {
        TopAppScreen()
        HomeContentScreen(favoritesViewModel, convertViewModel, compareViewModel)

    }
    LaunchedEffect(Unit) {
        delay(4.seconds)
        isSplashScreenVisible = false
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff1A2B30)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Spacer(modifier = Modifier.height(200.dp))
        Image(
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = "Splash Image",
        )

        LottieAnimationShow(R.raw.loading, 200, 100)

    }
}


@Composable
fun TopAppScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = "Image",
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillBounds
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.title_bar),
                contentDescription = "title",
                modifier = Modifier
                    .width(144.dp)
                    .height(32.dp)
            )
        }
        Text(text = "Currency Converter", color = Color.White, fontSize = 25.sp)
        Text(
            text = "check live foreign Currency exchange rates",
            color = Color.White,
            fontSize = 14.sp
        )
    }
}
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeContentScreen(
    favoritesViewModel: FavoritesViewModel,
    convertViewModel: ConvertViewModel,
    compareViewModel: CompareViewModel
) {
    var doubleBackToExitPressedOnce = false
    val activity = LocalOnBackPressedDispatcherOwner.current as ComponentActivity
    val context = LocalContext.current
    val tabItem = listOf(Constants.convertRoute, Constants.compareRoute)
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()


    Box {
        HorizontalPager(
            count = tabItem.size, state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 220.dp)
                .background(color = Color.White),
            verticalAlignment = Alignment.Top,

            ) { index ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp)
            ) {
                AppNavigation(
                    tabItem[index],
                    favoritesViewModel,
                    convertViewModel,
                    compareViewModel
                )
            }
        }

        TabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 200.dp)
                .background(color = Color.Transparent)
                .clip(RoundedCornerShape(30.dp)), backgroundColor = UnSelectedTab,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier
                        .pagerTabIndicatorOffset(
                            pagerState,
                            tabPositions
                        )
                        .width(0.dp)
                        .height(0.dp)
                )
            }
        ) {
            tabItem.forEachIndexed { index, screen ->
                val color = remember {
                    Animatable(SelectedTab)
                }
                LaunchedEffect(pagerState.currentPage == index) {
                    color.animateTo(if (pagerState.currentPage == index) Color.White else UnSelectedTab)
                }
                Tab(
                    text = {
                        Text(
                            screen,
                            style = if (pagerState.currentPage == index) TextStyle(
                                color = CardTextColor,
                                fontSize = 18.sp
                            )
                            else TextStyle(
                                color = Color.Gray,
                                fontSize = 16.sp
                            )
                        )
                    },
                    selected = pagerState.currentPage == index,
                    modifier = Modifier.background(
                        color = color.value,
                        shape = RoundedCornerShape(30.dp)
                    ),
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }

                    })
            }

        }
    }

    //Back Handler
    BackHandler(onBack = {
        if (doubleBackToExitPressedOnce) {
            finishAffinity(activity)
        } else {
            doubleBackToExitPressedOnce = true
            Toast.makeText(context, "Press again to exit", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 1000)
        }
    })
}
