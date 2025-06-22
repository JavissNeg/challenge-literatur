package com.negrete.challenge_literatura;

import com.negrete.challenge_literatura.model.Book;
import com.negrete.challenge_literatura.model.BookData;
import com.negrete.challenge_literatura.model.Author;
import com.negrete.challenge_literatura.model.Language;
import com.negrete.challenge_literatura.service.BookService;
import com.negrete.challenge_literatura.service.GutenbergService;
import com.negrete.challenge_literatura.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal implements CommandLineRunner {

    @Autowired
    private GutenbergService gutendexService;
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @Override
    public void run(String... args) {
        showMenu();
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        String menu = """
            \n=== Challenge Literatura ===
            1. Buscar un libro por título
            2. Mostrar libros guardados
            3. Mostrar autores guardados
            4. Mostrar autores vivos antes de un año determinado
            5. Mostrar libros por idioma
            
            0. Salir
            
            Seleccione una opción:
            """;

        do {
            System.out.print(menu);
            String input = scanner.nextLine();

            if (!isNumeric(input))
                option = -1;
            else
                option = Integer.parseInt(input);

            System.out.println();

            switch (option) {
                case 1 -> searchBookByTitle(scanner);
                case 2 -> showSavedBooks();
                case 3 -> showSavedAuthors();
                case 4 -> showLivingAuthorsBeforeYear(scanner);
                case 5 -> showBooksByLanguage(scanner);
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción no válida.");
            }
        } while (option != 0);
    }

    private void searchBookByTitle(Scanner scanner) {
        System.out.print("Ingrese el título del libro: ");
        String title = scanner.nextLine();

        gutendexService.searchBookByTitle(title)
            .ifPresentOrElse(
                bookData -> {
                    Book book = bookService.addBook(bookData);
                    System.out.println("\nLibro guardado: " + book.getTitle());
                },
                () -> System.out.println("\nNo se encontró ningún libro con ese título.")
            );
    }

    private void showSavedBooks() {
        bookService.getAllBooks().ifPresentOrElse(
            books -> {
                System.out.println("\n[Libros guardados]");
                for (Book book : books) {
                    System.out.println("- " + book.getTitle() + " (" + book.getLanguage() + ")");
                }
            },
            () -> System.out.println("\nNo hay libros guardados.")
        );
    }

    private void showSavedAuthors() {
        authorService.getAllAuthors().ifPresentOrElse(
            authors -> {
                System.out.println("\n[Autores guardados]");

                for (Author author : authors) {
                    System.out.print("- " + author.getName());

                    if (author.getBirthYear() != null) {
                        System.out.print(" (Nacido: " + author.getBirthYear());

                        if (author.getDeathYear() != null) {
                            System.out.print(", Fallecido: " + author.getDeathYear());
                        }
                        System.out.print(")");

                    }

                    System.out.println();
                }
            },
            () -> System.out.println("\nNo hay autores guardados.")
        );
    }

    private boolean isNumeric(String input) {
        return input != null && input.matches("\\d+");
    }

    private void showLivingAuthorsBeforeYear(Scanner scanner) {
        System.out.print("Ingrese el año de corte: ");
        String input = scanner.nextLine();

        if (!isNumeric(input)) {
            System.out.println("\nEntrada inválida. Debe ingresar solo números.");
            return;
        }

        int year = Integer.parseInt(input);
        authorService.getLivingAuthorsBeforeYear(year).ifPresentOrElse(
            authors -> {
                System.out.println("\n[Autores vivos antes de " + year + "]");

                for (Author author : authors) {
                    System.out.println("- " + author.getName() + " (Nacido: " + author.getBirthYear() + " - "+ "Muerte: " + author.getDeathYear() + ")");
                }
            },
            () -> System.out.println("\nNo hay autores vivos antes de " + year + ".")
        );
    }

    private void showBooksByLanguage(Scanner scanner) {
        Language[] languages = Language.values();

        System.out.println("\nSeleccione el idioma:");
        for (int i = 0; i < languages.length; i++) {
            System.out.println((i + 1) + ". " + languages[i].name());
        }

        System.out.print("\nIngrese el número de idioma: ");
        String input = scanner.nextLine();

        if (!isNumeric(input)) {
            System.out.println("\nOpción inválida.");
            return;
        }

        int option = Integer.parseInt(input);
        if (option < 1 || option > languages.length) {
            System.out.println("\nOpción fuera de rango.");
            return;
        }

        Language language = languages[option - 1];
        bookService.getBooksByLanguage(language).ifPresentOrElse(
            books -> {
                System.out.println("\n[Libros en idioma: " + language.name() + "]");
                for (Book book : books) {
                    System.out.println("- " + book.getTitle());
                }
            },
            () -> System.out.println("\nNo hay libros en el idioma: " + language.name())
        );
    }
}