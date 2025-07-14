class FileSystem {
    File rootDir;
    public FileSystem() {
        rootDir = new Directory("/");
    }
    
    public List<String> ls(String path) {
        File dir = searchFileCreateFileIfNotExisted(path, true);
        if(dir instanceof ContentFile){
            List<String> res = new ArrayList<>();
            res.add(dir.name);
            return res;
        }
        return dir.ls();
    }
    
    public void mkdir(String path) {
        searchFileCreateFileIfNotExisted(path, true);
    }
    
    public void addContentToFile(String filePath, String content) {
        File f = searchFileCreateFileIfNotExisted(filePath, false);
        f.addContentToFile(content);
    }
    
    public String readContentFromFile(String filePath) {
        File f = searchFileCreateFileIfNotExisted(filePath, false);
        return f.readContentFromFile();
    }

    public File searchFileCreateFileIfNotExisted(String filePath, boolean isDir){
        String[] pathNames = filePath.split("/");
        File parentDir = rootDir;
        File curFile = rootDir;
        for(int i = 1; i < pathNames.length; i++){
            String filename = pathNames[i];
            curFile = parentDir.findSubFile(filename);
            if(curFile == null){
                return createFile(parentDir, pathNames, i, isDir);
            }
            parentDir = curFile;

        }
        return curFile;
    }

    public File createFile(File parentDir, String[] absolutePath, int level, boolean isDir){
        for(int i = level; i < absolutePath.length; i++){
            if(i == absolutePath.length - 1 && !isDir){
                File newFile = new ContentFile(absolutePath[i]);
                parentDir.createSubFile(absolutePath[i], newFile);
                return newFile;
            }
            File newDir = new Directory(absolutePath[i]);
            parentDir.createSubFile(absolutePath[i], newDir);
            parentDir = newDir;
        }
        return parentDir;
    }


}

class File{
    String name;
    public File(String name){
        this.name = name;
    } 

    public List<String> ls(){
        return new ArrayList<>();
    }

    public void addContentToFile(String content){
        return;
    } 

    public String readContentFromFile(){
        return "";
    }

    public File findSubFile(String name){
        return null;
    }

    public void createSubFile(String name, File file){}
}

class Directory extends File{
    Map<String, File> subDirFiles;
    public Directory(String name){
        super(name);
        subDirFiles = new TreeMap<>();
    }

    public List<String> ls(){
        return new ArrayList<>(subDirFiles.keySet());
    }

    public File findSubFile(String name){
        return subDirFiles.getOrDefault(name, null);
    }

    public void createSubFile(String name, File file){
        subDirFiles.put(name, file);
    }
}

class ContentFile extends File{
    String content;
    public ContentFile(String name, String content){
        super(name);
        this.content = content;
    }

    public ContentFile(String name){
        super(name);
        content = "";
    }

    public void addContentToFile(String content){
        this.content += content;
    } 

    public String readContentFromFile(){
        return content;
    }

}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */