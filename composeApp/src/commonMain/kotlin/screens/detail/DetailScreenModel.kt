import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.Flow

class DetailScreenModel(private val questionRepository: QuestionRepository) : ScreenModel {
    fun getObject(objectId: Int): Flow<QuestionObject?> =
        questionRepository.getObjectById(objectId)
}
