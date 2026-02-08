public class File implements Directory {

    private final String fileName;
    private final String content;

    public File(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    @Override
    public String getName() {
        return fileName;
    }

    @Override
    public void ls() {
        System.out.println("File: " + fileName);
    }

    public String getContent() {
        return content;
    }
}
