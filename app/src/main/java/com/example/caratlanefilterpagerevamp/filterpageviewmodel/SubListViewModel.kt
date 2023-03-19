package com.example.caratlanefilterpagerevamp.filterpageviewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SubListViewModel : ViewModel() {
    private val _checkedCount = MutableLiveData<Int>(0)
    var selectedPosition : Int = 0
    val checkedCount: LiveData<Int>
        get() = _checkedCount
    fun updateCheckedCount(isChecked: Boolean) {
        _checkedCount.value = _checkedCount.value?.plus(if (isChecked) 1 else -1)
    }
    fun refreshCheckedCount(){
        _checkedCount.value = 0
    }
    fun unChecked(isChecked: Boolean){
        isChecked == true
    }
}
