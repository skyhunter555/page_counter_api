package ru.syntez.page.counter.api.utils;

import ru.syntez.page.counter.api.entities.FileExtensionEnum;

import java.util.Optional;

/**
 * Extension file utils
 *
 * @author Skyhunter
 * @date 12.12.2020
 */
public class ExtensionFileUtils {

    public static Optional<String> getExtensionFile(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }

    public static boolean isFileExtensionPresent(String fileName) {
        for (FileExtensionEnum extension: FileExtensionEnum.values()) {
            if (ExtensionFileUtils.getExtensionFile(fileName).isPresent()) {
                return true;
            }
        }
        return false;
    }

}
