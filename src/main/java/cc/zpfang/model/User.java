package cc.zpfang.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Description:
 * Created by zpfang on 2017/7/9.
 */
@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String address;
    private String groupCode;
}
