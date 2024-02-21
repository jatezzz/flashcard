import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class QuestionRepository(
    private val questionApi: QuestionApi,
    private val questionStorage: QuestionStorage,
) {
    private val scope = CoroutineScope(SupervisorJob())

    fun initialize() {
        scope.launch {
            refresh()
        }
    }

    suspend fun refresh() {
        questionStorage.saveObjects(questionApi.getData())
    }

    fun getObjects(): Flow<List<QuestionObject>> = questionStorage.getObjects()

    fun getObjectById(objectId: Int): Flow<QuestionObject?> =
        questionStorage.getObjectById(objectId)
}
