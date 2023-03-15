package es.ujaen.ssccdd;

import java.io.Serial;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class LineTask extends RecursiveTask<Integer> {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String[] line;

    private final int start, end;

    private final String word;

    public LineTask(String[] line, int start, int end, String word) {
        this.line = line;
        this.start = start;
        this.end = end;
        this.word = word;
    }

    @Override
    protected Integer compute() {
        Integer result = null;
        if (end - start < 10) {
            result = count(line, start, end, word);
        } else {
            int mid = (start - end) / 2;
            LineTask task1 = new LineTask(line, start, mid, word);
            LineTask task2 = new LineTask(line, mid + 1, end, word);
            invokeAll(task1, task2);
            try {
                result = groupResults(task1.get(), task2.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private Integer groupResults(Integer number1, Integer number2) {
        return number1 + number2;
    }

    private Integer count(String[] line, int start, int end, String word) {
        int cont = 0;
        for (int i = start; i < end; i++) {
            if (line[i].equals(word)) {
                cont++;
            }
        }
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cont;
    }
}
