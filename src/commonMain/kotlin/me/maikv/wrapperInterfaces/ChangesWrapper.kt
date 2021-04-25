package me.maikv.wrapperInterfaces

import me.maikv.datatransferobjects.Changes

interface ChangesWrapper: BasePath {
   /**
    * @see <a href="https://developers.themoviedb.org/3/changes/get-movie-change-list">Documentation</a>
    * The date parameters take strings in the format yyyy-mm-dd
    */
   suspend fun getMovieChangeList(endDate: String? = null, startDate: String? = null, page: Int? = null): Changes

   /**
    * @see <a href="https://developers.themoviedb.org/3/changes/get-tv-change-list">Documentation</a>
    * The date parameters take strings in the format yyyy-mm-dd
    */
   suspend fun getTvChangeList(endDate: String? = null, startDate: String? = null, page: Int? = null): Changes

   /**
    * @see <a href="https://developers.themoviedb.org/3/changes/get-person-change-list">Documentation</a>
    * The date parameters take strings in the format yyyy-mm-dd
    */
   suspend fun getPersonChangeList(endDate: String? = null, startDate: String? = null, page: Int? = null): Changes
}