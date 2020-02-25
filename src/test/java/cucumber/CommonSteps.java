package cucumber;

import com.springyapi.models.User;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CommonSteps {

    //  Any common functionality to go here.

    public static String readFile(String path) throws IOException {
        Charset encoding = StandardCharsets.US_ASCII;
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
