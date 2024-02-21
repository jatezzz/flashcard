import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

interface QuestionStorage {
    suspend fun saveObjects(newObjects: List<QuestionObject>)

    fun getObjectById(objectId: Int): Flow<QuestionObject?>

    fun getObjects(): Flow<List<QuestionObject>>
}

class InMemoryMuseumStorage : QuestionStorage {
    private val storedObjects = MutableStateFlow(emptyList<QuestionObject>())

    override suspend fun saveObjects(newObjects: List<QuestionObject>) {
        storedObjects.value = newObjects
    }

    override fun getObjectById(objectId: Int): Flow<QuestionObject?> {
        return storedObjects.map { objects ->
            objects.find { it.objectID == objectId }
        }
    }

    override fun getObjects(): Flow<List<QuestionObject>> = storedObjects
}
