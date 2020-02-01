package arsenal.metiz.catalog;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.DrawableRes;

public class Composition  {
    @DrawableRes
    private int image;
    private String title;
    private String type;


    public Composition(@DrawableRes int image, String title , String type ) {
        this.image = image;
        this.title = title;
        this.type = type;

    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
