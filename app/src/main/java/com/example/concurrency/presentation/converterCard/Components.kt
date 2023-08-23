package com.example.concurrency.presentation.converterCard


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import coil.compose.AsyncImage
import com.example.concurrency.R
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
                    expanded=true
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
            modifier=Modifier.background(CardComponentBackground),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            // Create menu items
            listOf("EGP", "USD", "JPY","ITEM 4","item 5").forEach { item ->
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
            fontSize = 16.sp
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




