package edu.axboot.utils;

import org.hashids.Hashids;

import java.util.UUID;

public class UUIDUtils {
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    public static String shortUUID() {
        Hashids hashids = new Hashids(randomUUID());
        return hashids.encode(System.currentTimeMillis());
    }
}
