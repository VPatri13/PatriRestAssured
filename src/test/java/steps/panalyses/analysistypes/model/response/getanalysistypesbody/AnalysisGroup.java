package steps.panalyses.analysistypes.model.response.getanalysistypesbody;

public class AnalysisGroup {
    private String name;
    private boolean is_default;
    private int id;

    public AnalysisGroup(String name, boolean is_default, int id) {
        this.name = name;
        this.is_default = is_default;
        this.id = id;
    }

    public AnalysisGroup() {
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isIs_default() {
        return is_default;
    }
}
