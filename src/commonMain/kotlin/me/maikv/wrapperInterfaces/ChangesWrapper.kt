package me.maikv.wrapperInterfaces

interface ChangesWrapper {
   suspend fun getMovieChangeList()
   suspend fun getTvChangeList()
   suspend fun getPersonChangeList()
}