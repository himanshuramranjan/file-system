import java.util.ArrayList;
import java.util.List;

public class Folder implements Directory {
    private final String directoryName;
    private final List<Directory> directories;

    public Folder(String folderName) {
        this.directoryName = folderName;
        this.directories = new ArrayList<>();
    }

    public void add(Directory directory) {
        directories.add(directory);
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    @Override
    public String getName() {
        return directoryName;
    }

    @Override
    public void ls() {
        System.out.println("Folder: " + directoryName);
        for (Directory directory : directories) {
            directory.ls();
        }
    }
}
