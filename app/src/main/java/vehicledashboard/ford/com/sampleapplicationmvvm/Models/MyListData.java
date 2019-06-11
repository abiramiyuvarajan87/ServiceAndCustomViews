package vehicledashboard.ford.com.sampleapplicationmvvm.Models;

public class MyListData {

    private String list_item_text;
    private int list_item_image_id;

    public MyListData(String list_item_text, int list_item_image_id) {
        this.list_item_text = list_item_text;
        this.list_item_image_id = list_item_image_id;
    }

    public String getList_item_text() {
        return list_item_text;
    }

    public void setList_item_text(String list_item_text) {
        this.list_item_text = list_item_text;
    }

    public int getList_item_image_id() {
        return list_item_image_id;
    }

    public void setList_item_image_id(int list_item_image_id) {
        this.list_item_image_id = list_item_image_id;
    }
}
