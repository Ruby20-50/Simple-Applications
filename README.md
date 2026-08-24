# Simple Applications

A collection of small Java desktop applications built with **JavaFX** and the **Model-View-Controller (MVC)** pattern. Each subfolder is an independent Maven project.

## Projects

### Currency Converter
Converts amounts between seven currencies (EUR, USD, TL, GBP, CHF, JPY, CNY) using a static exchange-rate lookup table. Includes a swap button and live conversion as you type.

- `CurrencyModel.java` — stores exchange rates and performs the conversion
- `CurrencyController.java` — handles input validation and UI events
- `CurrencyConverterView.java` / `currencyConvert-view.fxml` — UI layout

### LengthUnitConverter
Converts lengths between Meter, Feet, Yard, and Inch using precomputed conversion factors. Throws a custom `ConversionException` for unsupported unit pairs.

- `LengthConverter.java` — conversion logic
- `LengthController.java` — UI event handling
- `exceptions/ConversionException.java` — custom exception type

### Taschenrechner_U9
A basic calculator supporting addition, subtraction, multiplication, and division, with division-by-zero and invalid-input handling. Built as a coursework exercise on separating logic (Model) from UI (View) — see `Abschlussfragen.md` for the reflection questions and answers.

- `CalculatorModel.java` — arithmetic operations
- `CalculatorController.java` — wires UI buttons to the model
- `CalculatorView.java` / `hello-view.fxml` — UI layout

## Tech Stack

- Java 21
- JavaFX 17.0.2 (Controls + FXML)
- Maven (with Maven Wrapper included — no local Maven install required)
- JUnit 5.9.1 (test dependency, scaffolded but not yet used)

## Running a Project

Each app is self-contained. From inside a project folder:

```bash
./mvnw clean javafx:run
```

On Windows:

```cmd
mvnw.cmd clean javafx:run
```

## Architecture

All three apps follow the same MVC structure:

- **Model** — pure Java, holds data and business logic, no UI dependencies
- **View** — FXML layout (or a `View.java` class for Taschenrechner_U9)
- **Controller** — connects UI events to model logic, handles input validation and error messages

## Notes

- Exchange rates and conversion factors are hardcoded (no external API).
- Each project has its own `pom.xml`, `.gitignore`, and Maven wrapper — they build independently.