package steps.panalyses.analysistypes.model.response.getanalysistypesbody;

import java.util.ArrayList;

public class Item {
    private String name;
    private boolean is_default;
    private int analysis_group_id;
    private int id;
    private AnalysisGroup analysis_group;
    private ArrayList<LaboratoryAnalysis> laboratory_analyses;

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
