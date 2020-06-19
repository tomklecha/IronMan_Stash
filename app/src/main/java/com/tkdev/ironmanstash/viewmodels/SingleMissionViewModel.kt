package com.tkdev.ironmanstash.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tkdev.ironmanstash.data.InfinityStoneEntity
import com.tkdev.ironmanstash.repository.SingleMissionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SingleMissionViewModel(
        private val repository: SingleMissionRepository,
        private val uid: Long
) : ViewModel() {

    val mission: LiveData<InfinityStoneEntity> = repository.mission(uid)

    private val _password = MutableLiveData<Int>()

    val password: LiveData<Int> = _password

    fun complete(uid: Long) = viewModelScope.launch(Dispatchers.IO) {repository.complete(uid)}

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _password.postValue(repository.getPassword(uid))
        }
    }

}
