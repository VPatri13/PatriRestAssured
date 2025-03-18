package steps.panalyses.model.response.analysis_types_body;

import java.util.ArrayList;

public class Item {
    public String name;
    public boolean is_default;
    public int analysis_group_id;
    public int id;
    public AnalysisGroup analysis_group;
    public ArrayList<LaboratoryAnalysis> laboratory_analyses;


}
