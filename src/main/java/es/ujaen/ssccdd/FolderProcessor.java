package es.ujaen.ssccdd;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderProcessor extends RecursiveTask<List<String>> {

    private static final long serialVersioUID = 1L;

    private final String path;
    private final String extension;

    public FolderProcessor(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    @Override
    protected List<String> compute() {
        List<String> list = new ArrayList<>();
        List<FolderProcessor> tasks = new ArrayList<>();

        File file = new File(path);
        File[] content = file.listFiles();
        if (content != null) {
            for (File value : content) {
                if (value.isDirectory()) {
                    FolderProcessor task = new FolderProcessor(value.getAbsolutePath(), extension);
                    task.fork();
                    tasks.add(task);
                } else {
                    if (checkFile(value.getName()))
                        list.add(value.getAbsolutePath());
                }
            }
            if (tasks.size() > 50)
                System.out.println(file.getAbsolutePath() + ": " + tasks.size() + " tasks ran.\n");
            addResultsFromTasks(list, tasks);
        }
        return list;
    }

    private void addResultsFromTasks(List<String> list, List<FolderProcessor> tasks) {
        for (FolderProcessor item : tasks) {
            list.addAll(item.join());
        }
    }


    private boolean checkFile(String name) {
        return name.endsWith(extension);
    }

}
