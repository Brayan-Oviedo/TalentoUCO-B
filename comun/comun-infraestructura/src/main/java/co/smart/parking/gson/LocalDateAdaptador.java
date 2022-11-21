package co.smart.parking.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateAdaptador extends TypeAdapter<LocalDateTime> {

    private static String FORMATO_FECHA = "dd-MM-yyyy";
    DateTimeFormatter format = DateTimeFormatter.ofPattern(FORMATO_FECHA);

    @Override
    public void write(JsonWriter out, LocalDateTime value) throws IOException {
        if(value != null)
            out.value(value.format(format));
    }

    @Override
    public LocalDateTime read(JsonReader in) throws IOException {
        return LocalDateTime.parse(in.nextString(), format);
    }
}

