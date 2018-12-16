package jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "service", eager = true)
@SessionScoped
public class ManagedBeanService {

    private int min;

    private int max;

    private int result;

    private List<Integer> range;

    public ManagedBeanService() {
        range = new ArrayList<>();
    }

    public String initRange() {
        for (int i = min; i <= max; i++) {
            range.add(i);
            System.out.println("add --- " + i);
        }
        return play();
    }

    public String play() {
        if (range.isEmpty()) {
            return "scam";
        }
        result = range.get(range.size()/2);
        System.out.println("Rang -- " + range + " Result " + result);
        return "play";
    }

    public String lessNumber() {
        List<Integer> subList = range.subList(range.size()/2, range.size());
        range.removeAll(subList);
        System.out.println("Less Range -- " + range);
        return play();
    }

    public String moreNumber() {
        List<Integer> subList = range.subList(0, (range.size()/2) + 1);
        range.removeAll(subList);
        System.out.println("More Range -- " + range);
        return play();
    }

    public String resetRange() {
        range = new ArrayList<>();
        return "form";
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public List<Integer> getRange() {
        return range;
    }

    public void setRange(List<Integer> range) {
        this.range = range;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
