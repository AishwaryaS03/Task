package com.example.caratlanefilterpagerevamp.filterpageviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FilterPageRevampViewModel : ViewModel() {

    val count: MutableLiveData<Int> = MutableLiveData()
    fun updateCheckedCount(checkedCount: Int) {
        count.value = checkedCount
    }
}