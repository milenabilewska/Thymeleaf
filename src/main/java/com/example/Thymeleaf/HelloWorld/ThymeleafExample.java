//package com.example.Thymeleaf.HelloWorld;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.Context;
//
//import java.io.StringWriter;
//
//public class ThymeleafExample {
//
//    public static void main(String[] args) {
//        // Inicjalizacja silnika Thymeleaf
//        TemplateEngine templateEngine = new TemplateEngine();
//
//        // Utworzenie kontekstu Thymeleaf
//        Context context = new Context();
//        context.setVariable("pageTitle", "Thymeleaf Example");
//
//        // Renderowanie szablonu Thymeleaf
//        StringWriter writer = new StringWriter();
//        templateEngine.process("helloworld/hello.html", context, writer);
//        // Wyświetlenie wyniku
//        System.out.println(writer.toString());
//    }
//}
package com.example.Thymeleaf.HelloWorld;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.StringWriter;

import static java.lang.System.*;

public class ThymeleafExample {

    public static void main(String[] args) {
        // Inicjalizacja silnika Thymeleaf
        TemplateEngine templateEngine = new TemplateEngine();

        // Konfiguracja resolvera szablonów
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("helloworld/"); // Katalog, w którym znajdują się szablony
        templateResolver.setSuffix(".html");
        templateEngine.setTemplateResolver(templateResolver);

        // Utworzenie kontekstu Thymeleaf
        Context context = new Context();
        context.setVariable("pageTitle", "Thymeleaf Example");

        // Renderowanie szablonów Thymeleaf
        var writer = new StringWriter();
        templateEngine.process("index", context, writer); // Dodane renderowanie index.html
        out.println(writer.toString());

        writer = new StringWriter();
        templateEngine.process("hello", context, writer);
        out.println(writer.toString());

        writer = new StringWriter();
        templateEngine.process("hello2", context, writer);
        out.println(writer.toString());

        writer = new StringWriter();
        templateEngine.process("hello3", context, writer);
        out.println(writer.toString());
    }
}
