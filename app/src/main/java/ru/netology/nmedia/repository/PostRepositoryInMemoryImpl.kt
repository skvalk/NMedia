package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post

class PostRepositoryInMemoryImpl : PostRepository {

    private var nextId = 1L
    override val data = MutableLiveData(
        listOf(
            Post(
                id = nextId++,
                author = "Нетология. Университет интернет-профессий будущего",
                content = "Освоение новой профессии — это не только открывающиеся возможности и перспективы, но и настоящий вызов самому себе. Приходится выходить из зоны комфорта и перестраивать привычный образ жизни: менять распорядок дня, искать время для занятий, быть готовым к возможным неудачам в начале пути. В блоге рассказали, как избежать стресса на курсах профпереподготовки → http://netolo.gy/fPD",
                published = "23 сентября в 10:12",
                likes = (0..999).random(),
                shared = (0..1200).random(),
                views = (0..11960).random(),
                likedByMe = false,
                videoURL = "https://www.youtube.com/watch?v=WhWc3b3KhnY"
            ),
            Post(
                id = nextId++,
                author = "Нетология. Университет интернет-профессий будущего",
                content = "Делиться впечатлениями о любимых фильмах легко, а что если рассказать так, чтобы все заскучали \uD83D\uDE34\n",
                published = "22 сентября в 10:14",
                likes = (0..999).random(),
                shared = (0..1200).random(),
                views = (0..11960).random(),
                likedByMe = false,
                videoURL = ""
            ),
            Post(
                id = nextId++,
                author = "Нетология. Университет интернет-профессий будущего",
                content = "Таймбоксинг — отличный способ навести порядок в своём календаре и разобраться с делами, которые долго откладывали на потом. Его главный принцип — на каждое дело заранее выделяется определённый отрезок времени. В это время вы работаете только над одной задачей, не переключаясь на другие. Собрали советы, которые помогут внедрить таймбоксинг \uD83D\uDC47\uD83C\uDFFB",
                published = "22 сентября в 10:12",
                likes = (0..999).random(),
                shared = (0..1200).random(),
                views = (0..11960).random(),
                likedByMe = false,
                videoURL = "https://www.youtube.com/watch?v=WhWc3b3KhnY"
            ),
            Post(
                id = nextId++,
                author = "Нетология. Университет интернет-профессий будущего",
                content = "\uD83D\uDE80 24 сентября стартует новый поток бесплатного курса «Диджитал-старт: первый шаг к востребованной профессии» — за две недели вы попробуете себя в разных профессиях и определите, что подходит именно вам → http://netolo.gy/fQ",
                published = "21 сентября в 10:12",
                likes = (0..999).random(),
                shared = (0..1200).random(),
                views = (0..11960).random(),
                likedByMe = false,
                videoURL = ""
            ),
            Post(
                id = nextId++,
                author = "Нетология. Университет интернет-профессий будущего",
                content = "Диджитал давно стал частью нашей жизни: мы общаемся в социальных сетях и мессенджерах, заказываем еду, такси и оплачиваем счета через приложения.",
                published = "20 сентября в 10:14",
                likes = (0..999).random(),
                shared = (0..1200).random(),
                views = (0..11960).random(),
                likedByMe = false,
                videoURL = ""
            ),
            Post(
                id = nextId++,
                author = "Нетология. Университет интернет-профессий будущего",
                content = "Большая афиша мероприятий осени: конференции, выставки и хакатоны для жителей Москвы, Ульяновска и Новосибирска \uD83D\uDE09",
                published = "19 сентября в 14:12",
                likes = (0..999).random(),
                shared = (0..1200).random(),
                views = (0..11960).random(),
                likedByMe = false,
                videoURL = "https://www.youtube.com/watch?v=WhWc3b3KhnY"
            ),
            Post(
                id = nextId++,
                author = "Нетология. Университет интернет-профессий будущего",
                content = "Языков программирования много, и выбрать какой-то один бывает нелегко. Собрали подборку статей, которая поможет вам начать, если вы остановили свой выбор на JavaScript.",
                published = "19 сентября в 10:24",
                likes = (0..999).random(),
                shared = (0..1200).random(),
                views = (0..11960).random(),
                likedByMe = false,
                videoURL = ""
            ),
            Post(
                id = nextId++,
                author = "Нетология. Университет интернет-профессий будущего",
                content = "Знаний хватит на всех: на следующей неделе разбираемся с разработкой мобильных приложений, учимся рассказывать истории и составлять PR-стратегию прямо на бесплатных занятиях \uD83D\uDC47",
                published = "18 сентября в 10:12",
                likes = (0..999).random(),
                shared = (0..1200).random(),
                views = (0..11960).random(),
                likedByMe = false,
                videoURL = ""
            ),
            Post(
                id = nextId++,
                author = "Нетология. Университет интернет-профессий будущего",
                content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
                published = "21 мая в 18:36",
                likes = (0..999).random(),
                shared = (0..1200).random(),
                views = (0..11960).random(),
                likedByMe = false,
                videoURL = "https://www.youtube.com/watch?v=WhWc3b3KhnY"
            ),
        )
    )

    private val posts
        get() = checkNotNull(data.value) {
            "Data value should not be null"
        }

    override fun like(postId: Long) {
        data.value = posts.map {
            if (it.id != postId) it
            else it.copy(
                likedByMe = !it.likedByMe,
                likes = it.likes + if (!it.likedByMe) 1 else -1
            )
        }
    }

    override fun share(postId: Long) {
        data.value = posts.map {
            if (it.id != postId) it
            else it.copy(
                shared = it.shared + 10
            )
        }

    }

    override fun remove(postId: Long) {
        data.value = posts.filter { it.id != postId }
    }

    override fun save(post: Post) {
        if (post.id == 0L) insert(post) else update(post)
    }

    private fun insert(post: Post) {
        data.value = listOf(
            post.copy(id = ++nextId)
        ) + posts
    }

    private fun update(post: Post) {
        data.value = posts.map {
            if (it.id == post.id) post else it
        }
    }
}