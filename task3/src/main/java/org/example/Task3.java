package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        String pathTests = args[0];
        String pathValues = args[1];

        File testFile = new File(pathTests);
        File valuesFile = new File(pathValues);

        try {
            // Считываем json "test.json" в StringBuilder, чтобы получить строку с содержанием файла
            Scanner scanner = new Scanner(testFile);
            StringBuilder sbTests = new StringBuilder();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                sbTests.append(line);
            }

            // Считываем json "values.json" в StringBuilder, чтобы получить строку с содержанием файла
            scanner = new Scanner(valuesFile);
            StringBuilder sbValues = new StringBuilder();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                sbValues.append(line);
            }

            String testsJson = sbTests.toString();
            String valuesJson = sbValues.toString();

            // Получаем Map из id теста и статуса теста, из файла value.json
            Map<Integer, String> idValue = getIdValues(valuesJson);

            JsonNode rootNode = mapper.readTree(testsJson);

            // Вставляем все значения из values.json в tests.json
            putValueToTests(idValue, rootNode.get("tests"));

            // сохраняем полученную структуру в файл
            saveToFile(rootNode.toString());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static Map<Integer, String> getIdValues(String valuesJson) throws JsonProcessingException {
        Map<Integer, String> idValues = new HashMap<>();

        JsonNode valuesNode = mapper.readTree(valuesJson);


        if (valuesNode.get("values").isArray()) {
            for (JsonNode valueNode : valuesNode.get("values")) {
                int id = Integer.parseInt(valueNode.get("id").asText());
                String value = valueNode.get("value").asText();

                idValues.put(id, value);
            }
        }

        return idValues;

    }

    private static void putValueToTests(Map<Integer, String> idValue, JsonNode valuesNode) throws JsonProcessingException {

        if (valuesNode.isArray()) {

            for (JsonNode valueNode : valuesNode) {
                int id = Integer.parseInt(valueNode.get("id").asText());
                String status = idValue.get(id);

                if (status != null) {
                    ObjectNode objectNode = (ObjectNode) valueNode;
                    objectNode.put("value", status);
                }

                JsonNode nestedValues = valueNode.get("values");

                if (nestedValues != null) {
                    putValueToTests(idValue, nestedValues);
                }

            }
        }
    }

    private static void saveToFile(String jsonToWrite) throws IOException {
        Path path = Paths.get("report.json");
        byte[] strToBytes = jsonToWrite.getBytes();

        Files.write(path, strToBytes);
    }
}