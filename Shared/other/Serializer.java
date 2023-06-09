﻿package Shared.other;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class Serializer {
    public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteIn = new ByteArrayInputStream(Base64.getMimeDecoder().decode(bytes));
        ObjectInputStream in = new ObjectInputStream(byteIn);
        return in.readObject();
    }
    public static byte[] serialize(Object object) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream serializer = new ObjectOutputStream(byteStream);
        serializer.writeObject(object);
        return Base64.getEncoder().encode(byteStream.toByteArray());
    }
}
