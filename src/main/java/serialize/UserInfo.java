package serialize;

import java.io.Serializable;
import java.nio.ByteBuffer;

public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userName;
    private int userId;

    public UserInfo buildUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserInfo buildUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public final String getUserName() {
        return userName;
    }

    public final void setUserName(String userName) {
        this.userName = userName;
    }

    public final void setUserId(int userId) {
        this.userId = userId;
    }

    public final int getUserId() {
        return userId;
    }

    //使用基于ByteBuffer的通用二进制编解码技术对UserInfo对象进行编码，编码结果仍然是byte数组，可以与传统的JDK序列化后的码流大小进行比较
    public byte[] codeC() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        return codeC(buffer);
    }

    public byte[] codeC(ByteBuffer buffer) {
        buffer.clear();
        byte[] value = this.userName.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(this.userId);
        buffer.flip();
        value = null;
        byte[] result = new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }

}
