package com.epam.rd.autocode.assessment.basics.service;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class CsvStorageImpl implements CsvStorage {

    private String encoding;
    private String quoteCharacter;
    private String valuesDelimiter;
    private boolean headerLine;

    public CsvStorageImpl() {
        // Inicializar las propiedades con los valores por defecto
        this.encoding = "UTF-8";
        this.quoteCharacter = "\"";
        this.valuesDelimiter = ",";
        this.headerLine = true;
    }

    public CsvStorageImpl(Map<String, String> props) {
        // Inicializar las propiedades con los valores proporcionados en el mapa de propiedades
        this.encoding = props.getOrDefault("encoding", "UTF-8");
        this.quoteCharacter = props.getOrDefault("quoteCharacter", "\"");
        this.valuesDelimiter = props.getOrDefault("valuesDelimiter", ",");
        this.headerLine = Boolean.parseBoolean(props.getOrDefault("headerLine", "true"));
    }

    @Override
    public <T> List<T> read(InputStream source, Function<String[], T> mapper) throws IOException {
        // Implementar la lógica de lectura de CSV
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(source, encoding))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Separar la línea en valores utilizando el delimitador
                String[] values = line.split(valuesDelimiter);
                // Convertir los valores en un objeto usando el mapper y agregarlo a la lista
                T object = mapper.apply(values);
                // Agregar la lógica para procesar el objeto, como agregarlo a una lista
            }
        }
        // Devolver la lista de objetos procesados
        return null; // Cambiar esto para devolver la lista real de objetos
    }

    @Override
    public <T> void write(OutputStream dest, List<T> values, Function<T, String[]> mapper) throws IOException {
        // Implementar la lógica de escritura de CSV
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(dest, encoding))) {
            for (T value : values) {
                // Convertir el objeto en una cadena de valores usando el mapper
                String[] valueArray = mapper.apply(value);
                // Concatenar los valores en una línea de CSV
                String line = String.join(valuesDelimiter, valueArray);
                // Escribir la línea en el archivo de salida
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
