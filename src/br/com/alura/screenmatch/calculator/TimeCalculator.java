package br.com.alura.screenmatch.calculator;

import br.com.alura.screenmatch.model.Title;

public class TimeCalculator {
    private int totalTime = 0;

    public int getTotalTime() {
        return this.totalTime;
    }

    public void includeTitle(Title title) {
        this.totalTime += title.getMinuteLength();
    }
}
