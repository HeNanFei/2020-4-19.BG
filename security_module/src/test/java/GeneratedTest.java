
import com.zjt.security.utils.JwtTokenUtil;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GeneratedTest {

    public static void main(String[] args) {
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        ArrayList arrayList = new ArrayList();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("roleid"+":"+"authority name");
        arrayList.add(simpleGrantedAuthority);
        String s = jwtTokenUtil.generateToken(new User("user", "psw", arrayList));
        System.out.println(s);
    }

}
