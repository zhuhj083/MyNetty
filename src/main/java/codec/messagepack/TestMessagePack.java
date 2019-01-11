package codec.messagepack;

import org.msgpack.MessagePack;

import java.io.IOException;

public class TestMessagePack {

    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo(30, "navy");

        MessagePack pack = new MessagePack();
        byte[] bs = pack.write(info);

        UserInfo info2 = pack.read(bs, UserInfo.class);
        System.out.println(info2);

    }
}
