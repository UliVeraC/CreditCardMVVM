package com.example.creditcard.CardDesign.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreditCardViewModel: ViewModel() {
    private var _cardNumber = MutableLiveData<String>()
    val cardNumber: LiveData<String> = _cardNumber

    private var _cardOwner = MutableLiveData<String>()
    val cardOwner: LiveData<String> = _cardOwner

    private var _cardExpiration = MutableLiveData<String>()
    val cardExpiration: LiveData<String> = _cardExpiration

    fun setCardNumber(number : String){
        if(number.length > 16 ){
            return
        }
        _cardNumber.value = number
    }
    fun setCardOwner(name : String){
        _cardOwner.value = name
    }
    fun setCardExpiration(expiration : String){
        if(expiration.length > 4 ){
            return
        }

        _cardExpiration.value = expiration
    }

}