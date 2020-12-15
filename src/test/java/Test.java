import com.pzyruo.domain.User;
import com.pzyruo.service.impl.UserServiceImpl;

public class Test {
    @org.junit.Test
    public void Test01(){
        final User zs = new UserServiceImpl().login("zs", "123456");
        System.out.println(zs);
    }
}
