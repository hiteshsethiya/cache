package com.cache.app;

import com.cache.app.cache.CacheConfiguration;
import com.cache.app.cache.RCache;
import com.cache.app.enums.DataStore;
import com.cache.app.enums.EvictionPolicy;

import java.util.Scanner;

public class RCacheApplication {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please pass configuration!");
        }

        int size = Integer.parseInt(args[0]);
        String dataStore = args[1];
        String evictionPolicy = args[2];

        EvictionPolicy ePolicy = EvictionPolicy.valueOf(evictionPolicy);
        DataStore dStore = DataStore.valueOf(dataStore);

        CacheConfiguration cacheConfiguration = CacheConfiguration
                .builder()
                .cacheSize(size)
                .evictionPolicy(ePolicy)
                .dataStore(dStore)
                .build();

        RCache rCache = new RCache(cacheConfiguration);

        try (Scanner scanner = new Scanner(System.in)) {
            String command;
            while (scanner.hasNext()) {
                command = scanner.nextLine();
                parseCommand(command, rCache);
            }
        }
    }

    private static void parseCommand(String argument, RCache rCache) {

        String[] splitCommand = argument.trim().split(" ");

        String command = splitCommand[0].trim().toUpperCase();

        switch (command) {
            case "READ": {
                String key = splitCommand[1];
                if (key == null || key.isEmpty()) {
                    System.out.println("Key cannot be empty!");
                } else {
                    Object value = rCache.get(key);
                    if(value == null) {
                        System.out.println("Not found!");
                    } else {
                        System.out.println(value);
                    }
                }
            }
            break;

            case "PUT": {
                String key = splitCommand[1];
                String value = splitCommand[2];
                if (key == null || key.isEmpty()) {
                    System.out.println("Key cannot be empty!");
                } else {
                    rCache.put(key, value);
                    System.out.println("OK");
                }
            }
            break;

            case "REMOVE": {
                String key = splitCommand[1];
                if (key == null || key.isEmpty()) {
                    System.out.println("Key cannot be empty!");
                } else {
                    rCache.remove(key);
                    System.out.println("OK");
                }
            }
            break;

            case "FULL": {
                System.out.println(rCache.isFull());
            }
            break;
        }
    }
}
