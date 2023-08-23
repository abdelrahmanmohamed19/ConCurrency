package com.example.concurrency.presentation

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
import androidx.navigation.compose.rememberNavController
import com.example.concurrency.presentation.navigation.AppNavigation
import com.example.concurrency.presentation.navigation.NavigationScreens
import com.example.concurrency.ui.theme.CardTextColor
import com.example.concurrency.ui.theme.SelectedTab
import com.example.concurrency.ui.theme.UnSelectedTab

import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch






@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LinearGradient() {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.background_image), contentDescription = "Image",
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth(), contentScale = ContentScale.FillBounds)
    }
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "ConCurrency", color = Color.White, fontSize = 18.sp)
        }
        Text(text = "Currency Converter", color = Color.White, fontSize = 25.sp)
        Text(
            text = "check live foreigen Currency exchange rates",
            color = Color.White,
            fontSize = 18.sp
        )

    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Rest() {
    var doubleBackToExitPressedOnce = false
    val activity = LocalOnBackPressedDispatcherOwner.current as ComponentActivity
    val context = LocalContext.current
    val tabItem = listOf(NavigationScreens.ConvertScreen, NavigationScreens.CompareScreen)
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier
                .padding(all = 20.dp)
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
                            screen.title,
                            style = if (pagerState.currentPage == index) TextStyle(
                                color = CardTextColor,
                                fontSize = 18.sp
                            )
                            else androidx.compose.ui.text.TextStyle(
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
                            pagerState.animateScrollToPage(index) }

                    })
            }

        }
        HorizontalPager(
            count = tabItem.size, state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) { index ->

            AppNavigation(tabItem[index].route)

        }

    }
    BackHandler(onBack = {
        // Handle the back button press here
        // Navigate to a specific screen using navController.navigate(...)
        if (doubleBackToExitPressedOnce) {
            finishAffinity(activity) //This will exit the app
        } else {
            doubleBackToExitPressedOnce = true
            Toast.makeText(context, "Press again to exit", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
            // Reset the flag after 2 seconds
        }

    })

}
