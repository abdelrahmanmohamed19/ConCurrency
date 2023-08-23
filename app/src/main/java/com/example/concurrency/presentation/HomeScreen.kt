package com.example.concurrency.presentation

import androidx.compose.runtime.Composable




@Composable
fun HomeScreen() {

}



































//import androidx.compose.animation.Animatable
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Tab
//import androidx.compose.material3.TabRow
//import androidx.compose.material3.TabRowDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import com.example.concurrency.ui.theme.SelectedTabColor
//import com.example.concurrency.ui.theme.TabTextColor
//import com.example.concurrency.ui.theme.UnSelectedTabColor
//import com.google.accompanist.pager.ExperimentalPagerApi
//import com.google.accompanist.pager.HorizontalPager
//import com.google.accompanist.pager.pagerTabIndicatorOffset
//import com.google.accompanist.pager.rememberPagerState
//import kotlinx.coroutines.launch
//
//@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
//@Composable
//fun HomeScreen() {
//    val tabItems = listOf("Convert","Compare")
//    val pagerState = rememberPagerState()
//    val coroutineScope = rememberCoroutineScope()
//
//
//    Surface {
//        Column {
//            TabRow(
//                selectedTabIndex = pagerState.currentPage,
//                containerColor = UnSelectedTabColor,
//                modifier = Modifier
//                    .padding(all = 20.dp)
//                    .background(SelectedTabColor)
//                    .clip(RoundedCornerShape(20.dp)),
//                indicator = {
//                    tabPositions ->
//                    TabRowDefaults.Indicator(
//                        Modifier
//                            .pagerTabIndicatorOffset(
//                                pagerState,
//                                tabPositions
//                            )
//                            .width(0.dp)
//                            .height(0.dp)
//                )}
//                ) {
//                tabItems.forEachIndexed { index, s ->
//                    val color = remember{Animatable(UnSelectedTabColor)}
//
//                   LaunchedEffect(key1 = pagerState.currentPage == index){
//                       color.animateTo(if (pagerState.currentPage == index) Color.White else SelectedTabColor)
//                   }
//                    Tab(selected = pagerState.currentPage == index,
//                        modifier = Modifier.background(
//                            color = color.value,
//                            shape = RoundedCornerShape(30.dp)
//                        ),
//                        onClick = {
//                            coroutineScope.launch {
//                                pagerState.animateScrollToPage(index)
//                            }
//                        },
//                        text = {
//                            Text(text = s, color = TabTextColor)
//                        })
//                }
//
//            }
//            HorizontalPager(
//                count = tabItems.size,
//                state =pagerState,
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.Blue)
//                ) {page ->
//                Text(
//                    text = tabItems[page],
//                    modifier = Modifier.padding(50.dp),
//                    color = Color.White
//                )
//
//            }
//        }
//    }
//}
