public class FileSystem {

    private final Folder root;

    public FileSystem(Folder root) {
        this.root = root;
    }

    // Navigate to a directory
    public Folder cd(String directoryPath) {
        String[] parts = directoryPath.split("/");
        Folder current = root;

        for (String part : parts) {
            if (part.isEmpty() || part.equals(root.getName())) continue;

            boolean found = false;

            for (Directory dir : current.getDirectories()) {
                if (dir instanceof Folder && dir.getName().equals(part)) {
                    current = (Folder) dir;
                    found = true;
                    break;
                }
            }

            if (!found) {
                throw new RuntimeException("Directory not found: " + part);
            }
        }

        return current;
    }

    // Read file content
    public String less(String filePath) {
        String[] parts = filePath.split("/");
        Folder current = root;

        for (int i = 0; i < parts.length - 1; i++) {
            String part = parts[i];

            if (part.isEmpty() || part.equals(root.getName())) continue;

            boolean found = false;

            for (Directory dir : current.getDirectories()) {
                if (dir instanceof Folder && dir.getName().equals(part)) {
                    current = (Folder) dir;
                    found = true;
                    break;
                }
            }

            if (!found) {
                throw new RuntimeException("Directory not found: " + part);
            }
        }

        String fileName = parts[parts.length - 1];

        for (Directory dir : current.getDirectories()) {
            if (dir instanceof File && dir.getName().equals(fileName)) {
                return ((File) dir).getContent();
            }
        }
        throw new RuntimeException("File not found: " + fileName);
    }
}
