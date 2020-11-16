package ua.lviv.iot.career;

import java.io.IOException;

public class Career {

    // створив клас "Кар'єра", що є основною логікою в заданому завданні;

    public static void printGraph(int[][] currentOfGraph) {

        // у цьому рядку створена функція, яка буде виводити граф;
        // також було передано в якості параметру двозв'язний словник(список) поточного графа із яким працюю;

        for (int[] row : currentOfGraph) {

            // у циклі "for each" проходжу по кожному із рядків заданого графа, які розташовані на певному рівні
            // заданий граф, як піраміда, яка зображує структуру компанії, яка формує свою кар'єру;
            // має чотири позиції, у яких: 4 - нульова позиція, у кожного із наступних буде 1, 2, 3;

            for (int positionOfElement : row) {

                // кожен елемент в графі матиме свій індекс та власну позицію на певному рядку;
                // ця позиція, звичайно, задана у цілочисельному типі даних - int;
                System.out.print(positionOfElement + " ");

                // завдяки System.out.print() буду виводити позицію елементу, враховуючи конкатенацію із показником
                // запису цієї позиції у " ";
            }
            System.out.println();

            // використав для того, щоб розділяти кожен наступний вивід в окремий рядок;
        }
    }

    public static void main(String[] args) throws IOException {

        // у методі main буду працювати із input та output даними, а також із створенням об'єкту;
        // тому, у разі того, коли дані не будуть присутні, виконається throws IOException;

        int[][] currentOfGraph = CareerPathManager.readCurrentOfGraph("input.csv");

        // передаю сюди словник, який ініціалізовний в іншому класі;
        // йому присвоюю метод зчитування даного графу через ім'я файлу, де знаходиться його пірамідна структура;

        int quantityOfLevels = CareerPathManager.readQuantityOfLevels("input.csv");

        // передаю поле кількості рівнів на заданому графі, якому присвоюється клас, у якого є метод read()
        // для вичитування levels;

        CareerPath career = new CareerPath(quantityOfLevels, currentOfGraph);

        // створив об'єкт CareerPath, що ідентичний до назви іншого класу в цьому проєкті,
        // у якого є змінна career;
        // передав у параметри два поля;

        int maxSumOfExperience = CareerPathManager.countMaxSumOfExperience(career);

        // змінна maxSumOfExperience потрібна для того, щоб обрахувати максимальний та найкращий досвід,
        // який може здобути працівник, працюючи на нижньому рівні;

        CareerPathManager.writeMaxSumOfExperience("output.csv", maxSumOfExperience);

        // записуємо у файл, який передали у дужки, результат, що відповідатиме заданій умові завдання;

    }

}
