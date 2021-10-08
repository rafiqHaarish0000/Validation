package com.example.learner.Fragments


data class TrendingRepoModal(
    val responseData: ArrayList<TrendingRepo>
)

data class TrendingRepo(
    val avatar:String,
    val author: String,
    val name: String,
    val description: String,
    val stars: String,
    val language:String,
    val languageColor:String
)
