public class Main {
    public static void main(String[] args) {

        // Create root directory
        Folder root = new Folder("root");

        Folder docs = new Folder("docs");
        Folder projects = new Folder("projects");

        File file1 = new File("readme.txt", "This is the README file");
        File file2 = new File("design.txt", "LLD design content");

        projects.add(file2);
        docs.add(projects);
        docs.add(file1);

        root.add(docs);

        FileSystem fs = new FileSystem(root);

        System.out.println("\n--- Listing Root ---");
        root.ls();

        System.out.println("\n--- CD to /root/docs ---");
        Folder folder = fs.cd("/root/docs");
        folder.ls();

        System.out.println("\n--- Read File ---");
        System.out.println(fs.less("/root/docs/readme.txt"));
        System.out.println(fs.less("/root/docs/projects/design.txt"));
    }
}