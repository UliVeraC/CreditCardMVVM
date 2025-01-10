package com.example.creditcard.CardDesign.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.creditcard.CardDesign.View.components.CardNumberInput
import com.example.creditcard.CardDesign.View.components.ExpirationInput
import com.example.creditcard.CardDesign.View.components.OwnerInput
import com.example.creditcard.CardDesign.ViewModel.CreditCardViewModel

@Composable
fun FormCard(creditCardViewModel: CreditCardViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Column {
            CardNumberInput(creditCardViewModel)

            Spacer(modifier = Modifier.height(8.dp))
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ){
                OwnerInput(creditCardViewModel)

                ExpirationInput(creditCardViewModel)
            }
        }


    }
}