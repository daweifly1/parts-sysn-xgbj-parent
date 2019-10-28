package cn.com.xgit.parts.rm.common.util.hessian2;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.SerializerFactory;
import com.google.common.hash.BloomFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Slf4j
public class Hessian2RedisSerializer implements RedisSerializer<Object> {
    SerializerFactory serializerFactory = new SerializerFactory(BloomFilter.class.getClassLoader());

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Hessian2Output hessian2Output = new Hessian2Output(byteArrayOutputStream);
            hessian2Output.setSerializerFactory(serializerFactory);
            hessian2Output.startMessage();
            hessian2Output.writeObject(o);
            hessian2Output.completeMessage();
            hessian2Output.close();
            return byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            log.warn("序列化异常");
            throw new RuntimeException(e);
        }

    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        Hessian2Input hessian2Input = new Hessian2Input(new ByteArrayInputStream(bytes));
        hessian2Input.setSerializerFactory(serializerFactory);
        try {
            hessian2Input.startMessage();
            Object o = hessian2Input.readObject();
            hessian2Input.completeMessage();
            hessian2Input.close();
            return o;
        } catch (IOException e) {
            log.warn("反序列化异常");
            throw new RuntimeException(e);
        }
    }
}
