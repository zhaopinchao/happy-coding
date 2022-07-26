package com.study.rpc.serialize;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

/**
 * @author zhaopc
 * @date 2021/7/19 19:58
 */
public class ProtostuffTest {
    public static void main(String[] args) {
        Student student = new Student("hello", "man", System.currentTimeMillis());

        Schema<Student> schema = RuntimeSchema.getSchema(Student.class);

        LinkedBuffer buffer = LinkedBuffer.allocate(512);


        final byte[] protostuff;
        try {
            protostuff = ProtostuffIOUtil.toByteArray(student, schema, buffer);
        } finally {
            buffer.clear();
        }

        for (int i = 0; i < protostuff.length; i++) {
            System.out.print(Integer.toHexString(protostuff[i] & 0xff) + " ");
        }
        System.out.println();
        System.out.println("长度：" + protostuff.length);

        // deser
        Student fooParsed = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(protostuff, fooParsed, schema);
        System.out.println(fooParsed);
    }
}
