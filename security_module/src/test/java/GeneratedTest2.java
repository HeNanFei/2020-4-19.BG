import org.springframework.security.crypto.bcrypt.BCrypt;

public class GeneratedTest2 {

    public static void main(String[] args) {
        System.out.println( BCrypt.hashpw("summer",BCrypt.gensalt()));

        System.out.println(BCrypt.checkpw("psw","$2a$10$XoFQ/IbVfmhuMm.HeQNDO.1NtM3jNaKa0WrbXHjreEq5cT.ClDOxO"));

/*
        System.out.println(BCrypt.checkpw("123","$2a$10$T3pn8ZfyrTQ1F31bHrudYesv/ooQnzX9eNlNpnKvAxEr4O213AM8e"));
*/
    }

}
