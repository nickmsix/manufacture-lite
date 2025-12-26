package io.testomat.manufacture_lite;

import io.github.cdimascio.dotenv.Dotenv;

public class BaseTest {

    public static Dotenv env = Dotenv.configure().ignoreIfMissing().load();
}
