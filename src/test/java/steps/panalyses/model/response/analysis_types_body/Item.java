package steps.panalyses.model.response.analysis_types_body;

import java.util.ArrayList;

public class Item {
    public String name;
    public boolean is_default;
    public int analysis_group_id;
    public int id;
    public AnalysisGroup analysis_group;
    public ArrayList<LaboratoryAnalysis> laboratory_analyses;

    public Item(String name, boolean is_default, int analysis_group_id, int id, AnalysisGroup analysis_group, ArrayList<LaboratoryAnalysis> laboratory_analyses) {
        this.name = name;
        this.is_default = is_default;
        this.analysis_group_id = analysis_group_id;
        this.id = id;
        this.analysis_group = analysis_group;
        this.laboratory_analyses = laboratory_analyses;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public ArrayList<LaboratoryAnalysis> getLaboratory_analyses() {
        return laboratory_analyses;
    }

    public AnalysisGroup getAnalysis_group() {
        return analysis_group;
    }

    public int getId() {
        return id;
    }

    public int getAnalysis_group_id() {
        return analysis_group_id;
    }

    public boolean isIs_default() {
        return is_default;
    }
}
