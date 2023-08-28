package com.example.concurrency.presentation.ui


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.concurrency.ui.theme.CardBackground
import com.example.concurrency.ui.theme.CardBorderColor
import com.example.concurrency.ui.theme.CardButtonBackground
import com.example.concurrency.ui.theme.CardComponentBackground
import com.example.concurrency.ui.theme.CardTextColor
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.concurrency.R
import com.example.concurrency.data.remote.dto.CurrencyInfo
import com.example.concurrency.presentation.convert.ConvertViewModel
import com.example.concurrency.presentation.favorites.FavoritesViewModel


@Composable
fun MyTextTitle(text:String,paddingTop:Int,modifier: Modifier) {
    Text(
        text = text,
        style = TextStyle(
            color = CardTextColor,
            fontSize= 14.sp,
            fontWeight= FontWeight.Bold,
        ),
        modifier = modifier.padding(top = paddingTop.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserEditText(
    amount:String,
    isAmountError:Boolean,
    onAmountChange:(String)->Unit,
    errorMessage : String,
    paddingTop: Int = 0,
    modifier: Modifier) {
    val customColors = TextFieldDefaults.outlinedTextFieldColors(
        // Default Colors
        cursorColor = CardTextColor,
        focusedBorderColor = CardBorderColor,
        unfocusedBorderColor = CardBorderColor,
        containerColor = CardComponentBackground,

        // Error colors
        errorCursorColor = CardTextColor,
        errorBorderColor = Color.Red,

        )
    OutlinedTextField(
        value = amount,
        onValueChange = {
            onAmountChange(it)
        },
        shape = RoundedCornerShape(20.dp),
        modifier = modifier
            .padding(top = paddingTop.dp)
            .fillMaxWidth()
            .height(55.dp),

        isError = isAmountError,
        textStyle = TextStyle(
            color = CardTextColor,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        colors = customColors,

        )

}



@Composable
fun DropDownList(
    allCurrency: List<CurrencyInfo?>,
    selectedItem: CurrencyInfo,
    expanded:Boolean,
    onDropDownClick:()->Unit,
    onDropDownDismissClick:()->Unit,
    onDropDownSelectedItem:(CurrencyInfo)->Unit,
    paddingTop: Int = 0,
    modifier: Modifier
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = modifier
            .padding(top = paddingTop.dp)
            .fillMaxWidth()
            .border(
                border = BorderStroke(1.dp, CardBorderColor),
                shape = RoundedCornerShape(20.dp)
            )
        ,
        colors = CardDefaults.cardColors(
            containerColor = CardComponentBackground,
        ),
    ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .fillMaxWidth()
                    .height(55.dp)
                    .clickable {
                        onDropDownClick()
                    }
            )
            {
                CountryImage(
                    link = selectedItem.flagUrl !!,
                    modifier = Modifier.weight(0.30f)
                )
                Spacer(modifier = Modifier.width(5.dp))
                DropDownText(
                    text = selectedItem.currencyCode !!,
                    modifier = Modifier.weight(0.55f)
                )
                CurrencyIcon(
                    Icons.Default.KeyboardArrowDown,
                    "DropDown Icon",
                    Modifier.weight(0.15f)
                )

            }
            DropdownMenu(
                modifier= Modifier
                    .background(CardComponentBackground)
                    .height(180.dp),
                expanded = expanded,
                onDismissRequest = { onDropDownDismissClick() }
            ) {
                Column {
                    // Create menu items
                   allCurrency.forEach { item ->
                        DropdownMenuItem(
                            onClick = {
                               onDropDownSelectedItem(item !!)
                                onDropDownDismissClick()
                            },
                            text = {
                                CardDropDown(item !!)
                            }
                        )
                    }
                }
            }
        }

    }

@Composable
fun CardDropDown(currency: CurrencyInfo) {
    Row(
        modifier = Modifier.background(CardComponentBackground)

    ){
        CountryImage(
            link =  currency.flagUrl !!,
            modifier = Modifier.width(30.dp))
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "${currency.currencyCode} - ${   currency.name}",
            color = CardTextColor,
            fontSize = 12.sp
        )
    }
}


@Composable
fun DropDownText(text:String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = text,
            color = CardTextColor,
            fontSize = 16.sp
        )
    }
}

@Composable
fun CountryImage(link:String,modifier: Modifier) {
    AsyncImage(
        model = link,
        modifier = modifier
            .width(28.dp)
            .height(30.dp),
        contentDescription = "Country Image",
        error = painterResource(id = R.drawable.placeholder),
        placeholder = painterResource(id = R.drawable.placeholder),
    )
}


@Composable
fun CurrencyIcon(icon: ImageVector, contentDescription:String, modifier: Modifier) {
    Icon(
        imageVector = icon,
        contentDescription = contentDescription,
        modifier = modifier,
        tint = Color.DarkGray

    )
}


@Composable
fun ResultView(result:String ,paddingTop:Int,modifier: Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = CardComponentBackground,
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = modifier
            .padding(top = paddingTop.dp)
            .fillMaxWidth()
            .height(55.dp)
            .border(
                border = BorderStroke(1.dp, CardBorderColor),
                shape = RoundedCornerShape(20.dp)
            ),
        ) {
      Row (
          modifier = modifier
              .fillMaxWidth()
              .padding(start = 15.dp)
              .height(55.dp),
          horizontalArrangement = Arrangement.Start,
          verticalAlignment = Alignment.CenterVertically
      ){
          Text(
              text = result,
              style = TextStyle(
                  color = CardTextColor,
                  fontWeight = FontWeight.Bold,
                  fontSize = 16.sp
              )
          )
      }
    }
}



@Composable
fun ButtonClickOn(buttonText:String, paddingTopValue:Int, onButtonClick:() -> Unit ) {
    Button (colors = ButtonDefaults.buttonColors(containerColor = CardButtonBackground),
        enabled = true,
        onClick = {onButtonClick()},
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(top = paddingTopValue.dp)
            .fillMaxWidth()

    ){
        Text(text = buttonText, fontSize = 25.sp, style = TextStyle(color = CardBackground))
    }
}


@Composable
fun FavoritesComponents(favoriteViewModel: FavoritesViewModel, convertViewModel: ConvertViewModel) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(bottom = 16.dp)
    ) {

        Row {
            Text(
                text = stringResource(id = R.string.liveExchangRates),
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
                color = Color.DarkGray,
                modifier = Modifier.padding(top = 12.dp)
            )

            Button(
                onClick = { favoriteViewModel.onAddToFavoriteClick() },
                modifier = Modifier
                    .padding(start = 12.dp)
                    .wrapContentWidth(),
                border = BorderStroke(1.dp, color = Color.Black),
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.buttonColors(Color.White)) {
                Image(
                    painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = ""
                )
                Text(
                    text = stringResource(id = R.string.addFavorites),
                    color = Color.DarkGray,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 4.dp),
                    fontWeight = FontWeight.W500
                )
            }
            Box(contentAlignment = Alignment.Center) {
                DialogueFavoritesList(
                    currencyList = favoriteViewModel.state.value.allCurrencies !! ,
                    isShowDialog = favoriteViewModel.state.value.isShowDialog,
                    onSelectFavoriteCurrency = { selectedCurrency -> favoriteViewModel.onSelectFavoriteCurrency(selectedCurrency)}
                ) { favoriteViewModel.onCloseMyFavorite()
                    favoriteViewModel.getExchangeRates(convertViewModel.state.value.baseCurrency.currencyCode.toString())

                }
            }

        }
    }
}


@Composable
fun DialogueFavoritesList(
    currencyList: List<CurrencyInfo?>,
    isShowDialog: Boolean,
    onSelectFavoriteCurrency:(CurrencyInfo)->Unit,
    onDialogDismiss: () -> Unit
) {

    if (isShowDialog) {
        Dialog(onDismissRequest = { onDialogDismiss() }) {
            Column(
                Modifier.height(600.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(8.dp),
                    colors = CardDefaults.cardColors(containerColor = CardComponentBackground)

                ) {
                    Row {
                        Text(
                            text = stringResource(id = R.string.myFavorites),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W700,
                            color = Color.Black,
                            modifier = Modifier.padding(start = 8.dp, top = 12.dp, bottom = 12.dp)
                        )
                        Box(modifier = Modifier.fillMaxWidth(),contentAlignment = Alignment.TopEnd) {
                            IconButton(onClick = { onDialogDismiss() }) {
                                Icon(Icons.Filled.Clear, contentDescription = "")
                            }
                        }
                    }


                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, start = 8.dp)
                    ) {
                        itemsIndexed(currencyList) { index , item->
                            Row {
                                AsyncImage(
                                    model = item?.flagUrl,
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(CircleShape)
                                        .border(1.dp,color=Color.Black, shape = RoundedCornerShape(20.dp)),
                                    contentScale = ContentScale.Crop,
                                    contentDescription = "Country Image",
                                    error = painterResource(id = R.drawable.placeholder),
                                    placeholder = painterResource(id = R.drawable.placeholder),
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Column(verticalArrangement = Arrangement.Center) {
                                    item?.currencyCode?.let { Text(text = it, fontSize = 16.sp, fontWeight = FontWeight.W400) }
                                    item?.name?.let {
                                        Text(
                                            text = it,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.W400,
                                            color = Color.LightGray
                                        )
                                    }
                                }

                                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                                    IconButton(onClick = { onSelectFavoriteCurrency(item !!)}) {
                                        if (item?.isFavourite !!) {
                                            Icon(
                                                Icons.Filled.CheckCircle,
                                                contentDescription = "",
                                                tint = Color.DarkGray
                                            )
                                        } else {
                                            Icon(
                                                painterResource(id = R.drawable.not_selected_icon),
                                                contentDescription = "",

                                            )
                                        }
                                    }
                                }

                            }
                            Divider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp, end = 8.dp), color = Color.LightGray
                            )
                        }
                    }
                }

            }
        }
    }
}



@Composable
fun LottieAnimationShow(animationResId: Int, size:Int, padding:Int) {


    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(animationResId)
    )
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true,
        speed = 1f,
        restartOnPlay = false

    )

    LottieAnimation(
        composition,
        progress,
        modifier = Modifier.padding(top = padding.dp).size(size.dp),
    )


}
