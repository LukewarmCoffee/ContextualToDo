package com.example.contexto

import androidx.lifecycle.LiveData

//declares dao as a private property in constructor
class WordRepository(private val wordDao: WordDao) {
    //Room executes all queries on a separate thread
    //observed livedata will notify observer
    val allWords: LiveData<List<DoContext>> = wordDao.getAllWords()

    //suspend modifier tells compiler that it should be called from coroutine or suspend func
    suspend fun insert(doContext: DoContext) {
        wordDao.insert(doContext)
    }
}