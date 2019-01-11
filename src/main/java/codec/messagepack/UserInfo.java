package codec.messagepack;

import org.msgpack.annotation.Message;

@Message
public class UserInfo {
    private int age;
    private String name;

    public UserInfo(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public UserInfo() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static UserInfo[] userInfos(int number) {
        UserInfo[] userInfos = new UserInfo[number];
        UserInfo userInfo = null;
        for (int i = 0; i < number; i++) {
            userInfo = new UserInfo();
            userInfo.setAge(i);
            userInfo.setName("ABCDEFG --> " + i);
            userInfos[i] = userInfo;
        }
        return userInfos;
    }

}
