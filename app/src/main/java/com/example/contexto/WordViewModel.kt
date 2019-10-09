package com.example.contexto

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//class extends androidviewmodel and requires application as parameter
class WordViewModel(application: Application) : AndroidViewModel(application) {
    //Viewmodel maintains a reference to the repository to get data
    private val repository: WordRepository
    //LiveData gives us updated words when they change
    val allWords: LiveData<List<DoContext>>

    init{
        //gets reference to worddao from wordroomdatabase to constuct correct wordrepo
        val wordsDao = WordRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWords
    }

    //implementation of insert() is completely hidden from UI
    //dont want insert to block main thread so we use new coroutine
    //Viewmodels have coroutine scope based on lifecycle called viewmodelscope
    fun insert(doContext: DoContext) = viewModelScope.launch {
        repository.insert(doContext)
    }


}