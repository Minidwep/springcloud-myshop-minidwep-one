import com.minidwep.myshop.domain.TbPermission;
import com.minidwep.myshop.mapper.TbPermissionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class OAuth2Test {
    @Resource
    TbPermissionMapper tbPermissionMapper;
    @Test
    void contextLoads() {
        List<TbPermission> tbPermissions = tbPermissionMapper.selectByUserId(37);
        System.out.println(tbPermissions.size());
    }
  }
