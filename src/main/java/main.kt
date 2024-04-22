package sdj_kotlin_value

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.beans
import org.springframework.data.annotation.Id
import org.springframework.data.repository.CrudRepository

@SpringBootApplication open class App

fun main(args: Array<String>) {
    runApplication<App>(*args) {
        addInitializers(beans { bean { ExampleService(contactRepo = ref<ContactRepo>()) } })
    }
}

class ExampleService(private val contactRepo: ContactRepo)

@JvmInline value class EmailAddress(val theAddress: String)

data class Contact(@Id val id: String, val name: String, val emailAddress: EmailAddress)

interface ContactRepo : CrudRepository<Contact, String>
