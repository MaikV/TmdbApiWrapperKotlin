package me.maikv.wrapperInterfaces

interface ChangesWrapper: BasePath {
   suspend fun getMovieChangeList()
   suspend fun getTvChangeList()
   suspend fun getPersonChangeList()
}