package com.example.creditcard.CardDesign.View.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.creditcard.CardDesign.ViewModel.CreditCardViewModel

@Composable
fun ExpirationInput(creditCardViewModel: CreditCardViewModel){
    var valueExpirationInput by rememberSaveable {
        mutableStateOf("")
    }

    creditCardViewModel.cardExpiration.observe(LocalLifecycleOwner.current) { newValue ->
        valueExpirationInput = newValue
    }

    OutlinedTextField(
        placeholder = {
            Text(text = "00/00")
        },
        modifier = Modifier
            .fillMaxWidth(0.95f),
        value = valueExpirationInput,
        onValueChange = {
            creditCardViewModel.setCardExpiration(it)
        },
    )
}