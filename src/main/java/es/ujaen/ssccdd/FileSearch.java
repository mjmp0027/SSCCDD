package es.ujaen.ssccdd;

import java.io.File;

public class FileSearch implements Runnable{

    private final String initPath;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    private final String fileName;


    @Override
    public void run() {
        File file = new File(initPath);
        if (file.isDirectory()) {
            try {
                directoryProcess(file);
            } catch (InterruptedException e) {
                System.out.printf("%s: The search has been interrupted",Thread.currentThread().getName());
                cleanResources();
            }
        }

    }

    private void cleanResources() {
    }

    private void directoryProcess(File file) throws InterruptedException {

        // Get the content of the directory
        File[] list = file.listFiles();
        if (list != null) {
            for (File value : list) {
                if (value.isDirectory()) {
                    // If is a directory, process it
                    directoryProcess(value);
                } else {
                    // If is a file, process it
                    fileProcess(value);
                }
            }
        }
        // Check the interruption
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    private void fileProcess(File file) throws InterruptedException {
        // Check the name
        if (file.getName().equals(fileName)) {
            System.out.printf("%s : %s\n",Thread.currentThread().getName() ,file.getAbsolutePath());
        }

        // Check the interruption
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }


}
