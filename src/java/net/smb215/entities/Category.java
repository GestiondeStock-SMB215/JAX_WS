package net.smb215.entities;

public class Category {
    private String cat_id;
    private String cat_name;
    private String cat_desc;
    private String cat_pic;
    private String cat_time_stamp;

    public Category() {
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getCat_desc() {
        return cat_desc;
    }

    public void setCat_desc(String cat_desc) {
        this.cat_desc = cat_desc;
    }

    public String getCat_pic() {
        return cat_pic;
    }

    public void setCat_pic(String cat_pic) {
        this.cat_pic = cat_pic;
    }

    public String getCat_time_stamp() {
        return cat_time_stamp;
    }

    public void setCat_time_stamp(String cat_time_stamp) {
        this.cat_time_stamp = cat_time_stamp;
    }
    
}