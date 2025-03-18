package steps.panalyses.model.response.analysis_types_body;

public class AnalysisGroup {
    public String name;
    public boolean is_default;
    public int id;

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
