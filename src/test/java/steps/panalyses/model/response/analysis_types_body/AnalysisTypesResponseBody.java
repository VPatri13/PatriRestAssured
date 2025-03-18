package steps.panalyses.model.response.analysis_types_body;

import java.util.ArrayList;

public class AnalysisTypesResponseBody {

    public int page;
    public int per_page;
    public int total_pages;
    public int total_items;
    public ArrayList<Item> items;

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
