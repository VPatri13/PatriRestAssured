package steps.panalyses.model.response.analysis_types_body;

public class LaboratoryAnalysis {
    public int analysis_type_id;
    public int laboratory_id;
    public String name;
    public int id;

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
