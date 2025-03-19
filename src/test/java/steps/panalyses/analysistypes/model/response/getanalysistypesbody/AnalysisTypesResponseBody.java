package steps.panalyses.analysistypes.model.response.getanalysistypesbody;

import java.util.ArrayList;

public class AnalysisTypesResponseBody {

    private int page;
    private int per_page;
    private int total_pages;
    private int total_items;
    private ArrayList<Item> items;

    public AnalysisTypesResponseBody(int page, int per_page, int total_pages, int total_items, ArrayList<Item> items) {
        this.page = page;
        this.per_page = per_page;
        this.total_pages = total_pages;
        this.total_items = total_items;
        this.items = items;
    }

    public AnalysisTypesResponseBody() {
    }

    public int getPage() {
        return page;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getTotal_items() {
        return total_items;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getPer_page() {
        return per_page;
    }
}
