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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import com.example.concurrency.R
import com.example.concurrency.presentation.home.HomeViewModel
import com.example.concurrency.ui.theme.TextColorWhite



@Composable
fun CurrencyConverterTitle() {
   Column ( horizontalAlignment = Alignment.CenterHorizontally){
       Text(
           text = stringResource(R.string.cardTitleFirst),
           color = TextColorWhite,
           fontSize = 24.sp,
       )
       Text(
           text = stringResource(R.string.cardTitleSecond),
           color = TextColorWhite,
           fontSize = 13.sp,
           modifier = Modifier.padding(bottom = 20.dp, top = 10.dp)
       )
   }
}

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
fun UserEditText(paddingTop: Int = 0, modifier: Modifier) {
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
        value = "1 EGP",
        onValueChange = {},
        shape = RoundedCornerShape(20.dp),
        modifier = modifier
            .padding(top = paddingTop.dp)
            .fillMaxWidth()
            .height(55.dp),

        isError = false,
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
fun DropDownList(paddingTop: Int = 0, modifier: Modifier) {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("Item 1") }
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
                        expanded = true
                    }
            )
            {
                CountryImage(
                    link = "https://www.exchangerate-api.com/img/docs/JP.gif",
                    modifier = Modifier.weight(0.30f)
                )
                Spacer(modifier = Modifier.width(5.dp))
                DropDownText(
                    text = "EGP",
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
                onDismissRequest = { expanded = false }
            ) {
                Column {
                    // Create menu items
                    listOf("EGP - Egyptian Pound", "EGP - Egyptian Pound" , "EGP - Egyptian Pound" , "EGP - Egyptian Pound" , "EGP - Egyptian Pound" , "EGP - Egyptian Pound" , "EGP - Egyptian Pound" , "EGP - Egyptian Pound" , "EGP - Egyptian Pound").forEach { item ->
                        DropdownMenuItem(
                            onClick = {
                                selectedItem = item
                                expanded = false
                            },
                            text = {
                                CardDropDown(item)
                            }
                        )
                    }
                }
            }
        }

    }

@Composable
fun CardDropDown(text:String) {
    Row(
        modifier = Modifier.background(CardComponentBackground)

    ){
        CountryImage(
            link =  "https://www.exchangerate-api.com/img/docs/JP.gif",
            modifier = Modifier.width(30.dp))
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = text,
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
        model = "https://www.exchangerate-api.com/img/docs/JP.gif",
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
fun DialogueFavoritesList(isSelected : Boolean , onDismiss : () -> Unit) {
    val list = listOf(
        "EGP - Egyptian Pound",
        "EGP - Egyptian Pound",
        "EGP - Egyptian Pound",
        "EGP - Egyptian Pound",
        "EGP - Egyptian Pound",
        "EGP - Egyptian Pound",
        "EGP - Egyptian Pound",
        "EGP - Egyptian Pound",
        "EGP - Egyptian Pound"
    )
    var isAdded by remember { mutableStateOf(false) }

    if (isSelected) {
        Dialog(onDismissRequest = { onDismiss.invoke() }) {
            Column(Modifier.height(800.dp)) {
                Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.fillMaxWidth()) {
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, end = 16.dp)
                    ) {
                        Icon(imageVector = Icons.Filled.Clear, contentDescription = "")
                    }
                }

                Card(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(8.dp),
                    colors = CardDefaults.cardColors(Color.White)

                ) {
                    Row {
                        Text(
                            text = "Add to Favorites",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W700,
                            color = Color.Black,
                            modifier = Modifier.padding(start = 8.dp, top = 12.dp, bottom = 12.dp)
                        )
                        Box(modifier = Modifier.fillMaxWidth(),contentAlignment = Alignment.TopEnd) {
                            IconButton(onClick = { onDismiss.invoke() }) {
                                Icon(Icons.Filled.Clear, contentDescription = "")
                            }
                        }
                    }


                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, start = 8.dp)
                    ) {
                        items(list) {
                            Row {
                                Image(
                                    painter = painterResource(id = R.drawable.usa_flag),
                                    contentDescription = "",
                                    modifier = Modifier.padding(end = 16.dp)
                                )
                                Column(verticalArrangement = Arrangement.Center) {
                                    Text(text = it, fontSize = 16.sp, fontWeight = FontWeight.W400)
                                    Text(
                                        text = "Currency",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.W400,
                                        color = Color.LightGray
                                    )
                                }

                                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                                    IconButton(onClick = { isAdded = !isAdded }) {
                                        if (isAdded) {
                                            Icon(Icons.Filled.CheckCircle, contentDescription = "")
                                        } else {
                                            Icon(
                                                painterResource(id = R.drawable.not_selected_icon),
                                                contentDescription = ""
                                            )
                                        }
                                    }
                                }

                            }
                            Divider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp), color = Color.LightGray
                            )
                        }
                    }
                }

            }
        }
    }
}


    @Composable
    fun FavoritesComponents(viewModel: HomeViewModel) {
        var isClicked by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(bottom = 16.dp)
        ) {

            Row {
                Text(
                    text = "live exchange rates",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(top = 12.dp)
                )

                Button(onClick = { isClicked = true },
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
                        text = "Add to Favorites",
                        color = Color.DarkGray,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 4.dp),
                        fontWeight = FontWeight.W500
                    )
                }
                Box(contentAlignment = Alignment.Center) {
                    DialogueFavoritesList(isClicked, onDismiss = { isClicked = false })
                }

            }
        }
    }




