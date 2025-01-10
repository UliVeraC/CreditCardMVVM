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
fun OwnerInput(creditCardViewModel: CreditCardViewModel){
    var valueOwnerInput by rememberSaveable {
        mutableStateOf("")
    }

    creditCardViewModel.cardOwner.observe(LocalLifecycleOwner.current) { newValue ->
        valueOwnerInput = newValue
    }

    OutlinedTextField(
        placeholder = {
            Text(text = "Nombre del Titular")
        },
        modifier = Modifier
            .fillMaxWidth(fraction = 0.6f),
        value = valueOwnerInput,
        onValueChange = {
            creditCardViewModel.setCardOwner(it)
        },
    )
}