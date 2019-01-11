package codec.messagepack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * MessagePack 编码器开发
 */
public class MsgpackEncoder extends MessageToByteEncoder<Object> {

    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        MessagePack msgpack = new MessagePack();

        //Serialize
        byte[] raw = msgpack.write(o);
        byteBuf.writeBytes(raw);
    }
}
