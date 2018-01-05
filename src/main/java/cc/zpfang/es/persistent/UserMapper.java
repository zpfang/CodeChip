package cc.zpfang.es.persistent;

import cc.zpfang.es.model.User;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description:
 * Created by zpfang on 2017/7/9.
 */
public interface UserMapper {

    @Select("SELECT x.id, x.name, x.age, x.group_code groupCode, x.address FROM user x WHERE x.id >= ${startOffset} LIMIT 1000")
    @ResultType(value = User.class)
    List<User> getUserList(Long startOffset);

    @Select("SELECT count(*) FROM user")
    Long getCountUser();
}
