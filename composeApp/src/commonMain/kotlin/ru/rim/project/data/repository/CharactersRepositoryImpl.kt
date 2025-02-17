package ru.rim.project.data.repository
//import ru.rim.project.domain.repository.CharactersRepository

//class CharactersRepositoryImpl(private val dataSource: NetworkCharactersDataSource): CharactersRepository {
//    override suspend fun getCharacters(): BaseResult<List<Character>> {
//        return try {
//            val characters = withContext(Dispatchers.IO) {
//                dataSource.getCharacters(page).toDomain()
//            }
//            BaseResult.Success(characters)
//        } catch (e: Exception) {
//            BaseResult.Error(e)
//        }
//    }
//}
