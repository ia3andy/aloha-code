package ilove.quark.us

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class MyHelloExample {

    fun hello(): String {
        return "My Example Hello Quarkus Codestart"
    }
}
