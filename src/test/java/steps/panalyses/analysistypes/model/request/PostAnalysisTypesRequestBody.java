package steps.panalyses.analysistypes.model.request;

public class PostAnalysisTypesRequestBody {
    public String name;
    public boolean is_default;
    public int analysis_group_id;

    public PostAnalysisTypesRequestBody(String name, boolean is_default, int analysis_group_id) {
        this.name = name;
        this.is_default = is_default;
        this.analysis_group_id = analysis_group_id;
    }

    public String getName() {
        return name;
    }

    public boolean isIs_default() {
        return is_default;
    }

    public int getAnalysis_group_id() {
        return analysis_group_id;
    }
}
