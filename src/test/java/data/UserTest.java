package data;

import com.ypacm.user.UserServiceApp;
import com.ypacm.user.data.entity.User;
import com.ypacm.user.data.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserServiceApp.class)
public class UserTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {

        // 创建10条记录
        userRepository.save(new User("AAA","AAA", "AAA"));
        userRepository.save(new User("BBB","BBB", "BBB"));
        userRepository.save(new User("CCC","CCC", "CCC"));
        userRepository.save(new User("DDD","DDD", "DDD"));
        userRepository.save(new User("EEE","EEE", "EEE"));
        userRepository.save(new User("FFF","FFF", "FFF"));
        userRepository.save(new User("GGG","GGG", "GGG"));
        userRepository.save(new User("HHH","HHH", "HHH"));
        userRepository.save(new User("III","III", "III"));
        userRepository.save(new User("JJJ","JJJ", "JJJ"));

        // 测试findAll, 查询所有记录
        Assert.assertEquals(10, userRepository.findAll().size());

        // 测试findByName, 查询姓名为FFF的User
        Assert.assertEquals("FFF", userRepository.findByAccount("FFF").getPassword());

        // 测试删除姓名为AAA的User
        userRepository.delete(userRepository.findByAccount("AAA"));

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        Assert.assertEquals(9, userRepository.findAll().size());

    }
}