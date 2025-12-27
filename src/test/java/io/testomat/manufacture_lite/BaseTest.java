package io.testomat.manufacture_lite;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;

public class BaseTest {

    public static Dotenv env = Dotenv.configure().ignoreIfMissing().load();

    static {
        Configuration.baseUrl = env.get("BASE_URL");
    }
}
