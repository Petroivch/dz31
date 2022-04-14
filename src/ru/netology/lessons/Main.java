package ru.netology.lessons;
import java.io.*;

public class Main {
    static private final StringBuilder builder = new StringBuilder();

    static void makeDir(String pathDir) {
        File dir = new File(pathDir);
        try {
            builder.append(dir.mkdirs() ? "Стуктура каталогов создана " + dir.getCanonicalPath() + "\n" :
                    "Ошибка при создании структуры каталогов " + dir.getCanonicalPath() +
                            ". (Возможно, каталоги уже существуют).\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            builder.append(ex.getMessage());
        }
    }

    static void createFile(String nameFile) {
        File newFile = new File(nameFile);
        try {
            builder.append(newFile.createNewFile() ? "Файл создан " + newFile.getCanonicalFile() + "\n" :
                    "Ошибка при создании файла " + newFile.getCanonicalFile() + ". (Возможно, файл уже существует).\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            builder.append(ex.getMessage());
        }
    }

    public static void writeLog(String nameFile, String logOut) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nameFile, true))) {
            bw.write(logOut);
            bw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            builder.append(ex.getMessage());
        }
    }

    static void saveLog(String nameFile) {
        String logOut = builder.toString();
        writeLog(nameFile, logOut);
    }

    public static void main(String[] args) {
        makeDir("./Games/src/main");
        makeDir("./Games/src/test");
        makeDir("./Games/res/drawables");
        makeDir("./Games/res/vectors");
        makeDir("./Games/res/icons");
        makeDir("./Games/savegames");
        makeDir("./Games/temp");
        createFile("./Games/src/main/Main.java");
        createFile("./Games/src/main/Utils.java");
        createFile("./Games/temp/temp.txt");
        saveLog("./Games/temp/temp.txt");
    }
}