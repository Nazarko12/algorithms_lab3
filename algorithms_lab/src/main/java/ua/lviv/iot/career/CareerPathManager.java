package ua.lviv.iot.career;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CareerPathManager {

    // створив цей клас для того, щоб оперувати над обрахунком та записом даних із графу,
    // які отримаю із заданого файлу;

    public static void writeMaxSumOfExperience(String fileName, int maxSumOfExperience) {

        // створена статична функція, яка не потребує створення об'єкту;
        // буде виводити суму максимального досвіду, яку може здобути працівник;
        // у параметри було передано два поля;
        // fileName містить в собі дані, у вигляді елементів графа;
        // maxSumOfExperience - сума досвіду працівника, якій присвоєно певне значення, вказане у завданні;

        FileWriter csvWriter = null;

        // оголосив змінну csvWriter, яку перевірятимемо на допустимість значення "null";
        // коли її вміст дорівнюватиме значенню, яке присвоєно, то буде викликатися виключення,
        // яке оброблено "try-catch";
        // отже, у результаті я не хочу отримати пустий файл;
        // але, знаючи про помилки самих програмістів, я користуюся правилом оброблення даних;
        // тому, якщо цей файл не буде заповнений, компілятор повідомить нам про це;

        try {

            csvWriter = new FileWriter(fileName);
            csvWriter.append(Integer.toString(maxSumOfExperience));

        } catch (IOException ioexception) {
            ioexception.printStackTrace();
        } finally {

            try {

                csvWriter.flush();
                csvWriter.close();

            } catch (IOException exception) {
                exception.printStackTrace();
            }

        }

    }

    public static int readQuantityOfLevels(String fileName) {

        // створена статична функція, яка буде зчитувати кількість рівнів із fileName;

        int quantityOfLevels = 0;

        // спочатку quantityOfLevels буде дорівнювати нулю;

        Path pathToFile = Paths.get(fileName);

        // у цьому рядку буду використовувати змінну pathToFile,
        // аби присвоїти їй через метод "get" шлях до файлу, переданого в дужках;

        try (BufferedReader bufferedReader = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

            // BufferedReader - зручний інтерфейс у мові програмування Java,
            // який працює із записами даних у файл та із зчитуванням цих записів із цього файлу;
            // обробляю наступні рядки try-catch";
            // якщо результатом не буде вивід цілочисельного значення, переведеного із String,
            // то отримаємо помилку;
            // важливо, щоб зчитування із цього файлу було відображено в Integer.parseInt,
            // який сформує Int із line;

            String line = bufferedReader.readLine();
            quantityOfLevels = Integer.parseInt(line);

        } catch (IOException ioexception) {
            ioexception.printStackTrace();
        }
        return quantityOfLevels;

        // повертаємо значення quantityOfLevels - 3, бо починаємо обрахунок із нуля;
    }

    public static int[][] readCurrentOfGraph(String fileName) {

        // тепер елементи графа по індексах будуть записані в комірках пам'яті;

        int[][] currentOfGraph = null;
        int quantityOfLevels;

        Path pathToFile = Paths.get(fileName);

        try (BufferedReader bufferedReader = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

            String thisLine = bufferedReader.readLine();
            quantityOfLevels = Integer.parseInt(thisLine);
            currentOfGraph = new int[quantityOfLevels][];
            thisLine = bufferedReader.readLine();
            int levelIndex = 0;

            while (thisLine != null) {
                currentOfGraph[levelIndex] = new int[levelIndex + 1];
                String[] numbers = thisLine.split(" ");

                for (int elementIndex = 0; elementIndex < (levelIndex + 1); elementIndex++) {
                    currentOfGraph[levelIndex][elementIndex] = Integer.parseInt(numbers[elementIndex]);
                }

               // Кожний наступний рівень по індексу має бути більший від попереднього елемента, що має індекс;

                levelIndex++;
                thisLine = bufferedReader.readLine();
            }

        } catch (IOException ioexception) {
            ioexception.printStackTrace();
        }
        return currentOfGraph;
    }

    public static int countMaxSumOfExperience(CareerPath career) {

        // створив функцію, яка буде рахувати максимальну суму досвіду працівників;
        // у параметр передано клас та змінну цього класу, який містить поля,
        // необхідні для визначення того, де знаходиться елемент (індекс цього елемента);


        for (int iteratorOfPosition = (career.quantityOfLevels - 2); iteratorOfPosition > -1; iteratorOfPosition--) {

            // у цьому циклі:
            // 1. створив змінну iteratorOfPosition для того, щоб знати, на якій позиції знаходиться елемент;
            // 2. після знаку " = " присвоїв через змінну career поле quantityOfLevels,
            // індекси на рівні якого будуть рухатися із L-2, не враховуючи спільний індекс (0),
            // де вписано число 4;
            // старт відбудеться з індексу 1;

            for (int iteratorOfElementsOnPosition = 0; iteratorOfElementsOnPosition < (iteratorOfPosition + 1); iteratorOfElementsOnPosition++) {

                // у цьому циклі:
                // 1. створив змінну iteratorOfPosition для знаходження індексу на графі;
                // 2. змінна iteratorOfElementsOnPosition дорівнюватиме нулю на початок операції;
                // 3. згодом буду рухатися по елементах цього графа так, щоб
                // кожна наступна позиція елемента на рівні була більшою від попереднього на 1 індекс;
                // 4. інкрементую наступну позицію завдяки iteratorOfElementsOnPosition++;
                // 5. "for" перебиратиме всі елементи в графі по індексах та позиціях, на яких вони розташовані;

                int leftReliantEmployeeExperience = career.currentOfGraph[iteratorOfPosition + 1][iteratorOfElementsOnPosition];
                int rightReliantEmployeeExperience = career.currentOfGraph[iteratorOfPosition + 1][iteratorOfElementsOnPosition + 1];

                // буду порівнювати елементи графа у трикутнику (елемент, що вище двох інших,
                // які розташовані один із одним по горизонталі в одному рядку);
                // це відбуватиметься, як і зліва, так і зправа;
                // присутні лівий та правий елементи в трикутнику;
                // сума із верхнім елементом;
                if (leftReliantEmployeeExperience > rightReliantEmployeeExperience) {
                    career.currentOfGraph[iteratorOfPosition][iteratorOfElementsOnPosition] += leftReliantEmployeeExperience;
                } else {
                    career.currentOfGraph[iteratorOfPosition][iteratorOfElementsOnPosition] += rightReliantEmployeeExperience;
                }

            }
        }
                // Якщо лівий елемент у сумі із верхнім більший, ніж елемент, що зправа, прилеглий(reliant)
                // до нього, то додаємо його;
                // Якщо правий елемент у сумі із верхнім більший, ніж елемент, що зліва, прилеглий(reliant)
                // до нього, то додаємо його;

        int maxSumOfExperience = career.currentOfGraph[0][0];

        return maxSumOfExperience;

        // отримаємо результат максимальної суми досвіду при додаванні елементів, які найбільші у своєму рядку;
    }

}
