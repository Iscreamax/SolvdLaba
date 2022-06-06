package mobilestore.pattern.observer;

import java.util.*;

public class JavaDeveloperMobileStore implements Observed {
    List<String> monthlyPlans = new ArrayList<>();
    List<Observer> subscribers = new ArrayList<>();

    public void addMonthlyPlan(String monthlyPlan) {
        this.monthlyPlans.add(monthlyPlan);
        notifyObservers();

    }

    @Override
    public void addObserver(Observer observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : subscribers) {
            observer.notify(this.monthlyPlans);
        }

    }
}
