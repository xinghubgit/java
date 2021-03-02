package com.allen.svc.file;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileTest {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("region", "region.json"));


        Map<String, String> collect = bufferedReader.lines()
                .map(x -> {
                    try {
                        RegionInfo regionInfo = mapper.readValue(x, RegionInfo.class);
                        return regionInfo;
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(z -> Objects.nonNull(z))
                .collect(Collectors.toMap(y -> y.getRegionCode(), y -> y.getRegionDetail()));




        collect.entrySet().stream().forEach(x -> System.out.println("key:" + x.getKey() + " value:" + x.getValue()));






//        Files.is

//        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("region", "text.txt"), StandardOpenOption.WRITE);
//        bufferedWriter.write("CSF00000&&&&wwwwwwwwwwwwwwwwweeeeeeeeeeeessseeeeeeeeeeeeee");
//        bufferedWriter.newLine();
//        bufferedWriter.write("CSF00001&&&&wwwwwwwwwwwwwwwwweeeeeeeeeeeessseeeeeeeeeeeeee");
//        bufferedWriter.flush();
//        bufferedWriter.close();
    }
}
