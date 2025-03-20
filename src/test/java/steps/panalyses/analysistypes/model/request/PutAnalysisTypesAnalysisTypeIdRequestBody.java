package steps.panalyses.analysistypes.model.request;

public class PutAnalysisTypesAnalysisTypeIdRequestBody {

    private String name;
    private boolean is_default;
    private int analysis_group_id;

    public PutAnalysisTypesAnalysisTypeIdRequestBody(String name, int analysis_group_id, boolean is_default) {
        this.name = name;
        this.analysis_group_id = analysis_group_id;
        this.is_default = is_default;
    }

    public String getName() {
        return name;
    }

    public int getAnalysis_group_id() {
        return analysis_group_id;
    }

    public boolean isIs_default() {
        return is_default;
    }
}
