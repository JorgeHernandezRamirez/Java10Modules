module com.jorgehernandezramirez.java.modules.user.impl {
    requires transitive com.jorgehernandezramirez.java.modules.user.api;
    requires transitive slf4j.api;
    provides com.jorgehernandezramirez.java.modules.user.api.IUserService
            with com.jorgehernandezramirez.java.modules.user.impl.UserServiceDummyImpl;

}