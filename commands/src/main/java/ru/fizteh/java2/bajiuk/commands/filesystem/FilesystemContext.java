package ru.fizteh.java2.bajiuk.commands.filesystem;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class FilesystemContext {
    private static final Logger log = LoggerFactory.getLogger(FilesystemContext.class);

    String currentDirectory;
    public FilesystemContext() {
        currentDirectory = System.getProperty("user.dir");
    }

    public String ls() {
        File folder = new File(currentDirectory);
        File[] list = folder.listFiles();

        StringBuilder builder = new StringBuilder();
        for(File x : list) {
            builder.append(" ");
            builder.append(x.getName());
        }
        if (list.length != 0) {
            builder.deleteCharAt(0);
        }
        String result = builder.toString();
        if (result.equals("")) {
            result = null;
        }

        if (list.length == 0) {
            log.warn("no files in directory!");
        }

        return result;
    }

    public String pwd() {
        return currentDirectory;
    }

    public String makeDir(String name) {
        String dir = FilenameUtils.concat(currentDirectory, name);
        File file = new File(dir);
        if (file.exists()) {
            return "File exists already!";
        }
        file.mkdirs();
        log.warn("directory {} created",name);
        return null;
    }

    public String rm(String name) {
        String fileName = FilenameUtils.concat(currentDirectory, name);
        File file = new File(fileName);
        try {
            FileUtils.forceDelete(file);
        } catch (IOException e) {
            return "Cannot delete";
        }
        return null;
    }

    public String cp(String src, String dest) {
        File source = new File (FilenameUtils.concat(currentDirectory, src));
        File destination = new File (FilenameUtils.concat(currentDirectory, dest));

        try {
            if (destination.getCanonicalPath().startsWith(source.getCanonicalPath())) {
                return "Bad idea";
            }
            if (source.isFile() && !destination.exists()) {
                FileUtils.copyFile(source, destination);
            } else if (source.isFile() && destination.isDirectory()) {
                FileUtils.copyFileToDirectory(source, destination);
            } else if (source.isDirectory() && !destination.exists()) {
                FileUtils.copyDirectory(source, destination);
            } else if (source.isDirectory() && destination.isDirectory()) {
                FileUtils.copyDirectoryToDirectory(source, destination);
            }
        } catch (IOException e) {
            return "File not exists";
        }
        return null;
    }

    public String cd(String to) {
        String name = FilenameUtils.concat(currentDirectory, to);
        File file = new File(name);
        if (file.exists() && file.isDirectory()) {
            currentDirectory = name;
            log.warn(name);
            return null;
        }
        return "Directory not found";
    }

    public String mv(String src, String dest) {
        String result = cp(src, dest);
        if (result != null) {
            return result;
        }
        return rm(src);
    }
}
