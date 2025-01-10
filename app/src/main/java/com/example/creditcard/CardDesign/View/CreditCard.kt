package com.example.creditcard.CardDesign.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.creditcard.CardDesign.ViewModel.CreditCardViewModel
import com.example.creditcard.R
import java.util.StringTokenizer

@Composable
fun CreditCard(creditCardViewModel: CreditCardViewModel) {

    var creditCardNumberValue by rememberSaveable {
        mutableStateOf("0000 0000 0000 0000")
    }

    creditCardViewModel.cardNumber.observe(LocalLifecycleOwner.current) { newValue ->

        creditCardNumberValue = formatCreditCardNumber(newValue)
    }

    var valueOwnerValue by rememberSaveable {
        mutableStateOf("")
    }

    creditCardViewModel.cardOwner.observe(LocalLifecycleOwner.current) { newValue ->
        valueOwnerValue = capitalizeOwner(newValue)
    }

    var expirationNumberValue by rememberSaveable {
        mutableStateOf("")
    }

    creditCardViewModel.cardExpiration.observe(LocalLifecycleOwner.current) { newValue ->
        expirationNumberValue = formatExpirationDate(newValue)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFF272c39))
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = "Nombre de Banco",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Image(
                    modifier = Modifier
                        .size(45.dp)
                        .padding(vertical = 5.dp),
                    painter = painterResource(id = R.drawable.chip),
                    contentDescription = "chip"
                )
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = creditCardNumberValue,
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = expirationNumberValue,
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = valueOwnerValue,
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .padding(vertical = 5.dp),
                        painter = painterResource(id = R.drawable.visa),
                        contentDescription = "visa"
                    )

                }

            }
        }
    }
}

fun formatCreditCardNumber(value: String): String {
    var newFormatedValue: String = ""
    if (value.isEmpty()) {
        newFormatedValue = "0000 0000 0000 0000"
        return newFormatedValue
    }
    for ((index, character ) in value.withIndex()) {
        newFormatedValue += character
        if ((index + 1) % 4 == 0) {
            newFormatedValue += " "
        }
    }
    return newFormatedValue
}

fun capitalizeOwner(value: String): String{
    return value.uppercase()
}

fun formatExpirationDate(value: String): String {
    var newFormatedExpirationValue: String = ""
    if (value.isEmpty()) {
        newFormatedExpirationValue = "00/00"
        return newFormatedExpirationValue
    }
    for ((index, character ) in value.withIndex()) {
        newFormatedExpirationValue += character
        if ((index + 1) == 2) {
            newFormatedExpirationValue += "/"
        }
    }
    return newFormatedExpirationValue
}