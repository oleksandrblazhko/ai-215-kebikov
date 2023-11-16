# Використання JUnit в Android Studio з Kotlin

JUnit - це фреймворк для тестування одиниць програмного забезпечення в середовищі Java. У контексті використання в Android Studio на мові Kotlin, JUnit є ключовим інструментом для написання тестів, які перевіряють правильність роботи коду Android додатків.

## Процес використання JUnit в Android Studio на мові Kotlin

1. ### Додавання залежностей:** В файлі `build.gradle` проекту потрібно вказати залежність від JUnit, щоб Android Studio зміг використовувати його для тестування. Наприклад:

    ```kotlin
    testImplementation 'junit:junit:4.13.2'
    ```

2. ### Створення тестових класів: Створюються класи для тестування, де пишуться методи, що перевіряють правильність роботи різних частин коду.

    ```kotlin
    import org.junit.Test
    import static org.junit.Assert.assertEquals

    class MyTest {
        @Test
        fun testAddition() {
            //test e.g: and compare to result
            1+1
            assertEquals(2, result)
        }
    }
    ```

3. ### Анотації JUnit: Анотації JUnit - `@Test`,для позначення методу, який повиний виконуватися як тест.

4. ### Запуск тестів: Можна запускати тести безпосередньо у Android Studio.
