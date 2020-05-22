package com.apps.kunalfarmah.edunomics.Chat;

import android.net.Uri;

public class Contact {

    private String name;
    private Uri imageUri;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public Contact(String name, Uri imageUri) {
        this.name = name;
        this.imageUri = imageUri;
    }
}
