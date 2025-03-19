package steps.panalyses.analysistypes.model.response.getanalysistypesbody;

public class LaboratoryAnalysis {
    private int analysis_type_id;
    private int laboratory_id;
    private String name;
    private int id;

    public LaboratoryAnalysis(int analysis_type_id, int laboratory_id, String name, int id) {
        this.analysis_type_id = analysis_type_id;
        this.laboratory_id = laboratory_id;
        this.name = name;
        this.id = id;
    }

    public LaboratoryAnalysis() {
    }

    public int getAnalysis_type_id() {
        return analysis_type_id;
    }

    public int getLaboratory_id() {
        return laboratory_id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
